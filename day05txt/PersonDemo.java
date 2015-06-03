/*
三个特征：
封装，继承，多态。

封装。
隐藏实现细节。提高了安全性。
函数就是最小的封装体。




private :私有；用于修饰成员，而且私有只在本类中有效。
为了程序的健壮性，通常会将成员变量私有化。通过公有方法对其进行访问，好处在于可以在方法内加入逻辑判断。
通常按照java约定俗成的规范。这个公有方法通常会定义成set get方法。

私有仅仅是封装的一种体现。


*/
class Person
{
	private int age;
	private String name;

	public void setName(String n)
	{
		name = n;
	}
	public String getName()
	{
		return name;
	}

	public void setAge(int a)
	{
		age = a;
	}

	public int getAge()
	{
		return age;
	}
	public void abc(int a)
	{
		if(a>0 && a<130)
		{
			age = a ;
			speak();
		}
		else
			System.out.println("nono");
	}
	public void speak()
	{
		System.out.println(name+"::"+age);
	}
}



class  PersonDemo
{
	public static void main(String[] args) 
	{
		Person p = new Person();
		p.name = "lisi";
		//p.age = -20;
		p.abc(-20);
		//p.speak();
	}
}
