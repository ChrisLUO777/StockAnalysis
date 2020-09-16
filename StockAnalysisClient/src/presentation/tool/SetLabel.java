package presentation.tool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



import presentation.mainframe.MainFrame;
import presentation.stockui.StockUI;

public class SetLabel extends JLabel{

	private static int clicknum = 0;
		public SetLabel(){
			System.out.println(MainFrame.getmainframe().getHeight());
			setBounds(10,550,50,50);
			setIcon(new ImageIcon("image\\set1.png"));
			addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					clicknum++;
					if(clicknum%2==1){
	    		        MainFrame.getsubframe().setContentPane(new SetUI());
						MainFrame.getsubframe().setVisible(true);
						}
					else{
						MainFrame.getsubframe().setVisible(false);
					}
				}
		
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setIcon(new ImageIcon("image\\set2.png"));

					
				}
		
				@Override
				public void mouseExited(MouseEvent arg0) {
					setIcon(new ImageIcon("image\\set1.png"));
				
					
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
