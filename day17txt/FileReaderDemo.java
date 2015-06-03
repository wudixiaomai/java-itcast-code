/*
需求：读取一个硬盘上已有的一个文本文件。

read():会自定向下读取字符。

*/
import java.io.*;
class  FileReaderDemo
{
	public static void main(String[] args) throws IOException
	{
		//1，创建FileReader读取流对象，在构造是要指定要读取的文本文件。
		//其实就是用一个流对象与已有文件相关联。
		FileReader fr = new FileReader("text.txt");

		//2,使用Reader类中的read读取方法，将文件中的字符数据读到一个字符数组中。
		char[] buf = new char[1024];//通常定义的数组缓冲时，长度为1024的整数倍。

		
		int len = 0;

		while((len=fr.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,len));
		}

	
		
		fr.close();

		/*
		//read方法的返回值。其实返回的就是往数组里装的字符个数。
		int num = fr.read(buf);
		System.out.println(num+"::"+new String(buf));
		int num1 = fr.read(buf);
		System.out.println(num1+"::"+new String(buf,0,num1));
		
		int num2 = fr.read(buf);
		System.out.println(num2);
		*/
		/*
		//演示的是read的自定向下读取。
		fr.read(buf);//将流所关联的字符数据一个一个都读到数组中。

		System.out.println(new String(buf)+"..");//ab
		fr.read(buf);//将流所关联的字符数据一个一个都读到数组中。

		System.out.println(new String(buf)+"..");

		*/
	}
}
