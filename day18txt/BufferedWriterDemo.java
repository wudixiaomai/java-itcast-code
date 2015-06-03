/*
缓冲区是为了提高流的效率而存在的。

也就是缓冲区在建立时，初始化过程中必须要先有流对象。

演示字符流的写入缓冲区。

1，创建写入流对象。
2，创建缓冲区对象，并将写入流对象作为参数传递给缓冲区对象构造函数。
3，使用缓冲区的方法操作数据。
4，关闭缓冲区。

强调，在使用缓冲区时，一定要记得使用flush刷新。

*/
import java.io.*;
class  BufferedWriterDemo
{
	public static void main(String[] args)throws IOException 
	{
		FileWriter fw = new FileWriter("buf.txt");

		BufferedWriter bufw = new BufferedWriter(fw);

		for(int x=0; x<4; x++)
		{
			bufw.write("abcd"+x);
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
	}
}
