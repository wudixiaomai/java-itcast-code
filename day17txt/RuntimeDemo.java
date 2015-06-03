/*
Runtime类没有构造方法提供。
说明该类不可以直接实例化。

而该类中还有非静态的方法，是需要被对象调用才可以执行的。
那么该类中一定有静态并返回本类对象的方法。

该方法就是getRuntime();
*/

class RuntimeDemo 
{
	public static void main(String[] args) throws Exception
	{
		//获取Runtime对象。通过getRuntime静态获取。
		Runtime r = Runtime.getRuntime();

		//Process p = r.exec("winmine.exe");//其实找的是Path路径下的目录。

		r.exec("notepad.exe SystemDemo.java");//打开一个程序并关联一个可以用该程序解析的文件。


		//Thread.sleep(8000);
		//p.destroy();
	}
}

/*
//单例设计模式。
class Demo
{
	private static Demo d = new Demo();
	private Demo(){}
	void show(){}

	static Demo getInstance()
	{
		return d;
	}
}
*/