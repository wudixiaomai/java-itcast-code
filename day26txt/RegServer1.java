import java.io.*;
import java.net.*;
class  RegServer1
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10002);

		while(true)
		{
			Socket s= null;
			String ip = null;
			InputStream in = null;
			try
			{
				s = ss.accept();
				ip = s.getInetAddress().getHostAddress();
				System.out.println(ip+".....connected");

				in = s.getInputStream();

				byte[] buf = new byte[1024];
				
				int num = in.read(buf);

				String text = new String(buf,0,num);

				System.out.println(text);
				PrintWriter out = new PrintWriter(new FileWriter("reg.txt",true));
				out.println("已注册用户："+ip);
				out.println(text);
				out.print("\r\n\r\n");
				out.flush();
				out.close();



				PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

				pw.println("<font color='green' size='7'>注册成功</font>");	


				s.close();
			}
			catch (Exception e)
			{
				System.out.println(ip+",,"+e.toString());
			}
			finally
			{
				if(s!=null)
				try
				{
					s.close();
				}
				catch (Exception e)
				{
					System.out.println("close:"+e.toString());
				}
			}
			
		}
	}
}
