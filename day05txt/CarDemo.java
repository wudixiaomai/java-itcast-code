class Car
{
	int luntai = 4;
	String color = "red";
	public void run()
	{

		System.out.println(luntai+"...."+color);
	}
}



class CarDemo
{
	public static void main(String[] args) 
	{
		//数据类型 变量名＝　初始化值；

		Car c1 = new Car();//类类型变量一定指向对象。
		//c1.color = "blue";//对象名.对象成员。
		//c1.run();

		Car c2 = new Car();
		//c2.color = "bule";
		//c.run();


		show(c1);
		show(c2);


		new Car();//匿名对象。其实就是对象的一种简写形式。
		/*
		1，当对方法进行一次调用的时候可以使用匿名对象。
		2，匿名对象可以作为实际参数进行传递。
		*/
//		Car c = new Car();
//		c.run();
//		c.luntai = 3;
//		c.run();
//
//		new Car().luntai = 6;
//		new Car().run();
//		new Car().run();

		//Car c1 = new Car();
		show(new Car());

	}
	public static void show(Car c)//Car c = c1;//Car c = new Car();
	{
		c.luntai = 3;
		c.color = "black";
		c.run();
	}
}

