import java.awt.SystemColor;
import java.awt.TextField;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.swing.JLabel;

public class SpcFile {
	
	public static void ReadSpcFile() {
	//---------------Info extracted from spectrum file-------------------
	File file = new File(Mainn.fichier);
	  FileInputStream fis = null;
	try {
		fis = new FileInputStream(file);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  byte [] arr = new byte[(int)file.length()];
	  try {
		fis.read(arr);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	  ByteBuffer bb = ByteBuffer.wrap(arr);
	      bb.order(ByteOrder.LITTLE_ENDIAN);
	      //--------name file----------
	       Mainn.namFile = file.getName();
	      //System.out.println("naaaaaaaame  :  "+namFile);
	      //---------start time--------
	       
	     //-------------------Start time of sample--------------
	       
	     //-------------------HH:MM:SS--------------
		      bb.position(128+16+12);
		      String A3 ="";
		      for(int c=0;c<10;c++) {
		    	  char B3 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B3);  
		    	   A3 = A3 + strVar1 ;  	  
		      }
		      String  HH_MM_SS =  A3;
		      Mainn.StrTime = HH_MM_SS;
		     // System.out.println("HH:MM:SS            : "+HH_MM_SS);
          
        //---------start date--------
		      
		//-------------------DD-MMM-YY*--------------
		      bb.position(128+16);
		      String A2 ="";
		      for(int c=0;c<12;c++) {
		    	  char B2 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B2);  
		    	   A2 = A2 + strVar1 ;  	  
		      }
		      String  DD_MMM_YY =  A2;
		      Mainn.StrDat = DD_MMM_YY;
		      //System.out.println("DD-MMM-YY*            : "+DD_MMM_YY);
	      
	    //---------Real time-----------------------------------------
		      bb.position(128+16+12+10+10);
		      String A5 ="";
		      for(int c=0;c<10;c++) {
		    	  char B5 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B5);  
		    	   A5 = A5 + strVar1 ;  	  
		      }
		      String  Real_Time =  A5;
		      Mainn.realtimS = Real_Time;
		     // System.out.println("Real Time            : "+Real_Time);
	  //---------Live time----------------------------------------------		      
		      bb.position(128+16+12+10);
		      String A4 ="";
		      for(int c=0;c<10;c++) {
		    	  char B4 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B4);  
		    	   A4 = A4 + strVar1 ;  	  
		      }
		      String  Live_Time =  A4;
		      //System.out.println("Live Time            : "+Live_Time);
		      Mainn.livetimS = Live_Time;
	      
	    //---------dead time--------
		     float i4a = Float.parseFloat(Real_Time);
		     float i5a = Float.parseFloat(Live_Time);
	         float  dead =(float) (i4a-i5a)*100/i4a;	
	         String Dead = Float.toString(dead)+" %";
	         Mainn.Dead = Dead;
	     
	      
	    //---------offset of data and length of data--------
	      bb.position(64);
	      Mainn.lengthofdata = bb.getShort();
	      Mainn.lengthofdataS = Short.toString(Mainn.lengthofdata);   // Je dois verifier
		  bb.position(66);
		  Mainn.offsetofdata = bb.getShort();
		  Mainn.offsetofdataS = Short.toString(Mainn.offsetofdata); // Je dois verifier
	      
	    //---------Data of SPECTRUM--------------------------------------------------------------     
		  bb.position(128+16+12+10+10+42+12+8+10+8+128+128+8+12+12+8+1112); 
	      Mainn.tableauEntier= new int[Mainn.lengthofdata-Mainn.offsetofdata];
	      
	      for(int j=0;j<Mainn.lengthofdata-Mainn.offsetofdata;j++) {
	    	  float data = bb.getFloat();
	          int dataa = (int) data;
	    	  Mainn.tableauEntier[j]=dataa; 
	    	  //System.out.println("data :  "+Mainn.tableauEntier[j] );
	    	  
	      }
	      
	  //-------------------First, Second, and Third Energy calibration-----------------------
	      bb.position(128+16+12+10+10+42+12+8+10+8+128+128+8+12); 	      
	      float cf0 = bb.getFloat();
	      Mainn.cf0S = Float.toString(cf0);    
	      float cf1 = bb.getFloat();
	      Mainn.cf1S = Float.toString(cf1);
	      float cf2 = bb.getFloat();
	      Mainn.cf2S = Float.toString(cf2);
	     // String cfS = cf0S+"    "+cf1S+"   "+cf2S;
	     // System.out.println("coficient of calibration energy   :"+cfS );
		      
	 //-------------------First, Second, and Third FWHM----------------------------------
		      bb.position(128+16+12+10+10+42+12+8+10+8+128+128+8+12+12); 
	    	  
	    	  float cf0F = bb.getFloat();
		      Mainn.cf0SF = Float.toString(cf0F);    
		      float cf1F = bb.getFloat();
		      Mainn.cf1SF = Float.toString(cf1F);
		      
	      
	    //-----------------------Detector description--------------	    	
		      bb.position(128+16+12+10+10+42+12+8+10+8+128);
		      String A12 ="";
		      for(int c=0;c<64;c++) {
		    	  char B12 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B12);  
		    	   A12 = A12 + strVar1 ;  	  
		      }
		      String  Detector_Description0 =  A12;
		      //System.out.println("Detector Description 0            : "+Detector_Description0);
		      
		      String A13 ="";
		      for(int c=0;c<64;c++) {
		    	  char B13 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B13);  
		    	   A13 = A13 + strVar1 ;  	  
		      }
		      String  Detector_Description1 =  A13;
		     // System.out.println("Detector Description 1            : "+Detector_Description1);
	    	  
		      Mainn.DetectorDescription = "["+ Detector_Description0+"]"+"    "+"["+ Detector_Description1+"]";
	    
	    //-----------------------Sample description------------------------
		      bb.position(128+16+12+10+10+42+12+8+10+8);
		      String A10 ="";
		      for(int c=0;c<64;c++) {
		    	  char B10 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B10);  
		    	   A10 = A10 + strVar1 ;  	  
		      }
		      String  Sample_Description0 =  A10;
		      //System.out.println("Sample Description 0            : "+Sample_Description0);
		      
		      String A11 ="";
		      for(int c=0;c<64;c++) {
		    	  char B11 =  (char) (bb.get()); 	    	
		    	  String  strVar1 =  Character.toString(B11);  
		    	   A11 = A11 + strVar1 ;  	  
		      }
		      String  Sample_Description1 =  A11;
		      //System.out.println("Sample Description 1           : "+Sample_Description1);
		      Mainn.SampleDescription =  "["+ Sample_Description0+"]"+"    "+"["+ Sample_Description1+"]";
		     
	      
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
				
				JLabel Vlbl = new JLabel(" E=                               +                                  *C +                                          *C^2");						
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
			
	//----------------for windows of FWHM calibration--------------------------------------------
			Mainn.textField1f = new TextField(Mainn.cf0SF);
			Mainn.textField2f = new TextField(Mainn.cf1SF);
			
			
			
			Mainn.clik = 0; // for next and previous peak
    //--------------------------------------------------------------------
	
	
	
	}	
}
