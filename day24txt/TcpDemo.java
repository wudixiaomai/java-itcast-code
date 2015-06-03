/*
tcp协议：
1，面向连接。
2，通过三次握手完成连接。
3，是可靠的协议。
4，相对udp稍慢。


也分两个端点：
1，客户端。Socket。
2，服务端。ServerSocket。



*/
import java.net.*;
import java.io.*;
class ClientDemo 
{
	public static void main(String[] args) throws Exception
	{
		//1,建立tcp的客户端socket服务。在建立对象时，就要指定要连接的目的地址和端口。
		Socket s  = new Socket("192.168.1.253",9003);

		//2,通过建立的socket对象获取socket中的输出流。调用getOutputStream方法。

		OutputStream out = s.getOutputStream();

		out.write("gemen,tcp lai la!".getBytes());

		s.close();
		
	}
}


class  ServerDemo
{
	public static void main(String[] args) throws Exception
	{

		//1,建立服务端的tcp socket服务。必须要监听一个端口。
		ServerSocket ss = new ServerSocket(9003);

		//2,通过服务端的socket对象的accept方法获取连接上的客户端对象
		//因为要使用获取到的客户端对象的socket流和客户端进行通讯。
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");


		//获取客户端对象的读取流，读取数据。
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);

		String str = new String(buf,0,len);
		
		
		System.out.println(str);

		s.close();
		ss.close();
	}
}
