
/*
泛型类。


*/

class Student
{
}
class Worker
{
}
//定义一个工具类来操作对象，为了提高扩展性。使用Object来接收所有的子类对象。
/*class Tool
{
	private Object obj;
	public void setObj(Object obj)
	{
		this.obj = obj;
	}
	public Object getObj()
	{
		return obj;
	}
}
*/
//jdk1.5以后，出现泛型。对于这种工具类的设计如下。
/*
该工具类中要操作什么类型的对象不确定。定义一个类型参数。
使用者，传递什么样的类型，那么该类中操作的就是什么类型的对象。

什么时候使用泛型类？
当类中操作的引用数据类型不确定的时候，
就可以使用泛型类。
*/
class Tool<Q>
{
	private Q obj;
	public void setObj(Q obj)
	{
		this.obj = obj;
	}
	public Q getObj()
	{
		return obj;
	}
}

class  GenericDemo03
{
	public static void main(String[] args) 
	{
		Tool<Student> t = new Tool<Student>();

		t.setObj(new Worker());//编译失败。
		Student s = t.getObj();//避免了强转的麻烦

		//Tool t = new Tool();
		//t.setObj(new Worker());
		//Student s = (Student)t.getObj();
	}
}
