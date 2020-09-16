package presentation.OpStockUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;




import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import businesslogic.GetOptionalStock;
import businesslogic.GetStock;
import po.optionalStockPO;
import po.stockPO;
import presentation.initpanel.initPanel;
import presentation.mainframe.MainFrame;
import presentation.stockui.StockUI;
import presentation.tool.ExitLabel;
import presentation.tool.Mybutton;
import presentation.tool.SetLabel;

public class OpStockUI  extends JPanel{
	private JTable fileTable;
	Mybutton checkbt;
	Mybutton backbt;
	ExitLabel exiticon;
	Mybutton opstockbt;
	Mybutton marketbt;
	private JTextField stockidtext;
	
	public OpStockUI(){
		setBounds(0,0,300,700);
		setLayout(null);
		
		opstockbt = new Mybutton("image\\opstockbt1.png",50,0,200,60);
		opstockbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {

				
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
		
		marketbt = new Mybutton("image\\marketbt1.png",50,630,200,60);
		marketbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.setOpStockUI(false);
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
		
		backbt = new Mybutton("image\\backbt1.png",10,0,50,50);
		backbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.setOpStockUI(false);
				MainFrame.setInitPanel(true);
//				MainFrame.setBackground(MainFrame.getsubframe(), "image/background.jpg");
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				backbt.setIcon(new ImageIcon("image\\backbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				backbt.setIcon(new ImageIcon("image\\backbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(backbt);	
			
		
		
		
		checkbt = new Mybutton("image\\check3.png",210,110,30,30);
		checkbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				MainFrame.setSubPanel(new initPanel());
				
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				checkbt.setIcon(new ImageIcon("image\\check4.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				checkbt.setIcon(new ImageIcon("image\\check3.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				String stockid = stockidtext.getText().trim();
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(checkbt);
		

		
		exiticon = new ExitLabel();
		add(exiticon);
	
		stockidtext = new JTextField();
		stockidtext.setBounds(65, 115, 140, 20);
		add(stockidtext);


		ArrayList<stockPO> stockPOs = new ArrayList<stockPO>() ;
		GetStock getstock = new GetStock();
		
		String str = "sz000036";
		stockPO a = getstock.getStock(str);
		a.setId(str);
		String str1 = "sz000100";
		stockPO b = getstock.getStock(str1);
		b.setId(str1);
		String str2 = "sh600016";
		stockPO c = getstock.getStock(str2);
		c.setId(str2);
		
		stockPOs.add(a);
		stockPOs.add(b);
		stockPOs.add(c);


		
		
		
		init(stockPOs);	
		
		
		
		
		
		
		
		
		setOpaque(false); 
		setVisible(false);
	}
	
	private void init(ArrayList<stockPO> stockPOs) {
		JScrollPane scrollPane = new JScrollPane(initTable(stockPOs)); 

		scrollPane.getViewport().setOpaque(false);  
	    scrollPane.setOpaque(false); 
	
	    scrollPane.setViewportView(fileTable);  
	    scrollPane.setColumnHeaderView(fileTable.getTableHeader()); 
	    scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,170,300,350);
		add(scrollPane);
	}
	
		
	 private JTable initTable(ArrayList<stockPO> stockPOs)  
	    {  
	    	 String[] tableHeads = new String[]{"股票代码","开盘价","收盘价"};
	    		DefaultTableModel tableModel = new DefaultTableModel(){
	    			  public boolean isCellEditable(int row,int column){    
	    		            return false;
	    		        } 
	    		};
	    		
	    		tableModel.setColumnIdentifiers(tableHeads);
	    		for(int i = 0;i<stockPOs.size();i++){
	    			Vector v = new Vector();
	    			v.add(stockPOs.get(i).getId());
	    			v.add(stockPOs.get(i).getOpenPrice());
	    			v.add(stockPOs.get(i).getClosePrice());
	    			tableModel.addRow(v);
	    		}
	        fileTable = new JTable(tableModel);  
	        fileTable.setRowHeight(25);   
	        fileTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);   
	        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   
	        fileTable.setIntercellSpacing(new Dimension(0,0)); 
	        fileTable.setRowSorter(new TableRowSorter(tableModel));
	         
	    
	        fileTable.addMouseListener(new MouseAdapter() {
	    		public void mouseClicked(MouseEvent e ){
	    			int rowl  = fileTable.rowAtPoint(e.getPoint());
	    			int column = fileTable.columnAtPoint(e.getPoint());
	    			if (rowl > -1&&column==0){
	    		        String stockName = (String) fileTable.getModel().getValueAt(rowl, 0);
	    		        System.out.println(stockName);
	    				ArrayList<optionalStockPO> stockPOs = new GetOptionalStock().getOptionalStock(stockName,30);
	    		        MainFrame.getsubframe().setContentPane(new StockUI(stockPOs));
	    		        MainFrame.getsubframe().setVisible(true);
	    			}

	    		}
	    		
	    	});
	        //fileTable.setPreferredScrollableViewportSize(new Dimension(500,200));
	        fileTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//	        for (int i=0;i<7;i++){
//	        	TableColumn column=fileTable.getColumnModel().getColumn(i);
//	          if ((i%1)==0) column.setPreferredWidth(70);
//	          else column.setPreferredWidth(70);
//	        }
	        fileTable.setOpaque(false);  
	        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
	        render.setOpaque(false);
	        fileTable.setDefaultRenderer(Object.class,render);  
	         
	        JTableHeader header = fileTable.getTableHeader();   
	        header.setPreferredSize(new Dimension(30, 26));   
	        header.setOpaque(false);
	        header.getTable().setOpaque(false); 
	       
	        header.setDefaultRenderer(new HeaderCellRenderer());  
	        TableCellRenderer headerRenderer = header.getDefaultRenderer();   
	        if (headerRenderer instanceof JLabel)   
	        {  
	            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
	            ((JLabel) headerRenderer).setOpaque(false);   
	        }
			return fileTable;
	    }  
	        
	    class HeaderCellRenderer extends DefaultTableCellRenderer  
	    {  
	        private static final long serialVersionUID = 1L;  
	          
	        public Component getTableCellRendererComponent(JTable table, Object value,   
	                boolean isSelected, boolean hasFocus, int row, int column)  
	        {  
	            JLabel label = new JLabel()  
	            {  
	                private static final long serialVersionUID = 1L;  
	      
	                protected void paintComponent(Graphics g)  
	                 {  
	                    Graphics2D g2d = (Graphics2D) g;  
	                    g2d.setColor(Color.gray);  
	                    g2d.drawLine(0, 0, this.getWidth(), 0);  
	                    g2d.drawLine(0, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1);  
	                    g2d.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1, this.getHeight() - 1);    
	                    super.paintComponent(g);  
	                 }  
	             };  
	             label.setText(value != null ? value.toString() : "unknown");   
	             label.setHorizontalAlignment(JLabel.CENTER);  
	             return label;   
	        }  
	    }  



	
}
