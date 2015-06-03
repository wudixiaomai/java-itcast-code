

abstract class Demo
{
	abstract void show();
	
}

//格式：new 父类或者接口(){}
class Outer
{
	int x = 3;
	/*
	class Inner extends Demo
	{
		public void show(){System.out.println(x);}
	}
	*/
	public void method()
	{
		//new Inner().show();

		new Demo()
		{
			public void show()
			{
				System.out.println(x+"...");
			}
			/*
			public void func()
			{
				System.out.println("hah");
			}
			*/
		}.show();

	}
}

class  InnerDemo2
{
	public static void main(String[] args) 
	{
		//new Outer().method();

		new Test().method();//可以运行show func方法。通过匿名内部类来完成。




	}
}


//练习一。

interface Inter
{
	void show();
	void func();
}

class Test
{
	/*
	private class Inner implements Inter
	{
		public void show(){}
		public void func(){}
	}
	public void method()
	{
		Inner in =new Inner();
		in.show();
		in.func();
	}
	*/

	public void method()
	{
		Inter in = new Inter()
		{
			public void show(){}
			public void func(){}
		};

		in.show();
		in.func();
	}
}







//练习二。

interface Inter2
{
	void function();
}

class Test2
{
	//补足代码。
	static Inter2 method()
	{
		return new Inter2()
		{
			public void function(){}
		};
	}

}

main()
{
	Inter2 in = Test.method();
	in.function();

	Test2.method().function();
}