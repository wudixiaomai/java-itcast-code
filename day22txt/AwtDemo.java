/*
awt:
*/
import java.awt.*;

import java.awt.event.*;

class  AwtDemo
{
	public static void main(String[] args) 
	{
		//1，定义窗体。
		final Frame f = new Frame("my frame");
		
		//f.setSize(500,400);
		//f.setLocation(300,200);
		//2,对窗体进行设置。
		f.setBounds(300,200,500,400);

		f.setLayout(new FlowLayout());


		//3，定义一些窗体内部组件。
		//给窗体添加一个按钮。
		Button but = new Button("my button");


		//4，将这些组件通过add方法。添加到窗体中。
		f.add(but);

		//给窗体添加了一个关闭事件。
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("adapter closing：：："+e);
				System.exit(0);
			}
		});
		

		//给按钮添加一个事件。
		but.addActionListener(new ActionListener()
		{
			private int count = 1;
			public void actionPerformed(ActionEvent e)
			{
				//System.out.println("按钮:"+e);

				f.add(new Button("new Button-"+count++));
				
				//f.setVisible(true);
				f.validate();
			}
		});



		//5,让创建显示。
		f.setVisible(true);


		

	}
}

/*

class My extends MyWindow
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}




class MyWindow implements WindowListener
{
	public void windowActivated(WindowEvent e) 
	{
//		System.out.println("windowActivated");
	}
//          将 Window 设置为活动 Window 时调用。 
 public void windowClosed(WindowEvent e) 
	 {
//		System.out.println("windowClosed");
		
	}
//          因对窗口调用 dispose 而将其关闭时调用。 
public  void windowClosing(WindowEvent e)
	{
//		System.out.println("windowClosing");
//		System.exit(0);
	}
//          用户试图从窗口的系统菜单中关闭窗口时调用。 
 public void windowDeactivated(WindowEvent e) 
	 {
//		System.out.println("windowDeactivated");
	}
//          当 Window 不再是活动 Window 时调用。 
 public void windowDeiconified(WindowEvent e)
	 {
//		System.out.println("windowDeiconified");
	}
//          窗口从最小化状态变为正常状态时调用。 
 public void windowIconified(WindowEvent e) 
	 {
//		System.out.println("windowIconified");
	}
//          窗口从正常状态变为最小化状态时调用。 
 public void windowOpened(WindowEvent e) 
	 {
//		System.out.println("windowOpened");
	}
//          窗口首次变为可见时调用。 

}
*/