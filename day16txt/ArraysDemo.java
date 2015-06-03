import java.util.*;
/*
Arrays工具类中的方法都是静态的。
用于操作的数据的工具类。

*/

class  ArraysDemo
{
	public static void main(String[] args) 
	{

		//数组变成集合。
		String[] arr = {"ab","ccx","qq"};
		List<String> list = Arrays.asList(arr);


		/*
		注意：
		数组变成集合时，不可以使用集合的增删方法对元素进行操作。
		因为数组的长度是固定的，会反生不支持操作异常。UnsupportedOperationException
		

		数组转换成集合的目的是：使用集合的思想操作数组。
		比如：contains，indexOf。isEmpty.....
		*/
		list.add("kk");//UnsupportedOperationException
		System.out.println(list);



//		int[] arr = {3,1,5,7};
//		System.out.println(Arrays.toString(arr));
//
//		String s = arrayToString(arr);
//		System.out.println(s);

	}
	public static String arrayToString(int [] arr)
	{
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<arr.length; x++)
		{
			if(x!=arr.length-1)
				sb.append(arr[x]+", ");
			else
				sb.append(arr[x]);
		}
		return sb.toString();
	}
}
