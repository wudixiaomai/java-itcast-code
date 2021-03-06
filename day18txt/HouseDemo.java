/*
房子：平房，楼房。

House
	|--PingFang
	|--LouFang


准备对房子进行装修。

	1，对平房进行田园风光式的打造。
	2，对楼房进行欧式风格的打造。
可以用继承的方式来完成。
House
	|--PingFang
		|--TianYuanPingFang
	|--LouFang
		|--OuShiLouFang

	
该体系就有点臃肿，因为当平房想要改成欧式时，还要建立子类。

准备优化一下该体系。
请看下集。
HouseDemo2.java

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

class TianYuanPingFang extends PingFang
{
	public void showTianYuan()
	{
		super.show();
		System.out.println("田园风格");
	}
}

class LouFang extends House
{
	public void show()
	{
		System.out.println("楼房");
	}
}
class OuShiLouFang extends LouFang
{
	public void showOuShi()
	{
		super.show();
		System.out.println("欧式风格");
	}
}



class  HouseDemo
{
	public static void main(String[] args) 
	{
		PingFang p = new PingFang();
		///p.show();

		TianYuanPingFang t = new TianYuanPingFang();
		t.showTianYuan();


		LouFang l = new LouFang();
		//l.show();
		OuShiLouFang o = new OuShiLouFang();
		o.showOuShi();
	}
}
