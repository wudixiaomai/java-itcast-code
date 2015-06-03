/*
练习：定义一个功能，用于去除ArrayList中重复的元素。
1，存入字符串元素对象。
2，存入自定义对象，比如Person对象。

思路：
1，创建一个容器，用于存储非重复的元素。
2，对原容器进行遍历，
3，在遍历过程中进行判断，遍历到的元素是否在新容器中存在，
4，如果存在，就不存入，否则存入。
5，返回该新容器即可。
*/


import java.util.*;
class  ArrayListTest2
{
	public static void main(String[] args) 
	{
		List list = new ArrayList();
//		list.add("abc1");
//		list.add("abc2");
//		list.add("abc1");
//		list.add("abc2");

		list.add(new Student("lisi1",21));
		list.add(new Student("lisi2",22));
		list.add(new Student("lisi1",21));
		list.add(new Student("lisi2",22));
		list.add(new Student("lisi2",22));

		System.out.println(list);

		list = getSingleList(list);
		System.out.println(list);

	}

	public static List getSingleList(List  list)
	{
		//创建一个新的容器。
		List newList = new ArrayList();

		for(Iterator it = list.iterator(); it.hasNext(); )
		{
			Object obj = it.next();
			if(!(newList.contains(obj)))
				newList.add(obj);

		}
		return newList;

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
	/*
	为了建立学生对象特有的对象是否相同的比较行为需要复写Object类中的equals方法。
	*/
	public boolean equals(Object obj)
	{
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
