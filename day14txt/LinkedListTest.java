/*
通过LinkedList模拟一个队列出来。

思路：
要对队列进行描述，将这种先进先出的数据结果封装到该描述中。
底层使用的就是LinkedList对象。


重点，一定要会写。


*/
import java.util.*;
class DuiLie
{
	private LinkedList link ;

	DuiLie()
	{
		link = new LinkedList();
	}
	/*
	添加元素的方法。
	*/
	public void myAdd(Object obj)
	{
		link.addLast(obj);
	}

	/*
	获取的方法
	*/
	public Object myGet()
	{
		return link.removeFirst();
	}

	/*
	判断方法。
	*/
	public boolean isNull()
	{
		return link.isEmpty();
	}
}


class  LinkedListTest
{
	public static void main(String[] args) 
	{

		DuiLie dl = new DuiLie();
		dl.myAdd("abc1");
		dl.myAdd("abc2");
		dl.myAdd("abc3");
		dl.myAdd("abc4");
		while(!dl.isNull())
		{
			System.out.println(dl.myGet());
		}
	}
}


