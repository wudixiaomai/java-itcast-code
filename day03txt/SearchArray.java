class  SearchArray
{
	public static void main(String[] args) 
	{
		/*int[] arr = {4,1,3,2,7};
		
		int index = getIndex(arr,3);
		if(index==-1)
			System.out.println("该元素不存在");
		else
			System.out.println("该元素的角标是："+index);
			*/

		int[] arr = {1,3,4,5,7,9,10};

		int index = halfSearch2(arr,4);
		System.out.println("index="+index);
	}

	public static int halfSearch2(int[] arr,int key)
	{
		int max,min,mid;//这是定义三个变量记录了头尾及中间角标值。
		min = 0;
		max = arr.length-1;

		while(min<=max)
		{
			mid = (max+min)/2;
			if(key>arr[mid])
				min = mid + 1;
			else if(key<arr[mid])
				max = mid - 1;
			else
				return mid;
		}
		return -1;
	}

	/*
	折半查找。必须是对有序的数组进行查找。
	*/

	public static int halfSearch(int[] arr,int key)
	{
		int max,min,mid;
		min = 0;
		max = arr.length-1;
		mid = (max+min)/2;

		while(arr[mid]!=key)
		{
			if(key>arr[mid])
				min = mid + 1;
			else if(key<arr[mid])
				max = mid - 1;
			//System.out.println("max="+max+",min="+min);
			if(min>max)
				return -1;
			mid = (max+min)/2;
		}
		return mid;
	}

	/*
	对数组中的元素进行查找，获取该元素第一次在数组中出现的位置。
	*/
	public static int getIndex(int[] arr,int key)
	{
		for(int x=0; x<arr.length; x++)
		{
			if(arr[x]==key)
			{
				return x;
			}
		}
		return -1;
	}
}
