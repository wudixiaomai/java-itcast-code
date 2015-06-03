/*

第四部分。
自定义异常。

当自定义的项目中出现特有问题的时候，该问题java并没有相对应的描述。
这时，需要自己按照面向对象思想对问题进行自定义的描述。
这就是自定义异常。


需求：
定义除法运算。要求，除数不可以为负数。

1,对负数问题进行描述。
	定义一个类继承Exception。目的只有一个，让该类具备可抛性。
2,通过throw关键字将该问题的对象进行抛出，引起程序的跳转。
	通常函数内如果有throw抛出，那么函数上一定要进行throws的声明。

Throwable的体系具备的特点：
该体系所有的对象都可以被throws 和throw关键字操作。


throw和throws的区别：

throw用在函数内，后面跟异常对象。
throws用在函数上，后面跟异常类名，多个类用逗号隔开。






*/

class FuShuException extends Exception
{
	private int num;
	FuShuException()
	{
		super();
	}
	//自定义异常的信息，只要通过super调用父类构造函数，将信息传递给父类即可。
	FuShuException(String mess)
	{
		super(mess);//父类Throwable把定义变量，
					//并对不变量进行构造初始化的动作都完成了，那么子类只要使用父类的初始化动作就可以了。
	}

	FuShuException(String mess,int num)
	{
		super(mess);
		this.num = num;
	}
	public int getFuShu()
	{
		return num;
	}
}
/*

Throwable源码中，已经定义异常信息的进行初始化，以及获取。
那么子类继承Throwable，只要调用父类已定义好的功能即可。


class Throwable
{
	private String detailMessage;
	Throwable(String message)
	{
		detailMessage = message;
	}
	public String getMessage()
	{
		return detailMessage;
	}
}
*/
class Demo
{
	int div(int a,int b)throws FuShuException
	{
		if(b<0)
			throw new FuShuException("出现除数负数情况 / by fushu--",b);
		return a/b;
	}
}

class ExceptionDemo04 
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();

		try
		{
			int x = d.div(4,-188);
			System.out.println("x="+x);
		}
		catch (FuShuException e)
		{
			System.out.println("负数是："+e.getFuShu());
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}		
		System.out.println("over");
	}
}

/*
class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}


class Zhangsan extends Person
{
	Zhangsan(String name)
	{
		super(name);
	}
}

main()
{
	Zhangsan z = new Zhangsan("haha");
	System.out.println(z.getName());
}

*/