/*
String类涉及的编码的方法。
1，构造函数。String(byte[]):解码。
2，byte[] getBytes():编码。

字符串--->字节数组 ：编码。
字节数组--->字符串 ：解码。

在java中字符串默认就是GBK.

*/


class CharSetDemo2 
{
	public static void main(String[] args) throws Exception
	{
		demoEncoding1();
	}
	public static void demoEncoding1()throws Exception
	{
		String s = "你好";
		//使用gbk进行字符串的编码
		byte[] bys = s.getBytes("gbk");

		//解码时，使用了错误的码表。iso8859-1.
		String s1 = new String(bys,"ISO8859-1");

		System.out.println("s1="+s1);

		//已出现乱码，怎么解决？
		
		//1,将乱码从新按照解码的码表编一次，为了获取原字节数字。
		byte[] bys1 = s1.getBytes("iso8859-1");

		//2,将原字节数字，按照指定的码表解码。
		String s2 = new String(bys1,"gbk");

		System.out.println("s2="+s2);

	}

	public static void demoEncoding()throws Exception
	{
		String s = "你好";

		byte[] bys = s.getBytes("UTF-8");

		//showBys(bys);

		String s1 = new String(bys,"utf-8");

		System.out.println("s1="+s1);
	}

	public static void showBys(byte[] by)
	{
		for(byte b : by)
		{
			System.out.print(Integer.toHexString(b)+"..");
		}
	}
}
