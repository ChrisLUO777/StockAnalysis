package presentation.marketui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import po.benchmarkPO;
import po.optionalStockPO;
import presentation.mainframe.MainFrame;
import presentation.tool.ExitLabel;
import presentation.tool.Mybutton;

public class MarketChartUI extends JPanel{
	
	Mybutton closebt;
	Mybutton barbt;
	Mybutton linebt;
	public MarketChartUI(ArrayList<benchmarkPO> benchmarkPOs){
		setBounds(0,0,700,700);
		setLayout(null);
		JPanel barpanel = createBarPanel(benchmarkPOs);
		barpanel.setBounds(50,165,600,400);
		barpanel.setOpaque(false);
		barpanel.setVisible(true);
		add(barpanel);
		JPanel linepanel = createLinePanel(benchmarkPOs);
		linepanel.setBounds(50,165,600,400);
		linepanel.setOpaque(false);
		linepanel.setVisible(false);
		add(linepanel);

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
		
		barbt = new Mybutton("image\\exitbt1.png",50,10,50,50);
		barbt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				barpanel.setVisible(true);
				linepanel.setVisible(false);
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				barbt.setIcon(new ImageIcon("image\\exitbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				barbt.setIcon(new ImageIcon("image\\exitbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(barbt);

		linebt = new Mybutton("image\\exitbt1.png",100,10,50,50);
		linebt.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				barpanel.setVisible(false);
				linepanel.setVisible(true);
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				linebt.setIcon(new ImageIcon("image\\exitbt2.png"));

				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				linebt.setIcon(new ImageIcon("image\\exitbt1.png"));
			
				
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	    	
	    });
		add(linebt);

		
		setOpaque(false); 
		setVisible(true);
	}
	
		
	
	 public static JPanel createBarPanel(ArrayList<benchmarkPO> benchmarkPOs)
	    {
	        JFreeChart chart =createBarChart("开盘统计","日期","开盘",createDataset(benchmarkPOs));
	        return new ChartPanel(chart); //将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
	    }
	 public static JPanel createLinePanel(ArrayList<benchmarkPO> benchmarkPOs)
	    {
	        JFreeChart chart =createLineChart("开盘统计","日期","开盘",createDataset(benchmarkPOs));
	        return new ChartPanel(chart); //将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
	    }

	 public static CategoryDataset createDataset(ArrayList<benchmarkPO> benchmarkPOs) //创建柱状图数据集
	    {
	        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

	        for(int i=0;i<benchmarkPOs.size();i++){
	        dataset.setValue(benchmarkPOs.get(i).getOpen(),"",benchmarkPOs.get(i).getDate());
	        }
	        return dataset;
	    }
	 public static JFreeChart createBarChart(String chartTitle, String xName,
		        String yName, CategoryDataset dataset){
		    /**
		     * createBarChart的参数分别为：
		     * 标题，横坐标标题，纵坐标标题，数据集，图标方向（水平、垂直）
		     * ，是否显示图例，是否显示tooltips，是否urls
		     */
		    JFreeChart chart = ChartFactory.createBarChart(
		            chartTitle, xName, yName,
		            dataset, PlotOrientation.HORIZONTAL,
		            false, false, false);
		    /**
		     * VALUE_TEXT_ANTIALIAS_OFF表示将文字的抗锯齿关闭,
		     * 使用的关闭抗锯齿后，字体尽量选择12到14号的宋体字,这样文字最清晰好看
		     */
		    chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
		            RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		    // 背景色
		    chart.setBackgroundPaint(null);
		    // 设置标题字体
		    chart.getTitle().setFont(new Font("宋体", Font.BOLD, 14));
	 
		    CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		    // 设置纵虚线可见
		    //categoryPlot.setDomainGridlinesVisible(true);
		    // 虚线色彩
		    //categoryPlot.setDomainGridlinePaint(Color.black);
		    // 设置横虚线可见
		    categoryPlot.setRangeGridlinesVisible(true);
		    // 虚线色彩
		    categoryPlot.setRangeGridlinePaint(Color.black);
		    // 设置柱的透明度
		    categoryPlot.setForegroundAlpha(1.0f);
		    //设置柱图背景色（注意，系统取色的时候要使用
		    //16位的模式来查看颜色编码，这样比较准确）
		    categoryPlot.setBackgroundPaint(new Color(110, 182, 229));
		 
		    /*
		     * categoryPlot.setRangeCrosshairVisible(true);
		     * categoryPlot.setRangeCrosshairPaint(Color.blue);
		     */
		 
		    // 纵坐标--范围轴
		    NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		    // 纵坐标y轴坐标字体
		    numberAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));
		    // 纵坐标y轴标题字体
		    numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 12));
		    // 设置最高的一个 Item 与图片顶端的距离
		     numberAxis.setUpperMargin(0.2);
		    // 设置最低的一个 Item 与图片底端的距离
		     numberAxis.setLowerMargin(0.5);
		    // 设置刻度单位 为Integer
		    numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		 
		    // 横坐标--类别轴、域
		    CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		    // 横坐标x轴坐标字体
		    categoryAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));
		    // 横坐标x轴标题字体
		    categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 12));
		    // 类别轴的位置，倾斜度
//		    categoryAxis.setCategoryLabelPositions(
//		            CategoryLabelPositions.createUpRotationLabelPositions(
//		                    0.5235987755982988D));
		    //横轴上的 Lable
		    //categoryAxis.setMaximumCategoryLabelWidthRatio(0.6f);
		    //是否完整显示
		    //设置距离图片左端距离
//		    categoryAxis.setLowerMargin(0.1D);
		    // 设置距离图片右端距离
//		    categoryAxis.setUpperMargin(0.1D);
		 
		    // 渲染 - 中间的部分
		    BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		    // 设置柱子宽度
		    barRenderer.setMaximumBarWidth(0.04);
		    // 设置柱子高度
		    barRenderer.setMinimumBarLength(0.15);
		    // 设置柱子边框颜色
		    barRenderer.setBaseOutlinePaint(Color.BLACK);
		    // 设置柱子边框可见
		    barRenderer.setDrawBarOutline(true);
		    // 设置柱的颜色
		    barRenderer.setSeriesPaint(0, new Color(0, 255, 0));
		    barRenderer.setSeriesPaint(1, new Color(0, 0, 255));
		    barRenderer.setSeriesPaint(2, new Color(255, 0, 0));
		    // 设置每个柱之间距离
		    barRenderer.setItemMargin(20D);
		    barRenderer.setItemLabelAnchorOffset(5D);
		    // 显示每个柱的数值，并修改该数值的字体属性
		    barRenderer.setIncludeBaseInRange(true);
		    barRenderer.setBaseItemLabelGenerator(
		            new StandardCategoryItemLabelGenerator());
		    barRenderer.setBaseItemLabelsVisible(true);

		    return chart;
		}
	 private static JFreeChart createLineChart(String chartTitle, String xName,
		        String yName,CategoryDataset categorydataset)
	 {
	 JFreeChart jfreechart = ChartFactory.createLineChart(chartTitle,xName,yName,
	 categorydataset,
	 PlotOrientation.VERTICAL,
	 false,
	 true,
	 false);
	 jfreechart.setBackgroundPaint(Color.white);
	 CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
	 categoryplot.setBackgroundPaint(Color.lightGray);
	 categoryplot.setRangeGridlinePaint(Color.white);
	 
	 NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
	 numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	 numberaxis.setAutoRangeIncludesZero(true);
	 numberaxis.setAutoTickUnitSelection(true);
	    // 设置最高的一个 Item 与图片顶端的距离
     numberaxis.setUpperMargin(0.3);
    // 设置最低的一个 Item 与图片底端的距离
     numberaxis.setLowerMargin(0.1);

	 //获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
	 LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
	 lineandshaperenderer.setShapesVisible(true); //series 点（即数据点）可见
	 lineandshaperenderer.setSeriesPaint(0, Color.black);    //设置折线的颜色
//	 lineandshaperenderer.setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
//	 10F, 6F
//	 }, 0.0F)); //定义series为”First”的（即series1）点之间的连线 ，这里是虚线，默认是直线
//	 lineandshaperenderer.setSeriesStroke(1, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
//	 6F, 6F
//	 }, 0.0F)); //定义series为”Second”的（即series2）点之间的连线
//	 lineandshaperenderer.setSeriesStroke(2, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
//	 2.0F, 6F
//	 }, 0.0F)); //定义series为”Third”的（即series3）点之间的连线
	//设置曲线显示各数据点的值

	 CategoryAxis categoryaxis = categoryplot.getDomainAxis();
	    categoryaxis.setTickLabelFont(new Font("Dilog", 0, 12));
	    categoryaxis.setTickLabelPaint(Color.BLACK);
	    // 设置标志显示角度
	    categoryaxis.setCategoryLabelPositions(CategoryLabelPositions
	        .createUpRotationLabelPositions(Math.PI / 2.0));
	    // 坐标文字从上自下排列,原来使用的是createUpRotationLabelRosition,文字是从下到上排列
	    categoryaxis.setCategoryLabelPositions(CategoryLabelPositions
	        .createDownRotationLabelPositions(Math.PI / 2.0));
	 return jfreechart;
	 } 
	 
}
