/*
上传文本文件。

原理：
其实就是将本地的文件数据通过socket流，发送到了服务端。服务端对这些数据进行文件存储


*/

import java.io.*;
import java.net.*;
class  UploadClient
{
	public static void main(String[] args)throws Exception 
	{
		Socket s =new Socket("192.168.1.253",9005);

		//读取要上传的本地文本文件，为了提高效率，使用了缓冲区。
		BufferedReader bufr = new BufferedReader(new FileReader("UdpDemo.java"));

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			out.println(line.toUpperCase());
		}

		//out.println("");
			
		s.shutdownOutput();

		//读取服务端发挥的上传成功信息。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String info = bufIn.readLine();
		System.out.println(info);

		bufr.close();

		s.close();


	}
}
class  UploadServer
{
	public static void main(String[] args) throws Exception
	{

		ServerSocket ss = new ServerSocket(9005);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"....connected");

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		PrintWriter pw = new PrintWriter(new FileWriter("server.txt"),true);

		String line = null;

		while((line=bufIn.readLine())!=null)
		{
			//if("over".equals(line))
				//break;
			pw.println(line);
		}

		PrintWriter out =new PrintWriter(s.getOutputStream(),true);
		out.println("上传成功---");

		pw.close();

		s.close();

		ss.close();
	}
}
