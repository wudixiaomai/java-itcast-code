
/*
PrintWriter
字符打印流：
	可以在实例化时接收的参数类型：
	1，字符串路径。
	2，File对象。
		对于接收字符串路径和File对象，都可以指定字符集(编码表)。
	3，字节输出流。OutputStream
	4，字符输出流，Writer.
		对于接收两个输出流对象而言，可以加入另一个参数自动刷新。
		该自动刷新只对三个方法有效，println,printf,format.


如果现在使用打印流，既要自动刷新，又需要编码转换。

	PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("a.txt"),"utf-8"),true);

	新增需求：提高效率。还要使用打印方法。
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt"),"utf-8")),true);





PrintWriter out = response.getWriter();

out.println("<html>");
out.println("</html>");
*/

import java.io.*;
class  PrintWriterDemo
{
	public static void main(String[] args)throws IOException 
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter out = new PrintWriter(System.out,true);

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			out.println(line.toUpperCase());
			//out.flush();
		}

		out.close();
		bufr.close();
	}
}
