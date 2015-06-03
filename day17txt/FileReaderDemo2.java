/*
另一种读取方式。
不带参数的read方法。

*/
import java.io.*;
class  FileReaderDemo2
{
	public static void main(String[] args) 
	{

		FileReader fr = null;
		try
		{
			fr = new FileReader("text.txt");
			
			int ch = 0;

			while((ch=fr.read())!=-1)
			{
				System.out.print((char)ch);
			}

			/*
			// 使用read方法，一次读一个字符，该方法返回的是：读到的那个字符。
			int ch = fr.read();
			System.out.println((char)ch);
			int ch1 = fr.read();
			System.out.println((char)ch1);
			*/
		}
		catch (IOException e)
		{

			System.out.println(e.toString());
		}
		finally
		{
			if(fr!=null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{
					System.out.println("close:"+e.toString());
				}
		}
	}
}
