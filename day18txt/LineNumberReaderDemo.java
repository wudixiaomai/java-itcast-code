/*
ÑÝÊ¾LineNumberReader

*/
import java.io.*;
class  LineNumberReaderDemo
{
	public static void main(String[] args) throws IOException
	{

		FileReader fr = new FileReader("MyBufferedReaderDemo.java");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;

		System.out.println("number:"+lnr.getLineNumber());
		System.out.println("number:"+lnr.getLineNumber());

		lnr.setLineNumber(1000);

		while((line=lnr.readLine())!=null)
		{
			
			System.out.println(lnr.getLineNumber()+":"+line);
		}

		lnr.close();
	}
}
