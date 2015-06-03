
/*
基本数据类型的对象包装类。

将基本数据类型变成了对象。
为了定义更多的功能来操作这些基本数据类型。

byte	--> Byte
short	--> Short
int		--> Integer
long	--> Long
float	--> Float
double	--> Double
boolean	--> Boolean 
char	--> Character


包装类的功能：
通常用于基本类型与字符串之间的转换。

toBinrayString(num):获取一个整数的二进制表现形式。
Integer.toBinaryString(6);// 110;

int parseInt(numstr,radix)：将指定进行的表现形式转成十进制。
Integer.parseInt("110",2);// 6

除了Character以外。
其他7个都有parse方法。
XXX parseXXX(XXXstr);


对于整数两种将字符串转换成数字的方式.

static int parseInt(str):

new Integer(str).intValue();

*/
class IntegerDemo 
{
	public static void main(String[] args) 
	{

		Integer i1 = new Integer("123");
		Integer i2 = new Integer(123);

		System.out.println(i1==i2);//false 地址值不同。
		System.out.println(i1.equals(i2));//true Integer比较的是这个整数是否相等。



		//如何将一个字符串转换一个整数呢？
		//在对数字进行转换时，必须保证是数字格式的字符串。否则，会发生数组格式异常NumberFormatException;
		Integer i = new Integer("234");
		int x = i.intValue();

		System.out.println(x+5);

		


		int num = Integer.parseInt("110",2);



		System.out.println(num+2);

		//Integer i = new Integer(6);
		


//		System.out.println(Integer.toBinaryString(6));
//		System.out.println(Integer.MAX_VALUE);

	}
}
