//我去家乐福买冰箱。名次提炼法对事物进行描述，并封装对象。

class Person
{
	String name;
	public Item shopping(SuperMarket sm,String name)
	{
		return sm.sale(name);
	}

}
class SuperMarket
{
	String name;
	
	public Item sale(String name)
	{
		return new Item(name);
	}

}

class Item
{
	String name;
	Itme(String name)
	{
		this.name = name;
	}
}


class  BingXiang
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
