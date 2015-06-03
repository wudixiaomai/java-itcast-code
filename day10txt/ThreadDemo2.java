/*
三个线程同时执行。
当主函数所在线程开启了两个线程后，这两个不一定立刻执行，因为这时有可能cpu在执行主函数线程。

每一个线程都有自己默认的名称：Thread-编号，该编号从0开始。

Thread currentThread():获取当前线程对象的引用。
String getName():获取线程的名称。

主函数所在的线程名称为：main。



*/

class Demo extends Thread
{
	private String name;
	Demo(String name)
	{
		this.name = name;
	}
	public void run()
	{
		for(int x=0; x<10; x++)
		{
			for(long y=-1999; y<1999; y++){}
			System.out.println(Thread.currentThread().getName()+".....name:"+name+"...."+x);
		}
	}
}

class  ThreadDemo2
{
	public static void main(String[] args) 
	{
		Demo d1 = new Demo("one");
		Demo d2 = new Demo("two");

		/*
		如果是直接调用run方法，这时只有一个线程在运行，就是主函数所在线程。
		因为线程并没有被开启。
		d1.run();
		d2.run();
		*/
//		d1.run();
//		d2.run();
		d1.start();
		d2.start();

		for(int x=0; x<50; x++)
		{
			System.out.println(Thread.currentThread().getName()+".......main method run ...."+x);
		}
	}
}
