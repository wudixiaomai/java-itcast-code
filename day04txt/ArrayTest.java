
/*
数组作为容器的应用：
就一个基本思想：指针思想。


*/
class  ArrayTest
{

	/*
	打印数组的功能
	*/
	public static void daYin(int[] arr,int start)
	{
		for(int x=start; x<arr.length; x++)
		{
			if(x!=arr.length-1)
				System.out.print(arr[x]+",");
			else
				System.out.println(arr[x]);
		}
	}
	public static void main(String[] args) 
	{
		//toBin(6);
//		toHex2(58);

		toBin2(-6);
	}

	/*
	十进制-->二进制。
	*/

	public static void toBin(int num)
	{
		int[] arr = new int[32];
		int pos = arr.length;
		while(num>0)
		{
			arr[--pos] = num%2;
			num = num /2;
		}
		System.out.println("pos="+pos);
		daYin(arr,pos);
	}

	/*
	十进制-->十六进制。
	乘16，除16，这是十和十六进制之间的转换方式。但是运算麻烦。
	
	发现，二进制的每四位代表一个是十六进制位。
	可以不断获取每四位。从而就可以获取十六进制表现形式。
	*/
	public static void toHex(int num)
	{
		
		char[] arr = new char[8];
		int pos = arr.length;

		for(int x=0; x<8; x++)
		{
			int temp = num & 15;
			if(temp>9)
				//System.out.print((char)(temp-10+'A')+",");
				arr[--pos] = (char)(temp-10+'A');
			else
				//System.out.print(temp+",");
				arr[--pos] = (char)(temp+'0');

			num = num >>> 4;
		}

		for(int x=pos;x<arr.length; x++)
		{
			System.out.print(arr[x]+"...");
		}
	}
	/*
	查表法。
	发现规律。
	每次&15的值，都可以作为角标去查十六进制表中元素。

	*/

	public static void toHex2(int num)
	{
		//定义一个十六进制元素表。
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

		//临时容器，存入每次查表后的结果。
		char[] arr = new char[8];

		int pos = arr.length;

		while(num!=0)
		{
			int temp = num & 15;

			arr[--pos] = chs[temp];
			
			num = num >>> 4;
		}
		for(int x=pos;x<arr.length; x++)
		{
			System.out.print(arr[x]+",");
		}
	}
	/*
	通过查表法完成十进制--二进制。
	*/
	public static void toBin2(int num)
	{

		if(num==0)
		{
			System.out.println("0");
			return ;
		}
		char[] chs = {'0','1'};

		char[] arr = new char[32];

		int pos = arr.length;

		while(num!=0)
		{
			int temp = num & 1;
			arr[--pos] = chs[temp];

			num = num >>> 1;
		}

		for(int x=pos;x<arr.length; x++)
		{
			System.out.print(arr[x]+" ");
		}
	}
	
}









/*

1，获取最低四个二进制位。对应的十六进制元素。 6

{0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f};


  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0
 &0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1 =15.
 ------------------------------------------------------------------
  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0 ==6

2，获取下四个二进制位。对元素数据进行无符号右移(因为有负数的情况。)四位。这时就将下一个四位作为最低四位。

 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0
&0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1
 ------------------------------------------------------------------
 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1 ==  13    -10=3+'a' = (char)100 > d   -->  d   a=10  b=10+1






0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0


*/