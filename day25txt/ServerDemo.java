import java.net.*;
import java.io.*;

class  ServerDemo
{
	public static void main(String[] args) throws Exception
	{

		ServerSocket ss  = new ServerSocket(10000);

		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress());

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		String str = new String(buf,0,len);

		System.out.println(str);
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		out.println("<font color='red' size='7'>∑√Œ ≥…π¶</font>");
		
		s.close();
		ss.close();

	}
}
/*
GET / HTTP/1.1
Accept: application/x-shockwave-flash, image/gif, image/x-xbitmap, image/jpeg, i
mage/pjpeg, application/msword, application/vnd.ms-excel, application/vnd.ms-pow
erpoint, *
Accept-Language: zh-cn
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0
.50727; CIBA)
Host: 192.168.1.253:10000
Connection: Keep-Alive

*/