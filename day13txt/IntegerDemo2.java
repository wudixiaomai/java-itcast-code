/*
JDK1.5版本出现的新特性。
自动装箱拆箱。


*/
class  IntegerDemo2
{
	public static void main(String[] args) 
	{
		//Integer i = new Integer(4);

		//Integer a = null;//Integer a = new Integer(4);//自动装箱。
		
		//a = a + 3; //自动拆箱。a.intValue() + 3;


		//当使用自动装箱时，如果数组在byte范围内，就不会开辟新的空间。
		Integer x = 127;
		Integer y = 127;
		Integer a = new Integer(127);
		Integer b = new Integer(127);
		System.outl.println(a==b);//false
		System.out.println(x==y);//true; 特殊。
		System.out.println(x.equals(y));//true

	}
}

