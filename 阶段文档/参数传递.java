class Demo 
{	
	public static void main(String[] args) 
	{
		int x = 4;
		show(x);
		System.out.println("x="+x);
	}
	public static void show(int x)
	{
		x = 5;
	}
}


class Demo
{
	int x = 4;
	public static void main(String[] args)
	{
		Demo d = new Demo();
		d.x = 8;
		show(d);//show(new Demo());
		System.out.println(d.x);
	}

	public static void show(Demo d)
	{
		d.x = 5;
	}
}