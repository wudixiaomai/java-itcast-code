/*

练习：定义一个程序，根据自定义变量的值，打印该值对应的所属季节。


*/


class  IfTest
{
	public static void main(String[] args) 
	{

		int x = 12;

		if(x<1 || x>12)
			System.out.println(x+"月不存在");
		else if(x>=3 && x<=5)
			System.out.println(x+"月是春天");
		else if(x>=6 && x<=8)
			System.out.println(x+"月是夏天");
		else if(x>=9 && x<=11)
			System.out.println(x+"月是秋天");
		else
			System.out.println(x+"月是冬天");



		/*
		if(x==3 || x==4 || x==5)
			System.out.println(x+"月是春天");
		else if(x==6 || x==7 || x==8)
		*/
	}
}
