package presentation.stockui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import po.optionalStockPO;
import presentation.mainframe.MainFrame;
import presentation.tool.Mybutton;

public class StockUI extends JPanel{
	static int columnNum = 0;
	private JTextField stockidtext;
	private JTable fileTable;
	private DefaultTableModel tableModel;
	
	Mybutton checkbt1;
	Mybutton checkbt2;
	Mybutton backbt;
	Mybutton closebt;
	public StockUI(ArrayList<optionalStockPO> stockPOs){
		setBounds(0,0,700,700);
		setLayout(null);
		closebt = new Mybutton("image\\exitbt1.png",650,0,50,50);
		closebt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {

				MainFrame.getsubframe().setVisible(false);
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				closebt.setIcon(new ImageIcon("image\\exitbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				closebt.setIcon(new ImageIcon("image\\exitbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(closebt);
		

		init(stockPOs);

		
		setOpaque(false); 
		setVisible(true);
	}

	private void init(ArrayList<optionalStockPO> stockPOs) {
		JScrollPane scrollPane = new JScrollPane(initTable(stockPOs)); 
		scrollPane.getViewport().setOpaque(false);  
	    scrollPane.setOpaque(false); 
	    scrollPane.setViewportView(fileTable);  
	    scrollPane.setColumnHeaderView(fileTable.getTableHeader()); 
	    scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,170,700,350);
		add(scrollPane);
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
	                    g2d.setColor(Color.red);  
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
	    private JTable initTable(ArrayList<optionalStockPO> stockPOs)  
	    {  
	    	 String[] tableHeads = new String[]{"日期","开盘价","最高价","收盘价","最低价","交易量（股）","交易金额（元）"};
	    		      tableModel = new DefaultTableModel(){
	    			  public boolean isCellEditable(int row,int column){    
	    		            return false;
	    		        } 
//	    			  @Override
//	    			  public Class getColumnClass(int column) {  
//	    	                Class returnValue;  
//	    	                if ((column >= 0) && (column < getColumnCount())) {  
//	    	                    returnValue = getValueAt(0, column).getClass();  
//	    	                } else {  
//	    	                    returnValue = Object.class;  
//	    	                }  
//	    	                return returnValue;  
//	    	            }  
	    		};
	    		
	    		tableModel.setColumnIdentifiers(tableHeads);
	    		for(int i = 0;i<stockPOs.size();i++){
	    			Vector v = new Vector();
	    			v.add(stockPOs.get(i).getDate());
	    			v.add(stockPOs.get(i).getOpenPrice());
	    			v.add(stockPOs.get(i).getHighestPrice());
	    			v.add(stockPOs.get(i).getClosePrice());
	    			v.add(stockPOs.get(i).getLowestPrice());
	    			v.add(stockPOs.get(i).getNum());
	    			v.add(stockPOs.get(i).getMoney());
	    			tableModel.addRow(v);
	    		}
	        fileTable = new JTable(tableModel);  
	        fileTable.setRowHeight(25);   
	        fileTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);   
	        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   
	        //fileTable.setIntercellSpacing(new Dimension(0,0)); 
	        //fileTable.setRowSorter(new TableRowSorter(tableModel));
	        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(  
	                tableModel);  
	        fileTable.setRowSorter(sorter); 
	    
	        fileTable.addMouseListener(new MouseAdapter() {
	    		public void mouseClicked(MouseEvent e ){
	    			int rowl  = fileTable.rowAtPoint(e.getPoint());
	    			int column = fileTable.columnAtPoint(e.getPoint());
	    			if (rowl >-1&&column==0){
	    		        String stockName = (String) fileTable.getModel().getValueAt(rowl, 0);
	    		        System.out.println(stockName);
	    			}
	    		}


});
	        fileTable.setPreferredScrollableViewportSize(new Dimension(500,200));
	        fileTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//	        for (int i=0;i<7;i++){
//	        	TableColumn column=fileTable.getColumnModel().getColumn(i);
//	          if ((i%1)==0) column.setPreferredWidth(70);
//	          else column.setPreferredWidth(70);
//	        }
	        final JTableHeader header = fileTable.getTableHeader();  
	        //表头增加监听  
	        header.addMouseListener (new MouseAdapter() {  
	                public void mouseReleased (MouseEvent e) {  
	                    if (! e.isShiftDown())  
	                        fileTable.clearSelection();  
	                    //获取点击的列索引  
	                    columnNum = header.columnAtPoint(e.getPoint());  
	                    //设置选择模型  
	                    fileTable.addColumnSelectionInterval (columnNum,columnNum);  
	                    System.out.println(columnNum);
	                }  
	            });  
	        
	        
	        
	        JTextField filterText = new JTextField("日期查询xxxx-xx-xx");
			add(filterText);
			filterText.setBounds(30,130,170,30);
		    JTextField text1 = new JTextField("MIN");
		    add(text1);
		    text1.setBounds(460,130,90,30);
		    JTextField text2 = new JTextField("MAX");
			add(text2);
			text2.setBounds(570,130,90,30);
			checkbt1 = new Mybutton("image\\check3.png",200,130,30,30);
			checkbt1.addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
		                String text = filterText.getText();  
		                if (text.length() == 0) {  
		                    sorter.setRowFilter(null);  
		                } else {
		                	 sorter.setRowFilter(RowFilter.regexFilter(text));
		                	 fileTable.setRowSorter(sorter);
		                	 System.out.println(text);
		                   }
		                	
					
				}
		
				@Override
				public void mouseEntered(MouseEvent arg0) {
					checkbt1.setIcon(new ImageIcon("image\\check4.png"));

					
				}
		
				@Override
				public void mouseExited(MouseEvent arg0) {
					checkbt1.setIcon(new ImageIcon("image\\check3.png"));
				
					
				}
		
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					
					
				}
		
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					
				}
		    	
		    });
			add(checkbt1);
			
			checkbt2 = new Mybutton("image\\check3.png",660,130,30,30);
			checkbt2.addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
	                String txt1 = text1.getText();
	                String txt2 = text2.getText();
	                //System.out.println(columnNum);
	                if(columnNum!=0){
	                if (txt1.length() == 0&&txt2.length()==0) {  
	                    System.out.println("error");  
	                } 
	                else {
	                	if(txt1.length()!=0&&txt2.length()!=0){
	                	double t1 =Double.parseDouble(txt1);
	                	double t2 =Double.parseDouble(txt2);
	                	
	                		RowFilter<DefaultTableModel,Integer> filter = new RowFilter<DefaultTableModel,Integer>() {
	                			public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
	                				String index = entry.getStringValue(columnNum);
	                				Double a = Double.valueOf(index); 
	                			if (a>=t1&&a<=t2) {
	                			// The value starts with "a", include it
	                			return true;
	                			       }
	                			     
	                			// None of the columns start with "a"; return false so that this
	                			// entry is not shown
	                			return false;
	                			   }
	                			 };
	                	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
	                		sorter.setRowFilter(filter);
	                		fileTable.setRowSorter(sorter);
	                		System.out.println(columnNum);
	                	}
	                	
	                		 }
	                if(txt1.length()==0&&txt2.length()!=0){
	                	//double t1 =Double.parseDouble(txt1);
	                	double t2 =Double.parseDouble(txt2);
	                	
	                		RowFilter<DefaultTableModel,Integer> filter = new RowFilter<DefaultTableModel,Integer>() {
	                			public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
	                				String index = entry.getStringValue(columnNum);
	                				Double a = Double.valueOf(index); 
	                			if (a<=t2) {
	                			// The value starts with "a", include it
	                			return true;
	                			       }
	                			     
	                			// None of the columns start with "a"; return false so that this
	                			// entry is not shown
	                			return false;
	                			   }
	                			 };
	                	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
	                		sorter.setRowFilter(filter);
	                		fileTable.setRowSorter(sorter);
	                		System.out.println(columnNum);
	                	}
	                	
	                if(txt1.length()!=0&&txt2.length()==0){
	                	double t1 =Double.parseDouble(txt1);
	                	//double t2 =Double.parseDouble(txt2);
	                	
	                		RowFilter<DefaultTableModel,Integer> filter = new RowFilter<DefaultTableModel,Integer>() {
	                			public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
	                				String index = entry.getStringValue(columnNum);
	                				Double a = Double.valueOf(index); 
	                			if (a>=t1) {
	                			// The value starts with "a", include it
	                			return true;
	                			       }
	                			     
	                			// None of the columns start with "a"; return false so that this
	                			// entry is not shown
	                			return false;
	                			   }
	                			 };
	                	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
	                		sorter.setRowFilter(filter);
	                		fileTable.setRowSorter(sorter);
	                		System.out.println(columnNum);
	                	}
	                	
	                }
				}
		
				@Override
				public void mouseEntered(MouseEvent arg0) {
					checkbt2.setIcon(new ImageIcon("image\\check4.png"));

					
				}
		
				@Override
				public void mouseExited(MouseEvent arg0) {
					checkbt2.setIcon(new ImageIcon("image\\check3.png"));
				
					
				}
		
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					
					
				}
		
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					
				}
		    	
		    });
			add(checkbt2);
			
			
			
			backbt = new Mybutton("image\\backbt1.png",10,0,50,50);
			backbt.addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					fileTable.setRowSorter(null);
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
	        
	        
	        fileTable.setOpaque(false);  
	        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
	        render.setOpaque(false);
	        fileTable.setDefaultRenderer(Object.class,render);  
	         
	        JTableHeader header1 = fileTable.getTableHeader();   
	        header1.setPreferredSize(new Dimension(30, 26));   
	        header1.setOpaque(false);
	        header1.getTable().setOpaque(false); 
	       
	        header1.setDefaultRenderer(new HeaderCellRenderer());  
	        TableCellRenderer headerRenderer = header1.getDefaultRenderer();   
	        if (headerRenderer instanceof JLabel)   
	        {  
	            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
	            ((JLabel) headerRenderer).setOpaque(false);   
	        }
			return fileTable;
	    }  
}
