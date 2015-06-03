class  BreakDemo
{
	public static void main(String[] args) 
	{

		/*
		break：1，switch，2，循环语句。
		*/

		/*
		for(int x=0; x<3; x++)
		{
			if(x==1)
				break;
			System.out.println("x="+x);
			
		}
		*/
		
		/*
		continue:只作用与循环结构。
		结束本次循环，继续下次循环。
		*/

		for(int x=1; x<10; x++)
		{
			if(x%2==0)
				continue;
			System.out.println("x="+x);
			
		}
		

		haha:for(int x=0; x<3; x++)
		{
			for(int y=0; y<4; y++)
			{
				System.out.println("x="+x);

				break haha;
			}
		}

		haha:for(int x=0; x<3; x++)
		{
			for(int y=0; y<4; y++)
			{
				System.out.println("x="+x);

				continue haha ;
			}
		}

		


	}
}
