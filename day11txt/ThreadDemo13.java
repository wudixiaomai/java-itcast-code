/*
如何停止线程呢？
因为stop方法过时了。

停止线程的两种方式：
1，定义标记，让run方法结束。
	run方法中一般都定义循环。只要控制住循环条件即可。
	但是这种方式有局限性，如果线程进入到冻结状态，是不会读取标记的。那么线程是不会停止的。

2，中断线程。其实就是清除线程的冻结状态，让线程恢复到可运行状态，这样就可以让线程去读取标记，并结束线程。

停止线程原理：就是让run方法结束。



*/


class StopThread implements Runnable
{
	private boolean flag = true;
	public synchronized void run()
	{
		while(flag)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().getName()+"...exception....");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName()+"....");
		}
	}
	public void change()
	{
		flag = false;
	}

}

class  ThreadDemo13
{
	public static void main(String[] args) 
	{
		StopThread st = new StopThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();
		t2.start();

		int num = 0;

		while(true)
		{
			if(num++==50)
			{
				//st.change();
				t1.interrupt();
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"...."+num);
		}
	}
}
/*
wait():释放资源，释放锁。
sleep():释放资源，不释放锁。

释放资源：就是cpu不在处理该线程。

*/