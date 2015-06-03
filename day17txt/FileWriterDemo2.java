/*
演示io异常的try处理方式。
*/
import java.io.*;
class FileWriterDemo2 
{
	public static void main(String[] args) 
	{
		FileWriter fw = null;
		
		try
		{
			fw  = new FileWriter("k:\\a.txt");
			fw.write("aaa");
			
		}
		catch (IOException e)
		{
			System.out.println("io nono "+e.toString());
		}
		finally
		{
			if(fw!=null)//如果流对象没有建立成功是不要关闭的，所以要进行一下健壮性的判断。
				try
				{
					fw.close();
				}
				catch (IOException e)
				{
					System.out.println("close:"+e.toString());
				}
			
		}
		
	}
}
