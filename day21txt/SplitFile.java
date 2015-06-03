/*
文件切割。
原理：
	将一个文件中的数据分成等份存放在多个文件中。

*/
import java.io.*;
import java.util.*;
class  SplitFile
{
	public static void main(String[] args) throws IOException
	{
		merge();
//		splitFile();
	}

	public static void merge()throws IOException
	{
			
		//读取配置文件。

		File dir = new File("c:\\parts");
		File[] files = dir.listFiles(new FilenameFilter()
		{
			public boolean accept(File d,String name)
			{
				return name.endsWith(".properties");
			}
		});
		
//		System.out.println(files[0]);
		File file = files[0];

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);

		String filename = prop.getProperty("filename");

		int count = Integer.parseInt(prop.getProperty("filecount"));



		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();

		for(int x=1; x<count; x++)
		{
			File f = new File("c:\\parts\\"+x+".part");

			if(!f.exists())
			{
				throw new RuntimeException(f.getName()+"文件不存在，无法进行合并");
			}

			al.add(new FileInputStream("c:\\parts\\"+x+".part"));
		}

		final Iterator<FileInputStream> it = al.iterator();

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

		SequenceInputStream  sis = new SequenceInputStream(en);

		File parent = new File("c:\\parts");

		File destFile = new File(parent,filename);

		FileOutputStream fos = new FileOutputStream(destFile);

		byte[] buf = new byte[1024*4];

		int len = 0;

		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
		/**/

	}

	public static void splitFile()throws IOException
	{

		File file = new File("c:\\0.bmp");
		FileInputStream fis = new FileInputStream(file);


		FileOutputStream fos = null;
		byte[] buf = new byte[1024*1024];
		int len = 0;

		int count = 1;
		while((len=fis.read(buf))!=-1)
		{
			fos = new FileOutputStream("c:\\parts\\"+(count++)+".part");
			fos.write(buf,0,len);
			fos.close();
		}
		
		Properties prop = new Properties();

		prop.setProperty("filecount",count+"");
		prop.setProperty("filename",file.getName());

		fos = new FileOutputStream("c:\\parts\\"+(count)+".properties");

		prop.store(fos,"");
		fos.close();
	
		fis.close();
	}
}
