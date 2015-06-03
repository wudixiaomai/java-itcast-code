/*
练习：记录一个程序运行的次数，当满足指定次数时，该程序就不可以在继续运行了。
	  通常可用于软件使用次数的限定。

思路：
1，需要定义计数器。
	但是程序运行完以后，程序就在内存中被清除。
	那么下次在运行，计数器就还原。
	如何才可以记录住每一次计数器的变化呢？
	那么可以将该计数器的变化持久化存储一下。
	存的时候为了明确存入的值的特点，可以给该值起个名称。
	所以最好以 名称=值 的形式。就是键值对。
	
2，文件中的数据要获取就必须要使用流对象。

3，要操作键值对要使用Map集合。

4，可以和流相结合的map集合就是Properties。

5，通过Properties集合的load方法，将数据进行加载。

6，对数据进行修改后，重新存储。

7，也就是，软件每一次在启动时，都要先读取该配置文件，对获取的次数进行判断，
	满足条件，软件退出，否则，就对该次数自增后重新存储。


*/
import java.io.*;
import java.util.*;
class  ProgramCount
{
	public static void main(String[] args) throws IOException
	{
		int count = 0;
		Properties prop = new Properties();


		/*
		因为第一次运行时，该文件是不存在的。
		所以会发生FileNotFoundException异常。

		既使有这个文件，该文件第一次也没有对应 键。
		
		所以，可以这样解决一下。

		对该异常进行处理。
		在处理过程中给集合指定该键和值。
		*/
		
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream("time.ini");			
			prop.load(fis);
		}
		catch (FileNotFoundException e)
		{
			//文件虽然不存在，但是可以先给集合进行键值对的定义，
			//以便于下面获取指定键值方便。
			prop.setProperty("cishu",count+"");
		}


		String value = prop.getProperty("cishu");
		count = Integer.parseInt(value);

		if(count==5)
		{
			System.out.println("试用次数已到，给钱！");
			//return ;
			System.exit(0);
		}
		count++;
		prop.setProperty("cishu",count+"");

		FileOutputStream fos = new FileOutputStream("time.ini");

		prop.store(fos,"");


		fos.close();
		if(fis!=null)
			fis.close();


	}

	public static void method()throws IOException
	{
		int count = 0;
		//1,建立一个Properties集合。
		Properties prop = new Properties();

		//2,定义读取流对象和指定文件相关联。
		FileInputStream fis = new FileInputStream("time.ini");

		//3,通过Properties集合的load方法将数据加载进集合。
		prop.load(fis);

		//4,取出指定键所对应的值，
		String value = prop.getProperty("cishu");

		//5,对值进行自增。
		count = Integer.parseInt(value);
		count++;
		//6,将自增后的count进行重新存储。
		prop.setProperty("cishu",count+"");

		//7,将集合中的数据持久化存储到time.ini文件中。
		FileOutputStream fos = new FileOutputStream("time.ini");

		prop.store(fos,"");


		//8,关闭资源。
		fos.close();
		fis.close();

	}
}

