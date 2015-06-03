/*
泛型方法。
就是将泛型定义在方法上。

泛型定义在类上，该泛型作用于整个类。
那么建立一个对象，该对象操作带泛型的方法时，这些方法只能操作同一种类型。

可不可以让不同使用泛型的方法操作不同类型数据呢？
这时只要将泛型定义在方法上即可。

*/


class Utils<Z>
{
	<Q> void show(Q t)
	{
		System.out.println("show:"+t);
	}
	<T> void print(T t)
	{
		System.out.println("print:"+t);	
	}
	void method(Z z)
	{
		System.out.println("method:"+z);	
	}
}


class  GenericDemo04
{
	public static void main(String[] args) 
	{

		//泛型定义在类上，以及方法上。
		Utils<String> u1 = new Utils<String>();
		u1.show(1234);
		//u1.method(456);//错误，因为该方法要和类中定义的泛型一致。

		//泛型定义在方法上。
		/*
		Utils u = new Utils();
		u.show("haha");
		u.print(123);
		*/

		//泛型定义在类上。
		/*
		Utils<String> u = new Utils<String>();
		u.show("haha");
		u.print(123);
		*/

		
	}
}
