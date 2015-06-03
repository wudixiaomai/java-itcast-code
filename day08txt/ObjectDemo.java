/*
Object类中给所有对象定义了进行比较的方法。
但是这个方法对于自定义的特有特有，功能内容并不是所需要的。

这时，子类可以继承该方法，并复写该方法内容。

*/

class Demo //extends Object
{
	private int num;
	Demo(){}
	Demo(int num)
	{
		this.num = num;
	}
	public boolean equals(Object obj)//Object obj = new Demo();
	{
		if(!(obj instanceof Demo))
			return false;
		Demo d = (Demo)obj;
		return this.num == d.num;
	}
	/*
	建立本类自己的对象对应的字符串表现形式，只要覆盖Object类中的方法即可。
	该方法如果用在输入语句中，可以省略不写。
	*/
	public String toString()
	{
		return "num:"+num;
	}

	public void finalize()
	{
		System.out.println("haha");
	}

	//getClass();用于获取对象所属的类。返回的是该类文件对应的对象。


}

class Test
{
}

class ObjectDemo 
{
	public static void main(String[] args) 
	{

		new Demo();
		new Demo();

		System.gc();
		new Demo();

//		Demo d1 = new Demo(5);//Demo.class
//		Demo d2 = new Demo(5);
//		Test t = new Test();
//		Class c = d1.getClass();
//		System.out.println(t.getClass().getName());
//		System.out.println(t);

//		System.out.println(d1.equals(t));
	}
}


/*

所有对象都具有方法抽取到了Object类中。
1，boolean equals(Object obj):对两个对象进行比较。
2，String toString():获取对象的字符串表现形式。
通常在开发中，为了定义自定义对象的比较方式和字符串形式，
都会复写Object类中的这个两个方法。

3，int hashCode():在通过哈希算法算一个对象在内存中存储位置。
4，Class getClass():获取对象所属的类文件对象。其实就是字节码文件对象。
5，void  finalize():垃圾回收器的调用的方法。




*/