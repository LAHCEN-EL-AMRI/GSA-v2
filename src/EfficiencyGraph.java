

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

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

public class EfficiencyGraph extends JPanel {	

	   //private int posX = 0;   //Position X de la souris au clic
	   //private int posY = 0;   //Position Y de la souris au clic
	   //static Crosshair xCrosshair; 
	   //static Crosshair yCrosshair;
     static XYPlot plot;
              XYLineAndShapeRenderer renderer,renderer1;
    static NumberAxis rangeAxis;
    static ValueAxis domainAxis;
    static Marker start,start1,start2,start3;
            Marker calibr;
            float chartX1;
	static JFreeChart chart,chart1;
	static ChartPanel chartPanelEfficiency, chartPanelEfficiency2;
	static int cali=0;
	//static String clr11,clr22,clr33,clr44;
	private BufferedReader br;
	List<String> nuclides = new ArrayList<>();
	List<String> grandValeurEffi = new ArrayList<>();
	
	
	public EfficiencyGraph() throws IOException {
        XYDataset dataset = createDataset();
        chart = createChart(dataset);       
        chartPanelEfficiency = new ChartPanel(chart, true, true, true, false, true){  
        	@Override
            public Dimension getPreferredSize() {
                return new Dimension(Mainn.subPanel.getWidth(), Mainn.subPanel.getHeight());
            }        	
        };        
        chartPanelEfficiency.setFillZoomRectangle(false);
        chartPanelEfficiency.setMouseWheelEnabled(true);
        add(chartPanelEfficiency);
  //--------------------------------ZOOM-ET-DEPLACEMENT----------------------------------------------------     
       
        double up=domainAxis.getUpperBound();
        chartPanelEfficiency.addChartMouseListener(new ChartMouseListener() {

        	@Override
            public void chartMouseClicked(ChartMouseEvent cme) {
        		
        		Point2D po = chartPanelEfficiency.translateScreenToJava2D(cme.getTrigger().getPoint());
                Rectangle2D plotArea = chartPanelEfficiency.getScreenDataArea();
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
        
        chartPanelEfficiency.getPopupMenu().add(new JMenuItem("Minimize zoom")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
			
        		double b0m=domainAxis.getLowerBound();
        		double b1m=domainAxis.getUpperBound();
        		
        		domainAxis.setRange(b0m-(b1m-b0m)/4,b1m+(b1m-b0m)/4);
				
			}
		
		}); 
        
//---------------------------------Move_down-----------------------------------------     
        
        chartPanelEfficiency.getPopupMenu().add(new JMenuItem("Move down")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
			
				double a0m= rangeAxis.getLowerBound();
                double a1m= rangeAxis.getUpperBound();
          
        		rangeAxis.setRange(a0m-(a1m-a0m)/6,a1m);
        		
			}
		
		});                
     

	}
	private XYDataset createDataset() throws IOException {
      
		XYSeries series = new XYSeries("Efficiency");
		XYSeries series1 = new XYSeries("nuclides");
		
		//------------nucléides de calibrade éfficacié---------------
		 nuclides.clear();
		 grandValeurEffi.clear();
	     try (BufferedReader breffk = new BufferedReader(new FileReader(Mainn.filenameEfficien))) {   	 
	    	        String line;
	    	        breffk.readLine(); // Skip the header line
	    	        while ((line = breffk.readLine()) != null) {
	    	            String[] parts = line.trim().split("\\s+"); // Split by whitespace
	    	            if (parts.length >= 4) {
	    	                String nuclide = parts[0]; // First column (Nuclide)
	    	                double energy = Double.parseDouble(parts[1]); // Second column (Energy)
	    	                double efficiency = Double.parseDouble(parts[3]); // Fourth column (Efficiency)

	    	               // Ajouter le nom du nucléide à la liste
	    	                nuclides.add(nuclide);
	    	                // Add values to series1
	    	                series1.add(energy, efficiency);
	    	                grandValeurEffi.add(parts[3]);
	    	            }
	    	        }
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }
	         double maxEffi = grandValeurEffi.stream()
	                .mapToDouble(Double::parseDouble)
	                .max()
	                .orElse(Double.NaN);
	     
	                      //------------------------------

	
	//_______________________________________________________________	
	 int je=Mainn.offsetofdata;
	 for(int j=0;j<Mainn.lengthofdata-Mainn.offsetofdata;j=j+50) {
		 
		 String valeurTexte1 = Mainn.textField1.getText();
		 double valeurDouble1 = Double.parseDouble(valeurTexte1);
		 
		 String valeurTexte2 = Mainn.textField2.getText();
		 double valeurDouble2 = Double.parseDouble(valeurTexte2);
		 
		 String valeurTexte3 = Mainn.textField3.getText();
		 double valeurDouble3 = Double.parseDouble(valeurTexte3);
		 
		 String valeurTexte4 = Mainn.textField4.getText();
		 double valeurDouble4 = Double.parseDouble(valeurTexte4);
		 
		 double EnergirForEffici = valeurDouble1 + valeurDouble2 * j + valeurDouble3 * Math.pow(j, 2) + valeurDouble4 * Math.pow(j, 3);
		
		//-------------- Calcul de ln(E)-------------------
		if(EnergirForEffici>1 ) {
		 double lnE = Math.log(EnergirForEffici);
          
		 //---------Calcul de la formule ln(eff)-------------
		 
		 String valeurEffi1 = Mainn.textField1tpe.getText();
		 double valeurDoubleEffi1 = Double.parseDouble(valeurEffi1);
		 
		 String valeurEffi2 = Mainn.textField2tpe.getText();
		 double valeurDoubleEffi2 = Double.parseDouble(valeurEffi2);
		 
		 String valeurEffi3 = Mainn.textField3tpe.getText();
		 double valeurDoubleEffi3 = Double.parseDouble(valeurEffi3);
		 
		 String valeurEffi4 = Mainn.textField4tpe.getText();
		 double valeurDoubleEffi4 = Double.parseDouble(valeurEffi4);
		 
		 String valeurEffi5 = Mainn.textField5tpe.getText();
		 double valeurDoubleEffi5 = Double.parseDouble(valeurEffi5);
		 
		 String valeurEffi6 = Mainn.textField6tpe.getText();
		 double valeurDoubleEffi6 = Double.parseDouble(valeurEffi6);
		 
		 
		 double lnEff = valeurDoubleEffi1 + valeurDoubleEffi2 * lnE + valeurDoubleEffi3 * Math.pow(lnE, 2) + valeurDoubleEffi4 * Math.pow(lnE, 3) 
		              + valeurDoubleEffi5 * Math.pow(lnE, 4) + valeurDoubleEffi6 * Math.pow(lnE, 5);
		 
		 double Eff = Math.exp(lnEff);
		 if(Eff>0 && Eff<100 && Eff<maxEffi+maxEffi/4) {
		 
		 series.add(EnergirForEffici , Eff);
		 //System.out.println( EnergirForEffici+"        :         "+Eff);
		}
		 }
				 je=je+1;
		 
		// if(data>0) {series.add(je, Math.log(data));}
          
	  }
	

    //________________________________________________________________
	 
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series); 
        dataset.addSeries(series1); 
        XYSeries srt=dataset.getSeries(0);
        
        String timeSeriesName = dataset.getSeriesKey(0).toString();
       // System.out.println("   timeSeriesName    :"+timeSeriesName);
        
        return dataset ;
        
    }

	private JFreeChart createChart( XYDataset dataset) {
    
         JFreeChart chart = ChartFactory.createXYLineChart(
            "",      // chart title
            "E (keV)",                      // x axis label
            "Efficiency",                      // y axis label
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
                  
         //renderer = new XYLineAndShapeRenderer();
      // For series1, enable point labels
         //renderer1 = new XYLineAndShapeRenderer(true, true);
         
         renderer = new XYLineAndShapeRenderer(true, true);
         renderer.setBaseItemLabelGenerator((dataset1, series1, item) -> {
        	// Retourner le nom du nucléide pour chaque point dans series1
        	    if (series1 == 1 && item >= 0 && item < nuclides.size()) { // Vérifier que c'est la série 1
        	    	
        	    	return nuclides.get(item); 
        	        
        	    }
        	    return null;
        	});
         renderer.setBaseItemLabelsVisible(true); // Enable labels
         renderer.setBaseShapesVisible(true); // Show shapes at data points
         renderer.setBaseItemLabelPaint(Color.WHITE); // Change to your desired color
         renderer.setBaseItemLabelFont(new Font("Arial", Font.PLAIN, 10)); // Change the font size here
         //plot.setRenderer(1, renderer); // Set this renderer for series1
         
          
         renderer.setSeriesPaint(0,Color.GREEN); //COLEUR-DATA
         renderer.setSeriesPaint(1,Color.RED);
         renderer.setSeriesLinesVisible(0, true);//relient-les-poits-entre-eux-par-ligne 
         renderer.setSeriesLinesVisible(1, false);
         // renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));
         //renderer.setSeriesShape(0, new Rectangle());// la forme de poits
         renderer.setSeriesShape(0, new Ellipse2D.Double(-0.5, -0.5, 1, 1));// la forme de points
         renderer.setSeriesShape(1, new Ellipse2D.Double(-3, -3, 6, 6));
        // renderer.setSeriesShape(1, new Rectangle(-2,-2,4,4));
        // renderer.setSeriesShape(2, new Rectangle());       
         renderer.setSeriesStroke(0, new BasicStroke(2));//epesseur-de-coleur 
         renderer.setSeriesStroke(1, new BasicStroke(6));
        
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


    