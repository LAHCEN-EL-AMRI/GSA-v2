

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
import java.awt.SystemColor;

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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
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

public class ComparSpectr extends JPanel {	

	   //private int posX = 0;   //Position X de la souris au clic
	   //private int posY = 0;   //Position Y de la souris au clic
	   //static Crosshair xCrosshair; 
	   //static Crosshair yCrosshair;
              XYPlot plotCmpr;
              XYLineAndShapeRenderer rendererCmpr;
    static NumberAxis rangeAxisCmpr;
    static ValueAxis domainAxisCmpr;
    static  Marker startCmpr,start1Cmpr,start2Cmpr;
	static JFreeChart chartCmpr;
	static  ChartPanel chartPanelCmpr;
	
	public ComparSpectr() throws IOException {
        XYDataset dataset = createDataset();
        chartCmpr = createChart(dataset);       
        chartPanelCmpr = new ChartPanel(chartCmpr, true, true, true, false, true){  
        	@Override
            public Dimension getPreferredSize() {
                return new Dimension(Mainn.panel.getWidth(), Mainn.panel.getHeight());
            }        	
        };        
        chartPanelCmpr.setFillZoomRectangle(false);
        chartPanelCmpr.setMouseWheelEnabled(true);
        add(chartPanelCmpr);
  //--------------------------------ZOOM-ET-DEPLACEMENT----------------------------------------------------     
       
        double up=domainAxisCmpr.getUpperBound();
        chartPanelCmpr.addChartMouseListener(new ChartMouseListener() {

        	@Override
            public void chartMouseClicked(ChartMouseEvent cme) {
        		
        		Point2D po = chartPanelCmpr.translateScreenToJava2D(cme.getTrigger().getPoint());
                Rectangle2D plotArea = chartPanelCmpr.getScreenDataArea();
                // XYPlot plot = (XYPlot) chart.getPlot(); // your plot
                double chartX = plotCmpr.getDomainAxis().java2DToValue(po.getX(), plotArea, plotCmpr.getDomainAxisEdge());
                double chartY = plotCmpr.getRangeAxis().java2DToValue(po.getY(), plotArea, plotCmpr.getRangeAxisEdge());
                
                double a0= rangeAxisCmpr.getLowerBound();
                double a1= rangeAxisCmpr.getUpperBound();
                
        		double b0=domainAxisCmpr.getLowerBound();
        		double b1=domainAxisCmpr.getUpperBound();
        		
        		if( chartY<a1-(a1-a0)/6 && chartY>a0+(a1-a0)/6){
        		   if(chartX>=b0+(b1-b0)/2){
        			
        			domainAxisCmpr.setRange(b0+(b1-b0)/9,b1+(b1-b0)/9);       		
        			
        			plotCmpr.clearDomainMarkers();
                    start2Cmpr = new ValueMarker(b0+(b1-b0)/9+(b1-b0)/2);                  
                    start2Cmpr.setPaint(Color.orange);
                    start2Cmpr.setLabel("Move");
                    start2Cmpr.setLabelAnchor(RectangleAnchor.TOP_RIGHT);  
                    start2Cmpr.setLabelPaint(Color.orange);
                    start2Cmpr.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
                    plotCmpr.addDomainMarker(start2Cmpr);
        			
        			
        		}if(chartX<b0+(b1-b0)/2){
        			domainAxisCmpr.setRange(b0-(b1-b0)/9,b1-(b1-b0)/9);
        			plotCmpr.clearDomainMarkers();
                    start2Cmpr = new ValueMarker(b0-(b1-b0)/9+(b1-b0)/2);
                    start2Cmpr.setPaint(Color.orange);
                    start2Cmpr.setLabel("Move");
                    start2Cmpr.setLabelAnchor(RectangleAnchor.TOP_LEFT);
                    start2Cmpr.setLabelPaint(Color.orange);
                    start2Cmpr.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
                    plotCmpr.addDomainMarker(start2Cmpr);
        			
        		}}
        		
        		plotCmpr.clearRangeMarkers();
        		if(chartY>=a1-(a1-a0)/6 || chartY<=a0+(a1-a0)/6){
            		if(chartY>=a1-(a1-a0)/6){
            			rangeAxisCmpr.setRange(a0,a1-(a1-a0)/9);
            			
            		}if(chartY<=a0+(a1-a0)/6){
            			rangeAxisCmpr.setRange(a0,a1+(a1-a0)/9);
            			
            		}}
       		
            }

			@Override
			public void chartMouseMoved(ChartMouseEvent arg0) {
				double a2= rangeAxisCmpr.getLowerBound();
                double a3= rangeAxisCmpr.getUpperBound();
                
        		double b2=domainAxisCmpr.getLowerBound();
        		double b3=domainAxisCmpr.getUpperBound();
        		
        		plotCmpr.clearRangeMarkers();
        		startCmpr = new ValueMarker(a3-(a3-a2)/6);        		
                startCmpr.setPaint(Color.red);
                startCmpr.setLabel("Zoom_upp");
                startCmpr.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);             
                startCmpr.setLabelPaint(Color.red);                
                startCmpr.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
                plotCmpr.addRangeMarker(startCmpr);
        		
    			start1Cmpr = new ValueMarker(a2+(a3-a2)/6);
                start1Cmpr.setPaint(Color.red);
                start1Cmpr.setLabel("Zoom_lower");
                start1Cmpr.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
                start1Cmpr.setLabelPaint(Color.red);
                start1Cmpr.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
                plotCmpr.addRangeMarker(start1Cmpr);
                
    			plotCmpr.clearDomainMarkers();
                start2Cmpr = new ValueMarker(b2+(b3-b2)/2);
                start2Cmpr.setPaint(Color.orange);
                start2Cmpr.setLabel("Move");
                start2Cmpr.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
                start2Cmpr.setLabelPaint(Color.orange);
                start2Cmpr.setLabelTextAnchor(TextAnchor.TOP_CENTER);
                plotCmpr.addDomainMarker(start2Cmpr);
                
			}
        });
       
//---------------------------------Minimize_zoom-----------------------------------------     
        
        chartPanelCmpr.getPopupMenu().add(new JMenuItem("Minimize zoom")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
			
        		double b0m=domainAxisCmpr.getLowerBound();
        		double b1m=domainAxisCmpr.getUpperBound();
        		
        		domainAxisCmpr.setRange(b0m-(b1m-b0m)/4,b1m+(b1m-b0m)/4);
				
			}
		
		}); 
        
//---------------------------------Move_down-----------------------------------------     
        
        chartPanelCmpr.getPopupMenu().add(new JMenuItem("Move down")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
			
				double a0m= rangeAxisCmpr.getLowerBound();
                double a1m= rangeAxisCmpr.getUpperBound();
          
        		rangeAxisCmpr.setRange(a0m-(a1m-a0m)/6,a1m);
        		
			}
		
		});                
     
	}
  
	private XYDataset createDataset() throws IOException {
      
		
		XYSeries seriesGraph = new XYSeries("data");
		XYSeries series = new XYSeries("dataCmpr");

		
		 //__________________________________________________________________	
			  int ja=Mainn.offsetofdata;
			  for(int j=0;j<Mainn.lengthofdata-Mainn.offsetofdata;j++) {
			  
				  if(Mainn.choiceEchel =="Log") {if(Mainn.tableauEntier[j]>0) {seriesGraph.add(ja, Math.log(Mainn.tableauEntier[j]));}
	              	
				  }else {seriesGraph.add(ja, Mainn.tableauEntier[j]);}
	          ja=ja+1;
		     }
		//__________________________________________________________________
		
		//__________________________________________________________________	
		 String fileExtension = Mainn.fichierCmpr.substring(Mainn.fichierCmpr.lastIndexOf("."));
				
		  int je=comprChnFile.offsetofdataCmpr,sasa0 = 0,sasa1 = 0;
		  if(fileExtension.equals(".Chn")||fileExtension.equals(".chn")) {je=comprChnFile.offsetofdataCmpr;sasa1=comprChnFile.lengthofdataCmpr;
		  sasa0=comprChnFile.offsetofdataCmpr;}
		  if(fileExtension.equals(".Spc")||fileExtension.equals(".spc")) {je=comprSpcFile.offsetofdataCmpr;sasa1=comprSpcFile.lengthofdataCmpr;
			  sasa0=comprSpcFile.offsetofdataCmpr;}
		  if(fileExtension.equals(".Spe")||fileExtension.equals(".spe")) {je=comprSpeFile.offsetofdataCmpr;sasa1=comprSpeFile.lengthofdataCmpr;
		  sasa0=comprSpeFile.offsetofdataCmpr;}
		  //System.out.println(Mainn.fichierCmpr);
		  
		  for(int j=0;j<sasa1-sasa0;j++) {
		  
			  if(Mainn.choiceEchel =="Log" && (fileExtension.equals(".Chn")||fileExtension.equals(".chn"))) {if(comprChnFile.tableauEntierCmpr[j]>0) {series.add(je, Math.log(comprChnFile.tableauEntierCmpr[j]));}
			  }else if(fileExtension.equals(".Chn")||fileExtension.equals(".chn")){series.add(je, comprChnFile.tableauEntierCmpr[j]);}
			  
			  if(Mainn.choiceEchel =="Log" && (fileExtension.equals(".Spc")||fileExtension.equals(".spc"))) {if(comprSpcFile.tableauEntierCmpr[j]>0) {series.add(je, Math.log(comprSpcFile.tableauEntierCmpr[j]));}
			  }else if(fileExtension.equals(".Spc")||fileExtension.equals(".spc")){series.add(je, comprSpcFile.tableauEntierCmpr[j]);}
			  
			  if(Mainn.choiceEchel =="Log" && (fileExtension.equals(".Spe")||fileExtension.equals(".spe"))) {if(comprSpeFile.tableauEntierCmpr[j]>0) {series.add(je, Math.log(comprSpeFile.tableauEntierCmpr[j]));}
			  }else if(fileExtension.equals(".Spe")||fileExtension.equals(".spe")){series.add(je, comprSpeFile.tableauEntierCmpr[j]);}
			  
          je=je+1;
	     }
		//__________________________________________________________________
		  

        XYSeriesCollection dataset = new XYSeriesCollection();        
        dataset.addSeries(seriesGraph);
        dataset.addSeries(series);
        //XYSeries srt=dataset.getSeries(0);
        
        //String timeSeriesName = dataset.getSeriesKey(0).toString();
       // System.out.println("   timeSeriesName    :"+timeSeriesName);
        
        
        return dataset ;
        
    }

	private JFreeChart createChart( XYDataset dataset) {
		String fileExtension, namefile=null;
		fileExtension = Mainn.fichierCmpr.substring(Mainn.fichierCmpr.lastIndexOf("."));
		if(fileExtension.equals(".Chn")||fileExtension.equals(".chn")) {namefile=comprChnFile.nameFileCmpr;}
		if(fileExtension.equals(".Spc")||fileExtension.equals(".spc")) {namefile=comprSpcFile.nameFileCmpr;}
		if(fileExtension.equals(".Spe")||fileExtension.equals(".spe")) {namefile=comprSpeFile.nameFileCmpr;}
		
         JFreeChart chart = ChartFactory.createXYLineChart(
            "File :"+namefile,      // chart title
            "Channel",                      // x axis label
            "counts",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            false ,                     // include legend
            true,                     // tooltips
            true                     // urls
        );
         
 	     chart.setBackgroundPaint(Color.BLACK);
 	     chart.getTitle().setPaint(Color.BLUE);  
 	     chart.getTitle().setFont(new Font("Serif", Font.BOLD, 17));
 	    //chart.getTitle().setSize( 275, 180 );
	     chart.setBackgroundPaint(Color.BLACK); 
 	     
 		
 		 plotCmpr = chart.getXYPlot();         
 		 plotCmpr.setBackgroundPaint(Color.BLACK);
         //plotCmpr.setAxisOffset( new RectangleInsets(5.0, 5.0, 5.0, 5.0));//espace entre les axes (X et Y) et le dessin du graph 
         plotCmpr.setDomainGridlinePaint(Color.BLACK);//Ligne-vertical
         plotCmpr.setRangeGridlinePaint(Color.BLACK);  //ligne-horizontal    
         //plotCmpr.setOutlinePaint(Color.GRAY);//Cadre de graph
         plotCmpr.setOutlineStroke(new BasicStroke(2.5f));// ?  
                  
         rendererCmpr = new XYLineAndShapeRenderer();
         //.setBackground(SystemColor.inactiveCaptionBorder);
         rendererCmpr.setSeriesPaint(0,Color.GREEN); //COLEUR-DATA
         rendererCmpr.setSeriesPaint(1,Color.BLUE); 
         //rendererCmpr.setSeriesPaint(1,SystemColor.inactiveCaptionBorder); 
         //rendererCmpr.setSeriesPaint(1,Color.BLACK);//LADEUXIEM-COLOUR-pour-Gaussien1
         rendererCmpr.setSeriesLinesVisible(0, false);//relient-les-poits-entre-eux-par-ligne   
         rendererCmpr.setSeriesLinesVisible(1, false);//relient-les-poits-entre-eux-par-ligne   
         // rendererCmpr.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));
         //rendererCmpr.setSeriesShape(0, new Rectangle());// la forme de poits
         rendererCmpr.setSeriesShape(0, new Ellipse2D.Double(-1, -1, 2, 2));// la forme de poits
         rendererCmpr.setSeriesShape(1, new Ellipse2D.Double(-1, -1, 2, 2));// la forme de poits
        // rendererCmpr.setSeriesShape(1, new Rectangle(-2,-2,4,4));
        // rendererCmpr.setSeriesShape(2, new Rectangle());       
         rendererCmpr.setSeriesStroke(0, new BasicStroke(3));//epesseur-de-coleur
         rendererCmpr.setSeriesStroke(1, new BasicStroke(3));//epesseur-de-coleur
        
         plotCmpr.setRenderer(rendererCmpr);
         
         rangeAxisCmpr = (NumberAxis) plotCmpr.getRangeAxis();
         rangeAxisCmpr.setTickLabelPaint(Color.WHITE);   // LA COULEUR DE nombre de l'axe vertical      
         rangeAxisCmpr.setLabelPaint(Color.white);  // la couleur son titre          
        // rangeAxisCmpr.setRange(500,1000);//pour afficher une partie de chart de axe vertical(0,1000)        
        // rangeAxisCmpr.setAutoRangeIncludesZero(true);        
         domainAxisCmpr = plotCmpr.getDomainAxis();
         domainAxisCmpr.setTickLabelPaint(Color.white); // LA COULEUR DE nombre de l'axe horizontal        
         domainAxisCmpr.setLabelPaint(Color.white);  //la couleur son titre       
        // domainAxisCmpr.setRange(500,1000);//pour afficher une partie de chart de axe horizontal(0,4000)       
        return chart;
        }
 
}


    