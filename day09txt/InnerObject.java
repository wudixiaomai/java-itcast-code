
class Outer
{
	public void show()
	{
		Object obj = new Object()
		{
			public void func()
			{
				System.out.println("fun");
			}
		};
		obj.func();//错啦，现在是父类引用在执行子类对象。而父类中没有func方法。编译失败。


	}
}

class  InnerObject
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");

		new Outer().show();
	}
}
