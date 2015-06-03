/*
字节流可以处理任何数据。
包括字符数据，但是不可以对数据进行编码转换。

就有了字符流，该字符流的出现内部使用的还是字节流，但是封装了编码表，还可以根据指定的需求，指定编码表。



需求：通过io对象将数据写入到硬盘的一个文件中。
使用的就是可以操作文件的字符流对象。FileWriter。
*/
import java.io.*;
class  FileWriterDemo
{
	public static void main(String[] args) throws IOException
	{
		//创建FileWriter流对象,必须指定数据要存放的目的地。通过构造函数的形式。
		//创建对象时，调用了系统底层的资源。在指定位置建立了数据存放的目的文件。
		FileWriter fw= new FileWriter("text.txt");

		//2,调用Writer体系中的write方法将数据写入到了流中。
		fw.write("abcde");

		//3,刷新缓冲区，将流中的数据刷新到目的地中。
		//fw.flush();

		//4,关闭流资源。
		fw.close();




	}
}
/*
flush():将流中的数据刷新到目的地。而流还可以继续使用。
close()：将流中的数据刷新到目的地，但是流会关闭。其实close在关闭前调用flush方法。
*/