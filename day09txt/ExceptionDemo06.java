/*
第六部分。
异常使用的细节。
异常有两种：
一个编译时检查的异常。
一个运行时检查的异常。

异常在继承过程中出现覆盖时的注意事项。

1，子类覆盖父类方法，如果父类方法抛出异常，子类只能抛出父类方法异常或者该异常的子类。
2，父类如果抛出多个异常，子类只能抛出多个异常的子集。


子类覆盖父类时，只能抛出父类异常的子类或者子集

class AException extends Exception
{}
class BException extends Exception
{}
class CException extends AExcetpion

class Fu
{
	void show()throws AException ,BException
	{
		
	}
}

class Zi extends Fu
{
	void show()throws CException
	{}
}

*/






class FuShu extends RuntimeException
{
}
class Demo
{
	int div(int a,int b)
	{
		if(b<0)
			throw new FuShu();
		return a/b;
	}

	void show(int [] arr)
	{
		if(arr==null)
			throw new NullPointerException("数组为null，无法运算");
		System.out.println(arr[2]);
	}
}



class  ExceptionDemo06
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();
		int num = d.div(4,-1);
		d.show(null);
		System.out.println("num="+num);
		System.out.println("over");
	}
}
