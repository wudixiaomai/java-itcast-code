import java.util.*;


/*
泛型：
JDK1.5版本以后出现的一个安全机制。

好处：
1,将运行时期出现的问题（ClassCastException）转移到了编译时期。
2,避免了强制转换的麻烦。


泛型的格式：
通过<>来指定容器中元素的类型。

*/
class GenericDemo01
{
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		//al.add(123);

		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			System.out.println(s.length());
		}
	}
}