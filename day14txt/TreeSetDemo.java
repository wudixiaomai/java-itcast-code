/*
演示TreeSet集合。

Treeset:底层数据结构是二叉树。
TreeSet集合可以对Set集合中的元素进行排序。

存入TreeSet集合中的元素需要具备比较性。
而这个比较性是需要实现一个Comparable接口。


TreeSet集合如何保证元素唯一性的呢？
比较方法的return 0.

TreeSet集合的第一种比较方式。
让元素自身具备比较性，复写Comparable接口中的comparTo方法。


*/

import java.util.*;

class  TreeSetDemo
{
	public static void main(String[] args) 
	{
		TreeSet ts =new TreeSet();

		ts.add(new Student("lisi1",29));
		ts.add(new Student("lisi2",28));
		ts.add(new Student("lisi3",22));
		ts.add(new Student("lisi4",25));

		System.out.println(ts);
	}
}
class Student implements Comparable
{
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	public int compareTo(Object obj)
	{
		
		System.out.println(this+"..compareTo...."+obj);
		Student s = (Student)obj;
		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
		{
			/*
			int num = this.name.compareTo(s.name);
			if(num>0)
				return 1;
			if(num<0)
				return -1;
			return 0;
			*/
			return this.name.compareTo(s.name);

		}
		return -1;
		
		//return 1;//可以使TreeSet集合出现有序情况，存入顺序和取出顺序一致。
	}

	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return "student:"+name+"--"+age;
	}

}

/*
将学生存入TreeSet集合。
要求按照姓名排序。

*/