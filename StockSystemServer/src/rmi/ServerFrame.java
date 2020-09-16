package rmi;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ServerFrame {
	private static JFrame mainframe;
	private static JPanel contentpanel;
	private static JFrame memberframe;
	private ServerUI serverui;
	public ServerFrame(){
		serverui = new ServerUI();
		contentpanel = serverui;
		mainframe = new JFrame();
		mainframe.setTitle("");
		mainframe.setBounds(420,50,412,550);
		mainframe.setContentPane(contentpanel);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setVisible(true);
	}
	
	public static void setContentPanel(JPanel panel){
		mainframe.dispose();
		mainframe = new JFrame();
		contentpanel = panel;
		mainframe.setTitle("Express System");
		mainframe.setBounds(420,50,412,550);
		mainframe.setContentPane(contentpanel);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setVisible(true);
	}

}
