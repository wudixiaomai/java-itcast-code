/*
jdk1.5新特性。
静态导入。
也是简化书写。


*/

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.System.*;
import java.util.Arrays;
class StaticImport 
{
	public static void main(String[] args) 
	{


		int[] arr = {4,1,6,2,7,3,5};
		//Arrays.sort(arr);
		sort(arr);
//		System.out.println(Arrays.toString(arr));
		out.println(Arrays.toString(arr));
	}
}
