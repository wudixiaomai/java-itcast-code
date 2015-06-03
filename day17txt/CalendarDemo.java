import java.util.*;

class  CalendarDemo
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();
		
		c.set(2012,0,1);

		//c.add(Calendar.YEAR,-2);//对指定的时间对象中的年进行时间量的偏移。
		c.add(Calendar.DAY_OF_MONTH,-1);


		//System.out.println(c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日");

		getDays(2015);
	}
	/*
	定义功能，获取指定年的二月有多少天。
	思路：就是将该年的3月1日向前一天。就是二月的最后一天。

	*/
	public static void getDays(int year)
	{
		Calendar c = Calendar.getInstance();

		c.set(year,2,1);
		c.add(Calendar.DAY_OF_MONTH,-1);

		System.out.println(c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日");
	}

}
