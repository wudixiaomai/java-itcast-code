/*
需求：写入数据的一些细节：
1，new FileWriter("a.txt");在创建写入流对象时，会在指定目录下创建文件，如果该文件已经存在，会被覆盖。

2，想要对已有的文件进行数据的续写怎么办呢？
	可以使用FileWriter的另一个带boolean型参数的构造函数。

3，想要往数据中写入换行。
	使用\n，通过记事本查看的时候出现了小黑框。
	那么是因为window中的回车符其实是两个字符所组成的。\r\n

4，目的地文件可以是相对路径，也可以是绝对路径。那么写路径分隔符的时候。
	有两中方式：\\   /
*/
import java.io.*;
class  FileWriterDemo3
{
	public static void main(String[] args) 
	{
		FileWriter fw = null;
		
		try
		{
			fw  = new FileWriter("c:/a.txt",true);
			fw.write("hello\r\nworld");
			
		}
		catch (IOException e)
		{
			System.out.println("io nono "+e.toString());
		}
		finally
		{
			if(fw!=null)//如果流对象没有建立成功是不要关闭的，所以要进行一下健壮性的判断。
				try
				{
					fw.close();
				}
				catch (IOException e)
				{
					System.out.println("close:"+e.toString());
				}
			
		}
	}
}
/*

1，将指定字符串数据存储到一个文件中。。

2，对该文件进行数据的续写。

要求，使用标准异常处理形式。

*/