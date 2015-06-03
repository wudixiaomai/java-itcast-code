/*
Collection中。
集合作为容器常见的方法：
1，增加，
	add(obj)
2，删除，
	remove(obj)
	clear();
3，判断。
	isEmpty()
	contains(obj)
4，个数。
	size()
5，取出。
	iterator();
	作为容器的取出元素方式，需要动作有可能不只一个，那么将这些动作进行了对象的封装。
	作为容器的一个内部事物存在，也就是通过内部类来描述取出方式，
	至于该取出方式在每一个容器中是如何实现的，那是依据每一个容器的数据结构而定的。
	被封装了，所以我们要做的，就是通过一个方法获取该内部类对象即可。
	该方法就是iterator。
	而每一个容器都有取出方式，所以每一容器都具备该方法。这些取出方式声明是一致的，
	但实现不同。所以取出一个接口Iterator
	相当于取出布娃娃的夹子。



Collection
	|--List：有序(存和取出的顺序是一致的)，有角标，可重复。
		|--ArrayList：底层是数组数据结构，查询的速度很快，线程是不安全的。可变数组的原理50%延长。
		|--LinkedList：底层是链表数据结构，增删的速度的快，线程是不安全的。
		|--Vector：底层是数组结构，无论查询或者增删都慢。线程是安全的。100%延长。被ArrayList替代。
	|--Set：无序，不可以重复。



在对list集合元素进行迭代过程中，不允许出现迭代以外的对元素的操作，因为这样容易产生安全隐患。
java会抛出一个异常，并发修改异常。java.util.ConcurrentModificationException

想要在迭代过程中操作元素，可以通过List集合的ListIterator 列表迭代器来完成。

迭代器只支持在迭代过程中删除动作。

而迭代器的子接口ListIterator，
还支持在迭代过程中，添加元素和修改元素的动作。


*/
import java.util.*;
class  ArrayListDemo3
{
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		al.add("abc4");
		
		ListIterator li = al.listIterator();

		System.out.println(li.hasPrevious());
		//System.out.println(li.previous());
		while(li.hasNext())
		{
			String s = (String)li.next();
			if(s.equals("abc2"))
				//li.add("haha");
				li.set("qq");
			System.out.println("next::"+s);
		}



		while(li.hasPrevious())
		{
			System.out.println("previous::"+li.previous());
		}

//		System.out.println(li.hasPrevious()+"....");
//		System.out.println(li.previous()+"...");
		/*
		Iterator it = al.iterator();
		while(it.hasNext())
		{		
			String s = (String)it.next();
			if(s.equals("abc2"))
				al.add("haha");
			System.out.println(s);			
		}
		*/
		System.out.println(al);
	}
}
