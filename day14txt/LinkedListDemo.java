/*

演示LinkedList中特有方法.
特有方法：
addFirst():
addLast();
在jdk1.6,
offerFirst();
offerLast();


getFirst();
getLast();
jdk1.6
peekFirst();
peekLast();


removeFirst();
removeLast();
jdk1.6
pollFirst();
pollLast();


对于获取和删除，如果集合中没有元素，那么会出现NoSuchElementException。
到了jdk1.6，如果使用新方法peek，poll。
如果集合没有元素，那么不会出现异常，而是返回null.



LinkedList是可以模拟一些其他的数据结构的。

1，堆栈:先进后出，
2，队列:先进先出。
*/
import java.util.*;
class  LinkedListDemo
{
	public static void main(String[] args) 
	{
		LinkedList link = new LinkedList();
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		link.addFirst("abc4");

		while(!link.isEmpty())
		{
			System.out.println("remove:"+link.removeFirst());
		}

		/*
		System.out.println("first:"+link.getFirst());//abc4
		System.out.println("last:"+link.getLast());
		
		System.out.println("removelast:"+link.removeLast());

		
		System.out.println(link);
		*/
	}
}


