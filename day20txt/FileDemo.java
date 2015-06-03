import java.io.*;
/*
通过这两天对流的学习，

流是用来操作设备上的数据的。

如果想要对数据在的文件进行操作，
比如判断该文件是否存在。或者将文件删除等操作。

为了操作文件或者文件夹。

io包中提供了一个File对象。
File：用于描述文件系统中的文件以及文件夹。将文件或者文件夹封装成了对象。



*/

import java.io.*;
import java.util.*;
class FileDemo 
{
	public static void main(String[] args) throws IOException
	{
		method_5();
	}

	//演示File类的构造函数。
	public static void method_1()
	{
		//在进行File对象初始化时，可以将已有的文件或者文件夹封装成对象。
		//也可以将不存在的文件或者文件夹封装成对象。

		File file = new File("c:\\haha.txt");


		//将c:\\a.txt文件封装成了对象。
		File f = new File("c:\\a.txt");

		//通过两个参数完成。
		File f1 = new File("c:\\","a.txt");

		File f2 = new File("c:\\");

		File f3 = new File(f2,"a.txt");

		
		//在任何系统平台下都是目录分隔符。自动会获取该系统的分隔符。
		File f4 = new File("c:"+File.separator+"abc"+File.separator+"a.txt");


	}


	public static void method_2()throws IOException
	{
		File file = new File("c:\\demo.txt");

		//演示createNewFile():在指定为位置创建文件，如果该文件已经存在， 不会创建。
		boolean b = file.createNewFile();
		System.out.println("create:"+b);
		
		

		//file.deleteOnExit();//告诉jvm，在jvm退出时，将该文件删除，//无论是否发生异常或者其他情况。



		//演示delete();用于删除文件或者文件夹，如果返回true，删除成功。注意：不走回收站。
		//boolean b1 = file.delete();
		//System.out.println("delete:"+b1);

		//演示exists();判断文件或者文件夹是否存在。
		boolean b2 = file.exists();
		System.out.println("exists:"+b2);


	}

	public static void method_3()
	{
		File file = new File("time.ini");

		//1获取去文件或者文件夹的名称。
		String name = file.getName();
		System.out.println("name="+name);

		//2,获取文件或者文件夹的父目录。
		String parent = file.getParent();
		System.out.println("parent="+parent);

		//3,获取文件的绝对路径。
		String absPath = file.getAbsolutePath();
		System.out.println("absPath="+absPath);
		

		//4,获取文件的相对路径。
		String path = file.getPath();
		System.out.println("path="+path);



		/*
		结论：如果file对象中封装的路径是一个绝对路径。
		无论File类中封装的文件或者文件夹是相对路径还是绝对路径。
		getAbsolutePath():返回的都是绝对路径。
		getPath():返回的是File对象中封装的路径。
		
		getParent();如果封装的是相对路径，该方法返回null。
		*/
		
	}

	public static void method_4()
	{
		File file = new File("c:\\c.txt");

		boolean b = file.isFile();

		System.out.println("file:"+b);

		boolean b1 = file.isDirectory();
		System.out.println("directory:"+b1);


		//isHidden():判断文件或者文件夹是否是隐藏。通常系统文件都是隐藏的。所以在获取文件时，尽量不要获取隐藏的。



		/*
		注意：在进行文件或者文件夹判断时，必须要先判断该文件或者文件夹是否存在。

		if(file.exists())
		{
			 if( file.isFile())
		}
		*/


		File dir = new File("c:\\kk\\a\\c\\d\\x\\s\\a\\w\\e\\t");
		//dir.mkdir();//创建文件夹。
		dir.mkdirs();//创建多级目录。

		File f1 = new File("c:\\haha.txt");
		File f = new File("d:\\demo.txt");
		boolean b2 = f1.renameTo(f);

		System.out.println("rename:"+b2);

		//renameTo方法，在同一目录，可以完成对文件的重命名，在不同目录下，可以完成对文件移动。

	}

	public static void method_5()
	{
		File[] roots = File.listRoots();//列出本机存在盘符。

		for(File root : roots)
		{
			//System.out.println(root);
		}

		
		//演示list方法。
		File dir = new File("c:\\");

		String[] names = dir.list();//列出指定目录下当前的文件夹以及文件的名称。
		for(String name : names)
		{
			//System.out.println(name);
		}

		File file = new File("c:\\");

		//System.out.println(file.getAbsolutePath());

		String[] javas = file.list(new FilenameFilter()
		{
			public boolean accept(File dir,String name)
			{

				//System.out.println(dir+"--"+name);
				/*
				if(name.endsWith(".java"))
					return true;
				return false;
				*/
				File f = new File(dir,name);
				//System.out.println(f.getAbsolutePath()+"..."+f.isFile());
				return f.isFile() && name.endsWith(".java");
			}
		});
	

		/*
		过滤器:
		根据指定的条件获取数据。其实就是在自动调用accept方法。只要返回为true的都视为符合条件。

		*/
		System.out.println("len:"+javas.length);

		//System.out.println(Arrays.toString(javas));
		for(String java : javas)
		{
			System.out.println(java);
		}
		

		/*
		注意：list或者listFiles方法获取的都是当前目录下的文件或者文件夹，不包括子文件或者文件夹。

		*/
	}

}
/*

File(String parent,String child)
{
	this(new File(parent),child);

}

File(File parent ,String child)
{
	
}


FileWriter(String filename)
{
	File f = new File(filename);
	if(f.exists())
		f.delete();
	f.createNewFile();
}


File  getAbsoluteFile()
{

	String path = getAbsolutePath();
	return new File(path);
}
*/