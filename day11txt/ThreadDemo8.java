/*
当同步函数被static修饰后，使用的锁是什么呢？

static方法中是不可以出现this的。
通过运行示例也验证了这一点。


static是随着类的加载而加载，这时还没有建立该类的对象。
只有类被加载进了内存，这时只有一个对象存在就是该类所对应的字节码文件对象。

静态同步方法锁使用的锁是：该方法所属类的字节码文件对象。
就是  本类名.class
*/

class SaleTicket implements Runnable
{
	private static  int tick = 300;

	boolean b = true;

	public void run()
	{
		if(b)
		{
			while(true)
			{
				synchronized(SaleTicket.class)
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

	public synchronized static  void show()
	{
		if(tick>0)
		{
			try{Thread.sleep(10);}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+".....show...."+tick--);
		}
	}
}


class  ThreadDemo8
{
	public static void main(String[] args) 
	{
		SaleTicket st = new SaleTicket();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.start();
		//让主线程稍微停一下，让t1先去执行同步代码块。
		//然后主线程醒了以后，在将标记进行切换，让t2去执行同步函数。
		try{Thread.sleep(10);}catch(InterruptedException e){}
		st.b = false;
		t2.start();


	}
}


//------------------------------
/*
单例设计模式中的懒汉式：
当多个线程并发访问该方法时，有可能出现线程安全问题。
所以在getInstance方法上加入了同步。
虽然解决了安全问题。但是效率降低了。

可以通过双重判断的形式进行一下优化。

必须要会。


*/
class Single
{
	private static Single s = null;
	private Single(){}
	public static  Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)
			{
				if(s == null)			
					s = new Single();
			}
		}
		return s;
	}
}

//懒汉式。
class Single
{
	private static Single s = null;
	private Single(){}
	public static synchronized  Single getInstance()
	{		
		if(s == null)			
			s = new Single();		
		return s;
	}
}
//饿汉式：
class Single
{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance()
	{			
		return s;
	}
}
