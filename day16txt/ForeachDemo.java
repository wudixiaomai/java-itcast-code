/*
JDK1.5版本出现的新特之一：
增强的for循环。

增强for循环和传统for循环有什么区别：

通常增强for循环使用时，必须要有被遍历的目标。

建议：在遍历数组时，还是建议使用传统for循环。
for
*/
import java.util.*;
class  ForeachDemo
{
	public static void main(String[] args) 
	{
		
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		al.add("abc4");

		/*
		格式：
		for(元素类型 变量名 : 数组或Collection集合)
		{
			执行语句；
		}
		*/
		for(String s : al)
		{
			System.out.println("foreach:"+s);
		}
		/*
		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		*/
		/*
		for(Iterator<String> it = al.iterator(); it.hasNext(); )
		{
			
			System.out.println(it.next());
		}
		*/
		//foreach遍历数组。
		int[] arr = {4,1,7};
		for(int i : arr)
		{
			System.out.println("i="+i);
		}

		//foreach如何遍历map呢？不可以直接遍历map需要将map集合变成set集合后。才可以进行遍历

		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("01","lisi1");
		hm.put("02","lisi2");
		hm.put("03","lisi3");

		Set<String> keys = hm.keySet();
		for(String s : keys)
		{
			System.out.println(s+"="+hm.get(s));
		}
		//Set<Map.Entry<String,String>> entrys = hm.entrySet();
		//for(Map.Entry<String,String> me : entrys)

		for(Map.Entry<String,String> me : hm.entrySet())//遍历Set集合。
		{
			System.out.println(me.getKey()+"=="+me.getValue());
		}
	}
}
