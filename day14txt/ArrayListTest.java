/*
往集合中存储自定义的对象。
存入一些人对象。
1，先要对要操作的对象进行描述，定义class。
2，将该类对象存入集合。
3，对对象元素进行操作。


*/

import java.util.*;
class  ArrayListTest
{
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		al.add(new Person("lisi1",30));
		al.add(new Person("lisi2",31));
		al.add(new Person("lisi3",32));
		al.add(new Person("lisi4",33));

		boolean b = al.remove(new Person("lisi2",31));
		System.out.println("b="+b );
		System.out.println(al);

		/*
		for(int x=0; x<al.size(); x++)
		{
			System.out.println(al.get(x));
		}
		*/
		
		/*
		Iterator it = al.iterator();
		while(it.hasNext())
		{

			//Object obj = it.next();
			//Person p = (Person)obj;
			//简写。
			Person p = (Person)it.next();
			System.out.println(p.getName()+"---"+p.getAge());

			
			
				
			//常见小问题。因为next会操作指针所以调用一次即可。
			//System.out.println(((Person)(it.next())).getName()+"-----"+((Person)(it.next())).getAge());
//			System.out.println(it.next().toString());
		}
		*/
	}
}


class Person
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}

	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
			return false;


		Person p = (Person)obj;
		return this.name.equals(p.name)&& this.age == p.age;
		/*if(this.name.equals(p.name) && this.age == p.age)
			return true;
		return false;
		*/
	}
	public String toString()
	{
		return name+":"+age;
	}
}