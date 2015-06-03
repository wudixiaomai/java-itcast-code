/*
将指定目录下的所有java文件(包括子目录中的java文件)的绝路路径存储到一个文本文件中。

思路：
1，先对执行目录进行递归遍历。
2，将遍历到符合条件的file对象存储到一个临时容器中。
3，对容器中的文件进行操作，将file对象的路径写入到一个文件中。


*/

import java.io.*;
import java.util.*;
class  JavaFileList
{
	public static void main(String[] args) throws IOException
	{
		List<File> list = new ArrayList<File>();
		FilenameFilter filter = new MyFilter();
		File dir = new File("F:");
		File destFile = new File("javalist.txt");

//		System.out.println(list.size());

		listFile(dir,filter,list);

		write2File(list,destFile);

//		System.out.println(list.size());
//		for(File f : list)
//		{
//			System.out.println(f);
//		}
	}

	public static void listFile(File dir,FilenameFilter filter,List<File> list)
	{
		File[] files = dir.listFiles();

		for(int x=0; x<files.length; x++)
		{
			if(files[x].isDirectory())
				listFile(files[x],filter,list);
			else
			{
				if(filter.accept(dir,files[x].getName()))
				{
					list.add(files[x]);
				}
			}
		}
	}

	public static void write2File(List<File> list,File destFile)throws IOException
	{

		BufferedWriter bufw = new BufferedWriter(new FileWriter(destFile));

		for(File f : list)
		{
			bufw.write(f.getAbsolutePath());
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
	}
}
	
class MyFilter implements FilenameFilter
{
	public boolean accept(File dir,String name)
	{
		return name.endsWith(".class");
	}
}