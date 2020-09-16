package presentation.initpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import businesslogic.GetOptionalStock;
import presentation.OpStockUI.OpStockUI;
import presentation.mainframe.MainFrame;
import presentation.marketui.MarketUI;
import presentation.tool.ExitLabel;
import presentation.tool.Mybutton;
import presentation.tool.SetLabel;

public class initPanel  extends JPanel{
	
	SetLabel seticon;
	ExitLabel exiticon;
	
	Mybutton logobt;
	
	Mybutton opstockbt;
	Mybutton marketbt;
	public initPanel(){
		setBounds(0,0,300,700);
		setLayout(null);
		
		logobt = new Mybutton("image\\logo2.png",0,100,300,149);
		logobt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				logobt.setIcon(new ImageIcon("image\\logo3.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				logobt.setIcon(new ImageIcon("image\\logo2.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(logobt);
		
		opstockbt = new Mybutton("image\\opstockbt1.png",50,340,200,60);
		opstockbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.setInitPanel(false);
				MainFrame.setOpStockUI(true);
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				opstockbt.setIcon(new ImageIcon("image\\opstockbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				opstockbt.setIcon(new ImageIcon("image\\opstockbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(opstockbt);
		
		marketbt = new Mybutton("image\\marketbt1.png",50,400,200,60);
		marketbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.setInitPanel(false);
				MainFrame.setMarketUI(true);
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				marketbt.setIcon(new ImageIcon("image\\marketbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				marketbt.setIcon(new ImageIcon("image\\marketbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(marketbt);
		
		seticon =new SetLabel();
		add(seticon);
		
		exiticon = new ExitLabel();
		add(exiticon);
		setOpaque(false); 
		setVisible(true);
	}

	

}
