import java.io.*;
class MyLineNumberReaderDemo 
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("HouseDemo2.java");

		MyLineNumberReader myLnr = new MyLineNumberReader(fr);

		String line = null;
		myLnr.setLineNumber(1000);
		while((line=myLnr.myReadLine())!=null)
		{
			
			System.out.println(myLnr.getLineNumber()+":::"+line);
		}

		myLnr.myClose();
	}
}


