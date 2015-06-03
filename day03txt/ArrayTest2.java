import java.util.*;
class  ArrayTest2
{
	public static void main(String[] args) 
	{
		int[] arr = {4,1,2,6,5,7,3};
		printArray(arr);
		//selectSort(arr);
		//bubbleSort(arr);
		Arrays.sort(arr);//这是java提供的排序方法。开发时用它最方便。
		printArray(arr);

		
	}

	/*
	冒泡排序。:
	特点：相邻两个元素进行比较，内循环结束一次，在数组的最后位出现最值。
	-x:不断减少参与排序的元素个数。
	-1:避免角标越界。
	*/

	public static void bubbleSort(int[] arr)
	{
		for(int x=0; x<arr.length-1; x++)
		{
			for(int y=0;y<arr.length-x-1; y++)
			{
				if(arr[y]>arr[y+1])
				{
					/*
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
					*/
					swap(arr,y,y+1);
				}
			}
		}
	}

	/*
	数组选择排序。
	特点：
	内循环结束一次，数组0角标位出现最值。
	*/
	
	public static void selectSort(int[] arr)
	{
		for(int x=0; x<arr.length-1; x++)
		{
			for(int y=x+1; y<arr.length; y++)
			{
				if(arr[x]>arr[y])
				{
					/*
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
					*/
					swap(arr,x,y);
				}
			}
		}
	}

	/*
	定义对数组元素进行换位的操作。
	*/
	public static void swap(int[] arr,int x,int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
		
	/*
	打印数组元素。
	*/
	public static void printArray(int[] arr)
	{
		for(int x=0; x<arr.length; x++)
		{
			if(x!=arr.length-1)
				System.out.print(arr[x]+",,,");
			else
				System.out.println(arr[x]);
		}
	}
}
