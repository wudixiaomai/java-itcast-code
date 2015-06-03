/*
·ºÐÍ½Ó¿Ú¡£
*/

interface Inter<T>
{
	void show(T t);
}

class InterImpl<T> implements Inter<T>
{
	public void show(T t)
	{
		System.out.println("show::"+t);
	}
}

/*
class InterImpl implements Inter<String>
{
	public void show(String s)
	{
		System.out.println("show:"+s);
	}
}
*/

class  GenericDemo06
{
	public static void main(String[] args) 
	{
		InterImpl<Integer> i = new InterImpl<Integer>();
		i.show(123);

		//InterImpl i = new InterImpl();
		//i.show("hah");
	}
}
