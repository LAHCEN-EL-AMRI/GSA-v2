import static org.junit.Assert.assertArrayEquals;

import java.awt.SystemColor;
import java.awt.TextField;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;

public class SpeFile {	
	private static Scanner s;

	public static void ReadSpeFile() throws IOException {
		File file =	new File(Mainn.fichier);
		        s = new Scanner(file);		
		//--------name file----------
	       Mainn.namFile = file.getName();
	      
	    	  String keyword = s.next();
	    	  
	    	  //---------------------$SPEC_ID:--Sample description------------------------
	    	  if(keyword.equals("$SPEC_ID:")) {
	    		  String strVar1="";
	    		  String A1 ="";
	    		  for(int b=0;b<50;b++) {
	    	      
	    	    	   strVar1 =   s.next(); 
	    	    	   if(strVar1.equals("$SPEC_REM:")){keyword="$SPEC_REM:"; break; }
	    	    	   A1 = A1 + strVar1+" " ;  	  
	    	      }
	    	      Mainn.SampleDescription =  A1;
	    	      strVar1="";
	    	  }
	    	//---------------------$SPEC_REM:--detector description------------------------
	    	  if(keyword.equals("$SPEC_REM:")) {
	    		  
	    		  String strVar1="";
	    		  String A1 ="";
	    		  for(int b=0;b<100;b++) {
	    	      
	    	    	   strVar1 =   s.next(); 
	    	    	   
	    	    	   if(strVar1.equals("$DATE_MEA:")){ break; }
	    	    	   A1 = A1 + strVar1+" " ;  	  
	    	      }
	    		  Mainn.DetectorDescription =  A1; 
	    	      strVar1="";
	    		  
	    		 // System.out.println(keyword);
	    	  }
	    	//---------------------date-----$DATE_MEA:------------------------
	    	  	    		  
	    		//-------------------DD-MMM-YY--------------	    	    	    
	    	    	      String  DD_MMM_YY =  s.next();
	    			      Mainn.StrDat = DD_MMM_YY;
	    		//-------------------HH_MM_SS--------------	    
	    			      String  HH_MM_SS =  s.next();
	    			      Mainn.StrTime = HH_MM_SS;
	    			      //System.out.println(HH_MM_SS);
	    	  
	    	  
	    	//------------------------$MEAS_TIM------------------------
	    	      s.next();             	    		  
            	  String  Live_Time =  s.next();
    		      Mainn.livetimS = Live_Time; 
            	  
    		      String  Real_Time =  s.next();
    		      Mainn.realtimS = Real_Time;
    		    //---------dead time--------
    			     float i4a = Float.parseFloat(Real_Time);
    			     float i5a = Float.parseFloat(Live_Time);
    		         float  dead =(float) (i4a-i5a)*100/i4a;	
    		         String Dead = Float.toString(dead)+" %";
    		         Mainn.Dead = Dead;	  	    	  
	    	  //-------------$DATA:-----------------------------------------------
              s.next();	    	  
	    	  //---------offset of data and length of data-------------  
	    	  Mainn.offsetofdata = s.nextShort();
		      Mainn.offsetofdataS = Short.toString(Mainn.offsetofdata);
		      Mainn.lengthofdata = s.nextShort();
		      Mainn.lengthofdataS = Short.toString(Mainn.lengthofdata);
		      //---------Data of spectrum------------------------------
		      Mainn.tableauEntier= new int[Mainn.lengthofdata-Mainn.offsetofdata];
		      for(int j=0;j<Mainn.lengthofdata-Mainn.offsetofdata;j++) {
		    	  int data =s.nextInt();
		    	  Mainn.tableauEntier[j]=data; 
		    	  //System.out.println("data :  "+Mainn.tableauEntier[j] );
		    	  
		      }	    		    	  
		    //---------$MCA_CAL:------------------------------------------------------	    
		      for(int j=0;j<100;j++) {
		    	  String wordkey =s.next();
		    	  int nbrFctor;
		    	  if(wordkey.equals("$MCA_CAL:")) {
		    		  nbrFctor=s.nextInt();
		    		  if(nbrFctor==2) {Mainn.cf0S =s.next();Mainn.cf1S =s.next();Mainn.cf2S ="0";j=100;}
		    		  if(nbrFctor==3) {Mainn.cf0S =s.next();Mainn.cf1S =s.next();Mainn.cf2S =s.next();j=100;}
		    		  
		    		  }		    	  
		      }	
		    //---------$SHAPE_CAL:------------------------------------------------------
		      String casKev=s.next();
		      if(casKev.equals("keV")||casKev.equals("kev")||casKev.equals("KEV")||casKev.equals("Kev")) {		       
		          s.next();
		          int nbrFctor1=s.nextInt();
		          //System.out.println(nbrFctor1);
		          if(nbrFctor1==2) {Mainn.cf0SF =s.next();Mainn.cf1SF =s.next();}
    		      if(nbrFctor1==3) {Mainn.cf0SF =s.next();Mainn.cf1SF =s.next();s.next();}
		      }else {
		    	  int nbrFctor1=s.nextInt();
			      //System.out.println(nbrFctor1);
			      if(nbrFctor1==2) {Mainn.cf0SF =s.next();Mainn.cf1SF =s.next();}
	    		  if(nbrFctor1==3) {Mainn.cf0SF =s.next();Mainn.cf1SF =s.next();s.next();}
		      }
    		//-----------------------file name------------------------
		      Mainn.Vfilename.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						  Mainn.pan.repaint();								
						  Mainn.Vfilename.setText(Mainn.namFile);								
					}
				});					      				       
		      Mainn.Vfilename.setBounds(100, 30, 100, 17);
		      Mainn.Vfilename.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Vfilename);
		      
		      
		      
		      Mainn.Vstart.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						  Mainn.pan.repaint();								
						  Mainn.Vstart.setText(Mainn.StrTime);								
					}
				});					      				       
		      Mainn.Vstart.setBounds(100, 50, 100, 17);
		      Mainn.Vstart.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Vstart);
				
				
		      Mainn.Vstartd.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.Vstartd.setText(Mainn.StrDat);								
					}
				});	
		      Mainn.Vstartd.setBounds(100, 70, 100, 17);
		      Mainn.Vstartd.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Vstartd);
		      	
		      Mainn.Vreal.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						  Mainn.Vreal.setText(Mainn.realtimS);								
					}
				});	
		      Mainn.Vreal.setBounds(100, 90, 100, 17);
		      Mainn.Vreal.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Vreal);
				
		      Mainn.Vlive.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.Vlive.setText(Mainn.livetimS);								
					}
				});	
		      Mainn.Vlive.setBounds(100, 110, 100, 17);
		      Mainn.Vlive.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Vlive);
				
		      Mainn.Vdead.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.Vdead.setText(Mainn.Dead);								
					}
				});	
		      Mainn.Vdead.setBounds(100, 130, 100, 17);
		      Mainn.Vdead.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Vdead);
				
		      Mainn.Venergycalib.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						  //Venergycalib.setText(Dead);								
					}
				});	
		      Mainn.Venergycalib.setBounds(450, 30, 150, 17);
		      Mainn.Venergycalib.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Venergycalib);
				
		      Mainn.Vshapecalib.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						  //Vshapecalib.setText(Dead);								
					}
				});	
		      Mainn.Vshapecalib.setBounds(450, 50, 150, 17);
		      Mainn.Vshapecalib.setForeground(SystemColor.inactiveCaptionText);
		      Mainn.pan.add(Mainn.Vshapecalib);
				
				JLabel Vlbl = new JLabel(" E=                               +                                *C +                                          *C^2");						
				Vlbl.setBounds(450, 30, 700, 17);
				Vlbl.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Vlbl);
										
				Mainn.Vlbl1.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.Vlbl1.setText(Mainn.cf0S);								
					}
				});	
				Mainn.Vlbl1.setBounds(480, 30, 90, 17);
				Mainn.Vlbl1.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Mainn.Vlbl1);
				
				Mainn.Vlbl2.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.Vlbl2.setText(Mainn.cf1S);								
					}
				});							
				Mainn.Vlbl2.setBounds(600, 30, 90, 17);
				Mainn.pan.add(Mainn.Vlbl2);
				
				Mainn.Vlbl3.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.Vlbl3.setText(Mainn.cf2S);								
					}
				});							
				Mainn.Vlbl3.setBounds(720, 30, 90, 17);
				Mainn.Vlbl3.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Mainn.Vlbl3);
				
				Mainn.VDD.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.VDD.setText(Mainn.DetectorDescription);								
					}
				});	
				Mainn.VDD.setBounds(450, 70, 1000, 17);
				Mainn.VDD.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Mainn.VDD);
				
				Mainn.VSD.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.VSD.setText(Mainn.SampleDescription);								
					}
				});	
				Mainn.VSD.setBounds(450, 90, 1000, 17);
				Mainn.VSD.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Mainn.VSD);
				
				Mainn.VRNG.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();									  
						Mainn.VRNG.setText("From  " +Mainn.offsetofdataS+"   to  "+Mainn.lengthofdataS );								
					}
				});	
				Mainn.VRNG.setBounds(450, 110, 1000, 17);
				Mainn.VRNG.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Mainn.VRNG);
				
				Mainn.lddS = "";
				Mainn.VLDD.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.VLDD.setText(Mainn.lddS);								
					}
				});	
				Mainn.VLDD.setBounds(1150, 30, 220, 17);
				Mainn.VLDD.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Mainn.VLDD);
				
				Mainn.lsdS = "";
				Mainn.VDSD.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						Mainn.pan.repaint();								
						Mainn.VDSD.setText(Mainn.lsdS);								
					}
				});	
				Mainn.VDSD.setBounds(1150, 50, 220, 17);
				Mainn.VDSD.setForeground(SystemColor.inactiveCaptionText);
				Mainn.pan.add(Mainn.VDSD);
			
			
		//----------------for windows of energy calibration--------------------------------------------
			Mainn.textField1 = new TextField(Mainn.cf0S);
			Mainn.textField2 = new TextField(Mainn.cf1S);
			Mainn.textField3 = new TextField(Mainn.cf2S);
			Mainn.textField4 = new TextField("0");
			
	   //----------------for windows of FWHM calibration-----------------------------------------------
			Mainn.textField1f = new TextField(Mainn.cf0SF);
			Mainn.textField2f = new TextField(Mainn.cf1SF);
			
			
			
			Mainn.clik = 0; // for next and previous peak
      //--------------------------------------------------------------------
	}
	
}
