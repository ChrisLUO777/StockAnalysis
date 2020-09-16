package presentation.tool;

import ip.IP;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



import presentation.mainframe.MainFrame;



public class SetUI extends JPanel implements ActionListener{
	private JLabel titlelb;
	private JLabel ordlistlb;
	private JTextField iptext;
	private JButton checkbt;

	private JButton backbt;
	
	public SetUI(){
		setBounds(0,0,MainFrame.getsubframe().getWidth(),MainFrame.getsubframe().getHeight());
		setLayout(null);
		
		
		titlelb= new JLabel("IP");
		titlelb.setFont(new Font("幼圆", Font.BOLD, 30));
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(MainFrame.getsubframe().getWidth()/3, 0, MainFrame.getsubframe().getWidth()/3, MainFrame.getsubframe().getHeight()/4);
		add(titlelb);
		
		iptext = new JTextField(IP.ip);
		iptext.setBounds(MainFrame.getsubframe().getWidth()/3, MainFrame.getsubframe().getHeight()/4, MainFrame.getsubframe().getWidth()/3, MainFrame.getsubframe().getHeight()/8);
		add(iptext);
		
		checkbt = new JButton("连接");
		checkbt.setFont(new Font("幼圆", Font.BOLD, 20));
		checkbt.setHorizontalAlignment(SwingConstants.CENTER);
		checkbt.setBounds(MainFrame.getsubframe().getWidth()/3, MainFrame.getsubframe().getHeight()/8*3, MainFrame.getsubframe().getWidth()/3, MainFrame.getsubframe().getHeight()/8);
		checkbt.setFocusPainted(false);
		add(checkbt);
		checkbt.addActionListener(this);
		
	
	
		backbt = new JButton("返回");
		backbt.setFont(new Font("幼圆", Font.BOLD, 20));
		backbt.setHorizontalAlignment(SwingConstants.CENTER);
		backbt.setBounds(MainFrame.getsubframe().getWidth()/3, MainFrame.getsubframe().getHeight()/2, MainFrame.getsubframe().getWidth()/3, MainFrame.getsubframe().getHeight()/8);
		backbt.setFocusPainted(false);
		add(backbt);
		backbt.addActionListener(this);
		setOpaque(false); 
		setVisible(true);
	} 
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==checkbt){
			IP.ip = iptext.getText().trim();
		}

		else if(e.getSource()==backbt){
//			MainFrame.setContentPanel(new LoginUI());
		}
	}
}
