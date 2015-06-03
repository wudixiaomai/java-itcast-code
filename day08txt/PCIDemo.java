/*

电脑中有一个主板，
已经可以使用。

后期想要听音乐，装一个声卡。


如何进行描述：
描述主板。

想要使用后期出现的一些板卡，前期需要定义一个规则。
只要是符合了该规则的板卡，都可以被主板所使用。

PCI就是一个后期出现板卡可以被主板使用规则。
PCI的出现扩展了主板的功能。
PCI的出现降低了主板和其他功能板卡的藕合性。



*/

interface PCI
{
	void open();
	void close();
}
class MainBoard 
{
	void usePCI(PCI p)//PCI p = new SoundCard();
	{
		p.open();
		p.close();		
	}
	void run()
	{
		System.out.println("主板运行");
	}
}


class SoundCard  implements PCI
{
	public void open()
	{
		System.out.println("sound open");
	}
	public void close()
	{
		System.out.println("sound close");
	}
}


class NetCard implements PCI
{
	public void open()
	{
		System.out.println("net open");
	}
	public void close()
	{
		System.out.println("net close");
	}
}

class  PCIDemo
{
	public static void main(String[] args) 
	{
		MainBoard mb = new MainBoard();
		mb.run();
		mb.usePCI(new SoundCard());
		mb.usePCI(new NetCard());

	}
}
