/*
同步的两种表现形式：
1，同步代码块：需要一个锁。
2，同步函数：问：同步函数用的是哪个锁呢？

需求：将售票程序通过同步函数的形式解决一下线程安全问题。


*/

class SaleTicket implements Runnable
{
	private int tick = 100;

	public  void run()
	{
		while(true)
		{			
			show();
		}
	}

	public synchronized void show()
	{
		if(tick>0)
		{
			try{Thread.sleep(100);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+".....sale......"+tick--);
		}
	}
}

class ThreadDemo6 
{
	public static void main(String[] args) 
	{
		
		SaleTicket t = new SaleTicket();
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}



