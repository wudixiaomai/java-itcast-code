/*
需求：
想要让one和two同时执行。
这时就需要在原有单线程程序上，建立多个控制流程单元。

而window已经有了实现线程的动作，java只需要调用该动作即可，
调用方式都封装到了一个已有对象中，该对象是Thread。


通过查阅api文档。
创建线程的第一种方式：
1，继承Thread类。
2，覆盖Thread类中的run方法，将多线程要执行的代码存放在run方法中。
3，建立Thread类的子类对象创建线程。
4，使用线程类的start方法开启线程，调用线程的run方法。

name:two....0
name:one....0
name:two....1
name:one....1
name:two....2
name:one....2
name:two....3

发现one 和two可以同时执行了。

当主函数中加入for循环发现，有三个线程在进行同时执行。

每一次的执行结果都不一样，体现了多线程的特性：随机性。
原理：就是cpu在不断给每一个线程分配一个时间片。做着快速的切换。





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
			System.out.println("name:"+name+"...."+x);
		}
	}
}

class  ThreadDemo1
{
	public static void main(String[] args) 
	{
		Demo d1 = new Demo("one");
		Demo d2 = new Demo("two");
		//d1.show();
		//d2.show();
		d1.start();
		d2.start();

		for(int x=0; x<50; x++)
		{
			System.out.println("main method run ...."+x);
		}
	}
}
