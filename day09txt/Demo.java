class Fu
{
	int num = 4;
}
class Zi extends Fu
{
	int num = 6;
}


class  Demo
{
	public static void main(String[] args) 
	{
		Fu f = new Zi();
		System.out.println(f.num);

		Zi z = new Zi();
		System.out.println(z.num);
	}
}
