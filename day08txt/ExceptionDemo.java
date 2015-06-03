/*
异常的出现，其实就是java对问题的描述。
Throwable
	|--Error:通常不编写代码对其进行处理。OutOfMemoryError: Java heap space。。.NoClassDefFoundError
	|--Exception：可以对其进行处理。

两字子类下的所有子类对象的名称都是以父类名作为结尾。


*/

class Demo
{
	int div(int a,int b)throws Exception
	{
		return a/b;
	}
}



class ExceptionDemo 
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
			System.out.println("异常啦");
			System.out.println("message:"+e.getMessage());
			System.out.println("toString:"+e.toString());
			e.printStackTrace();

		}		
		
		System.out.println("over");
	}
}
/*
处理的异常的特有语句。
try 
{
	需要被检测的代码。
}
catch(异常类 变量)
{
	异常处理代码。
}

finally
{
	一定会被执行的代码。
}	
*/