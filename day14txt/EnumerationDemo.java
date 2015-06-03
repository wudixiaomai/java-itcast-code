/*
枚举和迭代的功能是重复的。
通过代码示例进行演示。

这个例子要求会写！
*/
import java.util.*;
class  EnumerationDemo
{
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		al.add("abc1");
		al.add("abc2");

		//通过枚举取出arrayList中的元素。
		/*
		arrayList中没有方法直接获取到枚举接口的对象。
		那么，我们可以自己建立枚举接口的对象。
		*/

		final Iterator it = al.iterator();
		Enumeration en = new Enumeration()
		{
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}
			public Object nextElement()
			{
				return it.next();	
			}
		};
		

		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}
}
