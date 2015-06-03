/*
线程间通讯，也就是生产者消费者的例子。

两个线程在同时处理同一个资源。
而这两个线程的动作是不同的。

运行过程中出现了妖！

原理：输入线程输入了姓名还没有输入性别时，输入线程被cpu执行，这时就会出现妖！

通过同步解决。
使用哪个锁呢？要确保锁的唯一性，在这里，资源是唯一的，并被两个线程同时处理。
所以可以将资源对象作为锁存在，解决了妖的问题。



*/

class Res
{
	String name;
	String sex;
}

class Input implements Runnable
{
	Res r; 

	Input(Res r)
	{
		this.r = r;
	}

	public void run()
	{
		int x = 0;

		while(true)
		{
			synchronized(r)
			{
				if(x==0)
				{
					r.name = "Mike";

					r.sex = "nan";
				}
				else
				{
					r.name = "李丽丽";
					r.sex = "女女女女";
				}
			}
			x = (x+1)%2; 
		}
	}
}


class Output implements Runnable
{
	private Res r ;
	Output(Res r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				System.out.println(r.name+"......."+r.sex);
			}
		}
	}
}
class  ThreadDemo10
{
	public static void main(String[] args) 
	{
		Res r = new Res();
		Input in = new Input(r);
		Output out = new Output(r);
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
	}
}
