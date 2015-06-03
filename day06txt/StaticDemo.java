/*
static：静态修饰符。
用于修饰类中的成员变量，或者成员函数。

被修饰的成员除了能被对象调用外，还可以被类名所调用。

被静态修饰的内容被对象所共享。
饮水机的例子。


static的特点：
1，static随着类的加载而加载，随着类的消失而消失，
	也就是说static的生存周期最长。
2，优先于对象存在。

3，被所有对象所共享。

4，可以直接被类名调用。

成员变量随着对象的建立而存在，随着对象被回收而消失。



静态使用的注意事项：
1，静态方法只能访问静态成员。非静态方法可以访问静态方法及非静态方法。
2，静态方法中不可以编写this，和super关键字。
3，主函数是静态的。




*/

class Person
{
	String name;//成员变量，也叫实例变量。
	static String country = "CN";//静态变量，也叫类变量。
	Person(String name)
	{
		this.name= name;
	}
	public native void show()
	{
		System.out.println(this.name);
	}
}


/*
主函数是被jvm所调用的，
那么jvm到底给main传递了什么样的参数呢？

打印args结果是：[Ljava.lang.String;@119298d
一看这样的结果，就知道，args值不是null。而是指向了一个数组实体。

继续打印一下该数组实体的长度。
长度为0.

那么结论是jvm传递的是就是 new String[0];
*/
class  StaticDemo
{
	public static void main(String[] args) //String[] args  = new String[0];
	{
		//for(int x=0; x<args.length; x++)
			//System.out.println(args[x]);//
		Person p = new Person("lisi");

		p.show();


		String[] arr = {"kk","qq","oo","zz"};

		DemoMain.main(arr);

		//Person p = new Person();
		//System.out.println(p.country);

		//System.out.println(Person.country);//类名.静态成员

		//p.show();
		//Person.show();
		
	}

}

class DemoMain
{
	public static void main(String[] args)
	{
		for(int x=0; x<args.length; x++)
		{
			System.out.println(args[x]+"...");
		}
	}
}


/*

class Demo
{
	int x = 4;
	public static void main(String[] args) 
	{
		new Demo().show();		
	}
	public void show()
	{
		System.out.println(x);
	}
}
*/