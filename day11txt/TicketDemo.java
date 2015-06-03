/*\
两个以上的线程才使用同步
使用的是同一个锁


*/
class SaleTicket implements Runnable
{
	private int ticket=10;
	Object obj =new Object();
	public void run()
	{
		while(true)
		{	
			synchronized(obj)
			{
				if(ticket>0)
				{
						try
							{
								Thread.sleep(4);
							}
						catch (Exception e)
							{
							}
						System.out.println("ticket saling threadnanme"+Thread.currentThread().getName()+"======"+ticket--);
					
					
				}
		}
		}
	}

}
public class TicketDemo
{
	public static void main(String args[]){
		SaleTicket st=new SaleTicket();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}

}