/*
包在文件系统中对应的就是文件夹。
作用：
1，对类进行分类管理。
2，对类提供了多层命名空间。

好处：将运行文件class，与源文件java相分离。


包在程序中的体现，通过package关键字来定义。
*/


/*


访问另一个包packa中的DemoA类。



第一个提示：
PackageDemo.java:24: 找不到符号
符号： 类 DemoA
位置： 类 mypack.PackageDemo
                DemoA d = new DemoA();
                ^
PackageDemo.java:24: 找不到符号
符号： 类 DemoA
位置： 类 mypack.PackageDemo
                DemoA d = new DemoA();
                              ^
2 错误

原因：被调用的DemoA类的类名写错，因为是包名.类名。packa.DemoA

--------------------------------------

第二个提示：
PackageDemo.java:38: 软件包 packa 不存在
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:38: 软件包 packa 不存在
                packa.DemoA d = new packa.DemoA();
                                         ^
2 错误

原因：
包packa并不在当前目录下，需要指定classpath，让jvm去指定路径下找packa包。
F:\java40\day09>set classpath=c:\myclass

--------------------------------------
第三个提示：
PackageDemo.java:52: packa.DemoA 在 packa 中不是公共的；无法从外部软件包中对其进
行访问
                packa.DemoA d = new packa.DemoA();
                     ^
PackageDemo.java:52: packa.DemoA 在 packa 中不是公共的；无法从外部软件包中对其进
行访问
                packa.DemoA d = new packa.DemoA();
                                         ^
2 错误

原因：类要在包以外被访问，必须public修饰，要权限足够大。


--------------------------------------
第四个提示：
PackageDemo.java:53: show() 在 packa.DemoA 中不是公共的；无法从外部软件包中对其
进行访问
                d.show();
                 ^
1 错误

被访问的类中的成员，只有公有才可以被访问。


*/



package mypack;

import packa.*;
import packa.haha.*;//导入子包中的类。


/*
packa
	|-DemoA.class
	|-haha
		|-ZZ.class
*/

class  PackageDemo
{
	public static void main(String[] args) 
	{
		DemoA d = new DemoA();
		d.show();
		ZZ z = new ZZ();
		//System.out.println("Hello package!");

		//packb.DemoB d1 = new packb.DemoB();
		//d1.func();
	}
}


