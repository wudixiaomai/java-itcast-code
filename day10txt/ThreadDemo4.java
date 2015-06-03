/*
创建线程的第二种方式：
实现Runnable接口。

步骤：
1，定义线程代码所属类实现Runnable接口。
2，复写Runnable接口中的run方法。将多线程要运行的代码存入其中。
3，创建Runnable接口的子类对象。
4，创建Thread类的对象，并将Runnable接口的子类对象作为参数传递给Thread类的构造函数。
	为什么要传递给Thread类的构造函数？
	因为要让线程对象去运行指定的run方法，而这个run方法所属Runnable接口的子类。
	所以将Runnable接口的子类对象传递给Thread类的构造函数，让线程对象一建立就可以明确要运行的run方法。
5，调用Thread类的start方法开启线程并执行指定的run方法。
实现Runnable接口的方式：避免了单继承的局限性。

而且该种方式较为常用。


*/

class SaleTicket implements Runnable
{
	private int tick = 100;
	public void run()
	{
		while(true)
		{
			if(tick>0)
			{
				System.out.println(Thread.currentThread().getName()+".....sale......"+tick--);
			}
		}
	}
}

class ThreadDemo4 
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
