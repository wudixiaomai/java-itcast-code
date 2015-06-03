import java.io.*;

/*
readLine方法原理：
一次读一行。
必须要判断一个行结束标记。对于windows 行标记是\r\n.

该方法返回的是一行数据但不包括回车符。


原理：
其实用的还是流对象的一次读一个字符方法。
将读到的每一个字符都进行了数组的临时存储。
当读到回车符时，进行判断，但并不存储回车符。

将数组中已有的字符数据变成字符串返回。



*/
class  BufferedReaderDemo2
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("buf.txt");

		BufferedReader bufr = new BufferedReader(fr);

		//BufferedReader bufr = new BufferedReader(new FileReader("buf.txt"));

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			System.out.print(line);
		}
		bufr.close();
	}
}
