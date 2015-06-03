/*
Set:无序，不可以重复
Set接口的中的方法和Collection一致。
	|--HashSet:底层的数据是哈希表,如何判断元素相同呢？通过两个方法完成。hashCode(),equals();
				当hashCode值相同，equals返回true时，hashset集合认为这两个元素是相同元素。只存储一个。
				调用原理：先判断hashCode方法的值，如果相同，才会判断equals。，如果不相同，是不会调用equals方法。

	|--TreeSet:



HashSet集合在判断元素是否相同，参考的是hashCode方法，在参考equals方法。
而ArrayList集合，在判断原始是否相同参考的是equals。
*/
import java.util.*;
class  HashSetDemo
{
	public static void main(String[] args) 
	{

		HashSet hs = new HashSet();

		hs.add(new Student("lisi1",21));
		hs.add(new Student("lisi2",22));
		hs.add(new Student("lisi3",23));
		//hs.add(new Student("lisi4",24));
		//hs.add(new Student("lisi3",23));
		
		boolean b = hs.contains(new Student("lisi2",22));
		System.out.println("b="+b);

		hs.remove(new Student("lisi3",23));
		System.out.println(hs);
		/*
		Iterator it = hs.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next()+"...");
		}
		*/

	}
}
class Student
{
	private String name;
	private int age;
	Student(String name,int age)
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
	public int hashCode()
	{
		System.out.println("hashcode---"+this);
		return name.hashCode()+age*27;
	}

	public boolean equals(Object obj)
	{
		System.out.println(this+"----equals---"+obj);
		if(!(obj instanceof Student))
			return false;
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.age==s.age;

	}
	public String toString()
	{
		return "student:"+name+"--"+age;
	}

}


/*

往HashSet集合中存入一些Person对象。
同姓名同年龄的视为同一个人。
1，先存入几个元素并进行打印。
2，刻意存入重复元素。打印。
3，保证元素的唯一性。打印。

*/