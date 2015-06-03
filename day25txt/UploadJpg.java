import java.net.*;
import java.io.*;


class  JpgClient
{
	public static void main(String[] args) throws Exception
	{

		Socket s = new Socket("192.168.1.253",9006);

		FileInputStream fis = new FileInputStream("c:\\0.bmp");

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
class  JpgServer
{
	public static void main(String[] args)throws Exception 
	{
		ServerSocket ss = new ServerSocket(9006);

		Socket s = ss.accept();

		InputStream in = s.getInputStream();
			
		
		FileOutputStream fos = new FileOutputStream("server.bmp");

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
		ss.close();


	}
}
