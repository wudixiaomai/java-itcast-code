import java.io.*;
import java.net.*;
class  RegServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10002);

		Socket s = ss.accept();

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);
		
		String str = new String(buf,0,len);

		System.out.println(str);
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		out.println("×¢²á³É¹¦");

		s.close();
		ss.close();

	}
}
