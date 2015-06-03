/*
需求：
通过客户端键盘录入用户名，实现登录。
服务端对客户端的发送过来的用户名进行校验。
如果该用户存在，服务端显示用户登录，并回馈给客户端欢迎光临。
如果该用户不存在，服务端显示用户尝试登录，并回馈给客户端，该用户不存在。

另外，客户端最多只能尝试登录三次。
服务端也一样作此限定。


思路：
客户端：
1，建立socket服务。
2，读取键盘录入。
3，将录入的一个用户名数据通过socket的输出发出，给服务端。
4，发出后，要读取服务端回馈的信息。
5，判断该信息，如果有欢迎字样表示登录成功，用户名输入结束。
因为操作的是文本，所以可以使用字符流。并加上缓冲提高效率。



*/
import java.net.*;
import java.io.*;

class  LoginClient
{
	public static void main(String[] args)throws Exception 
	{
		Socket s = new Socket("192.168.0.5",9007);
		//读取键盘录入，获取用户名。
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));


		//对socket输出流进行打印。将录入的用户名发送给服务端。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		//对socket输入流中的数据进行获取，其实就是在获取服务端的回馈信息。
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));

		//客户端值允许录入三次。
		for(int x=0; x<3; x++)
		{
			//从键盘读取一行。
			String username = bufr.readLine();
			

			if(username==null)
			{
				//s.shutdownOutput();
				break;
			}
			//将该行数据打印到socket输出流。
			out.println(username);

			//获取服务端反馈信息。
			String info = bufIn.readLine();
			System.out.println(info);
			if(info.contains("欢迎"))
				break;
		}

		bufr.close();
		s.close();

	}
}

/*
服务端：
1，建立socket服务。
2，不断获取客户端对象。
3，将客户端对象封装到单独的线程中。
4，限定判断次数。
5，读取本地用户文件列表，对获取的用户名进行校验。
6，根据校验结果给出响应信息。
*/
class UserThread implements Runnable
{

	private Socket s;
	UserThread(Socket s)
	{
		this.s = s;
	}
	public void run()
	{
		try
		{
			for(int x=0; x<3; x++)
			{
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

				String name = bufIn.readLine();
				if(name==null)
				{
					System.out.println("程序结束 ");
					break;
				}

				BufferedReader bufr = new BufferedReader(new FileReader("user.txt"));

				String line = null;

				PrintWriter out = new PrintWriter(s.getOutputStream(),true);
				boolean b = false;
				while((line=bufr.readLine())!=null)
				{
					if(line.equals(name))
					{
						b = true;
						break;
					}				
				}

				if(b)
				{
					System.out.println(name+"已登录");
					out.println(name+"，欢迎光临");
				}
				else
				{
					System.out.println(name+"尝试登录");
					out.println(name+"，用户不存在");
				}

			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(s!=null)
					s.close();
			}
			catch (Exception e)
			{
				System.out.println("close:"+e.toString());
			}
			
		}

	}
}

class  LoginServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(9007);

		while(true)
		{
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress()+".....connected");
			new Thread(new UserThread(s)).start();
		}
	}
}