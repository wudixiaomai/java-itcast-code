abstract class Person
{
	abstract void chifan();

}
class Chi
{
	void kaichi(Person p)//Person p = new Zhangsan();
	{
		p.chifan();
	}
}



class Zhangsan extends Person
{
	void chifan()
	{
		System.out.println("烤肉");
	}
}

class Lisi extends Person
{
	void chifan()
	{
		System.out.println("包子");
	}
}




/*
以前是指挥对象做事情。
那么对象多了以后，指挥每一个对象就编程复杂的事情，如何让复杂事情简单化呢？
找到这些对象的共性。只要指挥这个共性做事情就可以了。
*/

class  ChifanDemo
{
	public static void main(String[] args) 
	{

		Chi c = new Chi();
		c.kaichi(new Zhangsan());
		c.kaichi(new Lisi());
//		Zhangsan z = new Zhangsan();
//		z.chifan();
//		Lisi l = new Lisi();
//		l.chifan();
	}
}
