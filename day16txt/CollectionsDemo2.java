import java.util.*;

/*

演示一下sort max操作自定义元素。

<T extends Object & Comparable<? super T>> 
:该方法操作的类型必须是Object以及Comparable接口的子类型。

public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)


*/
class  CollectionsDemo2
{
	public static void main(String[] args) 
	{
		ArrayList<Person> al = new ArrayList<Person>();
		al.add(new Person("haha1",30));
		al.add(new Person("haha2",35));
		al.add(new Person("haha3",32));

		Person p = Collections.max(al);
		System.out.println(p);
	}
}

class Person implements Comparable<Person>
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public int compareTo(Person p)
	{
		if(this.age>p.age)
			return 1;
		if(this.age<p.age)
			return -1;
		return this.name.compareTo(p.name);
	}
	public String toString()
	{
		return name+":"+age;
	}
}