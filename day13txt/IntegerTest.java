/*
"23 8 100 -1 74 5"对字符串中的数值进行排序后，生成一个新的字符串。

思路：
1，获取字符串中所有的数值。
2，将数值存入到int数组中。
3，对int数组进行排序。
4，将数组变成字符串。

步骤：
1，使用String类的split方法根据空格规则将字符串切成字符串数组。
2，把字符串数组变成int数组。
3，通过选择排序对int数组进行排序。
4，通过StringBuilder将int数组变成字符串。


*/
import java.util.*;

class  IntegerTest
{
	public static void main(String[] args) 
	{
//		String s = numberStringSort("23 8 100 -1 74 5");
//		System.out.println(s);

		if(args.length!=2)
		{
			System.out.println("参数个数错误。程序结束");
			return ;
		}

		//通过给主函数传值的形式完成画矩形的动作。
		int row = Integer.parseInt(args[0]);
		int col = new Integer(args[1]).intValue();

		StringBuilder sb = new StringBuilder();

		for(int x=0; x<row; x++)
		{
			for(int y=0; y<col; y++)
			{
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	/*
	对字符串中的数值进行排序。
	*/
	public static String numberStringSort(String str)
	{
		String[] arr = getStringArray(str);//i

		int[] nums = getIntArray(arr);

		sortNums(nums);

		return toString(nums);
	}

	/*
	对字符串进行切割。
	*/
	private static String[] getStringArray(String str)
	{
		return str.split(" ");//
	}
	/*
	将字符串数组变成int数组。
	*/
	private static int[] getIntArray(String[] arr)
	{
		int[] nums = new int[arr.length];

		for(int x=0; x<arr.length; x++)
		{
			nums[x] = Integer.parseInt(arr[x]);
		
		}
		return nums;
	}
	/*
	对int数组进行排序。
	*/
	private static void sortNums(int[] arr)
	{
		Arrays.sort(arr);	
	}

	/*
	将数组转成字符串。
	*/
	private static String toString(int[] arr)
	{
		StringBuilder sb = new StringBuilder();

		for(int x=0; x<arr.length; x++)
		{
			if(x!=arr.length-1)
				sb.append(arr[x]+",");
			else
				sb.append(arr[x]);
		}
		return sb.toString();
	}
}