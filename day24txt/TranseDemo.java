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
class TranseClient 
{
	public static void main(String[] args) throws Exception
	{

		Socket s = new Socket("192.168.1.253",9004);
		//1,获取键盘录入。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//2,建立数据输出给服务端。
		OutputStream out = s.getOutputStream();

		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(out));


		//获取服务端返回的数据，将socket的InputStream进行包装。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;



		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;

			bufOut.write(line);
			bufOut.newLine();
			bufOut.flush();

			String str = bufIn.readLine();
			System.out.println("server:"+str);
		}


		bufr.close();
		s.close();

	}
}
class TranseServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(9004);

		Socket s = ss.accept();

		InputStream in = s.getInputStream();

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));

		String line = null;


		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		while((line=bufIn.readLine())!=null)
		{
			System.out.println("client:"+line);
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}

		s.close();
		ss.close();
	}
}
