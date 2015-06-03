/*
演示Vector中特有的一些方法。这些方法都有一个特点：都有element这个单词。.

Vector中支持一个特有的取出形式，枚举(Enumeration)
但是很遗憾：Enumeration被迭代器所替代，因为接口名称以及方法名称过长！！

*/
import java.util.*;
class  VectorDemo
{
	public static void main(String[] args) 
	{
		Vector v = new Vector();

		v.addElement("abc1");
		v.addElement("abc2");
		v.addElement("abc3");
		v.addElement("abc4");
		//1,取出方式elementAt。
		for(int x=0; x<v.size(); x++)
		{			
			System.out.println("elementat::"+v.elementAt(x));
		}

		Enumeration en  = v.elements();
		while(en.hasMoreElements())
		{
			System.out.println("en::"+en.nextElement());
		}

		Iterator it = v.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
