
/*
演示Date对象。
*/
import java.util.*;
import java.text.*;
class  DateDemo
{
	public static void main(String[] args) 
	{
		
		Date d = new Date();
		System.out.println(d);//Fri Oct 15 10:22:56 CST 2010

		//需求：让时间结果更贴近我们生活。
		//需要指定一个格式来显示时间。
		/*
		将格式作用到date对象上。
		步骤：
		1，先将格式封装到DateFormat的子类SimpleDateFormat对象中。
		2，使用format格式化方法格式date对象。(将格式作用到date对象上)

		*/

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日EE hh:mm:ss");
		String s = sdf.format(d);
		System.out.println(s);

	}
}
