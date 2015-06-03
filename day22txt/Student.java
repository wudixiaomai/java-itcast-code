import java.io.*;

class Student implements Serializable
{
	private /*static*/  String name;
	private /*transient*/ int age;
	//private transient  int pay;
	//public static final long serialVersionUID = 42L;

	Student (String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String getName()    
	{
		return   name;
	}
	public int getAge()
	{
		return age;
	}
}