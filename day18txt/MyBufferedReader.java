import  java.io.*;


/*
Reader
	|--FileReader
	|--BufferedReader

之所以没有让MyBufferedReader继承Reader，
是因为Reader中有抽象方法，老师懒得去复写。

其实应该是需要继承的。
因为装饰类和被装饰类它们都具有相同的功能，并所属与同一个父类或者接口。


*/
class MyBufferedReader //extends Reader
{
	private Reader r;
	MyBufferedReader(Reader r)
	{
		this.r = r;
	}

	/*
	1,通过FileReader的read方法，一次读一个字符。
	2，将该字符进行临时存储。该容器为了方便，选择StringBuilder。
	3，对读到字符进行判断，如果是回车符，就将StringBuilder已存储的字符变成字符串返回。
	*/
	public String myReadLine()throws IOException
	{
		//1,创建临时存储StringBuilder。
		StringBuilder sb = new StringBuilder();

		//2,使用FileReader的read方法一次读一个字符。需要循环读取。
		int ch = 0;

		while((ch=r.read())!=-1)
		{
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				return sb.toString();
			}
			else
				sb.append((char)ch);
		}

		if(sb.length()!=0)
			return sb.toString();

		return null;
	}

	public void myClose()throws IOException
	{
		r.close();
	}
}