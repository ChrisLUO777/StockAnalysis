package presentation.tool;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CheckLabel extends JLabel{
	public CheckLabel(int x,int y){
	setBounds(x,y,50,50);
	
	setIcon(new ImageIcon("image\\check1.png"));
	}
}
