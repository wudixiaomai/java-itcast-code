/*
线程的安全问题。

通过Thread类中的sleep方法模拟一下，线程的安全问题。
让多个线程在指定位置上停了一下，出现0号，以及负号票的情况。

如何造成的呢？
当多条语句对同一个资源(对应的通常是成员变量，也就是线程共享的数据)进行操作，而这些语句被多线程分开执行。
就容易引发线程安全问题。



如何解决安全问题呢？
只要保证在同一时刻，只有一个线程来执行这些操作资源的代码即可。

可以通过同步代码块来完成。

同步的原理：
其实就是有锁的存在。

火车上的卫生间。

同步的弊端：
降低了程序的效率，判断锁是较为消耗资源。

同步使用的前提：
1，必须要是两个或者两个以上的线程。
2，必须保证多个线程使用的是同一个锁。

*/

class SaleTicket implements Runnable
{
	private int tick = 100;
	private Object obj = new Object();
	public void run()
	{
		while(true)
		{
			synchronized(obj)
			{
				if(tick>0)
				{
					//try{Thread.sleep(500);}catch(Exception e){}
					System.out.println(Thread.currentThread().getName()+".....sale......"+tick--);
				}
			}
		}
	}
}

class ThreadDemo5 
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
/*
java中提供了同步的方式来解决线程的安全隐患。

synchronized(对象)
{
	需要被同步的代码；
}
*/


