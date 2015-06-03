/*
拷贝文本文件。
copy原理：
先读取源数据，让将读到的数据写入到目的地中。

如果使用流对象来完成：
1，字符读取流对象。
2，字符写入流对象。


使用了字符数组缓冲区。







*/
import  java.io.*;
class  CopyTextFile
{
	public static void main(String[] args) 
	{
		FileReader fr = null;
		FileWriter fw = null;
		try
		{
			fr = new FileReader("IO流.txt");
			fw = new FileWriter("copyio.txt");

			char[] buf = new char[1024];

			int len = 0;

			while((len=fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			if(fw!=null)
				try
				{
					fw.close();
				}
				catch (IOException e)
				{
					System.out.println(e.toString());
				}
			if(fr!=null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{
					System.out.println(e.toString());
				}
		}
		/*
		finally
		{
			try
			{
				if(fw!=null)
					fw.close();
			}
			catch ()
			{
			}
			finally
			{
				try
				{
					if(fr!=null)
						fr.close();
				}
				catch ()
				{
				}
			}
		}
		*/
	}
}
