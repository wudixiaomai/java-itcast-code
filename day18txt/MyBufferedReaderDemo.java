import java.io.*;

class  MyBufferedReaderDemo
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("bufcopy.txt");

		MyBufferedReader myBufr = new MyBufferedReader(fr);

		String line = null;

		while((line=myBufr.myReadLine())!=null)
		{
			
			System.out.println(line);
		}

		myBufr.myClose();
	}
}
