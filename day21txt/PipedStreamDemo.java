/*
管道流。
特点：
	1，管道输入流和管道输出流可以进行连接。
	2，需要多线程进行分别操作。

两个流的连接方式：
	1，通过构造函数的形式。
	2，通过connect方法。


示例：
一个线程读，一个线程写。



*/
import java.io.*;
class Read implements Runnable
{

	private PipedInputStream pis;
	Read(PipedInputStream pis)
	{

		this.pis = pis;
	}
	public void run()
	{
		byte[] buf = new byte[1024];
		try
		{
			int len  = pis.read(buf);//阻塞式方法。

			String str = new String(buf,0,len);
			System.out.println(str);
			pis.close();
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		
		
	}
}

class Write implements Runnable
{
	private PipedOutputStream pos ;
	Write(PipedOutputStream pos)
	{
		this.pos = pos;
	}
	public void run()
	{
		try
		{


			Thread.sleep(5000);
			pos.write("hello piped lai le ".getBytes());



			pos.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
}

class  PipedStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();

		pis.connect(pos);

		new Thread(new Read(pis)).start();
		new Thread(new Write(pos)).start();


	}
}
