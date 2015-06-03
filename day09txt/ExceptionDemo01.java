/*

第一部分。
掌握定义功能时，因为参数的发生的问题，通过throws的形式声明。
掌握异常处理的两种方式。其中以try的方式为重点。



演示异常在程序的发生以及异常的处理。


对异常进行处理。


对于异常的处理动作有两种：
1，继续将异常抛出。
2，使用特有语句对异常进行处理。
try
{
	
}
catch(异常类名 变量名)
{

}


异常的好处：可以引起程序的跳转。
			还可以将正常流程代码和问题代码相分离。

将问题情况，都进行描述。封装成对象。


*/

class Demo
{

	//在定义功能时，因为参数的不确定性，有可能导致功能无法运算。为了提高安全性，将容易出现的问题在函数声明出来。
	//调用者在使用该功能时，必须做出处理动作。强制处理。
	int div(int a,int b)throws Exception
	{
		return a/b;
	}
}

class ExceptionDemo01 
{
	public static void main(String[] args) //throws Exception
	{
		Demo d = new Demo();

		try
		{
			int x = d.div(4,0);
			System.out.println("x="+x);
		}
		catch (Exception e)//Exception e = new ArithmeticException();
		{
			System.out.println("exception...");
		}
		
		System.out.println("over");
	}
}
