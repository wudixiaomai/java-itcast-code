import java.util.*;

/*
对字符串的长度进行排序。
*/

class  TreeSetTest
{
	public static void main(String[] args) 
	{
		
		TreeSet ts = new TreeSet(new Comparator()
		{
			public int compare(Object o1,Object o2)
			{
				String s1  = (String)o1;
				String s2  = (String)o2;
				if(s1.length()>s2.length())
					return 1;
				if(s1.length()<s2.length())
					return -1;
				return s1.compareTo(s2);

			}
		});

		ts.add("abcdef");
		ts.add("bbb");
		ts.add("abc");
		ts.add("qwer");
		ts.add("aa");


		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			String s = (String)it.next();
			System.out.println(s+".."+s.length());
		}
		System.out.println("-------------------------");
		sortNumber();
		print();
		
	}

	/*
	"20 3 -1 98 6"
	*/
	public static void sortNumber()
	{
		String str = "20 3 -1 98 6";

		TreeSet ts = new TreeSet();

		String[] nums = str.split(" ");

		for(int x=0; x<nums.length; x++)
		{
			ts.add(new Integer(nums[x]));
		}

		System.out.println(ts);
	}

	public static void print()
	{
		int[] arr = {4,1,6,7,2};

		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int x=0; x<arr.length; x++)
		{
			if(x!=arr.length-1)
				sb.append(arr[x]+", ");
			else
				sb.append(arr[x]+"]");
		}
		System.out.println(sb);
	}
}
