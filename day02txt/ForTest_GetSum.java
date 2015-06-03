class  ForTest_GetSum
{
	public static void main(String[] args) 
	{

		/*
		因为要获取1~100之间的和。
		原理就是两个数据相加的结果和下一个数继续进行相加。

		每一次的和不一样，而且都需要参与下面的运算。
		所以定义变量将和进行记录。

		因为1~100有规律。可以通过定义变量记录住不断变化的数组。


		其实这就是累加思想的体现。日后对字符串的延长也可以使用该思想。
		*/

		int sum = 0;

		for(int x=0; x<=100; x++)
		{
			sum += x;
		}
		System.out.println("sum="+sum);
	}
}
