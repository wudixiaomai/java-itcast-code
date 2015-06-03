import java.util.*;
class  ArraysDemo2
{
	public static void main(String[] args) 
	{
		int[] arr = {3,1,4};
		
		/*
		当数组中的元素是对象时，asList会将这些对象作为集合中的元素存在。

		当数组中的元素是基本数据类型时，asList会将基本类型的数组对象作为元素存在。
		*/
		List<int[]> list = Arrays.asList(arr);
		System.out.println(list.get(0));
	}
}
