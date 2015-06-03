class SuperPerson
{
	private int num;

	private static  SuperPerson s = new SuperPerson();

	public void setNum(int num)
	{
		this.num = num;
	}

	public int getNum()
	{
		return num;
	}

	private SuperPerson(){}

	public static SuperPerson getInstance()
	{
		return s;
	}
}

class  PersonDemo
{
	public static void main(String[] args) 
	{

		SuperPerson s1 = SuperPerson.getInstance();
		SuperPerson s2 = SuperPerson.getInstance();
		s2.setNum(5);
		s1.setNum(10);

		System.out.println(s1.getNum()+"..."+s2.getNum());
		/*
		SuperPerson s1 = new SuperPerson();
		s1.setNum(10);
		SuperPerson s2 = new SuperPerson();
		s2.setNum(5);

		System.out.println(s1.getNum()+"..."+s2.getNum());

		*/
		
	}
}



