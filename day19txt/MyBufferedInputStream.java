
/*
自定义一个字节流的缓冲区。


*/
import java.io.*;
class MyBufferedInputStream
{
	private InputStream in;

	private byte[] buf = new byte[1024];
	private int pos = 0,count =0;


	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}
	/*
	读取一个字节。


	问：为什么字节流的read方法返回一个读取字节，返回值类型确实int类型呢？
	因为，在文件数据中，容易出现连续8个二进制1的情况，而8个二进制1是负数-1.
	而这个-1，又和read方法的读到结束的表示相同。

	那么出现读取数据过程中，提前停止的情况。

	所以对读到的字节数据进行提升。并通过保留原字节数据，在提升位补0的方式，避免负数的出现。，

	b&255  或者  b&0xff


	而write方法也接收一个int的数据，但是只写入该int的最低一个8位。也就是只写一个字节。


	简单说：就是read方法对字节数据进行提升。避免提前终止。
			write在强制转换。
	*/
	public int myRead()throws IOException
	{
		//1,当count为0时，通过流对象方法获取数据并存入 到缓冲区(byte数组)中。
		if(count==0)
		{
			count = in.read(buf);
			if(count<0)
				return -1;
			pos = 0;
			byte b = buf[pos];
			pos++;
			count--;
			return b&255;
		}
		else if(count>0)
		{
			byte  b = buf[pos];
			pos++;
			count--;
			return b&0xff;
		}
		return -1;
	}

	public void myClose()throws IOException
	{
		in.close();
	}

}
/*

11111111   111111111111111111




00000001  -1 :取反加+1
取反：11111110
加+1：11111111

byte b = -1; b & 255 = 

int x = b;

byte : -1  11111111
int　：-1  11111111 11111111 11111111 11111111
00000000 00000000 00000000 11111111 = 255

*/
