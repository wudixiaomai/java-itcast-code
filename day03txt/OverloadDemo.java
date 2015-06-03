/*
什么时候定义重载呢？
当函数的功能是一致，但是参数列表是不一致的。
这是函数名可以定义同一个名称，增强阅读性，方便调用。

*/

class  OverloadDemo
{
	public static void main(String[] args) 
	{
		
	}
	public static void isPrint99(int num)
	{
		if(num<=0)
		{
			System.out.println("非法数据");
			return ;
		}
		
		print99(num);
	}


	public static void print99(int num)
	{
		
		for(int x=1;x<=num; x++)
		{
			for(int y=1; y<=x; y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}

	public static void print99()
	{
		print99(9);
	}



	public static int add(int a,int b)
	{
		return a+b;
	}
	public static int add(int a,int b,int c)
	{
		return a+b+c;
	}
}


/*

void show(float a,char b,int c)
{}

a
void show(char b,float a, int c)

b
int show(float x,char y,int z)
{}

c
void show(float x,char y,int z)

d
void show(char a,int b)

e
int show()
*/
