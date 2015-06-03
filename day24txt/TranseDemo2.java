/*

客户端通过键盘录入数据，发送到服务端，
服务端接收到数据后，转换成大写在返回给客户端。

出现服务端或者客户端等待的情况。

原因：
因为客户端和服务端中的都有阻塞式方法。
read， readLine, accept，


*/
import java.net.*;
import java.io.*;
class TranseClient2 
{
	public static void main(String[] args) throws Exception
	{

		Socket s = new Socket("192.168.1.253",9004);
		//1,获取键盘录入。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//2,建立数据输出给服务端。

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//获取服务端返回的数据，将socket的InputStream进行包装。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;



		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;

			out.println(line);

			String str = bufIn.readLine();
			System.out.println("server:"+str);
		}


		bufr.close();
		s.close();

	}
}
class TranseServer2
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(9004);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"....connected");

		InputStream in = s.getInputStream();

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));

		String line = null;


		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		while((line=bufIn.readLine())!=null)
		{
			System.out.println("client:"+line);

			out.println(line.toUpperCase());
		}

		s.close();
		ss.close();
	}
}
