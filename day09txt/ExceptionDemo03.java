/*

第三部分。
获取异常的较为细节的信息。

需要通过异常的方法来完成。
Exception中只定义构造函数。
所以要找其父类的方法。

String getMessage():获取异常信息。
String toString():获取的是异常类名，以及异常信息。
void printStackTrace():打印异常类名，异常信息，异常出现在程序的位置。
					jvm默认的异常处理机制，其实使用的就是该方法。





*/
import java.io.*;
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

class ExceptionDemo03 
{
	public static void main(String[] args) throws IOException
	{
		Demo d = new Demo();

		try
		{
			int x = d.div(4,0);
			System.out.println("x="+x);
		}
		
		catch (ArithmeticException e)//ArithmeticException e = new ArithmeticExcetion();
		{
			System.out.println("除零错误");
			System.out.println("message:"+e.getMessage());
			System.out.println("toString:"+e.toString());
			//System.out.println("className:"+e.getClass().getName());
			//e.printStackTrace(new PrintStream("exce.log"));//将异常信息本地持久化存储。
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("角标越界");
		}
		
		System.out.println("over");
	}
}
