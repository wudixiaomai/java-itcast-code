/*
BuffereReader的出现是为了提高Reader的效率。
将read方法进行了增强。

其实这里就用到了一种设计模式：装饰设计模式。

对已有的对象的功能进行增强。



装饰和继承有什么区别呢？


Writer	
	|--FileWriter
		|--BufferedFileWriter。
	|--DataWriter
		|--BufferedDataWriter。
	|--MediaWriter
		|--BufferedMediaWriter.


虽然有有了三个功能对象可以操作指定数据，但是效率有点低。
那么，这时就想要提高一下操作效率，想到了缓冲技术。

想要提高FileWriter对象效率。只需要建立一个FileWriter的子类对象。
并复写write方法。加入缓冲操作即可。

现在建立的继承体系已经可以进行使用。

但是一些小问题：发现每一个子类出现其实功能都是相同的。
只是给每一个对象加入缓冲技术。
这样的设计，会让体系变的很臃肿。

优化：
可以将缓冲技术单独抽取进行封装。
要缓冲区谁将谁和缓冲相关联即可。
这样的设计的相对体系会变的简单。
但是这样的设计没有扩展性。
如果Writer出现了新的子类。
那么还要在BufferedWriter中继续修改，添加一个新的构造函数。

BufferedWriter。

class BufferedWriter
{
	BufferedWriter(FileWriter fw)
	{
		
	}
	BufferedWriter(DataWriter fw)
	{
		
	}
	BufferedWriter(MediaWriter fw)
	{
		
	}
}


所以这时，可以利用多态的特性。
class BufferedWriter
{
	private Writer w;
	BufferedWrier(Writer w)
	{
		this.w = w;
	}
	public void write()
	{}
}

虽然起到了装饰作用，但是它还是具有功能体系中的功能。

那么BufferedWriter还是Writer中的一员。体系如下。

Writer
	|--FileWriter
	|--DataWriter
	|--MediaWriter
	|--BufferedWriter

这个体系相对精简很多，对原有体系进行优化，其实就是对子类对象的功能进行增强。
那么这个设计方式起个名字：装饰设计模式。


*/
class Person
{
	void chifan()
	{
		System.out.println("chifan");
	}
}

/*
为了不随便改变原有的代码。
还要增强chifan功能。
那么就定义一个类，对原有对象进行装饰。

*/
class NewPerson
{
	private Person p;
	NewPerson(Person p)
	{
		this.p = p;
	}
	public void newChifan()
	{
		System.out.println("来一杯");
		p.chifan();
		System.out.println("来两根");
	}
}




class  PersonDemo
{
	public static void main(String[] args) 
	{
		Person p = new Person();
		
		//NewPerson np = new NewPerson(p);
		//np.newChifan();

		p.chifan();
	}
}
