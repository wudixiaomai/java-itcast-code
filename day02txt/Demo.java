/*

需求：定义一个hello world小程序。
思路：
1，通过class关键字定义一个类。
2，为了让该类独立运行，在类中定义个main函数。
3，为了和计算机互动，定义输出语句。让计算机帮我们打印一些信息。

代码其实就是思想的一种体现形式。

*/



class Demo//定义一个demo类。
{

	//保证程序的独立运行。
	public static void main(String[] args)
	{
		//输出语句
		System.out.println("hello world");
		int day=0;
		for(int x=3000;x>=5;x/=2){
			day++;
		}
		System.out.println("day="+day);
		
		System.out.println((char)65);
				int a='d';
				char ch=98;
				System.out.println("a="+a);
				System.out.println("ch="+ch);
	}
	
	
}

