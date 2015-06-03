/*
JDK1.5新特性：
可以变参数。

该特性：简化了数组传递。
但是有一个注意事项：
可变参数必须放在参数列表的最后面。
*/
class  ParamDemo
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");

//		int[] arr = {4,1,6};
//		showOld(arr);

//		int[] arr1 = {7,1,9,6,5};
//		showOld(arr1);
		
		show(4,1,6);//可变参数可以简化数组参数的书写。
		show(7,1,9,6,5);
		
	}

	public static void function(int i,int...  arr){}

	public static void show(int... arr)//...  代表的就是数组类型。
	{
		System.out.println(arr.length);
	}
	
	public static void showOld(int[] arr)
	{
		System.out.println(arr.length);
	}
}
