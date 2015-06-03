/*
数组和缓冲区容器的使用。


需求：
通过键盘录入的形式获取字符串。
并判断字符串是否是over，如果是，结束键盘录入，程序结束。
如果不是，那么就打印该录入数据的大写形式。


如何获取键盘录入呢？
System.out:系统输出。
System.in：键盘录入。


要获取键盘录入的数据。就需要用到一个功能。read();
写法：System.in.read();//该read方法会返回读到的数据。int.

read()：一次读一个，调用一次，就往下读一个。



思路：
1，通过键盘录入System.in.read():获取录入的每一个字节数据。
2，要将获取的数据变成字符串，因为只有变成字符串才可以调用toUpperCase()方法获取大写，
	也才可以判断是否是over。
3，先将读到每一个字节临时存储来，因为读到是字节，那么可以定义个字节数组进行存储。
4，将字节数组变成字符串。进行转换或者判断。

小细节：
window中，回车符是由两个字符来表示的。\r\n




发现该程序一些局限性，就是如果录入的字节个数，超过数组的长度，就会丢失数据。数组角标越界。

为了解决这个问题，我们可以换一个容器来完成：StringBuilder。可变长度的容器。

注意一点：就是对缓冲区进行清空。

要求：这两个程序的运行的过程要清楚，程序要会写。




*/

class StringBuilderTest 
{
	public static void main(String[] args) throws Exception
	{
		//readInByArray2();
		readInByBuffer();
		
	}

	public static void readInByBuffer() throws Exception
	{
		//先定义一个缓冲区容器。存放读到的字节数据。
		StringBuilder sb = new StringBuilder();
		
		while(true)
		{
			int ch = System.in.read();
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				//将缓冲区中的数据变成字符串。
				String s = sb.toString();
				if("over".equals(s))
					break;
				System.out.println("upper:"+s.toUpperCase());
				sb.delete(0,sb.length());
			}
			else
				sb.append((char)ch);
		}
	}


	/*
	读取键盘录入，使用数组作为临时容器。
	*/
	public static void readInByArray()throws Exception
	{
		//System.out.println((int)'\r'+",,,"+(int)'\n');
		//定义一个临时容器，用于存储每一个字节。
		byte[] arr = new byte[200];
		int pos = 0;
		
		while(true)
		{
			//读取键盘录入的字节
			int ch = System.in.read();
			
			if(ch=='\r')
				continue;
			if(ch=='\n')//判断是否到行结尾。
			{
				//将数组中存入的字节数据变成字符串进行over的判断。
				String s = new String(arr,0,pos);
				if("over".equals(s))
					break;
				System.out.println(s.toUpperCase());
				pos = 0;
			}
			else
			{
				arr[pos++] = (byte)ch;
			}
		}
		/*
		*/
	}
	/*
	使用switch语句形式。
	*/
	public static void readInByArray2()throws Exception
	{
		//System.out.println((int)'\r'+",,,"+(int)'\n');
		//定义一个临时容器，用于存储每一个字节。
		byte[] arr = new byte[200];
		int pos = 0;
		
		
		//因为是对有限的几个值进行判断，所以可以选择用switch语句来完成。
		while(true)
		{
			//读取键盘录入的字节
			int ch = System.in.read();
			
			switch(ch)
			{
				case '\r':
					break;
				case '\n':
					String s = new String(arr,0,pos);
					if("over".equals(s))
						return ;
					System.out.println(s.toUpperCase()+"....");
					pos = 0;
					break;
				default:
					arr[pos++] = (byte)ch;
			}


		}
		/**/
	}
}



