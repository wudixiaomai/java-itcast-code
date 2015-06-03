/*
演示FileOutputStream。
*/
import java.io.*;
class  FileOutputStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fos = new FileOutputStream("fos.txt");

		fos.write("abcede".getBytes());//可以直接写到目的地中。

		fos.close();//只用于关闭资源。
		
	}
}
