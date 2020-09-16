package presentation.tool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import presentation.mainframe.MainFrame;

public class ExitLabel extends JLabel{
	public ExitLabel(){
		setBounds(250,0,50,50);
		setIcon(new ImageIcon("image\\exitbt1.png"));
		addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setIcon(new ImageIcon("image\\exitbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				setIcon(new ImageIcon("image\\exitbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
	};
			
}
