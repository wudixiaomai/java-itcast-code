/*
写一个方法，实现字符串的反转，如：输入abc，输出cba（分值10分）
*/
class  StringReverse
{
	public static void main(String[] args) 
	{
//		String s = reverseString2("abcd");
//		System.out.println(s);

		getSum2();
	}
	/*
		a b c d e 
		e d c b a 
	*/
	public static String reverseString2(String str)
	{
		char[] chs = str.toCharArray();

		for(int start=0,end=str.length()-1; start<end; start++,end--)
		{
			swap(chs,start,end);
		}
		return new String(chs);
	}
	private static void swap(char[] chs,int start,int end)
	{
		char temp = chs[start];
		chs[start] = chs[end];
		chs[end] = temp;
	}
	public static String reverseString(String str)
	{
		StringBuilder sb = new StringBuilder(str);

		return sb.reverse().toString();
	}

	/*
	写一个程序，计算1+2的2次方+3的2次方+…+n的2次方（分值10分）
	*/

	public static void getSum()
	{
		int sum = 0;
		for(int x=1; x<=3; x++)
		{
			sum = sum + x*x;
		}
		System.out.println("sum="+sum);
	}

	public static void getSum2()
	{
		double sum = 0;
		for(int x=1; x<=3; x++)
		{
			sum = sum + Math.pow(x,2);
		}
		System.out.println("sum="+sum);
	}
}


