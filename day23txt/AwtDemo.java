import java.awt.*;
import java.awt.event.*;
class  AwtDemo
{
	private Frame f;
	private Button but,but1;
	
	AwtDemo()
	{
		init();
	}

	public void init()
	{
		f = new Frame("my frame");

		f.setBounds(300,200,100,200);

		f.setLayout(new FlowLayout());

		but = new Button("my button");
		but1 = new Button("腾讯QQ");

		f.add(but);
		f.add(but1);

		myEvent();

		f.setVisible(true);


	}

	public void myEvent()
	{
		//实现一个退出程序的动作。
		//也就完成窗体 × 按钮的动作处理。

		/*
		1，明确事件源。
		2，明确监听器。将监听器注册到事件源上，是通过事件源的addXXXListener();
		3，明确要处理的具体动作。
		4，将具体动作代码定义到具体动作函数中。
		*/

		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//给按钮添加一个处理动作,当按钮活动时，就在窗体中创建一个新的按钮。
		but.addActionListener(new ActionListener()
		{
			int count = 1;
			public void actionPerformed(ActionEvent e)
			{
//				System.out.println("new Button--"+count++);

				//f.add(new Button("new Button--"+count++));

//				f.setVisible(true);

				//通过事件对象，获取事件源。
//				System.out.println(e.getSource());
				Button b = (Button)e.getSource();

//				System.out.println(b.getParent());

				Frame f1 = (Frame)b.getParent();

				f1.add(new Button("new Button--"+count++));

				f.validate();



			}
		});
		

		but1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Runtime r  = Runtime.getRuntime();
					r.exec("C:\\Program Files\\Tencent\\QQ2009\\Bin\\QQ.exe");

				}
				catch (Exception ex)
				{
					System.out.println(ex.toString());
				}
				

			}
		});

	}

	public static void main(String[] args) 
	{
		new AwtDemo();
	}
}
