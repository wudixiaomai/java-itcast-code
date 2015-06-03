/*
泛型涉及的小细节。

1，定义泛型左右都一致。
2，在泛型方法中不可以使用泛型对象的特有方法。

*/
import java.util.*;
class  GenericDemo08
{
	public static void main(String[] args) 
	{
		ArrayList<Object> al = new ArrayList<String>();

		al.add("haha");
		al.add("haha2");
		printElement(al);
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(3);
		al1.add(4);

		printElement(al1);
//		al.add("haha");
//		al.add(123);
//
//		show("haha");
//		show(new Integer(1));
	}

	public static  void printElement(Collection<?> coll)
	{
		Iterator<?> it = coll.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	public static <T> void show(T t)
	{
		t.toString();
	}
}

