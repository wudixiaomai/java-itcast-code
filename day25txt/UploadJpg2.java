import java.net.*;
import java.io.*;


/*
服务端将获取到的客户端封装到单独的线程中。

*/

class  JpgClient2
{
	public static void main(String[] args) throws Exception
	{
		
		if(args.length==0)
		{
			System.out.println("哥们，姐们，指定一个jpg文件先！");
			return ;
		}
		
		File file = new File(args[0]);

		if(!(file.exists() && file.isFile() && file.getName().endsWith(".jpg")))
		{
			System.out.println("选择文件错误，请重新选择一个“ok”的文件。");
			return ;
		}


		Socket s = new Socket("192.168.1.253",9006);

		FileInputStream fis = new FileInputStream(file);

		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];

		int len = 0;

		while((len=fis.read(buf))!=-1)
		{
			out.write(buf,0,len);
		}

		s.shutdownOutput();

		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);

		String str = new String(bufIn,0,num);

		System.out.println(str);

		fis.close();
		s.close();
	}
}




class JpgThread implements Runnable
{
	private Socket s;
	JpgThread(Socket s)
	{
		this.s = s;
	}
	public void run()
	{

		int count = 1;

		String ip = s.getInetAddress().getHostAddress();

		try
		{


			InputStream in = s.getInputStream();

			File dir = new File("c:\\pic");
			File file = new File(dir,ip+"("+count+").jpg");

			while(file.exists())
				file = new File(dir,ip+"("+(count++)+").jpg");
		
			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[1024];

			int len = 0;
			while((len=in.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}

			OutputStream out = s.getOutputStream();

			out.write("上传文件成功".getBytes());

			fos.close();
			s.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
class  JpgServer2
{
	public static void main(String[] args)throws Exception 
	{
		ServerSocket ss = new ServerSocket(9006);

		while(true)
		{
			Socket s = ss.accept();
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip+"....connected");

			new Thread(new JpgThread(s)).start();
		}

		

	}
}
