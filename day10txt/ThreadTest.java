/*
线程练习：

1，定义一个类，继承Thread类。，因为该类中有需要被多线程执行的代码。
2，覆盖Thread中的run方法。将自定义的需要被多线程执行的代码存放在该方法中，
3，建立该类对象创建线程。
4，开启线程。

通常run方法中有循环结构。
*/

class A extends Thread
{
	public void run()
	{
		for(int x=0; x<30; x++)
		{
			System.out.println(Thread.currentThread().getName()+"aa"+x);
		}
	}
}




class  
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		A a4 = new A();
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		for(int x=0; x<50; x++)
		{
			System.out.println(" hello"+x);
		}
	}
}
/*
定义一个售票程序，
通过多线程来完成。
线程通过第二种方式来建立。


*/


作业：
自己理解一下单例设计模式中懒汉式的特点。
当多线程并发访问该方法时，会不会出现安全问题。
如何解决呢？
如何解决可以稍微高效一点呢？

class Single
{
	private static Single s = null;
	private Single(){}
	public static synchronized Single getInstance()
	{
		if(s==null)
			s = new Single();
		return s;
	}
}


