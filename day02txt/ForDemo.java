class  ForDemo
{
	public static void main(String[] args) 
	{
		int a = 0;
		while(a<3)
		{
			System.out.println("a="+a);
			a++;
		}
		System.out.println("a====="+a);


		for(int x = 0; x<3; x++)
		{
			System.out.println("x="+x);
		}

		//System.out.println("x====="+x);

		//Ç¶Ì×Óï¾ä¡£
		for(int x=1; x<10; x++)
		{
			if(x%2==1)
				System.out.println("x="+x);
		}
	}
}




