/*
System:
	用于描述jvm，该类中方法都是静态的。
	内部封装了一个Properties对象。


Map
	|--Hashtable
		|--Properties

Properties:
	getProperty(key);
	setProperty(key,value);

System:
	static getProperty(key);
	static setProperty(key,value);

*/
/*
练习1：
获取系统属性信息。通过entrySet获取打印。
练习2：
动态的给系统添加一些属性信息。-D
*/
import java.util.*;
class  SystemDemo
{
	public static void main(String[] args) 
	{
		//通过System类的getProperties方法获取jvm系统启动时的一些基本属性信息。
		Properties prop = System.getProperties();
		
		//获取指定属性信息。
		String sysname = prop.getProperty("os.name");
		System.out.println("name:"+sysname);

		System.setProperty("mykey","myValue");

		String myvalue = prop.getProperty("mykey");
		System.out.println("my:"+myvalue);


		//获取一个动态指定的属性信息。
		/*
		要想获取到动态的属性信息。
		需要在启动jvm时，通过参数的配置来完成。
		java -Dhahakey=zzzz SystemDemo
		v=zzzz
		*/
		String v = System.getProperty("hahakey");
		System.out.println("v="+v);


		/*
		//获取系统所有基本属性信息。
		Set keys = prop.keySet();
		Iterator it = keys.iterator();
		while(it.hasNext())
		{
			String key = (String)it.next();
			String value = (String)prop.get(key);
			System.out.println(key+":::"+value);
		}
		*/

	}
}
