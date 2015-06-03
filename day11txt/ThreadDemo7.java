/*
同步函数使用的是什么锁呢？
因为函数都需要被对象调用，所以函数都有一个对象所属。
该对象使用的this来表示的，所以同步函数使用的锁就是this。

以下示例验证同步函数的锁是不是this。

通过两个线程来验证一下，
一个线程在同步语句块中
一个线程在同步函数中。
如果它们使用的是同一个锁，那么就不会出现0好票。
否则就会安全问题。

打印结果部分如下：
Thread-1.....show....6
Thread-0.....obj....5
Thread-1.....show....4
Thread-0.....obj....3
Thread-1.....show....2
Thread-0.....obj....1
Thread-1.....show....0

出现了0好票的安全问题。
加入了同步还出现该问题。
说明两个同步前提没满足。

多个线程用的不是同一个锁。

让同步代码块也使用this这个锁。
安全问题解决。
从而验证同步函数使用的this锁。


*/

class SaleTicket implements Runnable
{
	private static int tick = 300;
	//private Object obj = new Object();

	boolean b = true;

	public void run()
	{
		if(b)
		{
			while(true)
			{
				synchronized(this)
				{
					if(tick>0)
					{
						try{Thread.sleep(10);}catch(InterruptedException e){}
						System.out.println(Thread.currentThread().getName()+".....obj...."+tick--);
					}
				}
			}
		}
		else
		{
			while(true)
			{
				show();
			}
		}
		
	}

	public synchronized static void show()
	{
		if(tick>0)
		{
			try{Thread.sleep(10);}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+".....show...."+tick--);
		}
	}
}


class  ThreadDemo7
{
	public static void main(String[] args) 
	{
		SaleTicket st = new SaleTicket();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.start();
		//让主线程稍微停一下，让t1先去执行同步代码块。
		//然后主线程醒了以后，在将标记进行切换，让t2去执行同步函数。
		//try{Thread.sleep(10);}catch(InterruptedException e){}
		st.b = false;
		t2.start();


	}
}
