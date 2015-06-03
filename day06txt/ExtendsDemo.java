class Person
{
	String name;
	int age;
}

class Student extends Person
{
	
	public void study()
	{
	}
}


class Worker extends Person
{
	public void work()
	{
	
	}
}


class  ExtendsDemo
{
	public static void main(String[] args) 
	{
		Student s = new Student();
		s.name = "hah";
	}
}

//A-->B-->C-->D
