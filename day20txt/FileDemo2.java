import java.io.*;

/*
File的应用。
获取指定目录下所有的文件夹以及文件，包括子目录中的内容。


编程手法：递归。
1，递归就是函数自身调用自身。
2，在使用递归时，一定要注意限定条件。
否则内存溢出。

在使用递归时，不过调用次数过多，否则超出jvm的内存范围。一样会导致内存溢出。


2,需求：
	删除一个带内容的目录。
	原理：对于windows的删除。要先删除文件夹中所以内容后，才可以参数该文件夹。

	也就是需要从里往外删。

	删除动作要慎用！




*/

import java.io.*;

class  FileDemo2
{
	public static void main(String[] args) 
	{
		File dir = new File("f:\\java40");

		//getAll(dir,0);

		deleteAll(dir);



		FileReader fr = new FileReader("c:\\a.txt");

		File f = new File("c:\\a.txt");
		if(f.exists())
			FileReader fr = new FileReader(f);



	}

	public static void deleteAll(File dir)
	{
		File[] files = dir.listFiles();

		for(int x=0;x<files.length; x++)
		{
			if(files[x].isDirectory())
				deleteAll(files[x]);
			else
				System.out.println(files[x]+".."+files[x].delete());
		}
		System.out.println(dir+".."+dir.delete());
	}

	public static void getAll(File dir,int level)
	{
		System.out.println(getLevel(level)+dir.getName());
		level++;
		File[] files = dir.listFiles();
		for(int x =0; x<files.length; x++)
		{
			if(files[x].isDirectory())
				getAll(files[x],level);
			else
				System.out.println(getLevel(level)+files[x].getName());
		}
	}
	
	public static String getLevel(int level)
	{
		StringBuilder sb =  new StringBuilder();

		for(int x=0; x<level; x++)
		{
			sb.append("|--");
		}
		return sb.toString();
	}

	public static void toBin(int num)
	{
		if(num>0)
		{
			toBin(num/2);
			System.out.print(num%2);
		}
	}

	public static int getSum(int n)
	{

		if(n==1)
			return 1;
		return n+getSum(n-1);
	}
}
