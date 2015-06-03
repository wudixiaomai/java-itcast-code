import java.io.*;
import java.util.*;
import java.text.*;


class ExceptionLogDemo 
{
	public static void main(String[] args) 
	{
		
		try
		{
			int num = 3/0;

		}
		catch (Exception e)
		{

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ HH:mm:ss");
			String date = sdf.format(d);

			try
			{
				

				PrintStream out = new PrintStream("exception.log");
				out.println(date);
				e.printStackTrace(out);
				out.close();
			}
			catch (IOException ex)
			{
				System.out.println(ex.toString());
			}
			
		}

	}
}


//log4j// log4j

