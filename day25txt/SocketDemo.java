/*
InetAddress:对ip或者主机进行对象的封装。
InetSocketAddress：对ip+端口或者主机+端口进行对象的封装。





socket中的异常。
1,SocketTimeoutException:客户端连接时，可以指定连接时间，超过该毫秒时间，就会发生该异常。

2，ConnectException：连接主机和端口失败。



IOException
	|--MalformedURLException：url无法解析时。
	|--UnknownHostException：ip地址错误，或者主机名称错误。
	|--SocketException
		|--ConnectException
		|--BindException：端口被多个应用程序所使用时。




*/
import java.net.*;
class  SocketDemo
{
	public static void main(String[] args) throws Exception
	{

		//Socket s = new Socket();

		
		//演示超时。
//		InetSocketAddress ias = new InetSocketAddress("192.168.0.253",9008);
//		s.connect(ias,3000);

		//Socket s1 = new Socket("192.168.1.253",9008);
//		System.out.println("Hello World!");


		//演示连接个数。
		Socket s1 = new Socket("192.168.1.253",9009);
		System.out.println(s1);
		Socket s2 = new Socket("192.168.1.253",9009);
		System.out.println(s2);
		Socket s3 = new Socket("192.168.1.253",9009);
		System.out.println(s3);

	}
}
