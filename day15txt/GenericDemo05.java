/*
静态方法不可以使用类中定义的泛型。
因为类中的泛型需要在对象初始化的时，指定具体类型。
而静态优先与对象存在。

在静态方法上定义泛型，一定要写在static关键字的后面。
返回值类型的前边。

*/
class Utils
{
	
	 static <Z> void method(Z z)
	{
		System.out.println("method:"+z);	
	}
}


class  GenericDemo05
{
	public static void main(String[] args) 
	{
		Utils.method("haha");
		Utils.method(123);
	}
}
