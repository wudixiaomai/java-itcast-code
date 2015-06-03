/*
第五部分。
finally:该代码块中存放的是一定会被执行的代码。

只有出现System.exit(0);finally是不会被执行的。

通常用于关闭资源。



*/




class  ExceptionDemo05
{
	public static void main(String[] args) 
	{
		try
		{
			int[] arr = new int[3];
			System.out.println(arr[3]);
			
			

		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("角标越界");
			//return ;
			System.exit(0);
		}
		finally
		{
			System.out.println("finally");
		}
		System.out.println("over");


	}
}


//try 可以单独和finlly在一起。

class TryDemo
{
	void show()throws Exception
	{
		try
		{
			//sdfasdfasdfsad
			throw new Exception();
		}
		finally
		{
			close();
		}
	}
}