/*
用switch语句完成四季程序的编写。
*/

class  SwitchTest
{
	public static void main(String[] args) 
	{
		int x = 3;

		switch(x)
		{
			case 3:
			case 4:
			case 5:
				System.out.println(x+"月份是春天");
			break;
			case 6:
			case 7:
			case 8:
				System.out.println(x+"月份是夏天");
			break;
			case 9:
			case 10:
			case 11:
				System.out.println(x+"月份是秋天");
			break;
			case 12:
			case 1:
			case 2:
				System.out.println(x+"月份是冬天");
			break;
			default:
				System.out.println(x+"月份不存在");
		}
	}
}
