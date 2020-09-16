package presentation.mainframe;

import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.OpStockUI.OpStockUI;
import presentation.initpanel.initPanel;
import presentation.marketui.MarketUI;
import presentation.tool.SetUI;

public class MainFrame {

	static Point origin1 = new Point();
	static Point origin2 = new Point();
	private static JFrame mainframe = new JFrame();
	private static JFrame subframe = new JFrame();
	private static JPanel imagePanel;  
	private static ImageIcon background; 

	private static initPanel initpanel; 
	private static OpStockUI opstockui;
	private static MarketUI marketui;
	public MainFrame(){
		initpanel = new initPanel();
		opstockui = new OpStockUI();
		marketui = new MarketUI();
	  mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  subframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  
	  mainframe.setBounds(150, 10,300, 700);;
	  subframe.setBounds(450, 10,700,700);

	  mainframe.add(initpanel);
	  mainframe.add(opstockui);
	  mainframe.add(marketui);
	  subframe.setContentPane(new SetUI());
	  
	  mainframe.setUndecorated(true);
	  subframe.setUndecorated(true);
	  mainframe.addMouseListener(new MouseAdapter() {  
			public void mousePressed(MouseEvent e) {  
			origin1.x = e.getX(); 
			origin1.y = e.getY();                         }                 });   
	  subframe.addMouseListener(new MouseAdapter() {  
			public void mousePressed(MouseEvent e) {  
			origin2.x = e.getX(); 
			origin2.y = e.getY();                         }                 }); 
	  mainframe.addMouseMotionListener(new MouseMotionAdapter() {        
			public void mouseDragged(MouseEvent e) {  
			Point p = mainframe.getLocation();  
			Point q = subframe.getLocation();
			mainframe.setLocation(p.x + e.getX() - origin1.x, p.y + e.getY() - origin1.y);
			subframe.setLocation(q.x + e.getX() - origin1.x, q.y + e.getY() - origin1.y);}          
			}); 
	  subframe.addMouseMotionListener(new MouseMotionAdapter() {        
			public void mouseDragged(MouseEvent e) {  
			Point p = mainframe.getLocation();  
			Point q = subframe.getLocation();
			mainframe.setLocation(p.x + e.getX() - origin2.x, p.y + e.getY() - origin2.y);
			subframe.setLocation(q.x + e.getX() - origin2.x, q.y + e.getY() - origin2.y);}          
			}); 
	  	
	  setBackground(mainframe,"image/background3.jpg");
	  setBackground(subframe,"image/subbackground3.jpg");
	  
	  
	 
	  mainframe.setVisible(true);
	  subframe.setVisible(false);
	}
	
	public static JFrame getmainframe(){
		return mainframe;
	}
	public static JFrame getsubframe(){
		return subframe;
	}
	public static void setBackground(JFrame frame,String str){
		  background = new ImageIcon(str); 
			JLabel label = new JLabel(background); 

			label.setBounds(0, 0, background.getIconWidth(),  
			background.getIconHeight());   
			imagePanel = (JPanel) frame.getContentPane();  
			imagePanel.setOpaque(false);  
			frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));   
			frame.setSize(background.getIconWidth(), background.getIconHeight()); 
	}
	
	public static void setInitPanel(boolean a){
		if(a){
			initpanel.setVisible(true);
		}
		else{
			initpanel.setVisible(false);
		}
		
	}
	
	public static void setOpStockUI(boolean a){
		if(a){
			opstockui.setVisible(true);
		}
		else{
			opstockui.setVisible(false);
		}
		
	}
	
	public static void setMarketUI(boolean a){
		if(a){
			marketui.setVisible(true);
		}
		else{
			marketui.setVisible(false);
		}
		
	}
//	public static void setMainPanel(JPanel panel){
//		mainframe.dispose();
//		mainframe = new JFrame();
//		mainframe.setLocation(150, 80);
//		mainframe.setContentPane(panel);
//		mainframe.addMouseListener(new MouseAdapter() {  
//			public void mousePressed(MouseEvent e) {  
//			origin1.x = e.getX(); 
//			origin1.y = e.getY();                         }                 }); 
//		mainframe.addMouseMotionListener(new MouseMotionAdapter() {        
//			public void mouseDragged(MouseEvent e) {  
//			Point p = mainframe.getLocation();  
//			Point q = subframe.getLocation();
//			mainframe.setLocation(p.x + e.getX() - origin1.x, p.y + e.getY() - origin1.y);
//			subframe.setLocation(q.x + e.getX() - origin1.x, q.y + e.getY() - origin1.y);}          
//			}); 
//		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBackground(mainframe,"image/background.jpg");
//		mainframe.setResizable(false);  
//		mainframe.setUndecorated(true);
//		mainframe.setVisible(true);
//	}
//	
//	public static void setSubPanel(JPanel panel){
//		subframe.dispose();
//		subframe = new JFrame();
//		subframe.setLocation(902, 200);
//		subframe.setContentPane(panel);
//		subframe.addMouseListener(new MouseAdapter() {  
//			public void mousePressed(MouseEvent e) {  
//			origin2.x = e.getX(); 
//			origin2.y = e.getY();                         }                 }); 
//		subframe.addMouseMotionListener(new MouseMotionAdapter() {        
//			public void mouseDragged(MouseEvent e) {  
//			Point p = mainframe.getLocation();  
//			Point q = subframe.getLocation();
//			mainframe.setLocation(p.x + e.getX() - origin2.x, p.y + e.getY() - origin2.y);
//			subframe.setLocation(q.x + e.getX() - origin2.x, q.y + e.getY() - origin2.y);}          
//			}); 
//		setBackground(subframe,"image/loginui.jpg");
//		subframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		subframe.setResizable(false);  
//		subframe.setUndecorated(true);
//		subframe.setVisible(true);
//	}
}
