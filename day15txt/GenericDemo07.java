/*
通配符： ？

泛型限定：
？ extends E:接收E类或者E的子类型。上限
？ super E:接收E类型或者E的父类型。下限


*/

import java.util.*;
class Tool<Q>
{
	void show(Q q)
	{
		System.out.println("shwo :"+q);
	}
	public String  toString()
	{
		return "tool string ";
	}
}

class Person
{
	private String name;
	Person (String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}

class Student extends Person
{
	Student (String name)
	{
		super(name);
	}
}
class  GenericDemo07
{
	public static void main(String[] args) 
	{
		//Tool<String> tool= new Tool<String>();
		Tool<Student> tool = new Tool<Student>();
		show(tool);

		
		TreeSet<Student> ts = new TreeSet<Student>();

		ts.add(new Student("zhangsan"));


		
		Tool<String> t1 = new Tool<String>();
		method(t1,"hahhahs");
	}

	public static <T> void method(Tool<T> t,T obj)
	{
		t.show(obj);
	}

	public static void show(Tool<? extends Person> t)
	{
		System.out.println(t);
	}
}


class MyCompare implements Comparator<Person>
{
	public int compare(Person s1,Person s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}