package presentation.tool;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SaveLabel extends JLabel{
	public SaveLabel(int x,int y){
		setBounds(x,y,40,40);
		setIcon(new ImageIcon("image\\save1.png"));
	}
}
