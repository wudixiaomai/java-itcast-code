/*


ab你好c谢谢de
要求是，按照指定的字节数截取字符串。如果截到了半个中文舍弃，

*/

class StringByByteGet 
{
	public static void main(String[] args) 
	{
		String s = getByByte("ab你好c谢谢de",9);
		System.out.println(s);
	}

	public static String getByByte(String str,int len)
	{
		byte[] arr = str.getBytes();
		int count = 0;
		for(int x = len-1; x>=0; x--)
		{
			if(arr[x]<0)
				count++;
			else
				break;

		}

		if(count%2==0)
			return new String(arr,0,len);
		else
			return new String(arr,0,len-1);
	}
}
