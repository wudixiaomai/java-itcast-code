/*
Collections:
集合框架的工具类。
它里面的方法都是静态的。

*/
import java.util.*;

/*
演示Collections中的
sort
max
方法。
*/
class  CollectionsDemo
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("cccc");
		al.add("abcde");
		al.add("aa");
		al.add("abc");
		al.add("abc");

		System.out.println(al);

		//对list集合进行排序。//其实使用的对象的compareTo方法。

		//Collections.sort(al);

		//按照指定的比较器进行list集合的排序。
		Collections.sort(al,new StrCompareByLen());

		System.out.println(al);

		//获取的是元素自然排序后，最大的元素。
//		String max = Collections.max(al);

		//获取按指定比较器后，最大的元素。
		String max = Collections.max(al,new StrCompareByLen());
		System.out.println("max="+max);
	}
}


class StrCompareByLen implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		if(s1.length()>s2.length())
			return 1;
		if(s1.length()<s2.length())
			return -1;
		return s1.compareTo(s2);
	}
}
