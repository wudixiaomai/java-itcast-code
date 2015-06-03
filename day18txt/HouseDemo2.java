/*

原体系：
House
	|--PingFang
	|--LouFang
下集。

无论将平房打造成田园还是欧式，都是对平房一种装修。
而该装修也可以用楼房。

将现将该装修定义好，需要把什么房子进行改装修，传入即可。
House
	|--PingFang
	|--LouFang
	|--TianYuan
	|--OuShi
	
这就是使用了装饰设计模式的体系。

*/
abstract class House
{
	abstract void show();
}

class PingFang extends House
{
	public void show()
	{
		System.out.println("平房");
	}
}


class LouFang extends House
{
	public void show()
	{
		System.out.println("楼房");
	}
}


class TianYuan extends House
{

	private House h;
	TianYuan(House h)
	{
		this.h = h;
	}
	public void show()
	{
		System.out.println("田园风格");
	}

	public void showTianYuan()
	{
		h.show();
		this.show();
	}

}


class OuShi extends House
{
	private House h;
	OuShi(House h)
	{
		this.h = h;
	}
	public void show()
	{
		System.out.println("欧式风格");
	}

	public void showOuShi()
	{
		h.show();
		this.show();
	}

}

class  HouseDemo2
{
	public static void main(String[] args) 
	{
		PingFang p = new PingFang();
		LouFang l = new LouFang();

		OuShi o = new OuShi(new TianYuan(p));
		o.showOuShi();

		//TianYuan t = new TianYuan(l);
		//t.showTianYuan();

		//OuShi o = new OuShi(l);
		//o.showOuShi();

		
	}
}
