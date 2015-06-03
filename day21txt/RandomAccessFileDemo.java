import java.io.*;

/*
RandomAccessFile

1，该对象只用于操作文件。
2，通过构造函数的模式参数指定要进行读（r）或者写(rw)。
3，该类对象内部封装了字节输入流和输入流，同时封装了一个可延长的字节数组缓冲区。
4，内部有指针来操作该缓冲区中的数据。
5，该对象中有直接操作基本数据类型数据的方法。如writeInt，，readInt。




注意：RandomAccessFile：模式为rw时，操作文件，如果该文件不存在，会创建后，在进行写入数据的操作，
	如果文件已存在，那么就在该文件进行原数据的操作。
	可以对已有的数据进行修改。

通过seek()方法指定对象要操作的数据位置，如果该位置上已有数据，那么出现数据被覆盖的操作，
这种功能，可用于对数据的修改。

一种应用：多线程下载。

多个线程同时往一个文件写入数据时，只要每一个线程负责的数据段不同，就不会出现数据错乱情况。
而且可以提高效率。

严重注意:要使用该对象，需要明确数据都是有规则的。


*/

class  RandomAccessFileDemo
{
	public static void main(String[] args) throws IOException
	{
		//通过该类将一些姓名和年龄信息写入到文件中。


		File file = new File("info.txt");
		
//		randomWrite(file);

//		randomRead(file);
		randomWrite2(file);

	}



	/*
	通过RandomAccessFile类进行文件的创建，并写入数据。姓名+年龄。

	
	*/
	public static void randomWrite(File file)throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile(file,"rw");

		raf.write("张三".getBytes());
		raf.writeInt(97);	
		raf.write("李四".getBytes());
		raf.writeInt(98);	
		raf.write("王武".getBytes());
		raf.writeInt(99);	
		
		raf.close();
	}

	/*
	读取操作。
	*/
	public static void randomRead(File file)throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile(file,"r");
		//raf.write(3);//拒绝访问

		//raf.seek(8*2);// 将缓冲中的指针进行自定义指定，就可以获取执行的数据信息。

		raf.skipBytes(8*2);//指定跳过的字节数，

		raf.seek(8);

		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		int age = raf.readInt();
		System.out.println(name+"::"+age);

		raf.close();


	}

	/*
	修改已有数据。
	*/
	public static void randomWrite2(File file)throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile(file,"rw");

		raf.seek(8*1);
		raf.write("李四".getBytes());
		raf.writeInt(65);	
		
		
		raf.close();
	}

}
