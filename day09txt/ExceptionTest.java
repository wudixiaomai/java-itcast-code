/*
练习：
定义除法运算。
除数不可以为0，或者负数。
在函数内容通过异常形式导致程序的跳转。
在调用是要进行多catch的处理。




*/


class ByZeroException extends Exception
{
	ByZeroException()
	{
		super();
	}
	ByZeroException(String message)
	{
		super(message);
	}
}

class ByFuShuException extends Exception
{
	ByFuShuException()
	{
		super();
	}
	ByFuShuException(String message)
	{
		super(message);
	}
}

class DivDemo
{
	public int div(int a,int b)throws ByZeroException,ByFuShuException
	{
		if(b==0)
			throw new ByZeroException("除数不可以为0,抓紧时间看病");
		if(b<0)
			throw new ByFuShuException("除数不可以负数");
		return a/b;
	}
}
class  ExceptionTest
{
	public static void main(String[] args) 
	{
		DivDemo d = new DivDemo();
		try
		{
			int num = d.div(4,-1);
			System.out.println("num="+num);
		}
		catch (ByZeroException e)
		{
			System.out.println(e.getMessage());
		}
		catch (ByFuShuException e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println("over");

	}
}
