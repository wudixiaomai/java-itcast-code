import java.net.*;
class UrlEncoderDemo 
{
	public static void main(String[] args) throws Exception
	{
		String str = "ÄãºÃ";

		byte[] arr = str.getBytes("utf-8");
		for(byte b : arr)
		{
			System.out.println(Integer.toHexString(b));
		}
		String s1 = URLEncoder.encode(str,"utf-8");
		System.out.println("s1="+s1);

		String s2 = URLDecoder.decode("%E4%BD%95%E5%A4%A7%E6%B5%B7","utf-8");
		System.out.println("s2="+s2);
	}
}
