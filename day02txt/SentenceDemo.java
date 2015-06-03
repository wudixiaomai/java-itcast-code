/*
1，获取1~100之间6的倍数的个数。
2，3000米绳子，每天减一半，问，多少天绳子会小于5米？


int x = 1;
for(System.out.println("a");x<3; System.out.println("c"))
{
	System.out.println("d");
	x++;
}


boolean b = true;
if(b=false)
	System.out.println("a");
else if(b)
	System.out.println("b");
else if(!b)
	System.out.println("c");
else
	System.out.println("d");


int x = 3;
switch(x)
{
	default:
		x+=3;
	case 1:
		x+=4;
	case 2:
		x+=5;
}
System.out.println("x="+x);



int x = 1,y = 1;

if(x++==2 && ++y==2)
{
	x = 5;
}
System.out.println("x="+x+",y="+y);


------------------------------
int x = 1,y = 1;

if(++x==2 | y++==2)
{
	x = 5;
}
System.out.println("x="+x+",y="+y);


*/



class  SentenceDemo
{
	public static void main(String[] args) 
	{

		//1，获取1~100之间6的倍数的个数。
		/*
		思路：
		1，遍历1~100这些数。使用for语句，因为该增量只为循环存在。
		2，在遍历的过程中限定条件。
		3，对于满足条件的，要进行计数。其实就是一个变量的自增。
		
		其实这就是计数器思想。

		*/

		int count = 0;

		for(int x=1; x<=100; x++)
		{
			if(x%6==0)
				count++;
		}
		System.out.println("count="+count);


		//2，3000米绳子，每天减一半，问，多少天绳子会小于5米？
		
		int day = 0;
		for(int x=3000; x>=5; x/=2)
		{
			day++;
		}
		/*
		for(int x=3000; x>=5; day++)
		{
			x/=2;
		}
		*/
		System.out.println("day="+day);


		int y = 1;
		for(System.out.println("a");y<3; System.out.println("c"))
		{
			System.out.println("d");
			y++;
		}

		//a,d,c,d,

	}
}

