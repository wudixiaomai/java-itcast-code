/*
多线程：

什么是进程？
正在执行的程序。

什么是线程？
线程就是进程中的一个控制单元。
一个进程中至少有一个控制流程。
仅有一个控制单元，成为单线程程序。

一个进程中当有多个控制单元时，就称为多线程程序。
多线程的出现提高了效率。



单线程程序当遇到循环较大时，one没哟执行完。two是不可以执行。
*/




class Demo
{
	private String name;
	Demo(String name)
	{
		this.name = name;
	}
	public void show()
	{
		for(int x=0; x<10; x++)
		{
			for(long y=-1999999999; y<1999999999; y++){}
			System.out.println("name:"+name+"...."+x);
		}
	}
}

class  ThreadDemo
{
	public static void main(String[] args) 
	{
		Demo d1 = new Demo("one");
		Demo d2 = new Demo("two");
		d1.show();
		d2.show();
	}
}
