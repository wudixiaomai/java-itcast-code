/*
演示比较器的泛型。
*/
import java.util.*;
class  GenericDemo02
{
	public static void main(String[] args) 
	{
		
		TreeSet<Person> ts = new TreeSet<Person>(new Comparator<Person>()
		{
			public int compare(Person p1,Person p2)
			{
				return 1;
			}
		});

		ts.add(new Person("lisi1",21));
		ts.add(new Person("lisi2",22));
		ts.add(new Person("lisi3",23));

		Iterator<Person> it = ts.iterator();

		while(it.hasNext())
		{
			Person p = it.next();
			System.out.println(p);
		}


		System.out.println(ts);
	}
}


class Person implements Comparable<Person>
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name =name;
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