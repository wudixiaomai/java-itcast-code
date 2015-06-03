import java.util.*;
/*
常用方法：
对Tree集合进行排序的逆转。
//将默认顺序，也就是自然顺序进行逆转，
Comparator reverseOrder();

//将指定的比较器的顺序进行逆转。
Comparator reverserOrder(Comparator);
*/
class  CollectionsDemo4
{
	public static void main(String[] args) 
	{
		TreeSet<Integer> ts= new TreeSet<Integer>(Collections.reverseOrder());
		ts.add(6);
		ts.add(2);
		ts.add(7);
		ts.add(1);
		
		System.out.println(ts);

		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);

		Collections.shuffle(al);
		System.out.println("al:"+al);

	}
}


/*
字符串进行长度由大到小的排序。
只要定义一个比较器，从小到大排序。通过逆转就可以完成该动作。

TreeSet ts = new TreeSet(new StrCompareByLen());//是按照字符串长度由小到大的顺序。



TreeSet ts = new TreeSet(Collections.reverseOrder(new StrCompareByLen());//是按照字符串长度由大到小的顺序。

*/
/*

//synchronizedList方法的原理。


class Collections 
{
	public static List synchronizedList(List list)
	{
		return SynList(list);
	}

	static class SynList 
	{
		private List list;
		private Object lock = new Object();
		
		SynList(List list)
		{
			this.list = list;
		}

		public void add(E e)
		{
			synchronized(lock)
			{
				list.add(e);
			}
		}
		public void remove(E e)
		{
			synchronized(lock)
			{
				list.remove(e);
			}
		}
	}
}
*/


public static int halfSearch(List<String> list,String key)
{
	int max,min,mid;
	max = list.size()-1;
	min = 0;

	while(min<=max)
	{
		mid = (max+min)/2;

		String midStr = list.get(mid);
		
		int num = key.compareTo(midStr);
		if(num>0)
			min = mid + 1;
		else if(num<0)
			max = mid - 1;
		else
			return mid;


	}
}

public static int halfSearch(List<String> list,String key,Comparator<String> comp)
{
	int max,min,mid;
	max = list.size()-1;
	min = 0;

	while(min<=max)
	{
		mid = (max+min)/2;

		String midStr = list.get(mid);
		
		int num = comp.compare(key,midStr);
		if(num>0)
			min = mid + 1;
		else if(num<0)
			max = mid - 1;
		else
			return mid;


	}

	return -(min+1)-1;
}
