/*
集合变成数组。
使用到Collection的方法toArray();


*/
import java.util.*;
class  CollectionToArray
{
	public static void main(String[] args) 
	{

		ArrayList<String> al = new ArrayList<String>();

		al.add("a1");
		al.add("a2");
		al.add("a3");
		al.add("a4");


		/*
		可以给toArray方法传递一个指定类型的数组即可。
		但是该数组到底定义多长呢？
		如果定义的长度小于了集合的size，那么toArray方法会自动新建一个数组，并长度为集合的size。
		如果长度大于集合的size，就以该数组为主。

		由此得出结论：最好是定义一个长度和集合size一致的数组。

		*/
		String[] arr = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(arr));
	}
}
