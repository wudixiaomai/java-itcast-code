
import java.net.*;
import java.io.*;
/*
为了便于聊天。

发送端：通过键盘录入的形式。

接收端：准备接收多次数据。


*/

class  SendDemo2
{
	public static void main(String[] args) throws Exception
	{
		
		DatagramSocket ds = new DatagramSocket();


		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("886".equals(line))
				break;
			byte[] buf = line.getBytes();

			DatagramPacket dp = 
				new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.255"),9001);

			ds.send(dp);
		}	

		ds.close();
	}
}


class  ReceDemo2
{
	public static void main(String[] args)throws Exception 
	{

		DatagramSocket ds = new DatagramSocket(9001);
		while(true)
		{

			byte[] buf = new byte[1024];

			DatagramPacket dp = new DatagramPacket(buf,buf.length);

			ds.receive(dp);

			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());

			System.out.println(ip+"::"+data);
		}
		//ds.close();


	}
}
