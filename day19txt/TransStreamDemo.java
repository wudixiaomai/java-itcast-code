/*
转换流。

InputStreamReader:将字节转成字符。
OutputStreamWriter：将字符转成字节。

特点：可以融入指定编码表。


*/

import java.io.*;

class  TransStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		//字节读取流。(System.in默认是键盘设备。)
		//InputStream in = System.in;

		//想要使用readLine方法，读取键盘录入一行。
		//但该方法是BufferedReader特有方法。
		//如何让BufferedReader的readLine方法可以操作键盘录入的字节数据呢?
		//那么可以将字节转成字符流就可以使用该方法。
		//这时就要用到了转换流。
		//InputStreamReader isr = new InputStreamReader(in);
		


		//BufferedReader bufr = new BufferedReader(isr);

		//三据代码合并成依据代码。这句代码要记住，只要一提到键盘录入，就要使用该代码。

		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));




		//在键盘录入时，通常都要自定义一下结束标记。

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			System.out.println(line.toUpperCase());
		}

		bufr.close();


	}

	/*
	读取键盘录入的一行数据，并进行判断，如果是over，程序结束。
	否则，打印一行数据的大写形式。
	发现代码和readLine方法的原理很相似，
	既然io中已有这样的方法，可不以直接使用呢？

	*/
	public static void readIn()throws IOException
	{
		StringBuilder sb = new StringBuilder();

		while(true)
		{
			int ch = System.in.read();
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				String s = sb.toString();
				if("over".equals(s))
					return ;
				System.out.println(s.toUpperCase());
				sb.delete(0,sb.length());
			}
			else
				sb.append((char)ch);
		}
	}
}

