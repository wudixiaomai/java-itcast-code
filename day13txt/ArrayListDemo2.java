/*
Collection
	|--List:列表中的元素都有角标。而且元素是有序的。可以重复。
		|--ArrayList：底层使用的数组数据结构。是不同步的。增删较慢。但是查询很快。
		|--LinkedList:底层是链表数据结构。增删的速度很快。查询很慢。
		|--Vector：底层使用的数组数据结构。是同步的。被ArrayList替代。无论增删还是查询，都超慢。

	|--Set:元素是不可以重复，而且元素是无序的。


该示例演示的是List接口中的特有方法。
可以通过角标操作元素的方法。

*/
import java.util.*;
class  ArrayListDemo2
{
	public static void main(String[] args) 
	{

		ArrayList al = new ArrayList();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");

		System.out.println(al);
		System.out.println("-----------------------");
		//1,在指定位置添加元素。
		al.add(1,"haha");

		//2,修改指定位置的元素。
		al.set(2,"qq");

		//3，删除指定位置的元素。
		al.remove(0);

		//4，获取指定元素的位置。
		int index = al.indexOf("qq");
		System.out.println("index="+index);

		//5,获取子列表。
		List ll = al.subList(1,2);
		System.out.println("ll:"+ll);


		//6,获取元素。
		for(int x=0; x<al.size(); x++)
		{
			System.out.println("get("+x+"):"+al.get(x));
		}


		System.out.println(al);

		
	}
}
