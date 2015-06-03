/*
Map集合。

Map集合的特点：
1，一次存入一对元素，是以键值对的形式存在。键与值之间存在着映射关系。
2，一定要保证键的唯一性。
Map
	|--HashMap:底层是哈希表数据结构，线程是不同步的，可以出现null键，null值。
	|--Hashtable：底层是哈希表数据结构，线程是同步的，不可以出现null键，null值。被HashMap替代。
	|--TreeMap：可以对map集合中的键进行排序。

Map.Entry:接口中的接口，是键值映射关系的类型。

*/
import java.util.*;
class  HashMapDemo
{
	public static void main(String[] args) 
	{
		HashMap<Integer,String> hm = new HashMap<Integer,String>();

		//1，添加元素。put。
		hm.put(1,"lisi1");
		hm.put(2,"lisi2");
		hm.put(3,"lisi3");
		hm.put(4,"lisi4");

		System.out.println(hm.get(20));

		//取出Map集合中的元素。原理：将map集合转成set集合。然后在使用迭代器取出。

		//通过values取出所以值。
		Collection<String> coll= hm.values();
		Iterator<String> it = coll.iterator();
		while(it.hasNext())
		{
			String value = it.next();
			System.out.println("value:"+value);
		}

		for(String str:coll){
			System.out.println("str:"+str);
		}


		//使用entrySet方法。完成。
		/*
		Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();

		Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();

		while(it.hasNext())
		{
			Map.Entry<Integer,String> me = it.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+"::"+value);

		}
		*/

		//使用keySet方法。完成。
		/*
		Set<Integer> keySet = hm.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext())
		{
			Integer i = it.next();
			String value = hm.get(i);
			System.out.println("key="+i+",,value="+value);
		}
		*/



		/*
		//如果添加了相同的键，那么新值会替换旧值，如果键不相同，put方法返回null。
		System.out.println(hm.put(5,"haha"));

		//2，判断。
		System.out.println(hm.containsKey(20));
		System.out.println(hm.containsValue("haha1"));


		//3,删除。remove(key);
		System.out.println(hm.remove(2));
		System.out.println(hm);
		*/

		//new Demo().show();
	}
}


interface MyMap
{
	public static interface MyEntry
	{
		void show();

	}
}

class Demo implements MyMap.MyEntry
{
	public void show()
	{
		System.out.println("my map.entry");
	}
}
