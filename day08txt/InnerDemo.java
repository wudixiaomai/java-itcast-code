/*
匿名内部类：其实就是内部类的简写格式。

前提：
内部类可以继承外部类或者实现外部接口。


格式：new 父类或者接口(){}

匿名内部类其实就是：子类匿名对象。这个对象有点胖。


什么时候使用匿名内部类呢？
应用场景之一：当方法的参数的接口类型的时候，该接口中的方法不超过3个。
这个时候，可以将匿名内部类作为实际参数进行传递。


*/

class Demo
{
	void show()
	{
		System.out.println("haha");
	}
}


class Outer
{
	int x = 3;
	/*
	class Inner extends Demo
	{
		void show()
		{
			System.out.println(x);
		}
	}
	*/
	public void method()
	{
		//new Inner().show();
		
		new Demo()
		{
			void show()
			{
				System.out.println("hehe");
			}
		}.show();

	}
}


interface Inter3
{
	void show();
	void method();
}


class  InnerDemo
{
	public static void main(String[] args) 
	{
		new Outer().method();
		
		Inter3 i = new Inter3()
		{
			public void show(){}
			public void method(){}
		};


		function(i);
	}

	//演示应用场景。
	public static void function(Inter3 in)
	{
		in.show();
		in.method();
	}
}
