import java.io.*;


/*
ObjectInputStream

ObjectOutputStream

用于直接操作对象的流。

可以完成对象持久化存储。


被静态修饰的成员变量是不会被序列化的。

transient:可以让成员变量不被序列化。


序列化接口是给类定义一个UID.给类加上一个标识。
而这个标识是通过可以序列化成员的数字签名，算出来的一个long型值。

只要可序列化的成员有改变，那么该UID就会改变。

那么通过原来class文件生成的对象被持久化后，

class文件发生该变产生了新的UID是，取出原来的持久化对象就会发生InvalidClassException。


当然可以通过手动的形式在类中指定UID。这样jvm就不会在给类分配UID。

所以该类无论怎样该变，UID都是同一个。






*/


class ObjectStream 
{
	public static void main(String[] args) throws IOException,ClassNotFoundException
	{
		//writeObj();

		readObj();
	}

	public static void readObj()throws IOException,ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

		Student stu = (Student)ois.readObject();
		Student stu1 = (Student)ois.readObject();

		System.out.println(stu.getName()+"::"+stu.getAge());
		System.out.println(stu1.getName()+"::"+stu1.getAge());

		ois.close();
	}

	public static void writeObj()throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));

		Student stu = new Student("lisi",99);
		Student stu1 = new Student("wangwu",49);

		oos.writeObject(stu);
		oos.writeObject(stu1);

		oos.close();
	}
}

