/*
演示ip对象。
*/

import java.net.*;

class  IPDemo
{
	public static void main(String[] args) throws Exception
	{
		//将指定ip封装成InetAddress对象。
		InetAddress ia = InetAddress.getByName("127.0.0.1");

		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
		

		InetAddress ia1 = InetAddress.getByName("www.baidudu.com");
		System.out.println(ia1.getHostAddress());

		InetAddress[] ias = getAllByName("www.sina.com.cn");

		for(InetAddress i : ias)
		{
			System.out.println(i.getHostAddress());
		}

	}
}

