class  Bin_HexDemo
{
	public static void main(String[] args) 
	{
		String s1 = toBinary(-6);
		String s2 = toHex(-58);
		System.out.println(s1);
//		System.out.println(s2);
		

//		System.out.println("num="+Integer.toBinaryString(-6));
	}

	/**
	十进制-->十六进制
	*/
	public static String toHex(int num)
	{
		return trans(num,15,4);
	}

	/**
	十进制-->二进制的操作。
	*/
	public static String toBinary(int num)
	{
		return trans(num,1,1);
	}

	/*
	定义一个进制转换功能的函数。
	*/
	private static String trans(int num,int base,int offset)
	{

		if(num==0)
			return "0";

		//1， 定义一个表，该表中存储了16进制以内进制的所有元素。
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
		//2,定义临时容器，用于存储查表后的结果。
		char[] arr = new char[32];

		//3,定义指针。对数组的角标进行操作。
		int pos = arr.length;

		//4,定义循环，不断的进行&运算，以及位移运算。并查表。
		while(num!=0)
		{
			//& 上执行基数，获取结果作为表中的角标。
			int temp = num & base;

			//通过该角标获取表中元素。并存入到临时容器中。
			arr[--pos] = chs[temp];

			//对num进行指定位的位移。
			num = num >>> offset;
		}

		/*//对临时容器进行遍历打印。
		for(int x=pos; x<arr.length; x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println();
		*/
		return arrayToString(arr,pos);

		/*
		return new String(arr,pos,arr.length-pos);
		*/
	}

	/*
	int数组变成字符串。
	*/
	public static String arrayToString(char[] arr,int start)
	{

		String str = "";
		for(int x=start; x<arr.length; x++)
		{
				str+=arr[x];
		}
		return str;

	}

}


