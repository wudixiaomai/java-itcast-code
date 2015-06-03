
/*
Math:
该类中的方法都是静态。

ceil();
floor();
round():
pow():
random():获取随机数。也可以使用java.util.Random对象完成。


练习：对三个数进行最大数的获取。

*/

import java.util.*;
class  MathDemo
{
	public static void main(String[] args) 
	{
//		System.out.println(Math.ceil(-12.3));
//		System.out.println(Math.floor(12.3));
//		System.out.println(Math.pow(10,3));//10的3次方。
		

		Random r = new Random();

		for(int x=0; x<10; x++)
		{
			//double d = Math.random()*6+1;

			//System.out.println((int)d);

			int num = r.nextInt(6)+1;
			System.out.println("num="+num);
		}
	}
}
