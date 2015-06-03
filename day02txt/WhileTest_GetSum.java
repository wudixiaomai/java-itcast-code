/*
计算1~100的和。
思路：
1，1~100有规律，可以通过循环的形式让这些数自动出现。
2，每两个数加完的和需要和下一个数进行求和。
	每次出现的和是变化的。需要定一个变量记录该值。
	并用该变量和下一个数进行求和。

*/

class  WhileTest_GetSum
{
	public static void main(String[] args) 
	{
		int x = 1;
		int sum = 0;

		while(x<=100)
		{
			sum = sum + x;
			x++;
		}

		System.out.println("sum="+sum);		
	}
}
