class  IfDemo
{
	public static void main(String[] args) 
	{

		//if的第一种格式
		int x = 4;
		/*if(x>1)
		{
			System.out.println("yes");
		}*/


		//if的第二种格式。
		/*if(x==3)
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
		System.out.println("over");
		*/

		//if的第三种格式
		/*
		if(x>1)
		{
			System.out.println("a");
		}
		else if(x>2)
		{
		
			System.out.println("b");
		}
		else if(x>3)
		{
			System.out.println("c");		
		}
		else
		{
			System.out.println("d");			
		}
		*/

		int y;

		if(x>1)
			y = 100;
		else
			y = 200;

		//变量 = （条件表达式)?表达式1：表达式2；

		y = (x>1)?100:200;//三元运算符 ？ ：。

		System.out.println((x>1)?100:200);

		if(x>1)
			System.out.println("a");
		else
			System.out.println("b");


		/*
		什么时候使用三元运算符？
		当if else 语句执行完有结果出现时，可以使用简写格式。
		给简写格式的特点：运算后肯定会有结果出现。

		*/
		
	}
}
