/*
演示读取缓冲区BufferedReader。

1,创建字符读取流对象和源数据相关联。
2，为了提高效率，创建读取流缓冲区对象，将读取流对象作为参数传递给缓冲区的构造函数。
3，可以使用缓冲区的readLine方法，一次读取一行，来读取文本，效率提高。
4，关闭缓冲区，其实就是在关闭流。
*/
import java.io.*;
class  BufferedReaderDemo
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("buf.txt");

		BufferedReader bufr = new BufferedReader(fr);

		//BufferedReader bufr = new BufferedReader(new FileReader("buf.txt"));

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}
		bufr.close();
	}
}
