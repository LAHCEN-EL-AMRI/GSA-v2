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

public class ChnFile {
	
	public static void ChnFile() {
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
	      bb.position(6);
	      char s0 =  (char) (bb.get());
	      String s00 = Character.toString(s0);
	      char s1 =  (char) (bb.get());
	      String s11 = Character.toString(s1);
	      //char s2 =  (char) (bb.get());
	      
	      bb.position(24);
	      char s3 =  (char) (bb.get());
	      String s33 = Character.toString(s3);
	      char s4 =  (char) (bb.get());
	      String s44 = Character.toString(s4);
	      //char s5 =  (char) (bb.get());
	      String s55 = ":";
	      char s6 =  (char) (bb.get());
	      String s66 = Character.toString(s6);
	      char s7 =  (char) (bb.get());
	      String s77 = Character.toString(s7);
	      String s22 = ":";
          Mainn.StrTime = s33+s44+s55+s66+s77+s22+s00+s11;
          //System.out.println("starttime   :"+StrTim);
          
        //---------start date--------
          bb.position(16);
	      char sa0 =  (char) (bb.get());
	      String sa00 = Character.toString(sa0);
	      char sa1 =  (char) (bb.get());
	      String sa11 = Character.toString(sa1);
	      char sa2 =  (char) (bb.get());
	      String sa22 = Character.toString(sa2);
	      char sa3 =  (char) (bb.get());
	      String sa33 = Character.toString(sa3);
	      char sa4 =  (char) (bb.get());
	      String sa44 = Character.toString(sa4);
	      char sa5 =  (char) (bb.get());
	      String sa55 = Character.toString(sa5);
	      char sa6 =  (char) (bb.get());
	      String sa66 = Character.toString(sa6);
	      Mainn.StrDat = sa00+sa11+sa22+sa33+sa44+sa55+sa66;
	      //System.out.println("strat date   :"+StrDat);
	      
	    //---------Real and live time--------
	      bb.position(8);
	      float realtim =(float)bb.getInt();
	      float i4a=   ((float)(realtim)/50);
	      Mainn.realtimS = Float.toString(i4a);
	      float livetim =(float)bb.getInt();
	      float i5a=   ((float)(livetim)/50);
	      Mainn.livetimS = Float.toString(i5a);
	      //System.out.println("real time   :"+realtimS);
	      //System.out.println("live time   :"+livetimS );
	      
	    //---------dead time--------
	      float  dead =(float) (i4a-i5a)*100/i4a;	
	      String Dead = Float.toString(dead)+" %";
	      Mainn.Dead = Dead;
	     /* bb.position(23);
	      float dead = (float)bb.getFloat();
	      char prc =  (char) (bb.get());
	      String prctg = Character.toString(prc);
	      Mainn.Dead = Dead;*/
	     // System.out.println("dead   :"+Dead );
	      
	    //---------offset of data and length of data----------------
	      bb.position(28);
	      Mainn.offsetofdata = bb.getShort();
	      Mainn.offsetofdataS = Short.toString(Mainn.offsetofdata);
	      Mainn.lengthofdata = bb.getShort();
	      Mainn.lengthofdataS = Short.toString(Mainn.lengthofdata);
	      //System.out.println("Mainn.offsetofdata   :"+offsetofdataS+"        "+"Mainn.lengthofdata   :"+lengthofdataS );
	      
	    //---------Data of spectrum---------------------------      
	      
	      Mainn.tableauEntier= new int[Mainn.lengthofdata-Mainn.offsetofdata];
	      
	      for(int j=0;j<Mainn.lengthofdata-Mainn.offsetofdata;j++) {
	    	  int data =bb.getInt();
	    	  Mainn.tableauEntier[j]=data; 
	    	  //System.out.println("data :  "+Mainn.tableauEntier[j] );
	    	  
	      }
	      
	    //---------coficient of calibration energy --------------------------  
	      bb.position(32+4*(Mainn.lengthofdata-Mainn.offsetofdata)+4);
	      float cf0 = bb.getFloat();
	      Mainn.cf0S = Float.toString(cf0);
	      float cf1 = bb.getFloat();
	      Mainn.cf1S = Float.toString(cf1);
	      float cf2 = bb.getFloat();
	      Mainn.cf2S = Float.toString(cf2);
	     // String cfS = cf0S+"    "+cf1S+"   "+cf2S;
	     // System.out.println("coficient of calibration energy   :"+cfS );
	      
	    //---------coficient of Peak shape -----------------------------------
	      bb.position(32+4*(Mainn.lengthofdata-Mainn.offsetofdata)+16);
	      float cfp0 = bb.getFloat();
	      Mainn.cfp0S = Float.toString(cfp0);
	      float cfp1 = bb.getFloat();
	      Mainn.cfp1S = Float.toString(cfp1);
	      float cfp2 = bb.getFloat();
	      Mainn.cfp2S = Float.toString(cfp2);
	      //String cfpS = Mainn.cfp0S+"    "+Mainn.cfp1S+"   "+Mainn.cfp2S;
	      //System.out.println("coficient of Peak shape   :"+cfpS );
	      
	      //-------Length of detector description--------------
	      bb.position(32+4*(Mainn.lengthofdata-Mainn.offsetofdata)+256);
	      short ldd =  (short) (bb.get());
	      Mainn.lddS = Float.toString(ldd);
	      //System.out.println("Length of detector description : "+lddS);
	      
	    //-----------------------Detector description--------------
	      bb.position(32+4*(Mainn.lengthofdata-Mainn.offsetofdata)+257);
	      String A ="";
	      for(int b=0;b<63;b++) {
	    	  char B =  (char) (bb.get());     	  
	    	  String  strVar =  Character.toString(B);  
	    	   A = A+ strVar ;  	  
	      }
	      Mainn.DetectorDescription =  A;  
	      //System.out.println("Detector description           : "+DetectorDescription);
	      
	    //-----------------------Length of sample description--------------
	      bb.position(32+4*(Mainn.lengthofdata-Mainn.offsetofdata)+320);
	      short lsd =  (short) (bb.get());
	      Mainn.lsdS = Float.toString(lsd);
	      //System.out.println("Length of sample description : "+lsdS);
	      				      
	      
	    //-----------------------Sample description------------------------
	      bb.position(32+4*(Mainn.lengthofdata-Mainn.offsetofdata)+321);
	      String A1 ="";
	      for(int c=0;c<63;c++) {
	    	  char B1 =  (char) (bb.get()); 	    	
	    	  String  strVar1 =  Character.toString(B1);  
	    	   A1 = A1 + strVar1 ;  	  
	      }
	      Mainn.SampleDescription =  A1;
	      //System.out.println("Sample description            : "+SampleDescription);
	      
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
			
			Mainn.VLDD.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					Mainn.pan.repaint();								
					Mainn.VLDD.setText(Mainn.lddS);								
				}
			});	
			Mainn.VLDD.setBounds(1150, 30, 220, 17);
			Mainn.VLDD.setForeground(SystemColor.inactiveCaptionText);
			Mainn.pan.add(Mainn.VLDD);
			
			Mainn.VDSD.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					Mainn.pan.repaint();								
					Mainn.VDSD.setText(Mainn.lsdS);								
				}
			});	
			Mainn.VDSD.setBounds(1150, 50, 220, 17);
			Mainn.VDSD.setForeground(SystemColor.inactiveCaptionText);
			Mainn.pan.add(Mainn.VDSD);
			
			
			Mainn.textField1 = new TextField(Mainn.cf0S);
			Mainn.textField2 = new TextField(Mainn.cf1S);
			Mainn.textField3 = new TextField(Mainn.cf2S);
			Mainn.textField4 = new TextField("0");
			
			
			Mainn.clik = 0; // for next and previous peak
    //--------------------------------------------------------------------
	
	
	
	}	
}
