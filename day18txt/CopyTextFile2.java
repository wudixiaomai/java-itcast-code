
/*
copy文本文件。
通过读一个，写一个的方式。


*/
import java.io.*;
class  CopyTextFile2
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("CopyTextFile.java");
		FileWriter fw = new FileWriter("copy.txt");
		
		int ch = 0;
		while((ch=fr.read())!=-1)
		{
			fw.write(ch);
		}

		fw.close();
		fr.close();
	}
}
