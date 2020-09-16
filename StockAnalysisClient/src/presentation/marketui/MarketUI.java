package presentation.marketui;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogic.GetBenchmark;
import po.benchmarkPO;
import po.stockPO;
import presentation.initpanel.initPanel;
import presentation.mainframe.MainFrame;
import presentation.stockui.StockUI;
import presentation.tool.ExitLabel;
import presentation.tool.Mybutton;
import presentation.tool.SetLabel;
import presentation.tool.SetUI;

public class MarketUI   extends JPanel{
	static int columnNum=0;
	Mybutton chartbt;
	Mybutton checkbt1;
	Mybutton checkbt2;
	Mybutton refreshbt;
	Mybutton backbt;
	Mybutton opstockbt;
	Mybutton marketbt;
	ExitLabel exiticon;
	private JTable fileTable;
	public MarketUI(){
		setBounds(0,0,300,700);
		setLayout(null);
		opstockbt = new Mybutton("image\\opstockbt1.png",50,0,200,60);
		opstockbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.setMarketUI(false);
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
		
		marketbt = new Mybutton("image\\marketbt1.png",50,60,200,60);
		marketbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {

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
				
				MainFrame.setMarketUI(false);
				MainFrame.setInitPanel(true);		
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
		
		
		chartbt = new Mybutton("image\\backbt1.png",10,50,50,50);
		chartbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {		
		        MainFrame.getsubframe().setContentPane(new MarketChartUI(new GetBenchmark().getBenchmark(30)));
		        MainFrame.getsubframe().setVisible(true);
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				chartbt.setIcon(new ImageIcon("image\\backbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				chartbt.setIcon(new ImageIcon("image\\backbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(chartbt);		

		
		exiticon = new ExitLabel();
		add(exiticon);
		
		
		

		
		
		
		
		
		
		
		init(new GetBenchmark().getBenchmark(30));
		
		setOpaque(false); 
		setVisible(false);
	}
	
	private void init(ArrayList<benchmarkPO> stockPOs) {
		JScrollPane scrollPane = new JScrollPane(initTable(stockPOs)); 

		scrollPane.getViewport().setOpaque(false);  
	    scrollPane.setOpaque(false); 
	
	    scrollPane.setViewportView(fileTable);  
	    scrollPane.setColumnHeaderView(fileTable.getTableHeader()); 
	    scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,170,300,350);
		add(scrollPane);
	}
	
		
	 private JTable initTable(ArrayList<benchmarkPO> benchmarkPOs)  
	    {  
	    	 String[] tableHeads = new String[]{"日期","开盘价","收盘价"};
	    		DefaultTableModel tableModel = new DefaultTableModel(){
	    			  public boolean isCellEditable(int row,int column){    
	    		            return false;
	    		        } 
	    		};
	    		
	    		tableModel.setColumnIdentifiers(tableHeads);
	    		for(int i = 0;i<benchmarkPOs.size();i++){
	    			Vector v = new Vector();
	    			v.add(benchmarkPOs.get(i).getDate());
	    			v.add(benchmarkPOs.get(i).getOpen());
	    			v.add(benchmarkPOs.get(i).getClose());
	    			tableModel.addRow(v);
	    		}
	        fileTable = new JTable(tableModel);  
	        fileTable.setRowHeight(25);   
	        fileTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);   
	        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   
	        fileTable.setIntercellSpacing(new Dimension(0,0)); 
	        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(  
	                tableModel);  
	        fileTable.setRowSorter(sorter);
	         
	    
	        
	        fileTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
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
			filterText.setBounds(80,130,170,30);
		    JTextField text1 = new JTextField("MIN");
		    add(text1);
		    text1.setBounds(20,530,90,30);
		    JTextField text2 = new JTextField("MAX");
			add(text2);
			text2.setBounds(140,530,90,30);
			checkbt1 = new Mybutton("image\\check3.png",250,130,30,30);
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
			
			checkbt2 = new Mybutton("image\\check3.png",230,530,30,30);
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
			
			
			
			refreshbt = new Mybutton("image\\refreshbt1.png",20,130,30,30);
			refreshbt.addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					 fileTable.setRowSorter(null);
				}
		
				@Override
				public void mouseEntered(MouseEvent arg0) {
					refreshbt.setIcon(new ImageIcon("image\\refreshbt2.png"));

					
				}
		
				@Override
				public void mouseExited(MouseEvent arg0) {
					refreshbt.setIcon(new ImageIcon("image\\refreshbt1.png"));
				
					
				}
		
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					
				}
		
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					
				}
		    	
		    });
	         
	        add(refreshbt);
	        
	        
	        fileTable.setOpaque(false); 
	        
	        
	        
	        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
	        render.setOpaque(false);
	        fileTable.setDefaultRenderer(Object.class,render);  
	         
	        
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
