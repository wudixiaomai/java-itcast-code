import java.io.*;

/*
¿½±´Í¼Æ¬¡£

*/
class  CopyJpg
{
	public static void main(String[] args) throws IOException
	{
		copy4();
	}
	public static void copy1()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.bmp");

		FileOutputStream fos = new FileOutputStream("c:\\1.bmp");

		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}

		fos.close();
		fis.close();
	}
	public static void copy2()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.bmp");

		FileOutputStream  fos = new FileOutputStream("c:\\2.bmp");

		byte[] buf = new byte[fis.available()];

		fis.read(buf);

		fos.write(buf);

		fos.close();
		fis.close();
	}
	public static void copy3()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.bmp");
		FileOutputStream fos = new FileOutputStream("c:\\3.bmp");

		BufferedInputStream bufis = new BufferedInputStream(fis);
		BufferedOutputStream bufos = new BufferedOutputStream(fos);

		
		int ch = 0;
		while((ch=bufis.read())!=-1)
		{
			bufos.write(ch);
		}
		
		bufos.close();
		bufis.close();

	}
	public static void copy4()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.bmp");

		FileOutputStream fos = new FileOutputStream("c:\\4.bmp");

		
		int ch = 0;
		while((ch=fis.read())!=-1)
		{
			fos.write(ch);
		}

		fos.close();
		fis.close();
	}
}
