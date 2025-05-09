

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.jfree.chart.*;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.plot.*;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.*;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTreeUI.MouseInputHandler;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

import java.awt.TextField;

import javax.swing.SwingConstants;

public class Ggraphique extends JPanel {	

	   //private int posX = 0;   //Position X de la souris au clic
	   //private int posY = 0;   //Position Y de la souris au clic
	   //static Crosshair xCrosshair; 
	   
	   //static Crosshair yCrosshair;
	    
    static XYPlot plot;
           XYLineAndShapeRenderer renderer;
    static NumberAxis rangeAxis;
    static ValueAxis domainAxis;
    static Marker start,start1,start2;
            Marker calibr;
            float chartX1;
            
	static JFreeChart chart,chart1;
	static ChartPanel chartPanel,chartPanel1;
	static int cali=0;
	
	//static String clr11,clr22,clr33,clr44;
	//private BufferedReader br;
	
	public Ggraphique() throws IOException {
        XYDataset dataset = createDataset();
        chart = createChart(dataset);       
        chartPanel = new ChartPanel(chart, true, true, true, false, true){  
        	@Override
            public Dimension getPreferredSize() {
                return new Dimension(Mainn.panel.getWidth(), Mainn.panel.getHeight());
            }        	
        };        
        chartPanel.setFillZoomRectangle(false);
        chartPanel.setMouseWheelEnabled(true);
        add(chartPanel);
  //--------------------------------ZOOM-ET-DEPLACEMENT----------------------------------------------------     
       
        double up=domainAxis.getUpperBound();
        chartPanel.addChartMouseListener(new ChartMouseListener() {

        	@Override
            public void chartMouseClicked(ChartMouseEvent cme) {
        		
        		Point2D po = chartPanel.translateScreenToJava2D(cme.getTrigger().getPoint());
                Rectangle2D plotArea = chartPanel.getScreenDataArea();
                // XYPlot plot = (XYPlot) chart.getPlot(); // your plot
                double chartX = plot.getDomainAxis().java2DToValue(po.getX(), plotArea, plot.getDomainAxisEdge());
                double chartY = plot.getRangeAxis().java2DToValue(po.getY(), plotArea, plot.getRangeAxisEdge());
                
                double a0= rangeAxis.getLowerBound();
                double a1= rangeAxis.getUpperBound();
                
        		double b0=domainAxis.getLowerBound();
        		double b1=domainAxis.getUpperBound();
        		
        		if( chartY<a1-(a1-a0)/6 && chartY>a0+(a1-a0)/6){
        		   if(chartX>=b0+(b1-b0)/2){
        			
        			domainAxis.setRange(b0+(b1-b0)/9,b1+(b1-b0)/9);       		
        			
        			/*plot.clearDomainMarkers();
                    start2 = new ValueMarker(b0+(b1-b0)/9+(b1-b0)/2);                  
                    start2.setPaint(Color.orange);
                    start2.setLabel("Move");
                    start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);  
                    start2.setLabelPaint(Color.orange);
                    start2.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
                    plot.addDomainMarker(start2);*/
                    
        			
        		}if(chartX<b0+(b1-b0)/2){
        			domainAxis.setRange(b0-(b1-b0)/9,b1-(b1-b0)/9);
        			/*plot.clearDomainMarkers();
                    start2 = new ValueMarker(b0-(b1-b0)/9+(b1-b0)/2);
                    start2.setPaint(Color.orange);
                    start2.setLabel("Move");
                    start2.setLabelAnchor(RectangleAnchor.TOP_LEFT);
                    start2.setLabelPaint(Color.orange);
                    start2.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
                    plot.addDomainMarker(start2);*/
                    
        			
        		}}
        		
        		plot.clearRangeMarkers();
        		if(chartY>=a1-(a1-a0)/6 || chartY<=a0+(a1-a0)/6){
            		if(chartY>=a1-(a1-a0)/6){
            			rangeAxis.setRange(a0,a1-(a1-a0)/9);
            			
            		}if(chartY<=a0+(a1-a0)/6){
            			rangeAxis.setRange(a0,a1+(a1-a0)/9);
            			
            		}}
        		
       		
            }

			@Override
			public void chartMouseMoved(ChartMouseEvent arg0) {
				double a2= rangeAxis.getLowerBound();
                double a3= rangeAxis.getUpperBound();
                
        		double b2=domainAxis.getLowerBound();
        		double b3=domainAxis.getUpperBound();
        		
        		plot.clearRangeMarkers();
        		start = new ValueMarker(a3-(a3-a2)/6);        		
                start.setPaint(Color.red);
                start.setLabel("Zoom_upp");
                start.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);             
                start.setLabelPaint(Color.red);                
                start.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
                plot.addRangeMarker(start);
        		
    			start1 = new ValueMarker(a2+(a3-a2)/6);
                start1.setPaint(Color.red);
                start1.setLabel("Zoom_lower");
                start1.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
                start1.setLabelPaint(Color.red);
                start1.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
                plot.addRangeMarker(start1);
                
    			/*plot.clearDomainMarkers();
                start2 = new ValueMarker(b2+(b3-b2)/2);
                start2.setPaint(Color.orange);
                start2.setLabel("Move");
                start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
                start2.setLabelPaint(Color.orange);
                start2.setLabelTextAnchor(TextAnchor.TOP_CENTER);
                plot.addDomainMarker(start2);*/
                
                
                
			}
        });
       
//---------------------------------Minimize_zoom-----------------------------------------     
        
        chartPanel.getPopupMenu().add(new JMenuItem("Minimize zoom")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
			
        		double b0m=domainAxis.getLowerBound();
        		double b1m=domainAxis.getUpperBound();
        		
        		domainAxis.setRange(b0m-(b1m-b0m)/4,b1m+(b1m-b0m)/4);
				
			}
		
		}); 
        
//---------------------------------Move_down-----------------------------------------     
        
        chartPanel.getPopupMenu().add(new JMenuItem("Move down")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
			
				double a0m= rangeAxis.getLowerBound();
                double a1m= rangeAxis.getUpperBound();
          
        		rangeAxis.setRange(a0m-(a1m-a0m)/6,a1m);
        		
			}
		
		});                
//---------------------------------Marker for each peak---------------------------------------------------------
   
//---------------------------------energy calibration by graph-mouse-----------------------------------------  
        chartPanel.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(MouseEvent x1){
            	Point2D po1 = chartPanel.translateScreenToJava2D(x1.getPoint());
                Rectangle2D plotArea1 = chartPanel.getScreenDataArea();
                
                 chartX1 = (float) plot.getDomainAxis().java2DToValue(po1.getX(), plotArea1, plot.getDomainAxisEdge());	
                // df0.format(Pi)
            }
          });
        
        JMenu ClbrEnrg = new JMenu("energy calibration by graph");
        chartPanel.getPopupMenu().add(ClbrEnrg).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {	
			  
			}	
		});    
        
        JMenuItem a = new JMenuItem("Channel 1/Energy(kev) 1");
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es1) {
				cali=1;
				//System.out.println(chartX1);
		        calibr = new ValueMarker(chartX1);                  
                calibr.setPaint(Color.GREEN);
                calibr.setLabel("Calibration");
                calibr.setLabelAnchor(RectangleAnchor.TOP_RIGHT);  
                calibr.setLabelPaint(Color.RED);
                calibr.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
                plot.addDomainMarker(calibr); 
                String chtx = Float.toString(chartX1);                
                Mainn.textFieldcali1.setText(chtx);
                //Mainn.textFieldM1.setText(chtx);
                Mainn.ClibEnrgyByGraph();  				    
			}
		});
		ClbrEnrg.add(a);
		
		JMenuItem b = new JMenuItem("Channel 2/Energy(kev) 2");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es2) {
				cali=2;
				//System.out.println(chartX1);
		        calibr = new ValueMarker(chartX1);                  
                calibr.setPaint(Color.GREEN);
                calibr.setLabel("Calibration");
                calibr.setLabelAnchor(RectangleAnchor.TOP_RIGHT);  
                calibr.setLabelPaint(Color.RED);
                calibr.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
                plot.addDomainMarker(calibr); 
                String chtx = Float.toString(chartX1);
                Mainn.textFieldcali1.setText(chtx);
                //Mainn.textFieldM2.setText(chtx);
                Mainn.ClibEnrgyByGraph();  
				    
			}
		});
		ClbrEnrg.add(b);
		
		JMenuItem c = new JMenuItem("Channel 3/Energy(kev) 3");
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es3) {
				cali=3;
				//System.out.println(chartX1);
		        calibr = new ValueMarker(chartX1);                  
                calibr.setPaint(Color.GREEN);
                calibr.setLabel("Calibration");
                calibr.setLabelAnchor(RectangleAnchor.TOP_RIGHT);  
                calibr.setLabelPaint(Color.RED);
                calibr.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
                plot.addDomainMarker(calibr); 
                String chtx = Float.toString(chartX1);
                Mainn.textFieldcali1.setText(chtx);
                //Mainn.textFieldM3.setText(chtx);
                Mainn.ClibEnrgyByGraph();  
				    
			}
		});
		ClbrEnrg.add(c);
		
		JMenuItem d = new JMenuItem("Channel 4/Energy(kev) 4");
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es4) {
				cali=4;
				//System.out.println(chartX1);
		        calibr = new ValueMarker(chartX1);                  
                calibr.setPaint(Color.GREEN);
                calibr.setLabel("Calibration");
                calibr.setLabelAnchor(RectangleAnchor.TOP_RIGHT);  
                calibr.setLabelPaint(Color.RED);
                calibr.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
                plot.addDomainMarker(calibr); 
                String chtx = Float.toString(chartX1);
                Mainn.textFieldcali1.setText(chtx);
                //Mainn.textFieldM4.setText(chtx);
                Mainn.ClibEnrgyByGraph();  
				    
			}
		});
		ClbrEnrg.add(d);

    }
    
  
	private XYDataset createDataset() throws IOException {
      
		XYSeries series = new XYSeries("data");


		//__________________________________________________________________	
		  int je=Mainn.offsetofdata;
		  for(int j=0;j<Mainn.lengthofdata-Mainn.offsetofdata;j++) {
		  	          
          series.add(je, Mainn.tableauEntier[j]);	
          je=je+1;
	     }
		//__________________________________________________________________

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);       
        XYSeries srt=dataset.getSeries(0);
        
        String timeSeriesName = dataset.getSeriesKey(0).toString();
       // System.out.println("   timeSeriesName    :"+timeSeriesName);
        
        return dataset ;
        
    }

	private JFreeChart createChart( XYDataset dataset) {
    
         JFreeChart chart = ChartFactory.createXYLineChart(
            "",      // chart title
            "Channel",                      // x axis label
            "counts",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            false ,                     // include legend
            true,                     // tooltips
            true                     // urls
        );
         
 	     chart.setBackgroundPaint(Color.BLACK);
 	     chart.getTitle().setPaint(Color.white);         
	     chart.setBackgroundPaint(Color.BLACK); 
 	     
 		
 		 plot = chart.getXYPlot();         
 		 plot.setBackgroundPaint(Color.BLACK);
         //plot.setAxisOffset( new RectangleInsets(5.0, 5.0, 5.0, 5.0));//espace entre les axes (X et Y) et le dessin du graph 
         plot.setDomainGridlinePaint(Color.BLACK);//Ligne-vertical
         plot.setRangeGridlinePaint(Color.BLACK);  //ligne-horizontal    
         //plot.setOutlinePaint(Color.GRAY);//Cadre de graph
         plot.setOutlineStroke(new BasicStroke(2.5f));// ?  
          
         
  
         
         
         renderer = new XYLineAndShapeRenderer();
          
         renderer.setSeriesPaint(0,Color.GREEN); //COLEUR-DATA
         //renderer.setSeriesPaint(1,Color.BLACK);//LADEUXIEM-COLOUR-pour-Gaussien1
         renderer.setSeriesLinesVisible(0, false);//relient-les-poits-entre-eux-par-ligne         
         // renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));
         //renderer.setSeriesShape(0, new Rectangle());// la forme de poits
         renderer.setSeriesShape(0, new Ellipse2D.Double(-1, -1, 2, 2));// la forme de poits
        // renderer.setSeriesShape(1, new Rectangle(-2,-2,4,4));
        // renderer.setSeriesShape(2, new Rectangle());       
         renderer.setSeriesStroke(0, new BasicStroke(3));//epesseur-de-coleur  
        
         plot.setRenderer(renderer);
         
         rangeAxis = (NumberAxis) plot.getRangeAxis();
         rangeAxis.setTickLabelPaint(Color.WHITE);   // LA COULEUR DE nombre de l'axe vertical      
         rangeAxis.setLabelPaint(Color.white);  // la couleur son titre          
        // rangeAxis.setRange(500,1000);//pour afficher une partie de chart de axe vertical(0,1000)        
        // rangeAxis.setAutoRangeIncludesZero(true);        
         domainAxis = plot.getDomainAxis();
         domainAxis.setTickLabelPaint(Color.white); // LA COULEUR DE nombre de l'axe horizontal        
         domainAxis.setLabelPaint(Color.white);  //la couleur son titre       
        // domainAxis.setRange(500,1000);//pour afficher une partie de chart de axe horizontal(0,4000)       
        return chart;
        }

 
}


    