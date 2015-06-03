/*
静态代码块。
static 
{

}
随着类的加载而执行，优先于主函数执行。而且只执行一次。
可以对类进行初始化。

*/

class Demo
{
	static
	{
		System.out.println("c");
	}

	{
		System.out.println("haha");
	}

	Demo()
	{
		System.out.println("kk");
	}
	public static void show()
	{
		System.out.println("show run");
	}
}

class StaticCode 
{
	/*
	static
	{
		System.out.println("a");
	}
	*/
	public static void main(String[] args) 
	{
		//Demo d = new Demo();
		//Demo d1 = new Demo();
		//Demo.show();
		//Demo.show();

		Demo d = new Demo();
		Demo d1 = new Demo();
		//System.out.println("d");
	}
	/*
	static
	{
		System.out.println("b");
	}
	*/
}
