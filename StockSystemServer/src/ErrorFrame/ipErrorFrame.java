package ErrorFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ipErrorFrame extends JFrame{
	private static final ipErrorFrame frame = new ipErrorFrame();
	public static ipErrorFrame getInstance(){
		
		return frame;
	}
	private ipErrorFrame(){
		
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
    	ipErrorFrame.getInstance();
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
			g2.drawString("ip异常",50,80);
			g2.drawString("请检查ip设置",45,110);
    		
    	}
    }
}



