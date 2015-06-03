/*
SequenceInputStream:
可以将多个读取流合并成一个读取流。


*/
import java.io.*;
import java.util.*;
class  SequenceStream
{
	public static void main(String[] args) throws IOException 
	{
		
		demo2();

	}
	/*
	Vector很遗憾，效率非常低。被ArrayList替代。

	*/
	public static void demo2()throws IOException 
	{
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
			for(int x=1; x<=3; x++)
				al.add(new FileInputStream(x+".txt"));
		

		final Iterator<FileInputStream> it = al.iterator();
		//迭代器和枚举的功能是一致的。
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>()
		{
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}
			public FileInputStream nextElement()
			{
				return it.next();	
			}
		};
		SequenceInputStream sis = new SequenceInputStream(en);


		FileOutputStream fos = new FileOutputStream("123.txt");

		byte[] buf = new byte[1024];

		int len = 0;
		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}

		fos.close();
		sis.close();
	}

	/*
	SequenceInputStream需要一个枚举接口对象。
	而枚举接口在Vector中存在。
	*/
	public static void demo()throws IOException 
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		for(int x=1; x<=3; x++)
			v.add(new FileInputStream(x+".txt"));

		Enumeration<FileInputStream> en = v.elements();

		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("4.txt");

		byte[] buf = new byte[1024];

		int len = 0;
		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}

		fos.close();
		sis.close();
	}
}
