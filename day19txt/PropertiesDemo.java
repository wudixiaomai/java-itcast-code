/*
Map
	|--Hashtable
		|--Properties

该集合中的键值对都是字符串。

该集合可以将设备上的指定格式信息存储进集合，并可以将集合中的信息进行持久化存储。
通常用于对键值对形式的配置文件进行操作。相当常用。！！

*/
import java.util.*;
import java.io.*;
class PropertiesDemo 
{
	public static void main(String[] args) throws IOException
	{
		//sysPropList();
		//loadFile();
		myLoad();
	}
	/*
	将硬盘中文件的键值对数据信息直接存储到集合中。

	*/
	public static void loadFile()throws IOException
	{
		//1,创建一个和流相关联的集合对象Properties。
		Properties prop = new Properties();
		System.out.println(prop.size());

		FileInputStream fis = new FileInputStream("user.txt");

		//3,使用Properties 集合的load方法将流中数据存储到集合中。

		prop.load(fis);

		//将集合中的键对应的值进行了修改。
		prop.setProperty("wangwu","20");


		//将修改后的数据重新存入到原文件中。
		FileOutputStream fos  = new FileOutputStream("user.txt");

		prop.store(fos,"haha");

		System.out.println(prop);
		fos.close();
		fis.close();

	}


	public static void sysPropList()throws IOException
	{
		Properties prop =System.getProperties();
		
//		prop.list(System.out);// 目的是控制台。
		//需求是：将jvm的属性信息存储到一个文件中。
		prop.list(new PrintStream("jvm.ini"));
	}

	public static void sysProp()
	{
		Properties prop =System.getProperties();

		Set<String> keys = prop.stringPropertyNames();

		for(String key : keys)
		{
			System.out.println(key+":"+prop.getProperty(key));
		}
	}

	/*
	load‘方法的原理。
	其实就是通过流读取指定文本数据信息，
	将读到的一行的数据作为字符串进行 等号 的切割。
	并将切割后的字符串数组中的元素作为键值存入Properties集合。

	*/
	public static void myLoad()throws IOException
	{
		BufferedReader bufr = new BufferedReader(new FileReader("user.txt"));

		String line = null;

		Properties prop = new Properties();

		while((line=bufr.readLine())!=null)
		{
			String[] arr = line.split("=");
			prop.setProperty(arr[0],arr[1]);


		}
		bufr.close();
		System.out.println(prop);
	}
}
