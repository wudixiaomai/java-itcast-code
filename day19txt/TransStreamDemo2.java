import java.io.*;



/*

流操作的基本规律：


1，明确数据源和数据目的（数据汇）。
	其实就是在明确是要使用输入流还是输出流。

2，明确操作的数据是否是纯文本数据。
	如果是使用字符流。
	如果不是使用字节流。

InputStream OutputStream Reader  Writer

源设备：键盘System.in ，硬盘File。内存。
目的设备：控制台System.out，硬盘File。内存。









1,需求：将键盘录入的数据存储到一个文件中。
	
	1，明确源设备:键盘录入。System.in.
	2，明确目的设备：硬盘上的文件。File

	3，明确操作的数据是否是纯文本。是！。
		使用字符流。

	对于源：键盘录入是通过System.in完成，因为操作的是纯文本数据，
		那么应该是字符输入流Reader。
		System.in是字节读取流，为了方便操作这些字节文本数据。
		将其转换成字符流。然后为了提高操作效率，使用了字符读取流的缓冲区。

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

	对于目的：确定是输出流，因为操作的是文本，字符输出流Writer.
			既然设备是一个硬盘上的文件。使用FileWriiter。
			为了提高操作效率。使用字符输出缓冲区。
		BufferedWriter bufw = new BufferedWriter(new FileWriter("a.txt"));
	
	新增需求：
		将获取到的字符数据按照指定的编码utf-8的形式存放到一个文件中。
		
		目的还是硬盘上的文件，但是涉及到了编码。要用到字符流中的转换流。
		因为转换流中只能接收字节输出流。就要使用可以操作的文件的字节输出流。FileOutputStream。
		为了提高效率，加入缓冲区。
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt"),"utf-8"));


		

2,需求：将一个文本文件中的数据变成大写展示在控制台上。
		源：一个硬盘上的文件。
			而且是纯文件数据。
			明确了要使用Reader。
			因为关联的是文件。FileReader。
			为了提高效率。使用了字符读取流的缓冲区。

		BufferedReader bufr = new BufferedReader(new FileReader("a.txt"));

		新增需求；将指定文本文件数据按照指定编码形式读取。
			涉及到了编码转换，需要使用转换流。字节转字符使用InputStreamReader
			,而转换流中需要接收字节读取流。又要关联文件，所以使用FileInputStream.
			为了提高效率。使用了字符读取流的缓冲区。

		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt"),"UTF-8");

		
		目的：控制台。System.out.
			确定使用输出流。
			操作的数据都是纯文本。使用。Writer。

			但是System.out的类型是PrintStream。是字节输出流，那么这时为了使用字符输出流。操作字符方便。
			将其字节输出流进行转换。使用转换流，因为字符到字节。OutputStreamWriter。
			为了提高效率。使用了字符输出缓冲区。

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));



	



*/
class  TransStreamDemo2
{
	public static void main(String[] args) throws IOException
	{

		//1,获取键盘录入数据，一行读取很方便，使用readLine方法。
		//需要将键盘录入的字节流转换成字符流，然后在通过字符流的缓冲区的readLine方法获取一行数据。
		
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(new FileInputStream("TransStreamDemo.java")));

		String line = null;

		
		//OutputStream out = System.out;//PrintStream ps = System.out;  PrintStream extends OutputStream		

		//OutputStreamWriter osw = new OutputStreamWriter(out);

		///BufferedWriter bufw = new BufferedWriter(osw);

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("abc.txt")));
											



		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();

		}

		bufw.close();
		bufr.close();
	}
}


/*
1,将文本文件打印在控制台上。

2，将键盘录入的数据存储到一个文件中。


*/