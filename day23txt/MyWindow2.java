package mywin;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
class  MyWindow2
{

	private Frame f;
	private TextField tf;
	private Button but,okBut;
	private TextArea ta;
	private Dialog d;

	private Label lab;

	MyWindow2()
	{
		init();
	}
	public void init()
	{
		f = new Frame("my window");

		f.setBounds(300,100,600,500);

		f.setLayout(new FlowLayout());

		tf = new TextField(60);

		but = new Button("转  到");

		ta = new TextArea(24,70);


		d = new Dialog(f,"错误提示",false);
		d.setBounds(400,200,200,150);
		d.setLayout(new FlowLayout());

		d.setResizable(false);


		lab = new Label();
		okBut = new Button("确  定");

		d.add(lab);
		d.add(okBut);

		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();

		f.setVisible(true);

	}

	public void myEvent()
	{


		//给对话框添加关闭动作。
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
		});

		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);

			}
		});


		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{

				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					showDir();
			}
		});

		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showDir();

			}
		});


		//关闭窗体。结束程序。
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}


	public void showDir()
	{
		
		ta.setText("");

		//1.获取文本框中的目录。并封装成file对象。
		String str_dir = tf.getText();
		File dir = new File(str_dir);

		if(dir.exists() && dir.isDirectory())
		{
			String[] names = dir.list();

			for(String name : names)
			{
				ta.append(name+"\r\n");
			}
		}
		else
		{

			String str = "找不到"+str_dir+",请确认路径是否正确";
			lab.setText(str);
			d.setVisible(true);
		}

	}
	public static void main(String[] args) 
	{
		new MyWindow2();
	}
}
/*


1,建立jar所需的配置信息。定义一个文件。
	在文件定义内容：
	Main-Class:空格包名.类名回车

	如果没有写空格：会在打jar包时，发生IOException。
	如果没有在结尾处回车：配置不会写入配置文件中。


2，打jar包。
	jar -cvfm haha.jar 配置文件名 要存储jar包的文件夹名


3，验证：
	通过winrar查看一下啊jar中的配置文件中是否有自定义的信息。

4，工具菜单--文件夹选项---文件类型---给jar扩展名的文件指定关联程序为 jdk\bin\javaw.exe  -jar

5，双击即可执行。



*/