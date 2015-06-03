import java.io.*;

/*
ByteArrayInputStream
ByteArrayOutputStream

这个两个对象对应的设备都是内存。

其实都是封装了字节数组。并未调用底层资源，所以读写方法没有异常抛出，也不用关闭。

既然是操作数组，直接用for循环，自定义指针不就可以了吗？

要明确操作数组中的数据，其实动作只有两种，一个设置一个获取。这就是对数据的读写操作。

所以这两个对象的出现，对数组进行封装。可以直接用IO流的读写思想操作数组。



CharArrayReader CharArrayWriter


这些直接操作的数据的流对象的特点：
对于读取流，在初始化的时候，都需要有数据源。
ByteArrayInputStream需要在构造是传入一个字节数组数据源。
CharArrayReader需要在构造是传入一个字符数组数据源。

而它们的输出流中可以不需要传入参数，因为该流对象的内部都分别封装了可以变长度的字节或者字符数组。


*/
class  ByteArrayStream
{
	public static void main(String[] args) 
	{
		
		//创建数据源。内存。
		ByteArrayInputStream bis  = new ByteArrayInputStream("abcde".getBytes());


		//创建目的,内存。
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		int ch = 0;
		while((ch=bis.read())!=-1)
		{
			bos.write(ch);
		}

		System.out.println(bos.toString());
	}
}
