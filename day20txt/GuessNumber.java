/*
猜数字的游戏
1，定义一个随机数。
2，获取键盘录入数据，并转换成一个整数。
3，进行比较。重复该过程。

*/
import java.io.*;
import java.util.*;
class  GuessNumber
{

	private int ranNumber;
	GuessNumber()
	{
		Random r = new Random();
		ranNumber = r.nextInt(100)+1;
	}

	/**
	猜数字游戏.
	*/
	public  void play()
	{
		boolean b = false;

		System.out.println("游戏开始，请输入1~100之间的数字：");
		while(!b)
		{
			try
			{
				int num = getNumber();
				if(num>=1&& num<=100)
					b = compare(num);
				else
					System.out.println("输入的数字超出范围,请重新输入：");

			}
			catch (IOException e)
			{
				System.out.println(e.toString());
				return ;
			}
			catch (NumberFormatException e )
			{
				System.out.println("你输入了非法数据，请重新输入:");
			}
			
		}
	}

	/*
	获取键盘录入数据。
	*/
	private int getNumber()throws IOException,NumberFormatException
	{
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));

		String line = bufr.readLine();
		return Integer.parseInt(line);
	}

	/*
	进行数据比较的方法。
	*/
	private boolean compare(int num)
	{
		boolean b = false;
		if(num>ranNumber)
			System.out.println("大了，继续");		
		else if(num<ranNumber)
			System.out.println("小了，继续");
		else
		{
			System.out.println("中了，恭喜");
			b = true;
		}
		return b;		
	}


	public static void main(String[] args) 
	{
		new GuessNumber().play();
	}
}
