/*
需求：
两个人各有300元，分三次每次100元，存入银行。

*/

class Bank
{
	private int sum;
	//Object obj = new Object();
	public synchronized void add(int n)//同步函数
	{
		//synchronized(obj)
		//{
			sum = sum + n;
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println("sum="+sum);
		//}
	}
}

class Consumer implements Runnable
{
	private Bank b = new Bank();
	public void run()
	{		
		for(int x=0; x<3; x++)
		{
			b.add(100);
		}
	}
}


class  ThreadTest2
{
	public static void main(String[] args) 
	{
		//必然要建立Consumer的对象
		//因为要把Runnable接口的子类对象作为参数传递给Thread类的构造函数。
		Consumer c = new Consumer();

		//创建线程对象。
//		Thread t1 = new Thread(c);
//		t1.start();
		new Thread(c).start();
		new Thread(c).start();

	}
}
