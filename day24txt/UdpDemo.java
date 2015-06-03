import java.net.*;

/*


udp协议：
1，面向无连接。
2，不可靠协议，容易丢包。
3，速度快。
4，包体积有限制，64k以内。

通常，聊天，在线视频，凌波。




建立一个upd的发送端。
用于发送数据。

1,建立updsocket服务。
2，将数据封装成数据包。
3，通过socket服务的send方法。将数据包发出。
4，关闭资源。
*/

class  SendDemo
{
	public static void main(String[] args) throws Exception
	{

		//1,建立udpsocket服务。
		DatagramSocket ds = new DatagramSocket();

		//2,将数据封装成数据包。要使用DatagramPacket对象
		//2.1先将要发送的数据变成字节数组。在指定发送的目的地和端口。
		//2.2将这些信息作为参数传递给数据包对象的构造函数。

		byte[] buf = "如果你收到了这条信息，恭喜你，你可以去吃饭了。".getBytes();


		InetAddress ip = InetAddress.getByName("192.168.1.255");

		DatagramPacket dp = new DatagramPacket(buf,buf.length,ip,9527);
		while(true)
		{
		//3,使用Socket服务的send方法将数据包发送出去。
		ds.send(dp);
		}

		//4,关闭资源。
		//ds.close();


	}
}



/*
建立udp的接收端。

1，建立udp接收端服务，必须要监听一个端口，因为要明确，哪个端口来的数据是由该应用程序所处理的。
2，建立一个空的数据包，用于存储接收到数据，
	将字节数据存储到数据包对象中，可以使用数据包对象的方法获取不同的数据信息。
3，使用Socket服务的receive方法将接收到的数据存储到数据包中。
4，通过数据包的方法获取指定数据信息。
5，关闭资源。

*/
class ReceDemo
{
	public static void main(String[] args)throws Exception
	{
		//1,建立updsocket服务，监听一个端口。
		DatagramSocket ds = new DatagramSocket(9527);

		while(true)
		{
		//2,建立一个执行大小的数据包，用于存储数据，以便获取。
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);

		//3,使用socket的receive方法将数据存储到数据包中。
		ds.receive(dp);

		//4,通过数据包对象的方法获取其中的数据。
		String ip = dp.getAddress().getHostAddress();

		String data = new String(dp.getData(),0,dp.getLength());

		int port = dp.getPort();

		System.out.println(ip+":"+data+"::"+port);
		}
		//5,关闭资源。
		//ds.close();


	}
}