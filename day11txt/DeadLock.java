/*
以防面试。
死锁代码示例。

*/

class Demo implements Runnable
{
	private boolean flag;
	Demo(boolean flag)
	{
		this.flag = flag ;
	}
	public void run()
	{
		if(flag)
		{


			synchronized(MyLock.lock1)
			{
				System.out.println(Thread.currentThread().getName()+"...if....lock1");
				synchronized(MyLock.lock2)
				{
					System.out.println(Thread.currentThread().getName()+"... if...lock2");					
				}
			}
		}
		else
		{
			synchronized(MyLock.lock2)
			{
				System.out.println(Thread.currentThread().getName()+"..else....lock2");	
				synchronized(MyLock.lock1)
				{
					System.out.println(Thread.currentThread().getName()+"..else...lock1");	
				}
			}
		}
	}
}

class MyLock
{
	static MyLock lock1 = new MyLock();
	static MyLock lock2 = new MyLock();
}



class  DeadLock
{
	public static void main(String[] args) 
	{
		Demo d1 = new Demo(true);
		Demo d2 = new Demo(false);
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		t1.start();
		t2.start();

	}
}
