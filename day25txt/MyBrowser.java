import java.net.*;
import java.io.*;

class MyBrowser 
{
	public static void main(String[] args) throws Exception
	{

		Socket s = new Socket("192.168.1.253",8080);


		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		

		out.println("GET /myweb/2.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Host: 192.168.1.253:10000");
		out.println("Connection: close");

		out.println();

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;

		while((line=bufIn.readLine())!=null)
		{
			System.out.println(line);
		}


		s.close();

	}
}
/*
GET /myweb/1.html HTTP/1.1
Accept: application/x-shockwave-flash, image/gif, image/x-xbitmap, image/jpeg, i
mage/pjpeg, application/msword, application/vnd.ms-excel, application/vnd.ms-pow
erpoint, 
Accept-Language: zh-cn
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0
.50727; CIBA)
Host: 192.168.1.253:10000
Connection: Keep-Alive

GET /myweb/1.html HTTP/1.1
Accept: *
Accept-Language: zh-cn
Host: 192.168.1.253:10000
Connection: Keep-Alive
*/