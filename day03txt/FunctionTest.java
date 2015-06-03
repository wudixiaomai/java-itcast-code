/*
	练习：
	1，定义一个功能，获取两个整数，大的整数。
	2，定义一个打印99乘法表功能的函数。
	3，定义一个功能，接收考试分数，返回分数对应的等级。
		90~100 ‘A'  80~89 'B'  70~79 'C' 60~69 'D' 60以下　'E'

	*/


class  FunctionTest
{


	/*
	3，定义一个功能，接收考试分数，返回分数对应的等级。
		90~100 ‘A'  80~89 'B'  70~79 'C' 60~69 'D' 60以下　'E'

	1,返回值类型是 char。
	2，参数是int。
	*/
	public static char getLevel(int num)
	{
		char ch ;
		if(num>=90 && num<=100)
			ch = 'A';
		else if(num>=80 && num<=89)
			ch = 'B';
		else if(num>=70 && num<=79)
			ch = 'c';
		else if(num>=60 && num<=69)
			ch = 'd';
		else 
			ch = 'E';
		return ch;
	}


	/*
	2，定义一个打印99乘法表功能的函数。
	*/
	
	public static void print99()
	{
		for(int x=1;x<=9; x++)
		{
			for(int y=1; y<=x; y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}


	/*
	1，定义一个功能，获取两个整数，大的整数。
	*/
	public static int getMax(int a,int b)
	{
		/*
		if(a>=b)
			return a;
		else
			return b;
		*/
		return (a>=b)?a:b;
	}
	
	public static void main(String[] args)
	{

	}



}
