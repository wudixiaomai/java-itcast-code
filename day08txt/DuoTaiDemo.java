class Animal
{
	void chi()
	{
		System.out.println("ani chi");
	}
	void jiao()
	{
		System.out.println("chi jiao");
	}
}

class Dog extends Animal
{
	void chi()
	{
		System.out.println("gu tou");
	}
	void jiao()
	{
		System.out.println("wang wang");
	}
	void kanmen()
	{
		System.out.println("kanmen");
	}
}


class Cat extends Animal
{
	void chi()
	{
		System.out.println("yu");
	}
	void jiao()
	{
		System.out.println("miao miao");
	}
	void catchMouse()
	{
		System.out.println("catch mouse");
	}
}

/*
对于成员函数：
1，编译时期：参考的引用型变量所属的类中是否有调用的方法。
2，运行时期：参考的的对象所属类的方法。


多态前提：
1，类与类之间要有关系。
2，通常都有覆盖操作。

多态在程序中的体现：
父类或者接口的引用指向或者接收自己的子类对象。



局限性：
不可以使用子类中特有的方法。


多态的好处：
增强了程序的扩展性。


instanceof:用于判断对象是否所属于指定类或者接口。

*/

class  DouTaiDemo
{
	public static void main(String[] args) 
	{
		
//		Animal d = new Dog();//父类引用指向了子类对象。
//		d.chi();
//		d.jiao();
//
//		Dog d1 = (Dog)d;
//		d1.kanmen();


		//d.kanmen();



//		Dog d = new Dog();
//		d.chi();
//		d.jiao();
//		d.kanmen();
		//show(new Dog());
		show(new Cat());

	}
	public static  void show(Animal a)
	{

		
		a.chi();
		a.jiao();
		if(a instanceof Dog)
		{
			Dog d = (Dog)a;
			d.kanmen();
		}
		else if(a instanceof Cat)
		{
			Cat c = (Cat)a;
			c.catchMouse();
		}

	}

	/*
	public void show(Dog d)//Dog d = new Dog();
	{
		d.chi();
		d.jiao();
	}
	public void show(Cat d)
	{
		d.chi();
		d.jiao();
	}
	*/
}
