package presentation.tool;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class InfoLabel extends JLabel{
	public InfoLabel(int x,int y,String str){
		setBounds(x,y,210,60);
		switch(str){
		case"sender":setIcon(new ImageIcon("image\\senderinfo.png"));break;
		case"courier":setIcon(new ImageIcon("image\\courierinfo.png"));break;
		case"business":setIcon(new ImageIcon("image\\businessinfo.png"));break;
		case"transport":setIcon(new ImageIcon("image\\transportinfo.png"));break;
		case"financial":setIcon(new ImageIcon("image\\financialinfo.png"));break;
		case"storage":setIcon(new ImageIcon("image\\storageinfo.png"));break;
		case"manager":setIcon(new ImageIcon("image\\managerinfo.png"));break;
		case"admin":setIcon(new ImageIcon("image\\admininfo.png"));break;
		}
		
	}
}
