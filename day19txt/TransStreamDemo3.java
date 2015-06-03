import java.io.*;
/*
演示System类中的
static void setIn(InputStream);

static void setOut(PrintStream);
方法。用于改变系统默认的输入和输出设备。

*/
class TransStreamDemo3 
{
	public static void main(String[] args) throws IOException
	{

		//System.setIn(new FileInputStream("CopyMp3.java"));

		
		System.setOut(new PrintStream("out.txt"));

		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw = 
			new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

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
