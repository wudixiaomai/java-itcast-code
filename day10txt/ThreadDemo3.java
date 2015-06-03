
/*
示例：
售票程序：
因为票会被多个线程同时卖出。
所以需要继承Thread，并把卖票代码存入run方法中。
*/
class SaleTicket  extends Thread
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




class ThreadDemo3 
{
	public static void main(String[] args) 
	{

		//创建四个线程，会出现400张票。
		//因为每一个对象中的都有自己的tick属性。
		SaleTicket t1 = new SaleTicket();
		//SaleTicket t2 = new SaleTicket();
		//SaleTicket t3 = new SaleTicket();
		//SaleTicket t4 = new SaleTicket();


		//对一个线程开启四次，会出现.IllegalThreadStateException。无效线程状态异常。
		t1.start();
		t1.start();
		t1.start();
		t1.start();
	}
}
