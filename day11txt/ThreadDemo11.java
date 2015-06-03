/*
对于打印结果不是很满意。
想要输入一个资源，就输入一次。

在资源类中定义标记，用于判断该资源是否有数据存在。

然后通过wait notify方法进行线程的控制。



wait();让执行的线程的进入到冻结状态。
notify()：唤醒线程池中的第一个线程。
notifyAll()：唤醒所有被等待的线程。
这三个方法都用于同步中操作线程，
为了什么没有定义在Thread类中，而是定义在Object中。

因为这些方法需要标识出它们所在的锁。
锁可以是任意对象。能被任意对象调用的方法定义在Object类中。


*/

class Res
{
	String name;
	String sex;
	boolean b ;
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
				if(r.b)
					try{r.wait();}catch(InterruptedException e){}
					
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
				r.b = true;
				r.notify();

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
				if(!r.b)
					try{r.wait();}catch(InterruptedException e){}
				System.out.println(r.name+"......."+r.sex);
				r.b = false;
				r.notify();
			}
		}
	}
}
class  ThreadDemo11
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

