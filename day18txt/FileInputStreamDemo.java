import java.io.*;
/*
演示FileInputStream
*/
class  FileInputStreamDemo
{
	public static void main(String[] args) throws IOException
	{

		FileInputStream fis = new FileInputStream("fos.txt");

		//System.out.println(fis.available());
		/*
		//这种方式貌似很爽。不用在循环，但是文件体积过大时，会导致创建字节数组，内存溢出。
		//要慎用。
		byte[] buf = new byte[fis.available()];

		fis.read(buf);

		System.out.println(new String(buf));
		*/
		
		byte[] buf =new  byte[1024];
		int len = 0;

		while((len=fis.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,len));
		}
		/**/
		fis.close();
	}
}
