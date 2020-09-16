package rmi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ip.IP;

public class ServerUI extends JPanel implements ActionListener{
	private JLabel titlelb1;
	private JLabel titlelb2;
	private JLabel iplb;
	private JButton startbt;
	private JButton stopbt;
	private JTextField iptext;
	
	public ServerUI(){
		setBounds(420,50,412,550);
		setLayout(null);	
		
		titlelb1= new JLabel("Stock");
		titlelb1.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb1.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb1.setBounds(0, 50, 400, 80);
		add(titlelb1);
		
		titlelb2= new JLabel("System");
		titlelb2.setFont(new Font("幼圆", Font.BOLD, 70));
		titlelb2.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb2.setBounds(0, 150, 400, 80);
		add(titlelb2);
		
		iplb= new JLabel("IP");
		iplb.setFont(new Font("幼圆", Font.BOLD, 40));
		iplb.setHorizontalAlignment(SwingConstants.CENTER);
		iplb.setBounds(40, 285, 100, 40);
		add(iplb);
		
		iptext = new JTextField(IP.ip);
		iptext.setBounds(150, 285, 200, 40);
		add(iptext);
		
		startbt = new JButton("Start");
		startbt.setFont(new Font("幼圆", Font.BOLD, 20));
		startbt.setHorizontalAlignment(SwingConstants.CENTER);
		startbt.setBounds(25, 350, 350, 66);
		startbt.setFocusPainted(false);
		add(startbt);
		startbt.addActionListener(this);
		
		stopbt = new JButton("Stop");
		stopbt.setFont(new Font("幼圆", Font.BOLD, 20));
		stopbt.setHorizontalAlignment(SwingConstants.CENTER);
		stopbt.setBounds(25, 430, 350, 66);
		stopbt.setFocusPainted(false);
		add(stopbt);
		stopbt.addActionListener(this);
		
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startbt){
			IP.ip = iptext.getText().trim();
			RMIServer.startserver();
			startbt.setText("running...");
		}
		else if(e.getSource() == stopbt){
			System.exit(0);
		}
	}

}
