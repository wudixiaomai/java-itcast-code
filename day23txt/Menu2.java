import java.awt.*;
import java.awt.event.*;

/*
演示一下菜单，以及子菜单.
*/
class  Menu2
{

	private Frame f;
	private MenuBar mb;
	private Menu fileMenu;
	private MenuItem openItem,saveItem,closeItem;

	private TextArea ta;

	private FileDialog openDia;

	Menu2()
	{
		init();
	}

	public void init()
	{
		f = new Frame("my window");

		f.setBounds(300,100,600,500);

		mb = new MenuBar();

		fileMenu = new Menu("文件");
		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		closeItem = new MenuItem("退出");

		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(closeItem);
		mb.add(fileMenu);

		f.setMenuBar(mb);

		ta = new TextArea();
		f.add(ta);

		openDia = new FileDialog(f,"我的打开对话框");

		myEvent();

		f.setVisible(true);


	}

	public void myEvent()
	{
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				openDia.setVisible(true);
			}
		});

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
		
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}	
		
		})

	public static void main(String[] args) 
	{
		new Menu2();
	}
}
