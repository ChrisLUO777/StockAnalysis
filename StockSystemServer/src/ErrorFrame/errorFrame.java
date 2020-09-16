package ErrorFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class errorFrame extends JFrame{
	private static final errorFrame frame = new errorFrame();
	public static errorFrame getInstance(){
		
		return frame;
	}
	private errorFrame(){
		
		initialize();
	}
    public void initialize(){
    	this.setBounds(500,200, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawPanel());
        this.setTitle("错误页面");
        this.setVisible(true);
    }
    public static void main(String [] args){
    	errorFrame.getInstance();
    }
    class DrawPanel extends JPanel{
    	public void paint(Graphics g){
    		Shape rect;
			Font font;
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.CYAN);
			font = new Font("宋体",Font.ITALIC,30);
			g2.setColor(Color.BLUE);
			g2.setFont(font);
			g2.drawString("未连接到数据库",50,80);
			g2.drawString("请打开数据库",45,110);
			g2.drawString("或者检查ip设置",45,140);
    		
    	}
    }
}


