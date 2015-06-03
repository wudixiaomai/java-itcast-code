/*
正则表达式

：专门用于操作字符串的规则。
这些规则由一些符号所组成的。


功能：
1，匹配。使用的是String类中的matches方法。


2，切割。使用的String类split方法。

3，替换。

4，查找。
	1，将正则规则通过Pattern类中的static方法complie，封装成Pattern对象，
	2，通过Pattern类中matcher方法与字符串相关联，获取匹配器对象。
	3，通过匹配器的方法来操作字符串。如：find是否找到，group取去匹配后的字符串。



其实String类中有关正则表达式的方法，底层都是先将传入的正则规则封装成Pattern对象。
然后通过Pattern对象获取Matcher对象，在调用Matcher的方法完成的。

*/
import java.util.regex.*;
import java.util.*;
import java.io.*;
class  RegexDemo
{
	public static void main(String[] args) throws IOException
	{
//		checkTel();
//		getWord();
//		splitStr();
//		replaceReg();

//		ipSort();
//		checkMail();

		getMail();
	}

	/*
	
	获取文件中的email地址。
	思路：
	1，既然要读取是一个文件，需要使用字符流。FileReader。BufferedReader。
	2，读到一行数据，就和规则相关联，取出这行字符串中所有的email地址。
	3，将email地址进行存储。

	*/
	public static void getMail()throws IOException
	{
		BufferedReader bufr = new BufferedReader(new FileReader("mail.txt"));
		
		String line = null;

		String mailreg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";

		Pattern p = Pattern.compile(mailreg);

		

		while((line=bufr.readLine())!=null)
		{
			Matcher m = p.matcher(line);
			while(m.find())
			{
				System.out.println(m.group());
			}

		}

	}


	
	public static void checkMail()
	{
		String  mail = "abc@sina.com.cn";

		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		
		//reg = "\\w+@\\w+(\\.\\w+)+";//宽松式校验。


		boolean b = mail.matches(reg);

		System.out.println("mail:"+b);
	}




	/*
	
	192.168.1.253 10.10.10.10 127.0.105.1 2.2.2.2 30.30.30.30
	将这些ip地址按照ip地址段的顺序排序。

	*/

	public static void ipSort()
	{
		String ip = "192.168.1.253 10.10.10.10 127.0.105.1 2.2.2.2 30.30.30.30";

		//最方便方式，就是按照字符串的字典顺序比较。但是必须要保证每一个地址的位数是相同的。
		//所以在不足三位段上补零，首先按照最大补零数进行填充。

		ip = ip.replaceAll("(\\d+)","00$1");
		System.out.println(ip);//补完。

		//对补完0的ip，进行每段最后三位的保留
		ip = ip.replaceAll("0*(\\d{3})","$1");
		System.out.println(ip);//192.168.001.253 010.010.010.010 127.000.105.001 002.002.002.002 030.030.030.030

		//通过空格进行切割。
		String[] arr = ip.split(" ");
		TreeSet<String> ts = new TreeSet<String>();
		
		for(String s: arr)
		{
			ts.add(s);
		}

		for(String s : ts)
		{
			System.out.println(s.replaceAll("0*([0-9]+)","$1"));
		}

	}

	//使用指定字符串替换符合规则的字符串。
	public static void replaceReg()
	{
		String str = "dfqqqghjzzkltpppyu";

		String s = str.replaceAll("(.)\\1+","$1");

		System.out.println(s);


	}


	//按照指定规则切割字符串。
	public static void splitStr()
	{
		String str = "we.rw.er.ty";//

		str = "dfqqqghjzzkltpppyu";

		String reg = "\\.";//对于 . 在正则中是一个特殊字符。如果只当作普通符号来用，必须要转义。
		
		reg = "(.)\\1+";// abzzzc
		String[] arr = str.split(reg);

		for(String s : arr)
		{
			System.out.println(s);
		}
	}




	/*
	获取字符串中指定的单词。

	思路：
	想要获取指定单词，使用匹配是不可以的，因为符合要求的结果不是boolean类，而是很多单个字符串。

	这时就要使用正则表达式对象。Pattern。
	*/
	public static void getWord()
	{
		String str ="da jia ming tian fang jia le ,shuang!";

		String reg = "\\b[a-z]{4}\\b";
		
		//1,将正则表达式封装成Pattern。使用Pattern对象中 compile方法。
		Pattern p = Pattern.compile(reg);

		//2,将正则对象和字符串进行关联。使用的matcher方法。该方法会返回一个匹配器对象Matcher。
		Matcher  m = p.matcher(str);
		
		//3,使用匹配器对象的find方法去找是否有符合规则的内容。通过group获取查找到的字符串。
		while(m.find())
		{
			System.out.println(m.group());
		}
	}

	//校验电话。
	public static void checkTel()
	{
		String tel = "15800190000";
		String telreg = "1[35]\\d{9}";

		System.out.println(tel.matches(telreg));



	}


	//演示数量词。
	public static void checkStr()
	{
		String str = "acccb";

		String strreg1 = "ac{3}b";//true
		String strreg2 = "ac*b";//true, * c出现0次或者多次都可以。
		String strreg3 = "ac?b";//false, ? 表示 c出现1次或者0次。
		String strreg4 = "ac+b";//true ，+ 表示 c出现1次或者多次。
		System.out.println("str="+str.matches(strreg1));
		System.out.println("str="+str.matches(strreg2));
		System.out.println("str="+str.matches(strreg3));
		System.out.println("str="+str.matches(strreg4));
	}

	public static void checkQQByReg()
	{
		String qq = "12345678";
		String qqreg = "[1-9]\\d{4,14}";
		boolean b = qq.matches(qqreg);
		System.out.println("qq:"+b);

//		Pattern p = Pattern.compile(qqreg);
//		Matcher m = p.matcher(qq);
//		boolean b2 = m.macthes();
	}

	/*
	判断一个QQ号，要求：5~15，不可以0开头，必须都是数字。
	*/

	public static void checkQQ(String qq)
	{
		

		int len = qq.length();

		if(len>=5 && len<=15)
		{
			if(!qq.startsWith("0"))
			{
				try
				{
					long num = Long.parseLong(qq);
					System.out.println(num);
				}
				catch (NumberFormatException e)
				{
					System.out.println("fifa qq");
				}
				
			}
			else
				System.out.println("no 0 start");
		}
		else
			System.out.println("qq len nono");
	}
}
