
/*
构造函数之间调用使用this语句。
注意：this语句。只能放在构造函数的第一行。
因为初始化动作一定要先执行。


*/
class Person
{
	private int age;
	private String name;

	Person()
	{
		this("hah");
		this.name = "heihei";
		
	}
	private Person(String name)
	{
		this.name = name;
	}
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	public void show()
	{
		System.out.println("name="+name);
	}

}
class ThisDemo2 
{
	public static void main(String[] args) 
	{
		Person p = new Person();
		p.show();

		//Person pp = new Person();

	}
}
