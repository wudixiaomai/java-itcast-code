class  FunctionDemo
{
	public static void main(String[] args) 
	{
		//int x = 3+4;
		//int y = 5+6;

		int x = getSum(3,7);
		//System.out.println(x);

		//draw(3,6);
		//draw(7,9);	

	}


	

	/*
	定义功能 判断两个整数是否相等。
	1，返回值类型：boolean 。
	2，参数列表：两个整形变量。
	*/
	public static boolean compare(int x,int y)
	{
		/*
		if(x==y)
			return true;
		else
			return false;
		*/

		//return (x==y)?true:false;

		return x==y;

	}


	/*
	
	发现当打印不同大小的矩形时，虽然复制代码可以完成，但是代码的重复程度太高。
	可不可以提高一下代码的复用性呢

	干脆，定义一个专门画矩形的功能。
	想什么时候画使用该功能即可。将画矩形功能的代码存放该功能中。

	1，明确该功能的结果，因为是打印输出了，所以没有具体的结果，那么返回类型是void。
	2，有没有位置内容参与运算呢？有，行和列不确定，就将行和列定义为形式参数。
	*/
	public static void draw(int row,int col)
	{
		for(int x=0; x<row; x++)
		{
			for(int y=0; y<col; y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}



	public static void add(int a,int b)
	{
		System.out.println(a+b);
		//return;

	}

	/*
	定义一个加法运算的功能。
	1，明确结果，是一个整数和。返回值类型就确定为int。
	2，实现该功能的过程中是否需要未知内容参与运算呢？加数和被加数不确定。作为参数存在。

	int add(int a,int b)
	{
		return a+b;
	}

	返回值类型 函数名(参数类型 形式参数1，参数类型 形式参数2，……)
	{
			执行语句;
			return 返回值;
	}

	定义函数的方式：
	因为函数是用来实现功能的，并可以将该功能进行复用。

	1，明确该功能运算后的结果。其实就是在明确返回值类型。
	2，明确该功能在实现过程中是否需要未知内容参与运算。其实就是在明确参数列表。

	*/
	public static int getSum(int x,int y)
	{
		return x+y;
	}


}
