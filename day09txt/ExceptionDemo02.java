/*

第二部分。
掌握，功能的多异常的抛出，
调用功能时，多catch的处理


多catch处理。
当定义功能时，该功能会发生的异常不只一个，
那么可以在函数上通过throws关键字对多个异常进行声明，异常类间通过逗号隔开。

那么在调用该功能时，进行try处理，也需要进行分类处理。
那么就需要try对应多个catch的情况。

小细节：父类的catch放在最下面。






*/

class Demo
{
	int div(int a,int b)throws ArithmeticException,ArrayIndexOutOfBoundsException
	{
		int[] arr = new int[a];
		System.out.println(arr[b]);//当发生的角标越界，会出现角标越界异常，被jvm打包成对象并抛出，
								//这时的函数已经跳转。下面的语句无法执行。
		return a/b;
	}
}

class ExceptionDemo02 
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();

		try
		{
			int x = d.div(4,4);
			System.out.println("x="+x);
		}
		
		catch (ArithmeticException e)
		{
			System.out.println("除零错误");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("角标越界");
		}
		
		System.out.println("over");
	}
}
