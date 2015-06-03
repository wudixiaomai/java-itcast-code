/*
集合：就是一个容器。
1，用于存储对象的。
2，该容器的长度是可变的。

因为装对象的容器内部的数据结构不同，
这些容器很很多中，经过了不断的抽取，就形成了体系。

这个体系我们称之为集合框架。

当我们学习一个体系的时候，
先要明确该体系的基本功能。


演示Collection中的方法。
*/

import java.util.*;

class ArrayListDemo
{
	public static void main(String[] args)
	{
		//1,通过Collection的子类对象，创建一个容器。其实集合对象中存放都是元素的引用(地址)
		ArrayList al = new ArrayList();

		//2,可以Collection的共性方法添加一些元素。
		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		al.add("abc4");


		ArrayList al1 = new ArrayList();
		al1.add("qq1");
		al1.add("qq2");
		al1.add("qq3");
		//al1.add("abc1");
		
		//添加一堆元素。
		//al.addAll(al1);

		//3,删除一个元素。
		al.remove("abc3");


		//4,交集。
		//boolean b = al.retainAll(al1);
		//System.out.println("b="+b);


		//5，清空集合。
		//al.clear();
		//获取集合的长度。
		

		//6,判断一个元素。其实用的还是equals方法。判断元素是否相同。

		//boolean b = al.contains("abc22");
		//System.out.println("b="+b);

		//System.out.println(al.size());
		
		iteratorDemo();
		

		//System.out.println(al.toString());//[abc1, abc2, abc4]
		/*
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next()+"..");
		}
		al.retainAll(al1);
		Iterator it1 = al.iterator();
		while(it1.hasNext())
		{
			System.out.println(it1.next()+"--");
		}
		*/

	}

	public static void iteratorDemo()
	{
		ArrayList al = new  ArrayList();
		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		al.add("abc4");

		
		/*
		什么是迭代器？
		就是用于取出集合中元素的对象。
		该对象因为每一个容器的数据结构不同，所以实现方式也不一样，而且
		迭代器是容器中的内容，所以是通过内部类来实现，也即是进行了容器内部封装。
		我们只要通过iterator()方法获取该对象即可操作容器中的元素。

		迭代器就如同大型游戏机中的抓布娃娃的游戏机，迭代器就是该游戏机中的那个夹子！

		*/
		Iterator it = al.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}


		for(Iterator it1 = al.iterator(); it1.hasNext(); )
		{
			System.out.println(it1.next());
		}


//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());//.NoSuchElementException
	}
}

/*
建立两个容器，A B
分别给容器中添加元素。

要求：获取A容器中的与B容器交集的元素，

将这些元素打印。


*/