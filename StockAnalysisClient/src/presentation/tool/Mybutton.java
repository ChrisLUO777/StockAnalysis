package presentation.tool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mybutton extends JLabel{
	public Mybutton(String icon,int a,int b,int c,int d){
		setBounds(a,b,c,d);
		setIcon(new ImageIcon(icon));

	}
}
