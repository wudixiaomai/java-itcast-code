/*
对字符串中字符进行排序。生成新的字符串。
*/

class StringTest 
{
	public static void main(String[] args) 
	{
		String s = new StringTest().sortString("cadpbe");
		System.out.println(s);
	}

	public String sortString(String str)
	{
		char[] chs = str.toCharArray();
		sort(chs);
		
		return new String(chs);
	}
	private void sort(char[] arr)
	{
		for(int x=0; x<arr.length-1; x++)
		{
			for(int y=x+1; y<arr.length; y++)
			{
				if(arr[x]>arr[y])
				{
					char temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}
	}
}
