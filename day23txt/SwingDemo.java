import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class  SwingDemo
{
	public static void main(String[] args) 
	{
			
		JFrame f = new JFrame("my swing");

		f.setBounds(300,200,500,400);

		f.setLayout(new FlowLayout());

		JButton but = new JButton("my button");

		f.add(but);


		f.setVisible(true);
	}
}
