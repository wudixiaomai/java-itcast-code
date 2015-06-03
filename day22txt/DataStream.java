import java.io.*;


/*
DataInputStream
DataOutputStream

IO中提高专门用于操作基本数据类型数据的对象。

readInt

writeInt


对于操作UTF数据。
这两个对象使用的是utf-8修改的码表。
所以该对象写入后的数据使用常见的utf-8码表是解析不出来的。
只能使用对象的readUTF才可以获取。

也就是这两个流对象通常成对使用。

它们也是对基本流对象的增强。


*/


class  DataStream
{
	public static void main(String[] args) throws IOException
	{
		
		//writeData();
		//readData();

		//writeUTF();

		readUTF();
	}

	public static void readUTF()throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utf.txt"));

		String str = dis.readUTF();

		System.out.println("str="+str);

		dis.close();
	}

	public static void writeUTF()throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("utf.txt"));

		dos.writeUTF("你好");

		dos.close();
	}

	public static void readData() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

		int num = dis.readInt();

		System.out.println("num="+num);

		boolean b = dis.readBoolean();
		System.out.println("b="+b);

		dis.close();
	}

	public static void writeData()throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

		dos.writeInt(1234);

		dos.writeBoolean(false);

		dos.close();
	}
}
