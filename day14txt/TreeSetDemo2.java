/*
演示TreeSet集合的第二种比较方式。

如果元素自身不具备比较性。
或者元素自身具备的比较性不是所需要的。

这时只能用第二种方式排序。
让容器自身具备比较性。
其实就是定义一个类实现Comparator接口，覆盖compare方法，
并将该类对象作为参数传递给TreeSet集合的构造函数。

当元素自身具备比较性，这时自然排序，也称为默认排序，
当给通过构造函数给TreeSet集合指定了比较器时，以比较器的比较方式为主。


*/
import java.util.*;
class  TreeSetDemo2
{
	public static void main(String[] args) 
	{

		TreeSet ts = new TreeSet(new MyCompare());

		ts.add(new Person(30));
		ts.add(new Person(35));
		ts.add(new Person(30));
		ts.add(new Person(32));
		ts.add(new Person(29));
		System.out.println(ts);
	}
}


class MyCompare  implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Person p1 = (Person)o1;
		Person p2 = (Person)o2;

		if(p1.getAge()>p2.getAge())
			return 1;
		if(p1.getAge()<p2.getAge())
			return -1;
		return 0;
	}
}

class Person implements Comparable
{
	private int age;
	Person(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
	public int compareTo(Object obj)
	{
		Person p = (Person)obj;
		if(this.age>p.age)
			return -1;
		if(this.age<p.age)
			return 1;
		return 0;
	}
	public String toString()
	{
		return "person:"+age;
	}
}

/*
作业：
对字符串进行长度排序。

*/