import java.awt.*;
import java.awt.event.*;

/*
演示一下菜单，以及子菜单.
*/
class  MyMenu
{

	private Frame f;
	private MenuBar mb;
	private Menu fileMenu;
	private MenuItem closeItem;

	private Menu subMenu;

	private MenuItem it1,it2;

	MyMenu()
	{
		init();
	}

	public void init()
	{
		f = new Frame("my window");

		f.setBounds(300,100,600,500);

		mb = new MenuBar();

		fileMenu = new Menu("文件");

		closeItem = new MenuItem("退出");


		subMenu = new Menu("子菜单");

		it1 = new MenuItem("子项1");
		it2 = new MenuItem("子项2");

		subMenu.add(it1);
		subMenu.add(it2);

		fileMenu.add(subMenu);


		fileMenu.add(closeItem);
		mb.add(fileMenu);

		f.setMenuBar(mb);

		myEvent();

		f.setVisible(true);


	}

	public void myEvent()
	{

		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
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

	public static void main(String[] args) 
	{
		new MyMenu();
	}
}
