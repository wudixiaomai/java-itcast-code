/*
通过缓冲区的形式，进行文本文件的copy。

字符流：
	字符流用于操作文本文件的流对象。是最基础的流对象。
	FileReader
	FileWriter
	为了提高字符流的操作的效率。而缓冲区对象必须要依赖于流对象存在。
	BufferedReader 
		|--LineNumberReader。
	BufferedWriter

*/
import java.io.*;
class  BufferCopyText
{
	public static void main(String[] args)throws IOException 
	{
		FileReader fr = new FileReader("buf.txt");
		BufferedReader bufr = new BufferedReader(fr);

		FileWriter fw = new FileWriter("bufcopy.txt");
		BufferedWriter bufw = new BufferedWriter(fw);

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			bufw.write(line);//将数据写入到缓冲区。
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
		bufr.close();
	}
}
