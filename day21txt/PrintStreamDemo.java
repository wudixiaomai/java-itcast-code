/*
PrintStream.

字节打印流
	初始化时，可以接收三种数据。
	1，File对象。
	2，字符串路径。
	3，字节输出流。


print(int):print将一个整数的4个字节进行打印。
write(int):将一个整数的最低8位写入，也就是内部有强制动作。

*/
import java.io.*;
class  PrintStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("c:\\ps.txt");
		//在对象建立时，一样会创建一个目的地文件。
//		PrintStream ps = new PrintStream(f);

		//将目的改成了控制台。
//		PrintStream ps = new PrintStream(System.out);


		ps.println("haha");
		ps.println("heihei");
		ps.close();
	}
}
