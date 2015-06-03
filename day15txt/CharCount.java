/*
什么时候使用Map集合呢？
当分析是对象间出现了映射关系时，就优先考虑map集合。


"zxcvbnxzcvbzxc"
获取该字符串中每一个字母出现的个数。a(2)b(3)....

思路：
1，将字符串变成字符数组
2，遍历该数组，并将数组中的字符作为键去查map集合。获取相对应的值。
	如果该值为null，那么说明该字母不存在与map集合中，那么就将该字母和1存入集合，表示该字母出现1次。
	如果值不为null，那么将该值取出后，进行自增，将该字母与自增后的值重新存入map集合，这样新值会覆盖旧值。
3，遍历后，map集合中存入的就是每一个字母对应的次数。
4，遍历该map即可。

*/
import java.util.*;
class  CharCount
{
	public static void main(String[] args) 
	{
		String s = getCharCount("zxcvbnxzcvbzxc");
		System.out.println(s);//b(2)c(3)n(1)v(2)x(3)z(3)
	}

	public static String getCharCount(String str)
	{
		char[] chs = str.toCharArray();
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		int count = 0;
		for(int x=0; x<chs.length; x++)
		{
			Integer value = tm.get(chs[x]);//将字母作为键获取对应的值。
			if(value!=null)//如果值存在，用count记录。并对count自增。如果值不存在。只对count自增即可。
			{
				count = value;
			}
			count++;

			tm.put(chs[x],count);
			count = 0;
		}

		//System.out.println(tm);//{b=2, c=3, n=1, v=2, x=3, z=3}

		StringBuilder sb = new StringBuilder();

		Set<Character> keys = tm.keySet();
		Iterator<Character> it = keys.iterator();
		while(it.hasNext())
		{
			Character ch = it.next();
			Integer i = tm.get(ch);
			sb.append(ch+"("+i+")");
		}

		return sb.toString();

	}
}
