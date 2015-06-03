import java.io.*;

class  CopyMp3
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();

		copy5();
		long end = System.currentTimeMillis();

		System.out.println((end-start)+"∫¡√Î");
	}

	public static void copy5()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.mp3");
		FileOutputStream fos = new FileOutputStream("c:\\6.mp3");

		MyBufferedInputStream bufis = new MyBufferedInputStream(fis);
		BufferedOutputStream bufos = new BufferedOutputStream(fos);

		
		int ch = 0;
		while((ch=bufis.myRead())!=-1)
		{
			bufos.write(ch);
		}
		
		bufos.close();
		bufis.myClose();

	}







	//15
	public static void copy1()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.mp3");

		FileOutputStream fos = new FileOutputStream("c:\\1.mp3");

		byte[] buf = new byte[1024*4];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}

		fos.close();
		fis.close();
	}
	//188
	public static void copy2()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.mp3");

		FileOutputStream  fos = new FileOutputStream("c:\\2.mp3");

		byte[] buf = new byte[fis.available()];

		fis.read(buf);

		fos.write(buf);

		fos.close();
		fis.close();
	}
	//500
	public static void copy3()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.mp3");
		FileOutputStream fos = new FileOutputStream("c:\\3.mp3");

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

	//
	public static void copy4()throws IOException
	{
		FileInputStream fis = new FileInputStream("c:\\0.mp3");

		FileOutputStream fos = new FileOutputStream("c:\\4.mp3");

		
		int ch = 0;
		while((ch=fis.read())!=-1)
		{
			fos.write(ch);
		}

		fos.close();
		fis.close();
	}
	
}
