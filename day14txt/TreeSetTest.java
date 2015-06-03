/*
将学生存入TreeSet集合。
要求按照姓名排序。

*/
import java.util.*;
class  TreeSetTest
{
	public static void main(String[] args) 
	{
		TreeSet ts =new TreeSet();

		ts.add(new Student("lisi1",29));
		ts.add(new Student("lisi3",22));
		ts.add(new Student("lisi2",21));
		ts.add(new Student("lisi2",26));
		ts.add(new Student("lisi5",25));
		ts.add(new Student("lisi5",25));
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
		Student s = (Student)obj;

		int num = this.name.compareTo(s.name);

		return num==0?new Integer(this.age).compareTo(new Integer(s.age)):num;
	}

	public int compareTo1(Object obj)
	{
		Student s = (Student)obj;
		
		int num = this.name.compareTo(s.name);
		if(num==0)
		{

			return new Integer(this.age).compareTo(new Integer(s.age));
			/*
			if(this.age>s.age)
				return 1;
			if(this.age<s.age)
				return -1;
			return 0;
			*/
		}


		return num;
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
		return name+"--"+age;
	}

}

