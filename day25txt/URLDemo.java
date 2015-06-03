import java.net.*;

class  URLDemo
{
	public static void main(String[] args)throws Exception 
	{

		String str = "http://192.168.1.253/myweb/1.html?name=zhangsan";
		URL url = new URL(str);
		/*
		 String getFile() :获取此 URL 的文件名。 该内容比getPath多一个Query。如果没有Query，返回内容和getPath一致。
		 String getHost():  获取此 URL 的主机名（如果适用）。 
		 String getPath() :获取此 URL 的路径部分。 
		 int getPort() :获取此 URL 的端口号。 
		 String getProtocol() :获取此 URL 的协议名称。 
		 String getQuery() :获取此 URL 的查询部分。
		*/

		System.out.println("getProtocol:"+url.getProtocol());
		System.out.println("getPort:"+url.getPort());
		System.out.println("getHost:"+url.getHost());
		System.out.println("getFile:"+url.getFile());
		System.out.println("getPath:"+url.getPath());
		System.out.println("getQuery:"+url.getQuery());

		URLConnection conn = url.openConnection();

		System.out.println(conn);


	}
}


/*
int port = url.getPort();

if(port==-1)
	port = 80;




*/