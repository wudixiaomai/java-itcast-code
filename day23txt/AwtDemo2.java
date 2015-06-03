import java.awt.*;
import java.awt.event.*;

/*
演示一下鼠标和键盘监听。	
*/
class  AwtDemo2
{
	private Frame f;
	private Button but;

	private TextField tf;//文本框
	
	AwtDemo2()
	{
		init();
	}

	public void init()
	{
		f = new Frame("my frame");

		f.setBounds(300,200,500,400);

		f.setLayout(new FlowLayout());


		tf = new TextField(30);
		but = new Button("my button");

		
		f.add(tf);
		f.add(but);

		myEvent();

		f.setVisible(true);


	}

	public void myEvent()
	{
		
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				/*
				if(e.getKeyCode()==KeyEvent.VK_A)
				{
					System.out.println("不许按A键。");
					e.consume();
				}
				*/
				int code = e.getKeyCode();

				if(!(code>=KeyEvent.VK_0&& code<=KeyEvent.VK_9))
				{
					System.out.println("你输入非法字符");
					e.consume();
				}
			}


		});



		but.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				//System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"::"+e.getKeyCode());
				
				if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					System.out.println("ctrl+enter 被按下了");
				}
				
				/*
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					System.out.println("程序退出");
					System.exit(0);
				}
				*/

			}
		});

		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//这时按钮的活动监听，只要按钮被触发就执行，按钮被触发有两种情况，1，鼠标点击，2，键盘。
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("action run");
			}
		});

		but.addMouseListener(new MouseAdapter()
		{
			private int count = 1;
			
			public void mouseEntered(MouseEvent e)
			{
				System.out.println("enter "+count++);
			}

			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
					System.out.println("mouse double click"+count++);
			}
		});

	}

	public static void main(String[] args) 
	{
		new AwtDemo2();
	}
}
