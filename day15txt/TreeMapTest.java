/*
练习：
每一个学生都有自己的归属地。
学生和归属地之间存在着映射关系。
学生有自己的姓名和年龄。
归属地用String表示。

键：Student。
值：String。
往HashMap集合中存入学生及对应的归属地。
通过两个取出方式将数据打印。

要求：按学生的年龄进行排序。

*/
import java.util.*;

class TreeMapTest 
{
	public static void main(String[] args) 
	{
		TreeMap<Student,String> tm = new TreeMap<Student,String>(new CompareByName());
		tm.put(new Student("lisi1",21),"北京");
		tm.put(new Student("lisi2",27),"上海");
		tm.put(new Student("lisi3",22),"天津");
		tm.put(new Student("lisi4",29),"南京");
		tm.put(new Student("lisi5",23),"沈阳");
		tm.put(new Student("lisi5",23),"大连");

		

		Set<Map.Entry<Student,String>> entrys = tm.entrySet();
		Iterator<Map.Entry<Student,String>> it = entrys.iterator();

		while(it.hasNext())
		{
			Map.Entry<Student,String> me = it.next();
			Student stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu.getName()+":"+stu.getAge()+":"+addr);
		}

	}
}

class CompareByName implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		int num = s1.getName().compareTo(s2.getName());
		if(num==0)
		{
			if(s1.getAge()>s2.getAge())
				return 1;
			if(s1.getAge()<s2.getAge())
				return -1;
			return 0;
		}
		return num;
	}
}



class Student implements Comparable<Student>
{
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student s)
	{
		if(this.age>s.age)
			return 1;
		if(this.age<s.age)
			return -1;
		return this.name.compareTo(s.name);
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public int hashCode()
	{
		return name.hashCode()+age*27;

	}
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(!(obj instanceof Student))
			return false;
		Student s = (Student)obj;

		return this.name.equals(s.name) && this.age==s.age;
	}
	public String toString()
	{
		return name+"::"+age;
	}
}

