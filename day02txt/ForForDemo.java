class  ForForDemo
{
	public static void main(String[] args) 
	{
		/*
		for(int x=0; x<4; x++)
		{
			for(int y=0; y<3; y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		*/

		/*
		
		*****
		****
		***
		**
		*

		*/
		
		for(int x=0; x<5; x++)
		{
			for(int y=x; y<5; y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		
		*
		**
		***
		****
		*****
		
		*/
		for(int x=0; x<5; x++)
		{
			for(int y=0; y<x+1; y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}


	}
}


/*

1*1=1
1*2=2 2*2=4
1*3=3 2*3=6 3*3=9



***
***
***
***



*****
****
***
**
*


*/