import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
class  MyBrowseGUI
{

	private Frame f;
	private TextField tf;
	private Button but ;
	private TextArea ta;

	MyBrowseGUI()
	{
		init();
	}
	public void init()
	{
		f = new Frame("my browser");

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
		try
		{
			ta.setText("");

			String str_url = tf.getText();
			//将文本框中的字符串封装成url对象。
			URL url = new URL(str_url);
			
			//通过url对象获取url连接对象。
			URLConnection conn = url.openConnection();

			//通过连接对象获取读取流。
			BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = null;

			while((line=bufIn.readLine())!=null)
			{
				ta.append(line+"\r\n");
			}



		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public static void main(String[] args) 
	{
		new MyBrowseGUI();
	}
}
