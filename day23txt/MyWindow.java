import java.awt.*;
import java.awt.event.*;
import java.io.*;
class  MyWindow
{

	private Frame f;
	private TextField tf;
	private Button but ;
	private TextArea ta;

	MyWindow()
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

		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();

		f.setVisible(true);

	}

	public void myEvent()
	{

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
		
		/*
		通过点击按钮，获取文本框中的目录。
		并将该目录下的文件或者文件夹名称显示文本区域中。
		*/
		
		//先清空文本区域中的数据。
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
			ta.setText("输入路径是非法的");



		/*
		//1,获取到文本框中的文本。
		String text = tf.getText();
		//2,将获取到的文本添加到文本区域中。				
		ta.append(text+"\r\n");

		//3,将文本框的内容清空。
		tf.setText("");
		*/

	}
	public static void main(String[] args) 
	{
		new MyWindow();
	}
}
