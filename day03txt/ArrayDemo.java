/*

数组：
什么时候使用数组：
当元素较多时，为了方便操作这些元素，会先进行临时存储。
所使用的容器就是数组。

好处：
可以对元素进行编号，方便操作。

特点：
数组是固定长度的。

*/

class  ArrayDemo
{
	public static void main(String[] args)
	{

		int[] x = new int[3];

		//System.out.println(x.length);

		//int[] y = x;//x 和 y 两个数组类型的变量，同时指向了同一个数组实体。
		//x = null;



		//ArrayIndexOutOfBoundsException: 3数组角标越界异常。
		//当访问到数组中不存在的角标时，就会发生该异常。

		/*
		NullPointerException:空指针异常。
		当引用型变量为null，还在操作实体时，就会发生。

		*/


		//数组的第一个常见操作：遍历。
		for(int a=0; a<x.length; a++)
		{
			System.out.println("x["+a+"] = "+x[a]+" ;");//x[0] = 0;
		}


		//数组的另一种定义形式。
		int[] arr = {3,1,6,9};
		int[] arr1 = new int[]{3,1,6,9};

		for(int a=0; a<arr.length; a++)
		{
			System.out.println("arr["+a+"] = "+arr[a]+" ;");//x[0] = 0;
		}


	}
}
