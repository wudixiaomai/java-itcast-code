import java.util.*;
/*
演示binarySearch。
该方法特殊之处：
当元素不存在的时候，返回的是该元素在集合中的  -(插入位置+1)
*/
class  CollectionsDemo3
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("cccc");
		al.add("abcde");
		al.add("aa");
		al.add("abc");
		al.add("abc");
		
		System.out.println("原集合："+al);
		//使用集合的二分查找对元素进行位置的获取。前提：必须要是对有序的集合。

		//按默认方式排序。自然顺序。
//		Collections.sort(al,new StrCompareByLen());
//
//		System.out.println("排序后："+al);
//
//		int index = Collections.binarySearch(al,"ccccc",new StrCompareByLen());
//		System.out.println("index="+index);


		//fill方法：将集合中所有的元素替换成指定元素。
		//Collections.fill(al,"zz");
		//System.out.println("fill:"+al);

		//replaceAll:
		//Collections.replaceAll(al,"aa","qq");
		//System.out.println("replaceAll:"+al);

		//reverse();反转集合元素。通过swap方法的演示，发现reverse的实现其实就是头尾元素的互换。
//		Collections.reverse(al);
//		System.out.println("reverse:"+al);

		//swap():对list集合中的元素进行换位。
		Collections.swap(al,0,2);
		System.out.println("swap:"+al);
	}
}
