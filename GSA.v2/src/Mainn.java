import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.FontMetrics;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;



public class Mainn extends JFrame {
	static short offsetofdata;
    static short lengthofdata;
	static int[] tableauEntier;
    static float mli ;
	private static final long serialVersionUID = 1L;
    static float valuemrker;
		   String fichieCmpr0,fichie,Afp,Afp2,Afp3,Afp4,Afp5,Afpe,Afp2e,Afp3e,Afp4e,Afp5e,Afp6e,txtAC1,txtAC2,AC1,AC2,At1,At2,Afpk,tai0,tai1,pr0,pr1,pr2,pr3,pr4,wid0,A,B,C,D,CM1,CM2,EM1,EM2,Edit1,Edit2,Edit3,EditC1,EditC2,EditC3;
	       String AV,BV,CV,DV;
	static String AfpeF2, Afp2eF2, AfpeF4, Afp2eF4, Afp3eF4;
	static String AfpeF3,Afp2eF3,Afp3eF3,Afp4eF3,Afp5eF3,Afp6eF3;
	static String choiceEchel,peakPosition,forRaport;
	static String forRange,forMrkrAllPeaks;
	static String   fichierCmpr;
	static String fichier,wt,mt,li,lm,tech,k_ecart,As,Bs,Cs,Ds,AC1s,AC2s,At1s,At2s;
	static String Asv1,Bsv1,Csv1,Dsv1;
	static String StrTim;
	static String namFile,StrTime,StrDat,realtimS,livetimS,Dead,offsetofdataS,lengthofdataS,cf0S,cf1S,cf2S,cf0SF,cf1SF,cfp0S,cfp1S,cfp2S,lddS,DetectorDescription,lsdS,SampleDescription;
	static String analyse=null;
	static String evitErrRaprt=null;
	static String pthLib;
	static String filePath1, KeyDetector ;
	static String filenameEfficien, filenameEfficienF2,filenameEfficienF3, filenameEfficienF4;
	static String filenameDegre,filenameDegreF3;
	static String formula;
	static JTextField textField1tpw;
	static TextField textFieldcali1;
	static TextField textFieldcali2;
	static JTextField fieldIdentif1;
	static JTextField fieldIdentif2;
	static TextField textField1,textField2,textField3,textField4,textField1f,textField2f,textFieldM1,textFieldM2,textFieldM3,textFieldM4,textFieldM11,textFieldM22,textFieldM33,textFieldM44;
	static TextField textField1tpe,textField2tpe, textField3tpe, textField4tpe, textField5tpe, textField6tpe;
	static TextField textField1tpeF2,textField2tpeF2;
	static TextField textField1tpeF3,textField2tpeF3, textField3tpeF3, textField4tpeF3, textField5tpeF3, textField6tpeF3;
	static TextField textField1tpeF4,textField2tpeF4, textField3tpeF4;
	static JPanel subPanel, pnm1, pnm1F2;
	static JPanel contentPane;
	static JPanel panel;
	static JPanel panelV;
	static JPanel pan;
	static JPanel panelPeaks;
	static JPanel pan2;	
	static JRadioButtonMenuItem rdbtnmntmView,rdbtnmntmView_1,rdbtnmntmView_4,rdbtnmntmView_2,rdbtnmntmView_3,rdbtnmntmView_5;
	static JCheckBoxMenuItem mntmEfficiencyCalibration, mntmEfficiencyCalibration1, mntmEfficiencyCalibration2, mntmEfficiencyCalibration3 ;
	private JSplitPane split;
	static int clik = 0,firstenter;
	private JTextField textField;
	static JButton viewPeakNext;
	static JLabel Vfilename;
	static JLabel Vstart;
	static JLabel Vstartd;
	static JLabel Vreal;   
	static JLabel Vlive;
	static JLabel Vdead;
	static JLabel Venergycalib;
	static JLabel Vshapecalib;
	static JLabel Vlbl1;
	static JLabel Vlbl2;
	static JLabel Vlbl3;
	static JLabel VDD;
	static JLabel VSD;
	static JLabel VRNG;
	static JLabel VLDD;
	static JLabel VDSD;
	static JLabel Vchannel;
	static JLabel Venrg;
	static JLabel Vaer;
	static JLabel VFHM;
	static JLabel VERe;
	static JLabel Vnucleid;
	static JLabel VActivity;
	static JLabel VENRG;
	static JLabel Vintensity;
	static JLabel VHilfelife;
	static JMenuItem mntmPeakSearch;
	static ArrayList<String> radinucleidNuc;
	static ArrayList<String> nucleidEnergyNuc;
	static ArrayList<String> nucIntensityNuc;   
    static ArrayList<String> hilflifeNuc;
    static ArrayList<String> ActivityTableau;
    static ArrayList<String> ActivityErrorTableau;
    
    static int savedValue, savedValueDegree, savedValueF3, savedValueDegreeF3; // Variable pour sauvegarder la valeur du Spinner
    
    
    static JSpinner spinner,spinnerF3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainn frame = new Mainn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Mainn() {
		
		
		filenameDegre="Detectors/degreeOfEquation.txt";
		filenameDegreF3="Detectors/degreeOfEquationF3.txt";
		//Mainn.formula = "Formula1";
		try (BufferedReader brDegre = new BufferedReader(new FileReader(filenameDegre))) {
            String lineDegre = brDegre.readLine(); // Lire la premi�re ligne
            savedValue = Integer.parseInt(lineDegre.trim());
              
        } catch (IOException e) {
            e.printStackTrace(); // Afficher l'erreur d'entr�e/sortie
        }  ;
        
        
        try (BufferedReader brDegreF3 = new BufferedReader(new FileReader(filenameDegreF3))) {
            String lineDegreF3 = brDegreF3.readLine(); // Lire la premi�re ligne
            savedValueF3 = Integer.parseInt(lineDegreF3.trim());
              
        } catch (IOException es) {
            es.printStackTrace(); // Afficher l'erreur d'entr�e/sortie
        }  ;
    

		
		textFieldcali1 = new TextField();
		textFieldcali2 = new TextField();
		Vfilename = new JLabel();
		Vstart = new JLabel();
		Vstartd = new JLabel();
		Vreal = new JLabel();
		Vlive = new JLabel();
		Vdead = new JLabel();
		Venergycalib = new JLabel();
		Vshapecalib = new JLabel();
		Vlbl1 = new JLabel();
		Vlbl2 = new JLabel();
		Vlbl3 = new JLabel();
		VDD = new JLabel();
		VSD = new JLabel();
		VRNG = new JLabel();
		VLDD = new JLabel();
		VDSD = new JLabel();
		Vchannel = new JLabel();
		Venrg = new JLabel();
		Vaer = new JLabel();
		VFHM = new JLabel();
		VERe = new JLabel();
		Vnucleid= new JLabel();
		VActivity= new JLabel();
		VENRG= new JLabel();;
		Vintensity= new JLabel();
		VHilfelife= new JLabel();
			
		pan = new JPanel();
		pan.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {	
				Vfilename.setText("");
				Vstart.setText("");	
				Vstartd.setText("");
				Vlbl1.setText("");
				Vlbl2.setText("");
				Vlbl3.setText("");
				VDD.setText("");
				VSD.setText("");
				VRNG.setText("");
				VLDD.setText("");
				VDSD.setText("");
				
			}
		});	
	    pan.setBackground(Color.LIGHT_GRAY);
	    pan.setMinimumSize(new Dimension(0,0));
	    				
	    
	    pan2 = new JPanel();
		pan2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {	
				Vchannel.setText("");
				Venrg.setText("");
				Vaer.setText("");
				VFHM.setText("");
				VERe.setText("");
				Vnucleid.setText("");
				VActivity.setText("");
				VENRG.setText("");
				Vintensity.setText("");
				VHilfelife.setText("");
				
			}
		});
		   pan2.setBackground(Color.LIGHT_GRAY);
		   pan2.setMinimumSize(new Dimension(0,0));
	    

		setIconImage(Toolkit.getDefaultToolkit().getImage("icons\\image.png"));
		setTitle("  Spectrum treatment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 814, 665);		
		//-------------------barre-Outils-dans-Interface-graphique----------------------------------
		
		JToolBar toolBar = new JToolBar();
		JButton btnSave0 = new JButton( new ImageIcon( "icons\\folder.png" ) );
		btnSave0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
               JFileChooser dialogue = new JFileChooser("example");
				dialogue.setAcceptAllFileFilterUsed(false); 
				dialogue.setDialogTitle("Select file ");
				FileNameExtensionFilter restrict = new FileNameExtensionFilter(".Chn","Chn");
				FileNameExtensionFilter restrict1 = new FileNameExtensionFilter(".Spc","Spc");
				FileNameExtensionFilter restrict3 = new FileNameExtensionFilter(".Spe","Spe");
				FileNameExtensionFilter restrict2 = new FileNameExtensionFilter(".dat","dat");
				FileNameExtensionFilter restrict4 = new FileNameExtensionFilter(".txt","txt");
				dialogue.addChoosableFileFilter(restrict);
				dialogue.addChoosableFileFilter(restrict1);
				dialogue.addChoosableFileFilter(restrict2);
				dialogue.addChoosableFileFilter(restrict3);
				dialogue.addChoosableFileFilter(restrict4);
				if (dialogue.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) {					
					fichie = dialogue.getSelectedFile().getAbsolutePath();									
				  }	
				fichier = fichie;
				
				//---------------read-input-file-Chn----------------------------------------------
				String fileExtension = fichier.substring(fichier.lastIndexOf("."));
				if(fileExtension.equals(".Chn")||fileExtension.equals(".chn")) {ChnFile.ChnFile();}
				if(fileExtension.equals(".Spc")||fileExtension.equals(".spc")) {SpcFile.ReadSpcFile();}
				if(fileExtension.equals(".Spe")||fileExtension.equals(".spe")) {try {SpeFile.ReadSpeFile();} catch (IOException e) {e.printStackTrace();}}
				
				//SpcFile.ReadSpcFile();
				//ChnFile.ChnFile();
				
				//------------------------------------------------------------------
				panel.removeAll();
				forMrkrAllPeaks="AllMrkrLog";//pour afficher tous les marqueur sur le graphe echel Log
				analyse="g2";
				JPanel pnl = new JPanel();
				try {
					pnl = new Loggraph();//Derive(); 
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "enter spectrum file ");
					e2.printStackTrace();
				}  
				
				panel.setLayout(new java.awt.BorderLayout());
				panel.add(pnl);
				panel.validate();	
                  
				
			}
		});
        btnSave0.setToolTipText( "Open spectrum file" );
        toolBar.add( btnSave0 );
        toolBar.addSeparator();
        
        
        JButton LogSpectre = new JButton( new ImageIcon( "icons\\LogSpectre.png" ) );
        LogSpectre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {      		
                panel.removeAll();
                if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					//panel.removeAll();
					forMrkrAllPeaks="AllMrkrLog";//pour afficher tous les marqueurs sur le graphe echel log
					analyse="g2";
					JPanel pnl = new JPanel();
					try {
						pnl = new Loggraph();
					} catch (IOException e2) {
						JOptionPane.showMessageDialog(null, "enter spectrum file ");
						e2.printStackTrace();
					}  
					
					panel.setLayout(new java.awt.BorderLayout());
					panel.add(pnl);
					panel.validate();    
					
        	}		       		
        	}
        });
        LogSpectre.setToolTipText( "Plot the Log spectrum" );
        toolBar.add( LogSpectre );
        toolBar.addSeparator();
        
        
        
        JButton btnSave1 = new JButton( new ImageIcon( "icons\\spectre.png" ) );
        btnSave1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {      		
                panel.removeAll();
                if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
                analyse=null;//pour uitiliser icon de outil sans erreur en cas analyse
                forMrkrAllPeaks="AllMrkrNorml";//pour afficher tous les marqueurs sur le graphe echel Normal
                
				JPanel pn = new JPanel();
				try {
					pn = new Ggraphique(); 
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "enter spectrum file ");
					e2.printStackTrace();
				}  				
				panel.setLayout(new java.awt.BorderLayout());
				panel.add(pn);
				panel.validate();	     	
        	}		       		
        	}
        });
        btnSave1.setToolTipText( "Plot the spectrum" );
        toolBar.add( btnSave1 );
        toolBar.addSeparator();      
                      
        
        
       
        TextArea textArea = new TextArea();  
        JButton btnSave2 = new JButton( new ImageIcon( "icons\\view_data.png" ) );
        btnSave2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {		
           //__________________________________________________________________
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file");}
				else{
				String Ls=System.getProperty("line.separator");
				String dtt,dss,dvv;
				String tss="Channel     Counts"+Ls;				

				      int je=offsetofdata;
			  for(int j=0;j<lengthofdata-offsetofdata;j++) {
				  
				  
				  dvv=je+"                   "+tableauEntier[j]+Ls;
		            tss=tss+dvv; 	
		            je=je+1;
			  }
			  textArea.setText(tss);	
	        
		    	       		
				}	
        	//__________________________________________________________________		
        	}
        });
        btnSave2.setToolTipText( "view file data" );
        toolBar.add( btnSave2 );
        toolBar.addSeparator();
        
        JButton btnSave3 = new JButton( new ImageIcon( "icons\\not_view_data.png" ) );
        btnSave3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					panel.removeAll();
					repaint();
        		    textArea.setText("");
        	}}
        });
        btnSave3.setToolTipText( "Hide file data" );
        toolBar.add( btnSave3 );
        toolBar.addSeparator();
		 
        JButton btnSaveAs = new JButton( new ImageIcon( "icons\\zoom.png" ) );
        btnSaveAs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {      	
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					if(analyse==null){
						double b0m=Ggraphique.domainAxis.getLowerBound();
						double b1m=Ggraphique.domainAxis.getUpperBound();
						Ggraphique.domainAxis.setRange(b0m+(b1m-b0m)/25,b1m-(b1m-b0m)/25);
						analyse=null;
					}else if(analyse=="g"){
						double b0md=treatment1.domainAxis.getLowerBound();
	        		    double b1md=treatment1.domainAxis.getUpperBound();
	        		    treatment1.domainAxis.setRange(b0md+(b1md-b0md)/25,b1md-(b1md-b0md)/25); 	        		
	        		}					
					else if (analyse=="g1"){
					double derScd0=GraphDeriveLissee.domainAxis.getLowerBound();
	        		double derScd1=GraphDeriveLissee.domainAxis.getUpperBound();
	        		GraphDeriveLissee.domainAxis.setRange(derScd0+(derScd1-derScd0)/25,derScd1-(derScd1-derScd0)/25);
					}else if (analyse=="g2"){
						double log0=Loggraph.domainAxis.getLowerBound();
		        		double log1=Loggraph.domainAxis.getUpperBound();
		        		Loggraph.domainAxis.setRange(log0+(log1-log0)/25,log1-(log1-log0)/25);
						}else if (analyse=="g3"){
							double log0=treatmentLog.domainAxis.getLowerBound();
			        		double log1=treatmentLog.domainAxis.getUpperBound();
			        		treatmentLog.domainAxis.setRange(log0+(log1-log0)/25,log1-(log1-log0)/25);
							}else if(analyse=="g4"){
								double b0m=ComparSpectr.domainAxisCmpr.getLowerBound();
								double b1m=ComparSpectr.domainAxisCmpr.getUpperBound();
								ComparSpectr.domainAxisCmpr.setRange(b0m+(b1m-b0m)/25,b1m-(b1m-b0m)/25);
								
							}         		      		        		
				}	       		
        	}
        });
        btnSaveAs.setToolTipText( "Zoom (+)" );
        toolBar.add( btnSaveAs );
        toolBar.addSeparator();
        
        JButton btnNew = new JButton( new ImageIcon( "icons\\zoomm.png") );
        btnNew.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					if(analyse==null){
        		double b0m=Ggraphique.domainAxis.getLowerBound();
        		double b1m=Ggraphique.domainAxis.getUpperBound();        		
        		//rangeAxis.setRange(a0m,a1m+(a1m-a0m)/9);
        		Ggraphique.domainAxis.setRange(b0m-(b1m-b0m)/25,b1m+(b1m-b0m)/25);
        		analyse=null;}else if(analyse=="g"){
        			double b0md=treatment1.domainAxis.getLowerBound();
            		double b1md=treatment1.domainAxis.getUpperBound();        		
            		treatment1.domainAxis.setRange(b0md-(b1md-b0md)/25,b1md+(b1md-b0md)/25);       		
        		   } else if (analyse=="g1"){
					double derScd0=GraphDeriveLissee.domainAxis.getLowerBound();
	        		double derScd1=GraphDeriveLissee.domainAxis.getUpperBound();
	        		GraphDeriveLissee.domainAxis.setRange(derScd0-(derScd1-derScd0)/25,derScd1+(derScd1-derScd0)/25); 
					}else if (analyse=="g2"){
						double log0=Loggraph.domainAxis.getLowerBound();
		        		double log1=Loggraph.domainAxis.getUpperBound();
		        		Loggraph.domainAxis.setRange(log0-(log1-log0)/25,log1+(log1-log0)/25); 
						}else if (analyse=="g3"){
							double log0=treatmentLog.domainAxis.getLowerBound();
			        		double log1=treatmentLog.domainAxis.getUpperBound();
			        		treatmentLog.domainAxis.setRange(log0-(log1-log0)/25,log1+(log1-log0)/25); 
							}else if(analyse=="g4"){
								double b0m=ComparSpectr.domainAxisCmpr.getLowerBound();
								double b1m=ComparSpectr.domainAxisCmpr.getUpperBound();
								ComparSpectr.domainAxisCmpr.setRange(b0m-(b1m-b0m)/25,b1m+(b1m-b0m)/25);
								
							}  						
				}	
        	}
        });
        toolBar.add(btnNew);
        btnNew.setToolTipText( "Zoom(-)" );    
        toolBar.addSeparator();
        
        
        JButton btnleft = new JButton( new ImageIcon( "icons\\left.png") );
        btnleft.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					if(analyse==null){
        		double b0m=Ggraphique.domainAxis.getLowerBound();
        		double b1m=Ggraphique.domainAxis.getUpperBound();        		
        		//rangeAxis.setRange(a0m,a1m+(a1m-a0m)/9);
        		Ggraphique.domainAxis.setRange(b0m+(b1m-b0m)/9,b1m+(b1m-b0m)/9);
        		analyse=null;}else if(analyse=="g"){
        			double b0md=treatment1.domainAxis.getLowerBound();
            		double b1md=treatment1.domainAxis.getUpperBound();        		
            		treatment1.domainAxis.setRange(b0md+(b1md-b0md)/9,b1md+(b1md-b0md)/9);       		
        		   } else if (analyse=="g1"){
					double derScd0=GraphDeriveLissee.domainAxis.getLowerBound();
	        		double derScd1=GraphDeriveLissee.domainAxis.getUpperBound();
	        		GraphDeriveLissee.domainAxis.setRange(derScd0+(derScd1-derScd0)/9,derScd1+(derScd1-derScd0)/9); 
					}else if (analyse=="g2"){
						double log0=Loggraph.domainAxis.getLowerBound();
		        		double log1=Loggraph.domainAxis.getUpperBound();
		        		Loggraph.domainAxis.setRange(log0+(log1-log0)/9,log1+(log1-log0)/9); 
						}else if (analyse=="g3"){
							double log0=treatmentLog.domainAxis.getLowerBound();
			        		double log1=treatmentLog.domainAxis.getUpperBound();
			        		treatmentLog.domainAxis.setRange(log0+(log1-log0)/9,log1+(log1-log0)/9); 
							}else if(analyse=="g4"){
								double b0m=ComparSpectr.domainAxisCmpr.getLowerBound();
								double b1m=ComparSpectr.domainAxisCmpr.getUpperBound();
								ComparSpectr.domainAxisCmpr.setRange(b0m+(b1m-b0m)/25,b1m+(b1m-b0m)/25);
								
							}  						
				}	
        	}
        });
        toolBar.add(btnleft);
        btnleft.setToolTipText( "Left" );    
        toolBar.addSeparator();
        
        
        
        JButton btnRight = new JButton( new ImageIcon( "icons\\right.png") );
        btnRight.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					if(analyse==null){
        		double b0m=Ggraphique.domainAxis.getLowerBound();
        		double b1m=Ggraphique.domainAxis.getUpperBound();        		
        		//rangeAxis.setRange(a0m,a1m+(a1m-a0m)/9);
        		Ggraphique.domainAxis.setRange(b0m-(b1m-b0m)/9,b1m-(b1m-b0m)/9);
        		analyse=null;}else if(analyse=="g"){
        			double b0md=treatment1.domainAxis.getLowerBound();
            		double b1md=treatment1.domainAxis.getUpperBound();        		
            		treatment1.domainAxis.setRange(b0md-(b1md-b0md)/9,b1md-(b1md-b0md)/9);       		
        		   } else if (analyse=="g1"){
					double derScd0=GraphDeriveLissee.domainAxis.getLowerBound();
	        		double derScd1=GraphDeriveLissee.domainAxis.getUpperBound();
	        		GraphDeriveLissee.domainAxis.setRange(derScd0-(derScd1-derScd0)/9,derScd1-(derScd1-derScd0)/9); 
					}else if (analyse=="g2"){
						double log0=Loggraph.domainAxis.getLowerBound();
		        		double log1=Loggraph.domainAxis.getUpperBound();
		        		Loggraph.domainAxis.setRange(log0-(log1-log0)/9,log1-(log1-log0)/9); 
						}else if (analyse=="g3"){
							double log0=treatmentLog.domainAxis.getLowerBound();
			        		double log1=treatmentLog.domainAxis.getUpperBound();
			        		treatmentLog.domainAxis.setRange(log0-(log1-log0)/9,log1-(log1-log0)/9); 
							}else if(analyse=="g4"){
								double b0m=ComparSpectr.domainAxisCmpr.getLowerBound();
								double b1m=ComparSpectr.domainAxisCmpr.getUpperBound();
								ComparSpectr.domainAxisCmpr.setRange(b0m=(b1m-b0m)/25,b1m-(b1m-b0m)/25);
								
							}  						
				}	
        	}
        });
        toolBar.add(btnRight);
        btnRight.setToolTipText( "Right" );    
        toolBar.addSeparator();
        
        
        JButton btnUp = new JButton( new ImageIcon( "icons\\Up.png") );
        btnUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					if(analyse==null){
        		double b0m=Ggraphique.rangeAxis.getLowerBound();
        		double b1m=Ggraphique.rangeAxis.getUpperBound();        		
        		//rangeAxis.setRange(a0m,a1m+(a1m-a0m)/9);
        		Ggraphique.rangeAxis.setRange(b0m,b1m-(b1m-b0m)/9);
        		analyse=null;}else if(analyse=="g"){
        			double b0md=treatment1.rangeAxis.getLowerBound();
            		double b1md=treatment1.rangeAxis.getUpperBound();       		
            		treatment1.rangeAxis.setRange(b0md,b1md-(b1md-b0md)/9);       		
        		   } else if (analyse=="g1"){
					double derScd0=GraphDeriveLissee.rangeAxis.getLowerBound();
	        		double derScd1=GraphDeriveLissee.rangeAxis.getUpperBound();
	        		GraphDeriveLissee.rangeAxis.setRange(derScd0,derScd1-(derScd1-derScd0)/9); 
					}else if (analyse=="g2"){
						double log0=Loggraph.rangeAxis.getLowerBound();
		        		double log1=Loggraph.rangeAxis.getUpperBound();
		        		Loggraph.rangeAxis.setRange(log0,log1-(log1-log0)/9); 
						}else if (analyse=="g3"){
							double log0=treatmentLog.rangeAxis.getLowerBound();
			        		double log1=treatmentLog.rangeAxis.getUpperBound();
			        		treatmentLog.rangeAxis.setRange(log0,log1-(log1-log0)/9); 
							}else if(analyse=="g4"){
								double b0m=ComparSpectr.rangeAxisCmpr.getLowerBound();
								double b1m=ComparSpectr.rangeAxisCmpr.getUpperBound();
								ComparSpectr.rangeAxisCmpr.setRange(b0m,b1m-(b1m-b0m)/9);
								
							}  						
				}	
        	}
        });
        toolBar.add(btnUp);
        btnUp.setToolTipText( "Up" );    
        toolBar.addSeparator();
        
        
        JButton btnDown = new JButton( new ImageIcon( "icons\\down.png") );
        btnDown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					if(analyse==null){
        		double b0m=Ggraphique.rangeAxis.getLowerBound();
        		double b1m=Ggraphique.rangeAxis.getUpperBound();        		
        		//rangeAxis.setRange(a0m,a1m+(a1m-a0m)/9);
        		Ggraphique.rangeAxis.setRange(b0m,b1m+(b1m-b0m)/9);
        		analyse=null;}else if(analyse=="g"){
        			double b0md=treatment1.rangeAxis.getLowerBound();
            		double b1md=treatment1.rangeAxis.getUpperBound();       		
            		treatment1.rangeAxis.setRange(b0md,b1md+(b1md-b0md)/9);       		
        		   } else if (analyse=="g1"){
					double derScd0=GraphDeriveLissee.rangeAxis.getLowerBound();
	        		double derScd1=GraphDeriveLissee.rangeAxis.getUpperBound();
	        		GraphDeriveLissee.rangeAxis.setRange(derScd0,derScd1+(derScd1-derScd0)/9); 
					}else if (analyse=="g2"){
						double log0=Loggraph.rangeAxis.getLowerBound();
		        		double log1=Loggraph.rangeAxis.getUpperBound();
		        		Loggraph.rangeAxis.setRange(log0,log1+(log1-log0)/9); 
						}else if (analyse=="g3"){
							double log0=treatmentLog.rangeAxis.getLowerBound();
			        		double log1=treatmentLog.rangeAxis.getUpperBound();
			        		treatmentLog.rangeAxis.setRange(log0,log1+(log1-log0)/9); 
							}else if(analyse=="g4"){
								double b0m=ComparSpectr.rangeAxisCmpr.getLowerBound();
								double b1m=ComparSpectr.rangeAxisCmpr.getUpperBound();
								ComparSpectr.rangeAxisCmpr.setRange(b0m,b1m+(b1m-b0m)/9);
								
							}  						
				}	
        	}
        });
        toolBar.add(btnDown);
        btnDown.setToolTipText( "Down" );    
        toolBar.addSeparator();
        
        //---------------------------------------------------------------------------
        JButton btnHome = new JButton( new ImageIcon( "icons\\home.png") );
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					if(analyse==null){
						
						Ggraphique.domainAxis.setAutoRange(true);
						Ggraphique.rangeAxis.setAutoRange(true);
						analyse=null;
					}else if(analyse=="g"){
						 
	        		    treatment1.domainAxis.setAutoRange(true);
	        		    treatment1.rangeAxis.setAutoRange(true);
	        		    
	        		}					
					else if (analyse=="g1"){
					
	        		GraphDeriveLissee.domainAxis.setAutoRange(true);
	        		GraphDeriveLissee.rangeAxis.setAutoRange(true);
					}else if (analyse=="g2"){
						
		        		Loggraph.domainAxis.setAutoRange(true);
		        		Loggraph.rangeAxis.setAutoRange(true);
						}else if (analyse=="g3"){
							
			        		treatmentLog.domainAxis.setAutoRange(true);
			        		treatmentLog.rangeAxis.setAutoRange(true);
							}else if (analyse=="g4"){
								
				        		ComparSpectr.domainAxisCmpr.setAutoRange(true);
				        		ComparSpectr.rangeAxisCmpr.setAutoRange(true);
								}           		      		        		
				}
        		
        	}
        });
        toolBar.add(btnHome);
        btnHome.setToolTipText( "home" );    
        toolBar.addSeparator();
        //---------------------------------------------------------------------------
        
        
        
        
        
        JButton btnSave = new JButton( new ImageIcon( "icons\\save.png" ) );
        btnSave.setToolTipText( "Save treatment" );
        toolBar.add( btnSave );
        toolBar.addSeparator();
        
        JButton btnfile = new JButton( new ImageIcon( "icons\\file.png" ) );
        btnfile.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		if(evitErrRaprt==null){JOptionPane.showMessageDialog(null, "first analyze the spectrum");}
				else{
					
        		String fichie0=null;				
                JFileChooser dialogue = new JFileChooser("results");  
                                          dialogue.setDialogTitle("Save report ");
			                             if (dialogue.showSaveDialog(null) ==  JFileChooser.APPROVE_OPTION) {
				
				                                  fichie0 = dialogue.getSelectedFile().getAbsolutePath();
				                                 				
			                               }			
			                           String fichier1 = fichie0;	
			                           
			//____________________________________________________________________________________
			
		    File ff=new File(fichier1); // d�finir l'arborescence
		   	try {
		   		String stta1 =treatment1.resultsfile;
				ff.createNewFile();
				FileWriter ffw = new FileWriter(ff);
			   	String mot00 ="Operator                      : "+Edit1;
			   	//String mot0 ="Centre                        : FSR_CNSETEN";
			   	java.util.Date date = new java.util.Date();
			   	String mot1 ="Date                          :" +date; 
			   	String mot2= "Name of the analyzed file     : "+namFile;  	
				//String mot3= "Spectre nucleaire             : Maroc";
				String cmmt ="Comment                       : "+Edit3;					
				String Newligne=System.getProperty("line.separator"); 
				String resultats=mot00+Newligne+mot1+Newligne+mot2+Newligne+cmmt+Newligne; 
				ffw.write(resultats);
				ffw.write("\n");  				
				ffw.write(stta1);
				 ffw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		   
			//____________________________________________________________________________________		        		      		
				}	
        	}
        });
        btnfile.setToolTipText( "Report file" );
        toolBar.add( btnfile );
        toolBar.addSeparator();
        
        JButton btnprint = new JButton( new ImageIcon( "icons\\print.png" ) );
        btnprint.setToolTipText( "Print report" );
        toolBar.add( btnprint );
        toolBar.addSeparator();       
      //----------------------------------------------------------
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File       ");
		menuBar.add(menu);
		JMenuItem mntmOuvrir = new JMenuItem("Open");
		mntmOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser dialogue = new JFileChooser("example");					
				dialogue.setAcceptAllFileFilterUsed(false); 
				dialogue.setDialogTitle("Select file ");
				FileNameExtensionFilter restrict = new FileNameExtensionFilter(".Chn","Chn");
				FileNameExtensionFilter restrict1 = new FileNameExtensionFilter(".Spc","Spc");
				FileNameExtensionFilter restrict2 = new FileNameExtensionFilter(".Spe","Spe");
				FileNameExtensionFilter restrict3 = new FileNameExtensionFilter(".dat","dat");
				FileNameExtensionFilter restrict4 = new FileNameExtensionFilter(".txt","txt");
				dialogue.addChoosableFileFilter(restrict);
				dialogue.addChoosableFileFilter(restrict1);
				dialogue.addChoosableFileFilter(restrict2);
				dialogue.addChoosableFileFilter(restrict3);
				dialogue.addChoosableFileFilter(restrict4);
				if (dialogue.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) {					
					fichie = dialogue.getSelectedFile().getAbsolutePath();
					
				}
				
				fichier = fichie;
				
				//---------------Info extracted from spectrum file-------------------
				String fileExtension = fichier.substring(fichier.lastIndexOf("."));
				if(fileExtension.equals(".Chn")||fileExtension.equals(".chn")) {ChnFile.ChnFile();}
				if(fileExtension.equals(".Spc")||fileExtension.equals(".spc")) {SpcFile.ReadSpcFile();}
				if(fileExtension.equals(".Spe")||fileExtension.equals(".spe")) {try {SpeFile.ReadSpeFile();} catch (IOException e) {e.printStackTrace();}}
				//ChnFile.ChnFile();
			    //--------------------------------------------------------------------
				
				panel.removeAll();
				forMrkrAllPeaks="AllMrkrLog";//pour afficher tous les marqueur sur le graphe echel Log
				analyse="g2";
				JPanel pnl = new JPanel();
				try {
					pnl = new Loggraph();//Derive(); 
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "enter spectrum file ");
					e2.printStackTrace();
				}  
				
				panel.setLayout(new java.awt.BorderLayout());
				panel.add(pnl);
				panel.validate();	
				
				
				
			}
		});				
		menu.add(mntmOuvrir);
		
		JMenu mnSpectrumView = new JMenu("Spectrum view");
		mnSpectrumView.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(fichier==null){mnSpectrumView.setEnabled(false);}
				else{mnSpectrumView.setEnabled(true);}
			}
		});
		menu.add(mnSpectrumView);
		
		 panel = new JPanel();
		 panel.setBackground(Color.BLACK);
		
		
		JMenuItem mntmLogEchel = new JMenuItem("Log echel");
		mntmLogEchel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				forMrkrAllPeaks="AllMrkrLog";//pour afficher tous les marqueur sur le graphe echel Log
				analyse="g2";
				JPanel pnl = new JPanel();
				try {
					pnl = new Loggraph();//Derive(); 
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "enter spectrum file ");
					e2.printStackTrace();
				}  
				
				panel.setLayout(new java.awt.BorderLayout());
				panel.add(pnl);
				panel.validate();	
				
			}
		});
		mnSpectrumView.add(mntmLogEchel);
		
		JMenuItem mntmNoemalEchel = new JMenuItem("Normal echel");
		mntmNoemalEchel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				analyse=null;
				forMrkrAllPeaks="AllMrkrNorml";//pour afficher tous les marqueur sur le graphe echel Normal
				panel.removeAll();				
				JPanel pn = new JPanel();
				try {
					pn = new Ggraphique(); 
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "enter spectrum file  ");
					e2.printStackTrace();
				} 
				panel.setLayout(new java.awt.BorderLayout());
				panel.add(pn);
				panel.validate();	
				
			}
		});
		mnSpectrumView.add(mntmNoemalEchel);
				
		
		textArea.setFont(new Font("Dialog", Font.BOLD, 12));
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.WHITE);
		
		JMenuItem mntmRemoveEspeceOf = new JMenuItem("Clear the result space");
		mntmRemoveEspeceOf.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmRemoveEspeceOf.setEnabled(false);}
				else{mntmRemoveEspeceOf.setEnabled(true);}	
				
			}
		});
		
		mntmRemoveEspeceOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");	
			}
		});
		
		
		JMenuItem mntmRemoveSpectrumView0 = new JMenuItem("Spectrum data");
		mntmRemoveSpectrumView0.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmRemoveSpectrumView0.setEnabled(false);}
				else{mntmRemoveSpectrumView0.setEnabled(true);}
			}
		});
		
		mntmRemoveSpectrumView0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//__________________________________________________________________
        		
				String Ls=System.getProperty("line.separator");
				String dtt,dss,dvv;
				String tss="Channel     Counts"+Ls;				

				      int je=offsetofdata;
			  for(int j=0;j<lengthofdata-offsetofdata;j++) {
				  
				  
				  dvv=je+"                   "+tableauEntier[j]+Ls;
		            tss=tss+dvv; 	
		            je=je+1;
			  }
			  textArea.setText(tss);	
	        
		    	       		
				}	
        	//__________________________________________________________________								
			
		});				
		menu.add(mntmRemoveSpectrumView0);
		
		JMenuItem mntmRemoveSpectrumView = new JMenuItem("Remove spectrum view");
		mntmRemoveSpectrumView.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmRemoveSpectrumView.setEnabled(false);}
				else{mntmRemoveSpectrumView.setEnabled(true);}
			}
		});
		
		mntmRemoveSpectrumView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				repaint();
			}
		});
		
		
		JMenu mnCompareSpectre = new JMenu("Compare spectre");
		mnCompareSpectre.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mnCompareSpectre.setEnabled(false);}
				else{mnCompareSpectre.setEnabled(true);}
			}
		});	
		menu.add(mnCompareSpectre);
		

		
		JMenuItem mntmLogEchel_2 = new JMenuItem("Log echel");
		mntmLogEchel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				choiceEchel ="Log";
                JFileChooser dialogue = new JFileChooser("example");
				dialogue.setAcceptAllFileFilterUsed(false); 
				dialogue.setDialogTitle("Select file ");
				FileNameExtensionFilter restrict = new FileNameExtensionFilter(".Chn","Chn");
				FileNameExtensionFilter restrict1 = new FileNameExtensionFilter(".Spc","Spc");
				FileNameExtensionFilter restrict2 = new FileNameExtensionFilter(".Spe","Spe");
				FileNameExtensionFilter restrict3 = new FileNameExtensionFilter(".dat","dat");
				FileNameExtensionFilter restrict4 = new FileNameExtensionFilter(".txt","txt");
				dialogue.addChoosableFileFilter(restrict);
				dialogue.addChoosableFileFilter(restrict1);
				dialogue.addChoosableFileFilter(restrict2);
				dialogue.addChoosableFileFilter(restrict3);
				dialogue.addChoosableFileFilter(restrict4);
				if (dialogue.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) {					
					fichieCmpr0 = dialogue.getSelectedFile().getAbsolutePath();									
				  }	
				fichierCmpr = fichieCmpr0;
				
				String fileExtension = fichierCmpr.substring(fichierCmpr.lastIndexOf("."));
				if(fileExtension.equals(".Chn")||fileExtension.equals(".chn")) {comprChnFile.ChnFile();}
				if(fileExtension.equals(".Spc")||fileExtension.equals(".spc")) {comprSpcFile.SpcFile();}
				if(fileExtension.equals(".Spe")||fileExtension.equals(".spe")) {try {comprSpeFile.SpeFile();;} catch (IOException ed) {ed.printStackTrace();}}
				
				
				//comprChnFile.ChnFile();
			
			
         panel.removeAll();
         
         analyse="g4";//pour uitiliser icon de outil sans erreur en cas analyse
         
			JPanel pnCmpr = new JPanel();
			try {
				pnCmpr = new ComparSpectr();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  				
			panel.setLayout(new java.awt.BorderLayout());
			panel.add(pnCmpr);
			panel.validate();
				
				
				
			}
		});
		mnCompareSpectre.add(mntmLogEchel_2);
		
		JMenuItem mntmNormalEchel_1 = new JMenuItem("Normal echel");
		mntmNormalEchel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
	                JFileChooser dialogue = new JFileChooser("example");
					dialogue.setAcceptAllFileFilterUsed(false); 
					dialogue.setDialogTitle("Select file ");
					FileNameExtensionFilter restrict = new FileNameExtensionFilter(".Chn","Chn");
					FileNameExtensionFilter restrict1 = new FileNameExtensionFilter(" .Spc","Spc");
					FileNameExtensionFilter restrict2 = new FileNameExtensionFilter(" .Spe","Spe");
					FileNameExtensionFilter restrict3 = new FileNameExtensionFilter(".dat","dat");
					FileNameExtensionFilter restrict4 = new FileNameExtensionFilter(".txt","txt");
					dialogue.addChoosableFileFilter(restrict);
					dialogue.addChoosableFileFilter(restrict1);
					dialogue.addChoosableFileFilter(restrict2);
					dialogue.addChoosableFileFilter(restrict3);	
					dialogue.addChoosableFileFilter(restrict4);
					if (dialogue.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) {					
						fichieCmpr0 = dialogue.getSelectedFile().getAbsolutePath();									
					  }	
					fichierCmpr = fichieCmpr0;
					
					String fileExtension = fichierCmpr.substring(fichierCmpr.lastIndexOf("."));
					if(fileExtension.equals(".Chn")||fileExtension.equals(".chn")) {comprChnFile.ChnFile();}
					if(fileExtension.equals(".Spc")||fileExtension.equals(".spc")) {comprSpcFile.SpcFile();}
					if(fileExtension.equals(".Spe")||fileExtension.equals(".spe")) {try {comprSpeFile.SpeFile();;} catch (IOException ed) {ed.printStackTrace();}}
					
					
					//comprChnFile.ChnFile();
				
             panel.removeAll();
             
             analyse="g4";//pour uitiliser icon de outil sans erreur en cas analyse
             
				JPanel pnCmpr = new JPanel();
				try {
					pnCmpr = new ComparSpectr();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  				
				panel.setLayout(new java.awt.BorderLayout());
				panel.add(pnCmpr);
				panel.validate();	
				
			}
		});
		mnCompareSpectre.add(mntmNormalEchel_1);
		
		menu.add(mntmRemoveSpectrumView);
		menu.add(mntmRemoveEspeceOf);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(mntmExit);
		
		JMenu mnCalibration = new JMenu("Calibration  ");
		menuBar.add(mnCalibration);
		

		
		textFieldM1 = new TextField("0");
		textFieldM2 = new TextField("0");
		textFieldM3 = new TextField("0");
		textFieldM4 = new TextField("0");
		
		textFieldM11 = new TextField("0");
		textFieldM22 = new TextField("0");
		textFieldM33 = new TextField("0");
		textFieldM44 = new TextField("0");
		
		textFieldM1.setText("0");
	    textFieldM11.setText("0");					    
	    textFieldM2.setText("0");
	    textFieldM22.setText("0"); 		
		
		JMenuItem mntmEnergyCalibration = new JMenuItem("Energy calibration");
		mntmEnergyCalibration.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmEnergyCalibration.setEnabled(false);}
				else{mntmEnergyCalibration.setEnabled(true);}	
			}
		});
		
		mntmEnergyCalibration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JDialog frame0 = new JDialog((Frame)null, "Energy calibration", true);
				
				JPanel panel1=new JPanel();
				panel1.setBounds(191, 23, 230, 153);
				panel1.setLayout(null);
				frame0.getContentPane().add(panel1);
				
				JLabel lblA_11 = new JLabel(" E=  a + b*Ca + c*Ca^2 + d*Ca^3");
				//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_11.setBounds(23, 11, 250, 17);
				panel1.add(lblA_11);
				
				JLabel lblA_12 = new JLabel("* a =");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_12.setBounds(23, 35, 46, 17);
				panel1.add(lblA_12);
				
				//TextField textField1 = new TextField("18.883");
				textField1.setBounds(100, 35, 86, 20);				
				panel1.add(textField1);
				
				JLabel lblA_13 = new JLabel("* b =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_13.setBounds(23, 57, 46, 17);
				panel1.add(lblA_13);
				
				//TextField textField2 = new TextField("0.493");
				textField2.setBounds(100, 55, 86, 20);				
				panel1.add(textField2);
				
				JLabel lblA_14 = new JLabel("  c =");
				//lblA_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_14.setBounds(23, 80, 46, 17);
				panel1.add(lblA_14);
				
				//TextField textField3 = new TextField("0");
				textField3.setBounds(100, 80, 86, 20);				
				panel1.add(textField3);
				
				JLabel lblA_15 = new JLabel("  d =");
				//lblA_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_15.setBounds(23, 105, 46, 17);
				panel1.add(lblA_15);
				
				//TextField textField4 = new TextField("0");
				textField4.setBounds(100, 105, 86, 20);				
				panel1.add(textField4);
				
				AV =textField1.getText();					    
			   // textField1.setText(AV);
			    
			    
			    BV =textField2.getText();					    
			    //textField2.setText(BV);
			    
			    CV =textField3.getText();					    
			    //textField3.setText(CV);
			    
			    DV =textField4.getText();					    
			    //textField4.setText(DV);
				
				JButton btnOk = new JButton(" OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						A =textField1.getText();					    
					    textField1.setText(A);
					    
					    B =textField2.getText();					    
					    textField2.setText(B);
					    
					    C =textField3.getText();					    
					    textField3.setText(C);
					    
					    D =textField4.getText();					    
					    textField4.setText(D);
						
						frame0.dispose();
					    
					}
				});
				btnOk.setBounds(100, 164, 70, 20);
				panel1.add(btnOk);
				
				JButton btnOk1 = new JButton("Cancel");
				btnOk1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    				    
					    textField1.setText(AV);
					  				    
					    textField2.setText(BV);
					    					    
					    textField3.setText(CV);
					   				    
					    textField4.setText(DV);
						frame0.dispose();	
		   
					}
				});
				btnOk1.setBounds(220, 164, 95, 20);
				panel1.add(btnOk1);
				
				JButton mdf = new JButton("Channel_energy Modification");
				mdf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						JDialog frameM = new JDialog((Frame)null, "Edit ", true); 	
						JPanel panelM=new JPanel();
						panelM.setBounds(191, 23, 230, 153);
						panelM.setLayout(null);
						frameM.getContentPane().add(panelM);
						
						JLabel lblAM = new JLabel("Channel ");
						//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblAM.setBounds(50, 10, 50, 17);
						panelM.add(lblAM);
						
						JLabel lblAM1 = new JLabel("Energy(Kev) ");
						//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblAM1.setBounds(200, 10, 80, 17);
						panelM.add(lblAM1);
						
						
						JLabel lblAMT1 = new JLabel(" *");
						//lblAMT1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblAMT1.setForeground(Color.RED);
						//lblAMT1.setToolTipText( lblAMT1.getText() );
						lblAMT1.setBounds(20, 35, 10, 17);						
						panelM.add(lblAMT1);
						
						//TextField textField1 = new TextField("18.883");
						textFieldM1.setBounds(50, 35, 86, 20);				
						panelM.add(textFieldM1);
						
						JLabel lblAMT2 = new JLabel(" *");
						//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblAMT2.setForeground(Color.RED);
						lblAMT2.setBounds(20, 57, 10, 17);
						panelM.add(lblAMT2);
						
						//TextField textField2 = new TextField("0.493");
						textFieldM2.setBounds(50, 55, 86, 20);				
						panelM.add(textFieldM2);
						
						
						//TextField textField3 = new TextField("0");
						textFieldM3.setBounds(50, 80, 86, 20);				
						panelM.add(textFieldM3);
					
						//TextField textField4 = new TextField("0");
						textFieldM4.setBounds(50, 105, 86, 20);				
						panelM.add(textFieldM4);
						
						JLabel lblAMT11 = new JLabel(" *");
						//lblAMT1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblAMT11.setForeground(Color.RED);						
						lblAMT11.setBounds(180, 35, 10, 17);						
						panelM.add(lblAMT11);
						
						//TextField textField1 = new TextField("18.883");
						textFieldM11.setBounds(200, 35, 86, 20);				
						panelM.add(textFieldM11);
						
						JLabel lblAMT22 = new JLabel(" *");
						//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblAMT22.setForeground(Color.RED);
						lblAMT22.setBounds(180, 57, 10, 17);
						panelM.add(lblAMT22);
						
						//TextField textField2 = new TextField("0.493");
						textFieldM22.setBounds(200, 55, 86, 20);				
						panelM.add(textFieldM22);
						
						//TextField textField3 = new TextField("0");
						textFieldM33.setBounds(200, 80, 86, 20);				
						panelM.add(textFieldM33);
					
						//TextField textField4 = new TextField("0");
						textFieldM44.setBounds(200, 105, 86, 20);				
						panelM.add(textFieldM44);
						
						JButton btnnOk = new JButton(" OK");
						btnnOk.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								CM1 =textFieldM1.getText();	
								Float NC1=Float.parseFloat(CM1);
							   
							    CM2 =textFieldM2.getText();	
							    Float NC2=Float.parseFloat(CM2);
							    
							    EM1 =textFieldM11.getText();
							    Float NE1=Float.parseFloat(EM1);
							   // textField1.setText(EM1);
							    
							    EM2 =textFieldM22.getText();
							    Float NE2=Float.parseFloat(EM2);
							   // textFieldM22.setText(EM2);
							if( (NE1!=0) && (NC1!=0) && (NE2!=0)){
							    Float b=(NE1-NE2)/(NC1-NC2);
							    Float a= NE2-b*NC2;
							    String Sa = Float.toString(a);
							    String Sb = Float.toString(b);
							    textField1.setText(Sa);
							    textField2.setText(Sb);
							    frameM.dispose();
							    
							  } else {JOptionPane.showMessageDialog(null, "enter the channel number and its corresponding energy ");}
							    
							}
						});
						btnnOk.setBounds(90, 154, 70, 20);
						panelM.add(btnnOk);
						
						JButton btnOk1A = new JButton("Cancel");
						btnOk1A.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
			 			    
								 frameM.dispose();	
				   
							}
						});
						btnOk1A.setBounds(180, 154, 100, 20);
						panelM.add(btnOk1A);						
						frameM.dispose();
						frameM.setSize(400,250);
						frameM.setLocation(150, 100);
						frameM.setResizable(false);
						frameM.setVisible(true);
		   
					}
				});
				mdf.setBounds(100, 132, 215, 20);
				panel1.add(mdf);
				
				JButton visualize = new JButton("Visualise");
				visualize.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						Asv1=textField1.getText(); // a de energie
					    Bsv1=textField2.getText(); // b de energie
					    Csv1=textField3.getText(); // c de energie
					    Dsv1=textField4.getText(); // d de energie
						JDialog frameV = new JDialog((Frame)null, "Visualise", true);						
						panelV=new JPanel();
						panelV.setBounds(100, 130, 450, 253);
						panelV.setLayout(null);
						frameV.getContentPane().add(panelV);
					
						panelV.removeAll();
						
						JPanel pnV = new JPanel();
						try {
							pnV = new VisualiseEnergie(); 
						} catch (IOException ev) {
							JOptionPane.showMessageDialog(null, "enter spectrum file ");
							ev.printStackTrace();
						} 
					
						panelV.setLayout(new java.awt.BorderLayout());
						panelV.add(pnV);
						panelV.validate();	
						
						frameV.dispose();
						frameV.setSize(panelV.getWidth(), panelV.getHeight());
						frameV.setLocation(panelV.getWidth(), panelV.getHeight());
						frameV.setResizable(true);
						frameV.setVisible(true);
						
					}
				});
				visualize.setBounds(220, 45, 95, 20);
				panel1.add(visualize);
				
				JButton inialize = new JButton("inialize");
				inialize.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						textField1.setText(cf0S);
					    textField2.setText(cf1S);
					    textField3.setText(cf2S);
					    textField4.setText("0");
					    
					    textFieldM1.setText("424");
					    textFieldM11.setText("227.915");					    
					    textFieldM2.setText("1529");
					    textFieldM22.setText("772.68");
					    textFieldM3.setText("0");
					    textFieldM33.setText("0");					    
					    textFieldM4.setText("0");
					    textFieldM44.setText("0");
					   
					}
				});
				inialize.setBounds(220, 80, 95, 20);
				panel1.add(inialize);
				
				frame0.setSize(350,250);
				frame0.setResizable(false);
				frame0.setVisible(true);
				
			}
		});
		mnCalibration.add(mntmEnergyCalibration);
		
		//__________________________________________________________________________________
		//-------en cas le fichier entr� n'a pas les infos de calibration
		textField1 = new TextField("18.883");
		textField2 = new TextField("0.493");
		textField3 = new TextField("0");
		textField4 = new TextField("0");
		
		textField1f = new TextField("0.731");
		textField2f = new TextField("0.038");
		
		JMenuItem mntmFwhmCalibration = new JMenuItem("FWHM calibration");
		mntmFwhmCalibration.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmFwhmCalibration.setEnabled(false);}
				else{mntmFwhmCalibration.setEnabled(true);}
			}
		});
		
		mntmFwhmCalibration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog frame1f = new JDialog((Frame)null, "FWHM calibration", true);				
				JPanel panel1f=new JPanel();
				panel1f.setBounds(191, 23, 230, 153);
				panel1f.setLayout(null);
				frame1f.getContentPane().add(panel1f);
				
				JLabel lblA_11f = new JLabel(" FWHM=  a + b*E^(1/2) ");
				//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_11f.setBounds(23, 11, 250, 17);
				panel1f.add(lblA_11f);
				
				JLabel lblA_12f = new JLabel("  a =");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_12f.setBounds(23, 35, 46, 17);
				panel1f.add(lblA_12f);
				
				//TextField textField1f = new TextField("0.731");
				textField1f.setBounds(100, 35, 86, 20);				
				panel1f.add(textField1f);
				
				JLabel lblA_13f = new JLabel("  b =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_13f.setBounds(23, 57, 46, 17);
				panel1f.add(lblA_13f);
				
				//TextField textField2f = new TextField("0.038");
				textField2f.setBounds(100, 55, 86, 20);				
				panel1f.add(textField2f);
				
				txtAC1=textField1f.getText();
				txtAC2=textField2f.getText();
				
				
				JButton btnOkf = new JButton(" OK");
				btnOkf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						AC1 =textField1f.getText();					    
					    textField1f.setText(AC1);
					    
					    AC2 =textField2f.getText();					    
					    textField2f.setText(AC2);
					    
					    frame1f.dispose();
					}
				});
				btnOkf.setBounds(100, 134, 70, 23);
				panel1f.add(btnOkf);
				
				JButton btnOk1f = new JButton("Cancel");
				btnOk1f.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						textField1f.setText(txtAC1);
						textField2f.setText(txtAC2);
						 frame1f.dispose();	
		   
					}
				});
				btnOk1f.setBounds(200, 134, 100, 23);
				panel1f.add(btnOk1f);
				
				
				frame1f.setSize(350,250);
				frame1f.setResizable(false);
				frame1f.setVisible(true);
				
			}
		});
		mnCalibration.add(mntmFwhmCalibration);
		
		TextField textField1t = new TextField("0.9833");
		TextField textField2t = new TextField("0.0004197");
		
		JMenuItem mntmTailCalibration = new JMenuItem("Tail calibration");
		mntmTailCalibration.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmTailCalibration.setEnabled(false);}
				else{mntmTailCalibration.setEnabled(true);}
			}
		});
		
		mntmTailCalibration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog frame1t = new JDialog((Frame)null, "Tail calibration", true);
				
				JPanel panel1t=new JPanel();
				panel1t.setBounds(191, 23, 230, 153);
				panel1t.setLayout(null);
				frame1t.getContentPane().add(panel1t);
				
				JLabel lblA_11t = new JLabel(" Tail=  a + b*E ");
				//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_11t.setBounds(23, 11, 250, 17);
				panel1t.add(lblA_11t);
				
				JLabel lblA_12t = new JLabel("  a =");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_12t.setBounds(23, 35, 46, 17);
				panel1t.add(lblA_12t);
				
				//TextField textField1t = new TextField("0.98");
				textField1t.setBounds(100, 35, 86, 20);				
				panel1t.add(textField1t);
				
				JLabel lblA_13t = new JLabel("  b =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_13t.setBounds(23, 57, 46, 17);
				panel1t.add(lblA_13t);
				
				//TextField textField2t = new TextField("0.00042");
				textField2t.setBounds(100, 55, 86, 20);				
				panel1t.add(textField2t);
				
				tai0 =textField1t.getText();	
				tai1 =textField2t.getText();	
				
				JButton btnOkt = new JButton(" OK");
				btnOkt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						At1 =textField1t.getText();					    
					    textField1t.setText(At1);
					    
					    At2 =textField2t.getText();					    
					    textField2t.setText(At2);
					    
					    frame1t.dispose();
					}
				});
				btnOkt.setBounds(100, 134, 70, 23);
				panel1t.add(btnOkt);
				
				JButton btnOk1t = new JButton("Cancel");
				btnOk1t.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						textField1t.setText(tai0);
						textField2t.setText(tai1);
						 frame1t.dispose();	
		   
					}
				});
				btnOk1t.setBounds(200, 134, 100, 23);
				panel1t.add(btnOk1t);
				
				frame1t.setSize(350,250);
				frame1t.setResizable(false);
				frame1t.setVisible(true);
				
			}
		});
		mnCalibration.add(mntmTailCalibration);
		
		 textField1tpe = new TextField("0");
		 textField2tpe = new TextField("0");
		 textField3tpe = new TextField("0");
		 textField4tpe = new TextField("0");
		 textField5tpe = new TextField("0");
		 textField6tpe = new TextField("0");
		
		Afpe =textField1tpe.getText();					    
	    Afp2e =textField2tpe.getText();					    
	    Afp3e =textField3tpe.getText();					    
	    Afp4e =textField4tpe.getText();					    
	    Afp5e =textField5tpe.getText();					    	    
	    Afp6e =textField6tpe.getText();	
	    
	    textField1tpeF2 = new TextField("0");
		textField2tpeF2 = new TextField("0");
		 
		 AfpeF2 =textField1tpeF2.getText();					    
		 Afp2eF2 =textField2tpeF2.getText();
		 
		 
		 textField1tpeF3 = new TextField("0");
		 textField2tpeF3 = new TextField("0");
		 textField3tpeF3 = new TextField("0");
		 textField4tpeF3 = new TextField("0");
		 textField5tpeF3 = new TextField("0");
		 textField6tpeF3 = new TextField("0");
		
		AfpeF3 =textField1tpeF3.getText();					    
	    Afp2eF3 =textField2tpeF3.getText();					    
	    Afp3eF3 =textField3tpeF3.getText();					    
	    Afp4eF3 =textField4tpeF3.getText();					    
	    Afp5eF3 =textField5tpeF3.getText();					    	    
	    Afp6eF3 =textField6tpeF3.getText();	
		 
		 
		 textField1tpeF4 = new TextField("0");
		 textField2tpeF4 = new TextField("0");
		 textField3tpeF4 = new TextField("0");
			 
		 AfpeF4 =textField1tpeF4.getText();					    
		 Afp2eF4 =textField2tpeF4.getText();
		 Afp3eF4 =textField3tpeF4.getText();
		 
		 
	    
	    JMenu mntmNewMenuItem = new JMenu("Efficiency calibration");
	    mntmNewMenuItem.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmNewMenuItem.setEnabled(false);}
				else{mntmNewMenuItem.setEnabled(true);}
			}
		});
		
		
	    
		mnCalibration.add(mntmNewMenuItem);
		
		mntmEfficiencyCalibration = new JCheckBoxMenuItem("By : ln(eff)= a + b*ln(E) + c*ln(E)^2 + ..... + f*ln(E)^n ");
		mntmEfficiencyCalibration.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmEfficiencyCalibration.setEnabled(false);}
				else{mntmEfficiencyCalibration.setEnabled(true);}//Pour apparaitre "Efficiency calibration" doit changer false par true
			}
		});
		
		
		mntmEfficiencyCalibration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JDialog eff = new JDialog((Frame)null, "Efficiency calibration", true);
				eff.getContentPane().setLayout(null);
				
				JPanel panelDetector=new JPanel();
				panelDetector.setBackground(Color.LIGHT_GRAY); // Gris clair
				//panelDetector.setBackground(Color.GRAY);
				panelDetector.setBounds(5, 0, 110, 600);
				panelDetector.setLayout(null);
				eff.getContentPane().add(panelDetector);
				
				 
				
			    JPanel panel1tpe=new JPanel();
			    panel1tpe.setBackground(Color.LIGHT_GRAY); // Gris clair
				panel1tpe.setBounds(120, 0, 500, 600);
				panel1tpe.setLayout(null);
				eff.getContentPane().add(panel1tpe);
				
				
				
				JLabel  samplename = new JLabel(" sample name :  ");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				samplename.setBounds(23, 35, 100, 17);
				panel1tpe.add(samplename); 
				
				TextField textFieldsamplename = new TextField(" ");
				textFieldsamplename.setBounds(170, 35, 150, 17);				
				panel1tpe.add(textFieldsamplename);
				
				
				JLabel  position = new JLabel(" position      :  ");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				position.setBounds(23, 65, 100, 17);
				panel1tpe.add(position); 
				
				TextField textFieldPosition = new TextField(" ");
				textFieldPosition.setBounds(170, 65, 150, 17);				
				panel1tpe.add(textFieldPosition);
				
				JLabel  otherinfo = new JLabel(" Other info    :  ");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				otherinfo.setBounds(23, 95, 100, 17);
				panel1tpe.add(otherinfo); 
				
				TextArea textareainfos = new TextArea("   ");
				textareainfos.setBounds(170, 95, 250, 200);				
				panel1tpe.add(textareainfos);
				
				JButton showTableButton = new JButton("Select the calibration nuclides");
		        showTableButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	
		            	EfficiencyTable dialog = new EfficiencyTable(eff);  // Remplacez parentFrame par le nom de votre fen�tre principale
		                dialog.setAlwaysOnTop(true);  // Assure que la fen�tre appara�t en avant
		                dialog.setVisible(true);      // Affiche la bo�te de dialogue
		            }
		        });
		        showTableButton.setBounds(23, 310, 250, 22);		        
		        panel1tpe.add(showTableButton, BorderLayout.SOUTH);
		        
		        JLabel DegreeN = new JLabel("Degree of the equation n =");
				//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		        DegreeN.setBounds(280, 310, 160, 22);
		        DegreeN.setForeground(Color.BLUE);
				panel1tpe.add(DegreeN);
		        
				
		     // Cr�er un JSpinner pour les valeurs de 2 � 5
		        SpinnerModel model = new SpinnerNumberModel(savedValue, 1, 5, 1); // Valeur initiale, min, max, pas
		        spinner = new JSpinner(model);
		        spinner.setBounds(450, 310, 50, 22);
		        spinner.setForeground(Color.BLUE);
		        JFormattedTextField txt = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		        txt.setForeground(Color.BLUE);
		        panel1tpe.add(spinner);
		        
				
				
				JLabel lblA_11tpe = new JLabel("ln(eff)= a + b*ln(E) + c*ln(E)^2 + ..... + f*ln(E)^n ");
				//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_11tpe.setBounds(23, 11+330, 380, 17);
				lblA_11tpe.setForeground(Color.BLUE);
				panel1tpe.add(lblA_11tpe);
				
				JLabel lblA_12tpe = new JLabel("  a =");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_12tpe.setBounds(23, 35+360, 46, 17);
				panel1tpe.add(lblA_12tpe);
				
				//TextField textField1tp = new TextField("1");
				textField1tpe.setBounds(75, 35+360, 56, 20);				
				panel1tpe.add(textField1tpe);
				
				JLabel lblA_13tpe = new JLabel("  b =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_13tpe.setBounds(23, 57+360, 46, 17);
				panel1tpe.add(lblA_13tpe);
				
				//TextField textField2tp = new TextField("3");
				textField2tpe.setBounds(75, 55+360, 56, 20);				
				panel1tpe.add(textField2tpe);
				
				JLabel lblA_14tpe = new JLabel("  c =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_14tpe.setBounds(23, 80+360, 46, 17);
				panel1tpe.add(lblA_14tpe);
				
				//TextField textField3tp = new TextField("1");
				textField3tpe.setBounds(75, 80+360, 56, 20);				
				panel1tpe.add(textField3tpe);
				
				JLabel lblA_15tpe = new JLabel("  d =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_15tpe.setBounds(23, 105+360, 46, 17);
				panel1tpe.add(lblA_15tpe);
				
				//TextField textField4tp = new TextField("1");
				textField4tpe.setBounds(75, 105+360, 56, 20);				
				panel1tpe.add(textField4tpe);
				
				JLabel lblA_16tpe = new JLabel("  e =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_16tpe.setBounds(23, 130+360, 46, 17);
				panel1tpe.add(lblA_16tpe);
				
				//TextField textField5tp = new TextField("20");
				textField5tpe.setBounds(75, 130+360, 56, 20);				
				panel1tpe.add(textField5tpe);
				
				JLabel lblA_17tpe = new JLabel("  f =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_17tpe.setBounds(23, 155+360, 46, 17);
				panel1tpe.add(lblA_17tpe);
				
				//TextField textField5tp = new TextField("20");
				textField6tpe.setBounds(75, 155+360, 56, 20);				
				panel1tpe.add(textField6tpe);
				
				
				Color defaultColor = UIManager.getColor("Button.background");
				
				
				JButton detector1 = new JButton("Det01(Cal1)");
				JButton detector2 = new JButton("Det01(Cal2)");
				JButton detector3 = new JButton("Det01(Cal3)");
				JButton detector4 = new JButton("Det01(Cal4)");
				JButton detector5 = new JButton("Det01(Cal4)");
				JButton save1 = new JButton(" save");
				
				Mainn.mntmEfficiencyCalibration.setSelected(false);
				if(Mainn.formula.equals("Formula1")) {Mainn.mntmEfficiencyCalibration.setSelected(true);}
				
				
				//--------------pour sauvegarder infos de detecteur en premier ouvertir de logiciel---
				
			       try (BufferedReader reader = new BufferedReader(new FileReader("Detectors\\save.txt"))) {
			    	    KeyDetector = reader.readLine();
			    	   if(KeyDetector.equals("Detector1")) { 
			        	   SwingUtilities.invokeLater(() -> detector1.doClick());
			             } else if(KeyDetector.equals("Detector2")) { 
			        	   SwingUtilities.invokeLater(() -> detector2.doClick());
			             } else if(KeyDetector.equals("Detector3")) { 
			        	   SwingUtilities.invokeLater(() -> detector3.doClick());
			             } else if(KeyDetector.equals("Detector4")) { 
			        	   SwingUtilities.invokeLater(() -> detector4.doClick());
			             } else if(KeyDetector.equals("Detector5")) { 
			        	   SwingUtilities.invokeLater(() -> detector5.doClick());
			             } else {
			            	 SwingUtilities.invokeLater(() -> detector1.doClick());
			             };
			             
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				
			       subPanel = new JPanel();
				
				

				//--------------------Detector1-----------------
			    
				detector1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Mainn.filenameEfficien="Detectors/Efficiency1.txt"; 
						KeyDetector = "Detector1";
												
						filePath1= "Detectors\\Detector1.txt";
					    
					
						detector1.setBackground(Color.BLUE); 
						detector2.setBackground(defaultColor);
						detector3.setBackground(defaultColor);
						detector4.setBackground(defaultColor);
						detector5.setBackground(defaultColor);
						save1.setBackground(defaultColor);
						
						
						//---------Supprimer le contenu du fichier et �crire la valeur du Spinner(degre de equation)
		                try (PrintWriter writer = new PrintWriter(new FileWriter(Mainn.filenameDegre))) {
		                    // �crire la valeur du Spinner dans le fichier
		                    writer.println(Mainn.spinner.getValue());
		                    writer.flush(); // S'assurer que toutes les donn�es sont �crites
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		                Mainn.filenameDegre="Detectors/degreeOfEquation1.txt";
		        		try (BufferedReader brDegre = new BufferedReader(new FileReader(Mainn.filenameDegre))) {
		                    String lineDegre = brDegre.readLine(); // Lire la premi�re ligne
		                    Mainn.savedValue = Integer.parseInt(lineDegre.trim());
		                      
		                } catch (IOException ed) {
		                    ed.printStackTrace(); // Afficher l'erreur d'entr�e/sortie
		                }  ;
		                                //--------------------------------
						
						
						
		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath1))) {
		            textFieldsamplename.setText(reader.readLine()); // 1st line
		            textFieldPosition.setText(reader.readLine());  // 2nd line
		            textField1tpe.setText(reader.readLine());      // 3rd line		           
		            textField2tpe.setText(reader.readLine());      // 5th line
		            textField3tpe.setText(reader.readLine());      // 6th line
		            textField4tpe.setText(reader.readLine());      // 7th line
		            textField5tpe.setText(reader.readLine());      // 8th line
		            textField6tpe.setText(reader.readLine());      // 9th line
		            StringBuilder infos = new StringBuilder();
		            String line;
		            boolean capture = false;
		            while ((line = reader.readLine()) != null) {
		                if (line.trim().equals("$")) {
		                    capture = !capture;
		                    continue; // Skip the line containing $
		                
		                }
		                if (capture) {
		                    infos.append(line).append("\n");
		                }
		            }
		            textareainfos.setText(infos.toString().trim()); // Content between $ and $
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        //-----graphEfficieny---
		        subPanel.removeAll();
				repaint();
		        JPanel pnmpp = new JPanel();
		        try {
					pnmpp = new EfficiencyGraph();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		        
		        
		        subPanel.setBounds(145, 360, 350, 185);
		        panel1tpe.add(subPanel);
		        subPanel.add(EfficiencyGraph.chartPanelEfficiency);
		        subPanel.revalidate();
		        subPanel.repaint();
		        
				//-----------------
		      //-------pour sauvergarder le numero de degr� efficacit�----------
		        double txtDeg6 = Double.parseDouble(textField6tpe.getText());
		        double txtDeg5 = Double.parseDouble(textField5tpe.getText());
		        double txtDeg4 = Double.parseDouble(textField4tpe.getText());
		        double txtDeg3 = Double.parseDouble(textField3tpe.getText());
		        if(txtDeg6!=0.0) {savedValueDegree=5;};
		        if(txtDeg6==0.0) {savedValueDegree=4;};
		        if(txtDeg6==0.0 && txtDeg5==0.0 ) {savedValueDegree=3;};
		        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0) {savedValueDegree=2;};
		        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0 && txtDeg3==0.0) {savedValueDegree=1;};
		        //System.out.println("   savedValueDegree    :"+savedValueDegree);
		        spinner.setValue(savedValueDegree);
		                        //-----------------------------------	
					}
				});
				detector1.setBounds(5, 0, 120, 23);
				panelDetector.add(detector1);
				
				
				//--------------------Detector2----------------------------------
				
				
				detector2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Mainn.filenameEfficien="Detectors/Efficiency2.txt";
						KeyDetector = "Detector2";
						detector1.setBackground(defaultColor); // Gris
						detector2.setBackground(Color.BLUE);
						detector3.setBackground(defaultColor);
						detector4.setBackground(defaultColor);
						detector5.setBackground(defaultColor);
						save1.setBackground(defaultColor);
						
						filePath1= "Detectors\\Detector2.txt";
						
						//---------Supprimer le contenu du fichier et �crire la valeur du Spinner(degre de equation)
		                try (PrintWriter writer = new PrintWriter(new FileWriter(Mainn.filenameDegre))) {
		                    // �crire la valeur du Spinner dans le fichier
		                    writer.println(Mainn.spinner.getValue());
		                    writer.flush(); // S'assurer que toutes les donn�es sont �crites
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		                Mainn.filenameDegre="Detectors/degreeOfEquation2.txt";
		        		try (BufferedReader brDegre = new BufferedReader(new FileReader(Mainn.filenameDegre))) {
		                    String lineDegre = brDegre.readLine(); // Lire la premi�re ligne
		                    Mainn.savedValue = Integer.parseInt(lineDegre.trim());
		                      
		                } catch (IOException ed) {
		                    ed.printStackTrace(); // Afficher l'erreur d'entr�e/sortie
		                }  ;
		                                //--------------------------------
						
				        try (BufferedReader reader = new BufferedReader(new FileReader(filePath1))) {
				            textFieldsamplename.setText(reader.readLine()); // 1st line
				            textFieldPosition.setText(reader.readLine());  // 2nd line
				            textField1tpe.setText(reader.readLine());      // 3rd line		           
				            textField2tpe.setText(reader.readLine());      // 5th line
				            textField3tpe.setText(reader.readLine());      // 6th line
				            textField4tpe.setText(reader.readLine());      // 7th line
				            textField5tpe.setText(reader.readLine());      // 8th line
				            textField6tpe.setText(reader.readLine());      // 9th line
				            StringBuilder infos = new StringBuilder();
				            String line;
				            boolean capture = false;
				            while ((line = reader.readLine()) != null) {
				                if (line.trim().equals("$")) {
				                    capture = !capture;
				                    continue; // Skip the line containing $
				                
				                }
				                if (capture) {
				                    infos.append(line).append("\n");
				                }
				            }
				            textareainfos.setText(infos.toString().trim()); // Content between $ and $
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				        //-----graphEfficieny---
				        subPanel.removeAll();
						repaint();
				        
				        JPanel pnmpp = new JPanel();
				        try {
							pnmpp = new EfficiencyGraph();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				        
				        
				        subPanel.setBounds(145, 360, 350, 185);
				        panel1tpe.add(subPanel);
				        subPanel.add(EfficiencyGraph.chartPanelEfficiency);
				        subPanel.revalidate();
				        subPanel.repaint();
				        
						//-----------------
				      //-------pour sauvergarder le numero de degr� efficacit�----------
				        double txtDeg6 = Double.parseDouble(textField6tpe.getText());
				        double txtDeg5 = Double.parseDouble(textField5tpe.getText());
				        double txtDeg4 = Double.parseDouble(textField4tpe.getText());
				        double txtDeg3 = Double.parseDouble(textField3tpe.getText());
				        if(txtDeg6!=0.0) {savedValueDegree=5;};
				        if(txtDeg6==0.0) {savedValueDegree=4;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 ) {savedValueDegree=3;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0) {savedValueDegree=2;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0 && txtDeg3==0.0) {savedValueDegree=1;};
				        //System.out.println("   savedValueDegree    :"+savedValueDegree); 
				        spinner.setValue(savedValueDegree);
				                   //-----------------------------------	
					}
				});
				detector2.setBounds(5, 40, 120, 23);
				panelDetector.add(detector2);
				//-----------------------Detecor3----------------------
				
				detector3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Mainn.filenameEfficien="Detectors/Efficiency3.txt";
						KeyDetector = "Detector3";
						detector1.setBackground(defaultColor); // Gris
						detector2.setBackground(defaultColor);
						detector3.setBackground(Color.BLUE);
						detector4.setBackground(defaultColor);
						detector5.setBackground(defaultColor);
						save1.setBackground(defaultColor);
					    
						filePath1= "Detectors\\Detector3.txt";
						
				        try (BufferedReader reader = new BufferedReader(new FileReader(filePath1))) {
				            textFieldsamplename.setText(reader.readLine()); // 1st line
				            textFieldPosition.setText(reader.readLine());  // 2nd line
				            textField1tpe.setText(reader.readLine());      // 3rd line		           
				            textField2tpe.setText(reader.readLine());      // 5th line
				            textField3tpe.setText(reader.readLine());      // 6th line
				            textField4tpe.setText(reader.readLine());      // 7th line
				            textField5tpe.setText(reader.readLine());      // 8th line
				            textField6tpe.setText(reader.readLine());      // 9th line
				            StringBuilder infos = new StringBuilder();
				            String line;
				            boolean capture = false;
				            while ((line = reader.readLine()) != null) {
				                if (line.trim().equals("$")) {
				                    capture = !capture;
				                    continue; // Skip the line containing $
				                
				                }
				                if (capture) {
				                    infos.append(line).append("\n");
				                }
				            }
				            textareainfos.setText(infos.toString().trim()); // Content between $ and $
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				        //-----graphEfficieny---
				        subPanel.removeAll();
						repaint();
				        
				        JPanel pnmpp = new JPanel();
				        try {
							pnmpp = new EfficiencyGraph();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				        
				        
				        subPanel.setBounds(145, 360, 350, 185);
				        panel1tpe.add(subPanel);
				        subPanel.add(EfficiencyGraph.chartPanelEfficiency);
				        subPanel.revalidate();
				        subPanel.repaint();
						//-----------------
				      //-------pour sauvergarder le numero de degr� efficacit�----------
				        double txtDeg6 = Double.parseDouble(textField6tpe.getText());
				        double txtDeg5 = Double.parseDouble(textField5tpe.getText());
				        double txtDeg4 = Double.parseDouble(textField4tpe.getText());
				        double txtDeg3 = Double.parseDouble(textField3tpe.getText());
				        if(txtDeg6!=0.0) {savedValueDegree=5;};
				        if(txtDeg6==0.0) {savedValueDegree=4;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 ) {savedValueDegree=3;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0) {savedValueDegree=2;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0 && txtDeg3==0.0) {savedValueDegree=1;};
				        //System.out.println("   savedValueDegree    :"+savedValueDegree);  
				        spinner.setValue(savedValueDegree);
				                   //-----------------------------------	

					}
				});
				detector3.setBounds(5, 80, 120, 23);
				panelDetector.add(detector3);
				
				//----------------Detector4---------------------
				
				detector4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Mainn.filenameEfficien="Detectors/Efficiency4.txt";
						KeyDetector = "Detector4";
						detector1.setBackground(defaultColor); // Gris
						detector2.setBackground(defaultColor);
						detector3.setBackground(defaultColor);
						detector4.setBackground(Color.BLUE);
						detector5.setBackground(defaultColor);
						save1.setBackground(defaultColor);
						
						filePath1= "Detectors\\Detector4.txt";
						
				        try (BufferedReader reader = new BufferedReader(new FileReader(filePath1))) {
				            textFieldsamplename.setText(reader.readLine()); // 1st line
				            textFieldPosition.setText(reader.readLine());  // 2nd line
				            textField1tpe.setText(reader.readLine());      // 3rd line		           
				            textField2tpe.setText(reader.readLine());      // 5th line
				            textField3tpe.setText(reader.readLine());      // 6th line
				            textField4tpe.setText(reader.readLine());      // 7th line
				            textField5tpe.setText(reader.readLine());      // 8th line
				            textField6tpe.setText(reader.readLine());      // 9th line
				            StringBuilder infos = new StringBuilder();
				            String line;
				            boolean capture = false;
				            while ((line = reader.readLine()) != null) {
				                if (line.trim().equals("$")) {
				                    capture = !capture;
				                    continue; // Skip the line containing $
				                
				                }
				                if (capture) {
				                    infos.append(line).append("\n");
				                }
				            }
				            textareainfos.setText(infos.toString().trim()); // Content between $ and $
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				        
				        //-----graphEfficieny---
				        subPanel.removeAll();
						repaint();
				        
				        JPanel pnmpp = new JPanel();
				        try {
							pnmpp = new EfficiencyGraph();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				        
				        subPanel.setBounds(145, 360, 350, 185);
				        panel1tpe.add(subPanel);
				        subPanel.add(EfficiencyGraph.chartPanelEfficiency);
				        subPanel.revalidate();
				        subPanel.repaint();
						//-----------------
				      //-------pour sauvergarder le numero de degr� efficacit�----------
				        double txtDeg6 = Double.parseDouble(textField6tpe.getText());
				        double txtDeg5 = Double.parseDouble(textField5tpe.getText());
				        double txtDeg4 = Double.parseDouble(textField4tpe.getText());
				        double txtDeg3 = Double.parseDouble(textField3tpe.getText());
				        if(txtDeg6!=0.0) {savedValueDegree=5;};
				        if(txtDeg6==0.0) {savedValueDegree=4;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 ) {savedValueDegree=3;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0) {savedValueDegree=2;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0 && txtDeg3==0.0) {savedValueDegree=1;};
				        //System.out.println("   savedValueDegree    :"+savedValueDegree);
				        spinner.setValue(savedValueDegree);
				                       //-----------------------------------	

					}
				});
				detector4.setBounds(5, 120, 120, 23);
				panelDetector.add(detector4);
				
				//----------------------Detector5-------------------------
				
				detector5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Mainn.filenameEfficien="Detectors/Efficiency5.txt";
						KeyDetector = "Detector5";
						detector1.setBackground(defaultColor); // Gris
						detector2.setBackground(defaultColor);
						detector3.setBackground(defaultColor);
						detector4.setBackground(defaultColor);
						detector5.setBackground(Color.BLUE);
						save1.setBackground(defaultColor);
					    
						filePath1= "Detectors\\Detector5.txt";
						
				        try (BufferedReader reader = new BufferedReader(new FileReader(filePath1))) {
				            textFieldsamplename.setText(reader.readLine()); // 1st line
				            textFieldPosition.setText(reader.readLine());  // 2nd line
				            textField1tpe.setText(reader.readLine());      // 3rd line		           
				            textField2tpe.setText(reader.readLine());      // 5th line
				            textField3tpe.setText(reader.readLine());      // 6th line
				            textField4tpe.setText(reader.readLine());      // 7th line
				            textField5tpe.setText(reader.readLine());      // 8th line
				            textField6tpe.setText(reader.readLine());      // 9th line
				            StringBuilder infos = new StringBuilder();
				            String line;
				            boolean capture = false;
				            while ((line = reader.readLine()) != null) {
				                if (line.trim().equals("$")) {
				                    capture = !capture;
				                    continue; // Skip the line containing $
				                
				                }
				                if (capture) {
				                    infos.append(line).append("\n");
				                }
				            }
				            textareainfos.setText(infos.toString().trim()); // Content between $ and $
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				        
				        //-----graphEfficieny---
				        subPanel.removeAll();
						repaint();
				        
				        JPanel pnmpp = new JPanel();
				        try {
							pnmpp = new EfficiencyGraph();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				        
				        subPanel.setBounds(145, 360, 350, 185);
				        panel1tpe.add(subPanel);
				        subPanel.add(EfficiencyGraph.chartPanelEfficiency);
				        subPanel.revalidate();
				        subPanel.repaint();
						                //-------pour sauvergarder le numero de degr� efficacit�----------
				        double txtDeg6 = Double.parseDouble(textField6tpe.getText());
				        double txtDeg5 = Double.parseDouble(textField5tpe.getText());
				        double txtDeg4 = Double.parseDouble(textField4tpe.getText());
				        double txtDeg3 = Double.parseDouble(textField3tpe.getText());
				        if(txtDeg6!=0.0) {savedValueDegree=5;};
				        if(txtDeg6==0.0) {savedValueDegree=4;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 ) {savedValueDegree=3;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0) {savedValueDegree=2;};
				        if(txtDeg6==0.0 && txtDeg5==0.0 && txtDeg4==0.0 && txtDeg3==0.0) {savedValueDegree=1;};
				        //System.out.println("   savedValueDegree    :"+savedValueDegree);  
				        spinner.setValue(savedValueDegree);
				                              //-----------------------------------	
				        
					}
				});
				detector5.setBounds(5, 160, 120, 23);
				panelDetector.add(detector5);
				
				
				
		        
				save1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//------------------------------------
						
						Mainn.mntmEfficiencyCalibration1.setSelected(false);
		                Mainn.mntmEfficiencyCalibration2.setSelected(false);
		                Mainn.mntmEfficiencyCalibration3.setSelected(false);
		                Mainn.mntmEfficiencyCalibration.setSelected(true);
		                Mainn.formula = "Formula1";
						
						
						save1.setBackground(Color.BLUE); 
					    
				        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath1))) {
				            writer.write(textFieldsamplename.getText() + "\n");
				            writer.write(textFieldPosition.getText() + "\n");
				            writer.write(textField1tpe.getText() + "\n");         
				            writer.write(textField2tpe.getText() + "\n");
				            writer.write(textField3tpe.getText() + "\n");
				            writer.write(textField4tpe.getText() + "\n");
				            writer.write(textField5tpe.getText() + "\n");
				            writer.write(textField6tpe.getText() + "\n");
				            writer.write("$\n" + textareainfos.getText() + "\n$\n");
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Detectors\\save.txt"))) {
				        	writer.write(KeyDetector + "\n");	
				        }catch (IOException e) {
				            e.printStackTrace();
				        }
				      //---------Fichier Coeffi_Formula3 pour les cofficients efficacit�
				        try (BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Coeffi_Formula1.txt"))) {
				            
				            writerF3.write(Mainn.textField1tpe.getText() + "\n");         
				            writerF3.write(Mainn.textField2tpe.getText() + "\n");
				            writerF3.write(Mainn.textField3tpe.getText() + "\n");
				            writerF3.write(Mainn.textField4tpe.getText() + "\n");         
				            writerF3.write(Mainn.textField5tpe.getText() + "\n");
				            writerF3.write(Mainn.textField6tpe.getText() + "\n");
				            
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				      //-------fichier formula----
	  		  	        try(BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Formula.txt"))) {
	  		  	        	           
	  		  	        	            writerF3.write("Formula1");         
	  		  	        	            
	  		  	        	        } catch (IOException e) {
	  		  	        	            e.printStackTrace();
	  		  	        	        }
	  		  	        	        //-------------------------
				        
				        //----------save and repaint graph----------
				        subPanel.removeAll();
						repaint();				        
				        JPanel pnmpp = new JPanel();
				        try {
							pnmpp = new EfficiencyGraph();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 			        
				        subPanel.setBounds(145, 360, 350, 185);
				        panel1tpe.add(subPanel);
				        subPanel.add(EfficiencyGraph.chartPanelEfficiency);
				        subPanel.revalidate();
				        subPanel.repaint();
				        
				        //---------------------------------
				        
					}
				});
				save1.setBounds(380, 5, 120, 25);
				panel1tpe.add(save1);
		        
				//------------------------------------------
				
				
				
				
				
				JButton btnOktpe = new JButton(" OK");
				btnOktpe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Afpe =textField1tpe.getText();					    
					    textField1tpe.setText(Afpe);
					    
					    
					    Afp2e =textField2tpe.getText();					    
					    textField2tpe.setText(Afp2e);
					    
					    Afp3e =textField3tpe.getText();					    
					    textField3tpe.setText(Afp3e);
					    
					    Afp4e =textField4tpe.getText();					    
					    textField4tpe.setText(Afp4e);
					    
					    Afp5e =textField5tpe.getText();					    
					    textField5tpe.setText(Afp5e);
					    
					    Afp6e =textField5tpe.getText();					    
					    textField5tpe.setText(Afp6e);
					    
					    eff.dispose();
					}
				});
				btnOktpe.setBounds(100, 190+360, 70, 23);
				panel1tpe.add(btnOktpe);
				
				JButton btnOk1tpe = new JButton("Cancel");
				btnOk1tpe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    	    
					    textField1tpe.setText(Afpe);
					    				    
					    textField2tpe.setText(Afp2e);
					    		    
					    textField3tpe.setText(Afp3e);
					    			    
					    textField4tpe.setText(Afp4e);
					    			    
					    textField5tpe.setText(Afp5e);
					    			    
					    textField6tpe.setText(Afp6e);
						
						eff.dispose();	
		   
					}
				});
				btnOk1tpe.setBounds(200, 190+360, 100, 23);
				panel1tpe.add(btnOk1tpe);	
				
				JButton inialize1 = new JButton("inialize");
				inialize1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						textField1tpe.setText("0");
						textField2tpe.setText("0");
						textField3tpe.setText("0");
						textField4tpe.setText("0");
						textField5tpe.setText("0");
						textField6tpe.setText("0");
					    
					}
				});
				inialize1.setBounds(330,190+360, 80, 23);
				panel1tpe.add(inialize1);
				
				eff.setSize(650,660);
				eff.setResizable(false);
				eff.setVisible(true);
				
			}
		});
		//this.setVisible(true);
		mntmNewMenuItem.add(mntmEfficiencyCalibration);
		
		mntmEfficiencyCalibration1 = new JCheckBoxMenuItem("By : Eff=a*E^(-b) ");
		mntmEfficiencyCalibration1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmEfficiencyCalibration1.setEnabled(false);}
				else{mntmEfficiencyCalibration1.setEnabled(true);}//Pour apparaitre "Efficiency calibration" doit changer false par true
			}
		});	
		mntmEfficiencyCalibration1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Formule2Efficiency.Formule2Efficiency(); 
				//Mainn.mntmEfficiencyCalibration1.setSelected(false);
			}
		});
		//this.setVisible(true);
		mntmNewMenuItem.add(mntmEfficiencyCalibration1);
		
		mntmEfficiencyCalibration2 = new JCheckBoxMenuItem("By : Eff= a + b*E + c*E^2 + ..... + f*E^n ");
		mntmEfficiencyCalibration2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmEfficiencyCalibration2.setEnabled(false);}
				else{mntmEfficiencyCalibration2.setEnabled(true);}//Pour apparaitre "Efficiency calibration" doit changer false par true
			}
		});	
		mntmEfficiencyCalibration2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Formule3Efficiency.Formule3Efficiency();
		
			}
		});
		//this.setVisible(true);
		mntmNewMenuItem.add(mntmEfficiencyCalibration2);
		
		mntmEfficiencyCalibration3 = new JCheckBoxMenuItem("By : Eff= exp(a + b*E + c*E^2) ");
		mntmEfficiencyCalibration3.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmEfficiencyCalibration3.setEnabled(false);}
				else{mntmEfficiencyCalibration3.setEnabled(true);}//Pour apparaitre "Efficiency calibration" doit changer false par true
			}
		});	
		mntmEfficiencyCalibration3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Formule4Efficiency.Formule4Efficiency();
			}
		});
		//this.setVisible(true);
		mntmNewMenuItem.add(mntmEfficiencyCalibration3);
		//mntmEfficiencyCalibration.setSelected(true);
		
		//----------fichier pour sauvegarder la formule efficacit� utilis�e
				try (BufferedReader formEffic = new BufferedReader(new FileReader("Detectors\\Formula.txt"))) {
		    	    formula = formEffic.readLine();
		    	   if(formula.equals("Formula1")) { 
		    		   Mainn.mntmEfficiencyCalibration.setSelected(true);
		             } else if(formula.equals("Formula2")) { 
		            	 Mainn.mntmEfficiencyCalibration1.setSelected(true);
		             } else if(formula.equals("Formula3")) { 
		            	 Mainn.mntmEfficiencyCalibration2.setSelected(true);
		             } else if(formula.equals("Formula4")) { 
		            	 Mainn.mntmEfficiencyCalibration3.setSelected(true);             
		             } else {
		            	 Mainn.mntmEfficiencyCalibration.setSelected(true);
		             };
		             
		        } catch (IOException e) {
		            e.printStackTrace();
		        }		
				//-----------------------------------------------
		
		
		
		JMenu mnT = new JMenu("Analyze  ");
		menuBar.add(mnT);
		
		
		
		TextField textField1tp = new TextField("1");
		TextField textField2tp = new TextField("5");
		TextField textField3tp = new TextField("2");
		TextField textField4tp = new TextField("1");
		TextField textField5tp = new TextField("20");
		
		JMenuItem mntmSmoothMAnd = new JMenuItem("parameters of search peaks");
		mntmSmoothMAnd.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mntmSmoothMAnd.setEnabled(false);}
				else{mntmSmoothMAnd.setEnabled(true);}
			}
		});
		
		mntmSmoothMAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    JDialog d = new JDialog((Frame)null, "search parameters peaks", true);
			    
			    JPanel panel1tp=new JPanel();
				panel1tp.setBounds(191, 23, 230, 153);
				panel1tp.setLayout(null);
				d.getContentPane().add(panel1tp);
				
				JLabel lblA_11tp = new JLabel(" Parameters of search peaks ");
				//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_11tp.setBounds(23, 11, 250, 17);
				panel1tp.add(lblA_11tp);
				
				JLabel lblA_12tp = new JLabel("  m =");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_12tp.setBounds(23, 35, 46, 17);
				panel1tp.add(lblA_12tp);
				
				//TextField textField1tp = new TextField("1");
				textField1tp.setBounds(100, 35, 86, 20);				
				panel1tp.add(textField1tp);
				
				JLabel lblA_13tp = new JLabel("  Z =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_13tp.setBounds(23, 57, 46, 17);
				panel1tp.add(lblA_13tp);
				
				//TextField textField2tp = new TextField("3");
				textField2tp.setBounds(100, 55, 86, 20);				
				panel1tp.add(textField2tp);
				
				JLabel lblA_14tp = new JLabel("Threshold=");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_14tp.setBounds(23, 80, 70, 17);
				panel1tp.add(lblA_14tp);
				
				//TextField textField3tp = new TextField("1");
				textField3tp.setBounds(100, 80, 86, 20);				
				panel1tp.add(textField3tp);
				
				JLabel lblA_15tp = new JLabel("  lmin =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_15tp.setBounds(23, 105, 46, 17);
				panel1tp.add(lblA_15tp);
				
				//TextField textField4tp = new TextField("1");
				textField4tp.setBounds(100, 105, 86, 20);				
				panel1tp.add(textField4tp);
				
				JLabel lblA_16tp = new JLabel("  lmax =");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblA_16tp.setBounds(23, 130, 46, 17);
				panel1tp.add(lblA_16tp);
				
				//TextField textField5tp = new TextField("20");
				textField5tp.setBounds(100, 130, 86, 20);				
				panel1tp.add(textField5tp);
				
				pr0 =textField1tp.getText();
				pr1 =textField2tp.getText();
				pr2 =textField3tp.getText();
				pr3 =textField4tp.getText();
				pr4 =textField5tp.getText();
				
				
				JButton btnOktp = new JButton(" OK");
				btnOktp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						Afp =textField1tp.getText();					    
					    textField1tp.setText(Afp);
					    
					    
					    Afp2 =textField2tp.getText();					    
					    textField2tp.setText(Afp2);
					    
					    Afp3 =textField3tp.getText();					    
					    textField3tp.setText(Afp3);
					    
					    Afp4 =textField4tp.getText();					    
					    textField4tp.setText(Afp4);
					    
					    Afp5 =textField5tp.getText();					    
					    textField5tp.setText(Afp5);
					    
					    d.dispose();
					}
				});
				btnOktp.setBounds(100, 155, 70, 23);
				panel1tp.add(btnOktp);
				
				
				JButton btnOk1tp = new JButton("Cancel");
				btnOk1tp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						textField1tp.setText(pr0);
						textField2tp.setText(pr1);
						textField3tp.setText(pr2);
						textField4tp.setText(pr3);
						textField5tp.setText(pr4);
						d.dispose();	
		   
					}
				});
				btnOk1tp.setBounds(200, 155, 100, 23);
				panel1tp.add(btnOk1tp);	
				
				d.setSize(350,250);
				d.setResizable(false);
				d.setVisible(true);
				
			}
		});
		mnT.add(mntmSmoothMAnd);
		
		TextField textField1tpk = new TextField("8");
		
		JMenuItem mntmWithsigma = new JMenuItem("Width_peak ");
		mntmWithsigma.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmWithsigma.setEnabled(false);}
				else{mntmWithsigma.setEnabled(true);}
			}
		});
		
		mntmWithsigma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JDialog dk = new JDialog((Frame)null, "Width_peak", true);
				    
				    JPanel panel1tpk=new JPanel();
					panel1tpk.setBounds(191, 23, 230, 153);
					panel1tpk.setLayout(null);
					dk.getContentPane().add(panel1tpk);
					
					JLabel lblA_11tpk = new JLabel(" Width = k*FWHM/2.355 ");
					//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblA_11tpk.setBounds(23, 11, 250, 17);
					panel1tpk.add(lblA_11tpk);
					
					JLabel lblA_12tpk = new JLabel("  k =");
					//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblA_12tpk.setBounds(23, 35, 46, 17);
					panel1tpk.add(lblA_12tpk);
					
					//TextField textField1tp = new TextField("1");
					textField1tpk.setBounds(100, 35, 86, 20);				
					panel1tpk.add(textField1tpk);
					
					
					wid0 =textField1tpk.getText();	
					
					
					JButton btnOktpk = new JButton(" OK");
					btnOktpk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							Afpk =textField1tpk.getText();					    
						    textField1tpk.setText(Afpk);
						    
						    dk.dispose();
						}
					});
					btnOktpk.setBounds(100, 155, 70, 23);
					panel1tpk.add(btnOktpk);
					
					JButton btnOk1tpk = new JButton("Cancel");
					btnOk1tpk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
		 			    
							textField1tpk.setText(wid0);
							dk.dispose();	
			   
						}
					});
					btnOk1tpk.setBounds(200, 155, 100, 23);
					panel1tpk.add(btnOk1tpk);	
					
					dk.setSize(350,250);
					dk.setResizable(false);
					dk.setVisible(true);
				
			}
		});
		
		
		wt=textField1tp.getText();// W  pour la class PeakSearch
	    mt=textField2tp.getText();// m  pour la class PeakSearch
		
		
		JMenuItem mntmViewDriv = new JMenuItem("View 2 derivative_error");
		mntmViewDriv.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmViewDriv.setEnabled(false);}
				else{mntmViewDriv.setEnabled(true);}
			}
		});		
		mntmViewDriv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				analyse="g1";
				wt=textField1tp.getText();// W
			    mt=textField2tp.getText();// m
				panel.removeAll();
				
				JPanel pn = new JPanel();
				try {
					pn = new GraphDeriveLissee();
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "enter spectrum file  ");
					e2.printStackTrace();
				} 
				
				panel.setLayout(new java.awt.BorderLayout());
				panel.add(pn);
				panel.validate();	
				
			}
		});
		mnT.add(mntmViewDriv);
		mnT.add(mntmWithsigma);
		
		mntmPeakSearch = new JMenuItem("Peak search");
		mntmPeakSearch.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmPeakSearch.setEnabled(false);}
				else{mntmPeakSearch.setEnabled(true);}	
				
			}
		});
		mntmPeakSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 // peakPosition="marker";    //pour apparaitre Marker sur graph
				  evitErrRaprt="apparaitre";//pour �viter erreur en rapport des resultats
			    //analyse=null;   //pour fonctionner des icones comme zoom.....  
			      wt=textField1tp.getText();// z
			      mt=textField2tp.getText();// m
			      tech=textField3tp.getText();// seuil
			      li=textField4tp.getText(); // lmin
			      lm=textField5tp.getText(); //lmax
			      As=textField1.getText(); // a de energie
			      Bs=textField2.getText(); // b de energie
			      Cs=textField3.getText(); // c de energie
			      Ds=textField4.getText(); // d de energie			      
				try {
					PeakSearch.PeakRearchERE();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int n=0;
				for(n=0;n<PeakSearch.centrePic.size();n++) {
					
					if(forMrkrAllPeaks=="AllMrkrNorml") {
        		    Ggraphique.start2 = new ValueMarker(Float.parseFloat(PeakSearch.centrePic.get(n)));
        		    Ggraphique.start2.setStroke( new BasicStroke( 1 ) );
        		    Ggraphique.start2.setPaint(Color.RED);        		    
        		    String Nn = Integer.toString(n+1);
        		    Ggraphique.start2.setLabel(Nn);
        		    Ggraphique.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        		    Ggraphique.start2.setLabelPaint(Color.RED);
        		    Ggraphique.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
        		    Ggraphique.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
        		    Ggraphique.plot.addDomainMarker( Ggraphique.start2);
					}
					if(forMrkrAllPeaks=="AllMrkrLog") {
	        		    Loggraph.start2 = new ValueMarker(Float.parseFloat(PeakSearch.centrePic.get(n)));
	        		    Loggraph.start2.setStroke( new BasicStroke( 1 ) );
	        		    Loggraph.start2.setPaint(Color.RED);        		    
	        		    String Nn = Integer.toString(n+1);
	        		    Loggraph.start2.setLabel(Nn);
	        		    Loggraph.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
	        		    Loggraph.start2.setLabelPaint(Color.RED);
	        		    Loggraph.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
	        		    Loggraph.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
	        		    Loggraph.plot.addDomainMarker( Loggraph.start2);
						}
				}
				
				
			String peaksearch1=	PeakSearch.peaksearch;
			textArea.setText(peaksearch1);
			
			
			
			/*try {
				Library.Librar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
				
			}
		});		
		mnT.add(mntmPeakSearch);
		
		
		JMenu mnBackgroundType = new JMenu("Background type");
		mnBackgroundType.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mnBackgroundType.setEnabled(false);}
				else{mnBackgroundType.setEnabled(true);}
			}
		});
		
		mnT.add(mnBackgroundType);
		
		JRadioButtonMenuItem rdbtnmntmStraightlineBackground = new JRadioButtonMenuItem("Straight-line background");
		rdbtnmntmStraightlineBackground.setSelected(true);
		mnBackgroundType.add(rdbtnmntmStraightlineBackground);
		
		JRadioButtonMenuItem rdbtnmntmSteppedBackground = new JRadioButtonMenuItem("Stepped background");
		rdbtnmntmSteppedBackground.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){rdbtnmntmSteppedBackground.setEnabled(false);}
				else{rdbtnmntmSteppedBackground.setEnabled(false);}//Pour apparaitre "Stepped background" doit changer false par true
			}
		});
		mnBackgroundType.add(rdbtnmntmSteppedBackground);
		
		JRadioButtonMenuItem rdbtnmntmParabolicBackground = new JRadioButtonMenuItem("Parabolic background");
		rdbtnmntmParabolicBackground.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){rdbtnmntmParabolicBackground.setEnabled(false);}
				else{rdbtnmntmParabolicBackground.setEnabled(false);}//Pour apparaitre "Parabolic background" doit changer false par true
			}
		});
		mnBackgroundType.add(rdbtnmntmParabolicBackground);
		
		JMenu mnSpectrumTreatment = new JMenu("Calculation of surfaces");
		mnSpectrumTreatment.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mnSpectrumTreatment.setEnabled(false);}
				else{mnSpectrumTreatment.setEnabled(true);}
			}
		});
		
		mnT.add(mnSpectrumTreatment);
		
		JMenuItem mntmLogEchel_1 = new JMenuItem("Log echel");
		mntmLogEchel_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmLogEchel_1.setEnabled(false);}
				else{mntmLogEchel_1.setEnabled(true);}//Pour apparaitre "Log echel" doit changer false par true
			}
		});
		mntmLogEchel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				
			      evitErrRaprt="apparaitre";//pou �viter erreur en rapport des resultats
			      analyse="g3"; //POUR fonctionner la barre d'outil comme zoom.....  
			      wt=textField1tp.getText();// z
			      mt=textField2tp.getText();// m
			      tech=textField3tp.getText();// seuil
			      li=textField4tp.getText(); // lmin
			      lm=textField5tp.getText(); //lmax
			      As=textField1.getText(); // a de energie
			      Bs=textField2.getText(); // b de energie
			      Cs=textField3.getText(); // c de energie
			      Ds=textField4.getText(); // d de energie
			      AC1s=textField1f.getText();// a de FWHM
			      AC2s=textField2f.getText(); // b de FWHM 
			      At1s=textField1t.getText(); // a de tail
			      At2s=textField2t.getText();// b de tail
			      k_ecart=textField1tpk.getText();// k de ecart type
			      
					panel.removeAll();
					repaint();
				
					JPanel pnm1 = null;
					try {										
						pnm1 = new treatmentLog(); //Nouvel();
						String stta =treatmentLog.results;					
						 textArea.setText(stta);
						 
						
					} catch (IOException e2) {
						JOptionPane.showMessageDialog(null, "enter spectrum file ");
						e2.printStackTrace();
					}  
					
					panel.setLayout(new java.awt.BorderLayout());
					panel.add(pnm1);
					panel.validate();
					
					int n=0;
					for(n=0;n<treatmentLog.DomainAxisPeakCmpr.size();n++) {
						
						
						treatmentLog.start2 = new ValueMarker(Float.parseFloat(treatmentLog.DomainAxisPeakCmpr.get(n)));
						treatmentLog.start2.setStroke( new BasicStroke( 1 ) );
						treatmentLog.start2.setPaint(Color.RED);        		    
	        		    String Nn = Integer.toString(n+1);
	        		    treatmentLog.start2.setLabel(Nn);
	        		    treatmentLog.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
	        		    treatmentLog.start2.setLabelPaint(Color.RED);
	        		    treatmentLog.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
	        		    treatmentLog.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
	        		    treatmentLog.plot.addDomainMarker( treatmentLog.start2);
						
					}
					
					
					//---for library----
					try {
						Library.Librar();
					} catch (IOException es) {
						// TODO Auto-generated catch block
						es.printStackTrace();
					}
					//---------------------
					
					
			}
		});
		mnSpectrumTreatment.add(mntmLogEchel_1);
		
		  AC1s=textField1f.getText();// a de FWHM pour la class PeakSearch
	      AC2s=textField2f.getText(); // b de FWHM pour la class PeakSearch
	      
		JMenuItem mntmNormalEchel = new JMenuItem("Normal echel");
		mntmNormalEchel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				      evitErrRaprt="apparaitre";//pou �viter erreur en rapport des resultats
				      analyse="g"; //POUR fonctionner la barre d'outil comme zoom.....  
				      wt=textField1tp.getText();// z
				      mt=textField2tp.getText();// m
				      tech=textField3tp.getText();// seuil
				      li=textField4tp.getText(); // lmin
				      lm=textField5tp.getText(); //lmax
				      As=textField1.getText(); // a de energie
				      Bs=textField2.getText(); // b de energie
				      Cs=textField3.getText(); // c de energie
				      Ds=textField4.getText(); // d de energie
				      AC1s=textField1f.getText();// a de FWHM
				      AC2s=textField2f.getText(); // b de FWHM 
				      At1s=textField1t.getText(); // a de tail
				      At2s=textField2t.getText();// b de tail
				      k_ecart=textField1tpk.getText();// k de ecart type
				      
						panel.removeAll();
						repaint();
					
						JPanel pnm1 = null;
						try {										
							pnm1 = new treatment1(); 
							String stta =treatment1.results;							
							 textArea.setText(stta);
							 
							
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "enter spectrum file ");
							e2.printStackTrace();
						}  
						
						panel.setLayout(new java.awt.BorderLayout());
						panel.add(pnm1);
						panel.validate();
						
						
						int n=0;
						for(n=0;n<treatment1.DomainAxisPeak.size();n++) {
							
							
							treatment1.start2 = new ValueMarker(Float.parseFloat(treatment1.DomainAxisPeak.get(n)));
							treatment1.start2.setStroke( new BasicStroke( 1 ) );
							treatment1.start2.setPaint(Color.RED);        		    
		        		    String Nn = Integer.toString(n+1);
		        		    treatment1.start2.setLabel(Nn);
		        		    treatment1.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
		        		    treatment1.start2.setLabelPaint(Color.RED);
		        		    treatment1.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		        		    treatment1.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
		        		    treatment1.plot.addDomainMarker( treatment1.start2);
							
						}
						
						//---for library----
						try {
							Library.Librar();
						} catch (IOException es) {
							// TODO Auto-generated catch block
							es.printStackTrace();
						}
						//---------------------
						
			}
		});
		mnSpectrumTreatment.add(mntmNormalEchel);
		

		
		JMenu mnFileRapport = new JMenu("Save report file");
		mnFileRapport.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mnFileRapport.setEnabled(false);}
				else{mnFileRapport.setEnabled(true);}
			}
		});
		
		TextField textFieldOperator = new TextField(" ");
		TextField textFieldNameSample = new TextField(" ");		
		TextArea textAreaEdit = new TextArea("no comment");
		
		JMenuItem mntmEditInfosAnd = new JMenuItem("Edit infos and comment");
		mntmEditInfosAnd.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(fichier==null){mntmEditInfosAnd.setEnabled(false);}
				else{mntmEditInfosAnd.setEnabled(true);}
			}
		});
		
		mntmEditInfosAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               JDialog frameEdit = new JDialog((Frame)null, "Edit infos and comment", true);
				
				JPanel panelEdit=new JPanel();
				panelEdit.setBounds(191, 23, 230, 153);
				panelEdit.setLayout(null);
				frameEdit.getContentPane().add(panelEdit);
				
				
				JLabel lblEdit = new JLabel(" General Info ");
				//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEdit.setBounds(150, 11, 250, 17);
				panelEdit.add(lblEdit);
				
				JLabel lblEdit1 = new JLabel(" Operator           :");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEdit1.setBounds(23, 35, 90, 17);
				panelEdit.add(lblEdit1);
				
				
				textFieldOperator.setBounds(160, 35, 150, 20);				
				panelEdit.add(textFieldOperator);
				
				JLabel lblEdit2 = new JLabel("For the memory:");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEdit2.setBounds(23, 70, 100, 17);
				panelEdit.add(lblEdit2);
				
				
				textFieldNameSample.setBounds(160, 70, 150, 20);
				textFieldNameSample.setText(namFile);
				
				panelEdit.add(textFieldNameSample);
				
				JLabel lblEdit3 = new JLabel("  Comment        :");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEdit3.setBounds(23, 105, 90, 17);
				panelEdit.add(lblEdit3);
				
				
				textAreaEdit.setBounds(120, 105, 250, 70);				
				panelEdit.add(textAreaEdit);
				
				EditC1=textFieldOperator.getText();	
				EditC2=textFieldNameSample.getText();	
				EditC3=textAreaEdit.getText();	
				
				JButton bntEdit = new JButton(" OK");
				bntEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Edit1 =textFieldOperator.getText();					    
						textFieldOperator.setText(Edit1);
					    
						Edit2 =textFieldNameSample.getText();					    
						textFieldNameSample.setText(Edit2);
						
						Edit3 =textAreaEdit.getText();					    
						textAreaEdit.setText(Edit3);
					    
					    frameEdit.dispose();
					}
				});
				bntEdit.setBounds(100, 185, 70, 23);
				panelEdit.add(bntEdit);
				
				JButton btnEdit1 = new JButton("Cancel");
				btnEdit1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						textFieldOperator.setText(EditC1);
						textFieldNameSample.setText(EditC2);
						textAreaEdit.setText(EditC3);
						
						 frameEdit.dispose();	
		   
					}
				});
				btnEdit1.setBounds(200, 185, 100, 23);
				panelEdit.add(btnEdit1);
				
				frameEdit.setSize(450,250);
				frameEdit.setResizable(false);
				frameEdit.setVisible(true);
				
			}
		});
		
		
		fieldIdentif1 = new JTextField("Lib\\Lib.dat");
		fieldIdentif2 = new JTextField("1");
		radinucleidNuc    = new ArrayList<String>(); 		
		nucleidEnergyNuc  = new ArrayList<String>();
		nucIntensityNuc   = new ArrayList<String>();
		hilflifeNuc       = new ArrayList<String>();
		ActivityTableau    = new ArrayList<String>(); 
		ActivityErrorTableau    = new ArrayList<String>();
		JMenuItem mntmIdentification = new JMenuItem("Identification and Activity");
		mntmIdentification.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mntmIdentification.setEnabled(false);}
				else{mntmIdentification.setEnabled(true);}
			}
		});
		mntmIdentification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JDialog frameIdentific = new JDialog((Frame)null, "Identification", true);	
				
				JPanel paneldendific=new JPanel();
				paneldendific.setBounds(191, 23, 230, 153);
				paneldendific.setLayout(null);
				frameIdentific.getContentPane().add(paneldendific);
				
				
				
				JLabel lblEdit1i = new JLabel(" Library              :");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEdit1i.setBounds(23, 35, 90, 17);
				paneldendific.add(lblEdit1i);
				
				
				fieldIdentif1.setBounds(120, 35, 150, 20);				
				paneldendific.add(fieldIdentif1);
				
				JButton bntLib = new JButton(" Selection");
				bntLib.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					
						JFileChooser dialogue = new JFileChooser("Lib");
						dialogue.setAcceptAllFileFilterUsed(false); 
						dialogue.setDialogTitle("Select file ");
						
						FileNameExtensionFilter restrict = new FileNameExtensionFilter(".dat","dat");						
						dialogue.addChoosableFileFilter(restrict);				
						if (dialogue.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) {	
							
							pthLib = dialogue.getSelectedFile().getAbsolutePath();	
							fieldIdentif1.setText(pthLib);		
						  }	
						
					}
				});
				bntLib.setBounds(300, 35, 100, 23);
				paneldendific.add(bntLib);
				
				
				JLabel lblEdit2i = new JLabel("Tolerance (Kev):");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEdit2i.setBounds(23, 70, 100, 17);
				paneldendific.add(lblEdit2i);
				
				
				fieldIdentif2.setBounds(120, 70, 150, 20);				
				paneldendific.add(fieldIdentif2);
				
				JButton bntEdit = new JButton(" OK");
				bntEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						radinucleidNuc.clear(); nucleidEnergyNuc.clear();
						nucIntensityNuc.clear(); hilflifeNuc.clear();
						ActivityTableau.clear();
						ActivityErrorTableau.clear();
						
						
						String pth = fieldIdentif1.getText();
						fieldIdentif1.setText(pth);						
						String tlr = fieldIdentif2.getText();
						fieldIdentif2.setText(tlr);
						
						String collect =""; float plusProche,crrespndEnergy0=0; String lin=System.getProperty("line.separator"),linResult = null;
						int size=0;
						Float AreaNettreatmntLog=null, AreaNetErrortreatmntLog=null;
						if(Mainn.analyse=="g3") {size=treatmentLog.EnergyAxisPeakCmpr.size();}
						if(Mainn.analyse=="g") {size=treatment1.EnergyAxisPeak.size();}
						for(int jS=0;jS<size;jS++) {
						  String nceid =""; String enrgyNuc =""; String intensityNuc =""; String AreaNett=""; String AreaNettError=""; String Activity_=""; String Activity_Error="";
						  String hilflifeeNuc =""; float plusProche1 = 1000;
						  if(Mainn.analyse=="g3") {crrespndEnergy0 = Float.parseFloat(treatmentLog.EnergyAxisPeakCmpr.get(jS));}
						  if(Mainn.analyse=="g") { crrespndEnergy0 =Float.parseFloat(treatment1.EnergyAxisPeak.get(jS));}
						  if(Mainn.analyse=="g3") {linResult =	treatmentLog.ForIdentification.get(jS);}
						  if(Mainn.analyse=="g") { linResult =	treatment1.ForIdentification1.get(jS);}
						  
		    			  for(int jn=0;jn<Library.nucleidEnergy.size();jn++) {
		    				String radinucleid0=Library.radinucleid.get(jn);  
		    				float enrgNuceild0 = Float.parseFloat(Library.nucleidEnergy.get(jn));		    				
		    				String nucIntensity0=Library.nucIntensity.get(jn);
		    				String hilflife0=Library.hilflife.get(jn);
		    				
		    				if(Mainn.analyse=="g3") {AreaNettreatmntLog =Float.parseFloat(treatmentLog.AreayAxisPeakCmpr.get(jS));
		    			    AreaNetErrortreatmntLog =Float.parseFloat(treatmentLog.ErrorAxisPeakCmpr.get(jS));}
		    				if(Mainn.analyse=="g") {AreaNettreatmntLog =Float.parseFloat(treatment1.AreayAxisPeak.get(jS));
		    			    AreaNetErrortreatmntLog =Float.parseFloat(treatment1.ErrorAxisPeak.get(jS));}
		    				
		    				
		    				float tole = Float.parseFloat(fieldIdentif2.getText());
		    				if(crrespndEnergy0<=enrgNuceild0+tole && crrespndEnergy0>=enrgNuceild0-tole ) {
		    					plusProche=Math.abs(crrespndEnergy0-enrgNuceild0);
		    					if(plusProche<plusProche1) {
		    						nceid=radinucleid0;	 enrgyNuc =Float.toString(enrgNuceild0);
		  						    intensityNuc =nucIntensity0; hilflifeeNuc =hilflife0;
		  						    AreaNett=Float.toString(AreaNettreatmntLog);
		  						    AreaNettError=Float.toString(AreaNetErrortreatmntLog);
		  						    
		    						plusProche1=plusProche;
		    					}		
		    				}			    				  
		    			  }if(nceid.equals("")) {
		    			  radinucleidNuc.add(nceid); nucleidEnergyNuc.add(enrgyNuc);
  						  nucIntensityNuc.add(intensityNuc); hilflifeNuc.add(hilflifeeNuc);
  						  ActivityTableau.add(Activity_);
  						  ActivityErrorTableau.add(Activity_Error);
  						  }else {
  							radinucleidNuc.add(nceid); nucleidEnergyNuc.add(enrgyNuc+" Kev");
    						nucIntensityNuc.add(intensityNuc+" %"); hilflifeNuc.add(hilflifeeNuc);
    						
    						
    						
    					  String EffiCaljs,coffi1s, coffi2s, coffi3s, coffi4s, coffi5s, coffi6s, enrgjs;
  		    			  Float EffiCalj = null,coffi1, coffi2, coffi3, coffi4, coffi5, coffi6, enrgj;
  		    			  
  		    			Float enrgjeff	= Float.parseFloat(enrgyNuc);
  		    			  //----la lecture de fichier pour des coefficients d'efficacit�
  		    			  if(Mainn.mntmEfficiencyCalibration.isSelected()) {
  		    				try (BufferedReader readerd = new BufferedReader(new FileReader("Detectors\\Coeffi_Formula1.txt"))) {
  		    					
  		    					textField1tpe.setText(readerd.readLine()); // 1st line
  		    					textField2tpe.setText(readerd.readLine()); 
  		    					textField3tpe.setText(readerd.readLine()); 
  		    					textField4tpe.setText(readerd.readLine()); 
  		    					textField5tpe.setText(readerd.readLine()); 
  		    					textField6tpe.setText(readerd.readLine()); 
  		    					
  		    				} catch (FileNotFoundException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				} catch (IOException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				}
  		    			  }
  		    			  
  		    			if(Mainn.mntmEfficiencyCalibration1.isSelected()) {
  		    				try (BufferedReader readerd = new BufferedReader(new FileReader("Detectors\\Coeffi_Formula2.txt"))) {
  		    					
  		    					textField1tpeF2.setText(readerd.readLine()); // 1st line
  		    					textField2tpeF2.setText(readerd.readLine()); 
  		    					
  		    				} catch (FileNotFoundException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				} catch (IOException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				}
  		    			  }
  		    			
  		    			if(Mainn.mntmEfficiencyCalibration2.isSelected()) {
  		    				try (BufferedReader readerd = new BufferedReader(new FileReader("Detectors\\Coeffi_Formula3.txt"))) {
  		    					
  		    					textField1tpeF3.setText(readerd.readLine()); // 1st line
  		    					textField2tpeF3.setText(readerd.readLine()); 
  		    					textField3tpeF3.setText(readerd.readLine()); 
  		    					textField4tpeF3.setText(readerd.readLine()); 
  		    					textField5tpeF3.setText(readerd.readLine()); 
  		    					textField6tpeF3.setText(readerd.readLine()); 
  		    					
  		    				} catch (FileNotFoundException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				} catch (IOException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				}
  		    			  }
  		    			
  		    			if(Mainn.mntmEfficiencyCalibration3.isSelected()) {
  		    				try (BufferedReader readerd = new BufferedReader(new FileReader("Detectors\\Coeffi_Formula4.txt"))) {
  		    					
  		    					textField1tpeF4.setText(readerd.readLine()); // 1st line
  		    					textField2tpeF4.setText(readerd.readLine()); 
  		    					textField3tpeF4.setText(readerd.readLine()); 
  		    					
  		    				} catch (FileNotFoundException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				} catch (IOException e1) {
  		    					// TODO Auto-generated catch block
  		    					e1.printStackTrace();
  		    				}
  		    			  }
  		    		 
  		    			      //---------------------------------
  		    			
  		    			if(Mainn.formula.equals("Formula1")) {
	  		    			  coffi1s =textField1tpe.getText();					    
	  		    			  coffi2s =textField2tpe.getText();					    
	  		    			  coffi3s =textField3tpe.getText();					    
	  		    			  coffi4s =textField4tpe.getText();					    
	  		    			  coffi5s =textField5tpe.getText();					    	    
	  		    			  coffi6s =textField6tpe.getText();
	  		    			  
	  		    			  coffi1=Float.parseFloat(coffi1s);
	  				    	  coffi2=Float.parseFloat(coffi2s);
	  				 		  coffi3=Float.parseFloat(coffi3s);
	  				    	  coffi4=Float.parseFloat(coffi4s);
	  				    	  coffi5=Float.parseFloat(coffi5s);
	  				    	  coffi6=Float.parseFloat(coffi6s);
	  				    	EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgjeff) + coffi3 * Math.pow(Math.log(enrgjeff), 2) + coffi4 * Math.pow(Math.log(enrgjeff), 3)+ coffi5 * Math.pow(Math.log(enrgjeff), 4) + coffi6 * Math.pow(Math.log(enrgjeff), 5))));
	  		    			  };
	  		    			if(Mainn.formula.equals("Formula2")) {
		  		    			  coffi1s =textField1tpeF2.getText();					    
		  		    			  coffi2s =textField2tpeF2.getText();					    
		  		    			  
		  		    			  coffi1=Float.parseFloat(coffi1s);
		  				    	  coffi2=Float.parseFloat(coffi2s);
		  				    	EffiCalj=(float)(coffi1* Math.pow(enrgjeff, coffi2));
		  				    	//EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgjeff) + coffi3 * Math.pow(Math.log(enrgjeff), 2) + coffi4 * Math.pow(Math.log(enrgjeff), 3)+ coffi5 * Math.pow(Math.log(enrgjeff), 4) + coffi6 * Math.pow(Math.log(enrgjeff), 5))));
		  		    			  };
		  		    			  
		  		    			if(Mainn.formula.equals("Formula3")) {
		  		    				coffi1s =textField1tpeF3.getText();					    
			  		    			  coffi2s =textField2tpeF3.getText();					    
			  		    			  coffi3s =textField3tpeF3.getText();					    
			  		    			  coffi4s =textField4tpeF3.getText();					    
			  		    			  coffi5s =textField5tpeF3.getText();					    	    
			  		    			  coffi6s =textField6tpeF3.getText();
			  		    			  
			  		    			  coffi1=Float.parseFloat(coffi1s);
			  				    	  coffi2=Float.parseFloat(coffi2s);
			  				 		  coffi3=Float.parseFloat(coffi3s);
			  				    	  coffi4=Float.parseFloat(coffi4s);
			  				    	  coffi5=Float.parseFloat(coffi5s);
			  				    	  coffi6=Float.parseFloat(coffi6s);
			  				    	EffiCalj=(float)( coffi1 + coffi2 * enrgjeff + coffi3 * Math.pow(enrgjeff, 2) + coffi4 * Math.pow(enrgjeff, 3) 
			  		                         + coffi5 * Math.pow(enrgjeff, 4) + coffi6 * Math.pow(enrgjeff, 5));
			  		 
		  		    			};
		  		    			if(Mainn.formula.equals("Formula4")) {
		  		    				  coffi1s =textField1tpeF4.getText();					    
			  		    			  coffi2s =textField2tpeF4.getText();					    
			  		    			  coffi3s =textField3tpeF4.getText();					    
			  		    			  
			  		    			  coffi1=Float.parseFloat(coffi1s);
			  				    	  coffi2=Float.parseFloat(coffi2s);
			  				 		  coffi3=Float.parseFloat(coffi3s);
			  				    	  
			  				 		EffiCalj=(float)(  Math.exp(coffi1+ coffi2*enrgjeff+coffi3*Math.pow(enrgjeff, 2)));
			  				 		  
			  				    	
		  		    			};
	    		            
  				    	  
  				    	  float I0 = Float.parseFloat(intensityNuc);
  				    	  Float acvti=AreaNettreatmntLog/(Float.parseFloat(livetimS)*EffiCalj*I0/100);		    			  
  				    	  Float acvtiError=AreaNetErrortreatmntLog/(Float.parseFloat(livetimS)*EffiCalj*I0/100);		    			  
		    			 
  				    	  Activity_ =Float.toString(acvti);
  				    	  Activity_Error =" � "+Float.toString(acvtiError)+" Bq";
  				    	  // Activity_ =String.format("%.3f", acvti);
  				    	  //Activity_Error =" � "+String.format("%.5f",acvtiError)+" Bq";
  				    	
    						
    						ActivityTableau.add(Activity_);
    						ActivityErrorTableau.add(Activity_Error);
    						
  						  }
		    			  
		    			  collect=collect+linResult+"      "+nceid+"      "+Activity_+Activity_Error+lin;
						}
						textArea.setText("");
						String eps= "                                   ";
						String Names = "             Channel"+eps+"Energy"+eps+"FWHM"+eps+"Net area                          Background                          Error (%)";
						textArea.setText(Names+"        "+"nucleids"+"        "+"Activity�Error(Bq) "+lin+lin+collect);
						
						frameIdentific.dispose();
					}
				});
				bntEdit.setBounds(100, 155, 70, 23);
				paneldendific.add(bntEdit);
				
				JButton btnEdit1 = new JButton("Cancel");
				btnEdit1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	 			    
						
						
						frameIdentific.dispose();	
		   
					}
				});
				btnEdit1.setBounds(200, 155, 100, 23);
				paneldendific.add(btnEdit1);
				
				frameIdentific.setSize(450,250);
				frameIdentific.setResizable(false);
				frameIdentific.setVisible(true);
				
				
				
			}
		});
		mnT.add(mntmIdentification);
		mnT.add(mntmEditInfosAnd);
		
		mnT.add(mnFileRapport);
		
		JMenuItem mntmNameRapport = new JMenuItem("Name file");
		mntmNameRapport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
				String fichie0=null;
				
                     JFileChooser dialogue = new JFileChooser("results");
				                             dialogue.setDialogTitle("Save report "); 
				                            if (dialogue.showSaveDialog(null) ==  JFileChooser.APPROVE_OPTION) {
					
					                                  fichie0 = dialogue.getSelectedFile().getAbsolutePath();
					                                 		
				                               }			
				                           String fichier1 = fichie0;				
				//____________________________________________________________________________________
				
			    File ff=new File(fichier1); // d�finir l'arborescence
			    String stta1 = null;
			   	try {
			   		if(forRaport=="logTreatmnt") {
			   		 stta1 =textArea.getText();
			   		}
			   		if(forRaport=="Treatmnt") {
				   		 stta1 =textArea.getText();
				   		}
					ff.createNewFile();
					FileWriter ffw = new FileWriter(ff);
				   	String mot00 ="Operator                      : "+Edit1;
				   	//String mot0 ="Centre                        : FSR_CNSETEN";
				   	java.util.Date date = new java.util.Date();
				   	String mot1 ="Date                          :" +date; 
					String mot2= "Name of the analyzed file     : "+namFile;  	
					//String mot3= "Spectre nucleaire             : Maroc";
					String cmmt ="Comment                       : "+Edit3;
		
					String Newligne=System.getProperty("line.separator"); 
					String resultats=mot00+Newligne+mot1+Newligne+mot2+Newligne+cmmt+Newligne; 
					ffw.write(resultats);
					ffw.write("\n"); 					
					ffw.write(stta1);
					ffw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
				//____________________________________________________________________________________
			}
		});
		mnFileRapport.add(mntmNameRapport);
		
		JMenu mnGraphView = new JMenu("Graphical View");
		menuBar.add(mnGraphView);
		
		JMenu mnSpectrum = new JMenu("Spectrum");
		mnSpectrum.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mnSpectrum.setEnabled(false);}
				else{mnSpectrum.setEnabled(true);}
			}
		});
		mnGraphView.add(mnSpectrum);
		
		rdbtnmntmView_5 = new JRadioButtonMenuItem("view");
		
		JRadioButtonMenuItem rdbtnmntmHinddel = new JRadioButtonMenuItem("hidden");
		rdbtnmntmHinddel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmHinddel.isSelected()){rdbtnmntmView_5.setSelected(false);}
				else{rdbtnmntmView_5.setSelected(true);}
				
			}
		});
		
		rdbtnmntmView_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmView_5.isSelected()){rdbtnmntmHinddel.setSelected(false);}
				else{rdbtnmntmHinddel.setSelected(true);}	
				
			}
		});
		rdbtnmntmView_5.setSelected(true);
		mnSpectrum.add(rdbtnmntmView_5);
		mnSpectrum.add(rdbtnmntmHinddel);
		
		JMenu mnG = new JMenu("Single peaks");
		mnG.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mnG.setEnabled(false);}
				else{mnG.setEnabled(true);}
			}
		});
		mnGraphView.add(mnG);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("hidden");
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnmntmNewRadioItem.isSelected()){rdbtnmntmView.setSelected(false);}
				else{rdbtnmntmView.setSelected(true);}
				
			}
		});
		
		 rdbtnmntmView = new JRadioButtonMenuItem("view");
		 
		 rdbtnmntmView.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		if(rdbtnmntmView.isSelected()){rdbtnmntmNewRadioItem.setSelected(false);}
		 		else{rdbtnmntmNewRadioItem.setSelected(true);}
		 		
		 	}
		 });
		 rdbtnmntmView.setSelected(true);	
		mnG.add(rdbtnmntmView);
		
		mnG.add(rdbtnmntmNewRadioItem);
		
		JMenu mnMultiplePeaks = new JMenu("Multiple peaks");
		mnMultiplePeaks.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mnMultiplePeaks.setEnabled(false);}
				else{mnMultiplePeaks.setEnabled(true);}
				
			}
		});
		mnGraphView.add(mnMultiplePeaks);
		
		JRadioButtonMenuItem rdbtnmntmHidden = new JRadioButtonMenuItem("hidden");
		rdbtnmntmHidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmHidden.isSelected()){rdbtnmntmView_1.setSelected(false);}
				else{rdbtnmntmView_1.setSelected(true);}
			}
		});
		
		
		rdbtnmntmView_1 = new JRadioButtonMenuItem("view");
		rdbtnmntmView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnmntmView_1.isSelected()){rdbtnmntmHidden.setSelected(false);}
		 		else{rdbtnmntmHidden.setSelected(true);}	
				
			}
		});
		rdbtnmntmView_1.setSelected(true);
		mnMultiplePeaks.add(rdbtnmntmView_1);
		
		mnMultiplePeaks.add(rdbtnmntmHidden);
		
		JMenu mnDeconvolutionOfPeaks = new JMenu("Deconvolution of peaks");
		mnDeconvolutionOfPeaks.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mnDeconvolutionOfPeaks.setEnabled(false);}
				else{mnDeconvolutionOfPeaks.setEnabled(true);}	
				
			}
		});
		mnGraphView.add(mnDeconvolutionOfPeaks);
		
		
		 rdbtnmntmView_4 = new JRadioButtonMenuItem("view");
		
		 JRadioButtonMenuItem rdbtnmntmHidden_3 = new JRadioButtonMenuItem("hidden");
		rdbtnmntmHidden_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmHidden_3.isSelected()){rdbtnmntmView_4.setSelected(false);}
				else{rdbtnmntmView_4.setSelected(true);}
				
			}
		});
		
		rdbtnmntmView_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmView_4.isSelected()){rdbtnmntmHidden_3.setSelected(false);}
				else{rdbtnmntmHidden_3.setSelected(true);}
				
			}
		});
		rdbtnmntmView_4.setSelected(true);
		mnDeconvolutionOfPeaks.add(rdbtnmntmView_4);
				
		mnDeconvolutionOfPeaks.add(rdbtnmntmHidden_3);
		
		JMenu mnQueusSinglePeaks = new JMenu("Queus single peaks");
		mnQueusSinglePeaks.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mnQueusSinglePeaks.setEnabled(false);}
				else{mnQueusSinglePeaks.setEnabled(true);}	
				
			}
		});
		mnGraphView.add(mnQueusSinglePeaks);
		
	   rdbtnmntmView_2 = new JRadioButtonMenuItem("view");
		
		JRadioButtonMenuItem rdbtnmntmHidden_1 = new JRadioButtonMenuItem("hidden");
		rdbtnmntmHidden_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmHidden_1.isSelected()){rdbtnmntmView_2.setSelected(false);}
				else{rdbtnmntmView_2.setSelected(true);}	
				
			}
		});
		
		rdbtnmntmView_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmView_2.isSelected()){rdbtnmntmHidden_1.setSelected(false);}
				else{rdbtnmntmHidden_1.setSelected(true);}	
				
			}
		});
		rdbtnmntmView_2.setSelected(true);
		mnQueusSinglePeaks.add(rdbtnmntmView_2);
		
		
		mnQueusSinglePeaks.add(rdbtnmntmHidden_1);
		
		JMenu mnBackground = new JMenu("Background");
		mnBackground.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				if(fichier==null){mnBackground.setEnabled(false);}
				else{mnBackground.setEnabled(true);}
				
			}
		});
		mnGraphView.add(mnBackground);
		
		JRadioButtonMenuItem rdbtnmntmHidden_2 = new JRadioButtonMenuItem("hidden");
		rdbtnmntmHidden_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmHidden_2.isSelected()){rdbtnmntmView_3.setSelected(false);}
				else{rdbtnmntmView_3.setSelected(true);}
				
			}
		});
		
		rdbtnmntmView_3 = new JRadioButtonMenuItem("view");
		rdbtnmntmView_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnmntmView_3.isSelected()){rdbtnmntmHidden_2.setSelected(false);}
				else{rdbtnmntmHidden_2.setSelected(true);}	
				
			}
		});
		rdbtnmntmHidden_2.setSelected(true);
		mnBackground.add(rdbtnmntmView_3);
		
		mnBackground.add(rdbtnmntmHidden_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    this.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))))
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(14))
		);
		panel.setLayout(null);
						
		
		JLabel lblNPeak = new JLabel("Peak N�");
		
		textField = new JTextField();		
		textField.setBackground(SystemColor.inactiveCaptionBorder);
		textField.setColumns(10);
		
		JButton btnRange = new JButton("Range");
		btnRange.setForeground(Color.BLUE);
		btnRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String domainRang=btnRange.getText();
				if(domainRang=="Range") {btnRange.setText("Not Range");forRange="Range";}
				if(domainRang=="Not Range") {btnRange.setText("Range");}
				
			}
		});
		btnRange.setBackground(SystemColor.activeCaptionBorder);
		
		JButton btnNext = new JButton("Next");
		btnNext.setForeground(Color.BLUE);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Identification.identif();
        		
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
					
					float zomDomainPeak ;
					float zomRangPeak ;
					float zomBckgrndPeak ;
					float zomFwhmdPeak ;
					float AirCentr;
					float crrespndEnergy;
					
                    if(analyse=="g2") {
						
						if(Mainn.mntmPeakSearch.isSelected()) {
							
							if(firstenter==2) {if(clik==0) {clik=PeakSearch.centrePic.size()-1;
							}else if(clik==PeakSearch.centrePic.size()-1) {clik=0;}else{clik=clik+2;}				
							}if(clik>PeakSearch.centrePic.size()-1) {clik=PeakSearch.centrePic.size()-1;}
							
							zomDomainPeak =		Float.parseFloat(PeakSearch.centrePic.get(clik));//centroide de pic channel
				            zomRangPeak   =		Float.parseFloat(PeakSearch.energyPic.get(clik));  //energie correspend � centroide de pic
				            zomFwhmdPeak  =		Float.parseFloat(PeakSearch.RangPic.get(clik));// fwhm
				            AirCentr      =     Float.parseFloat(PeakSearch.AirPic.get(clik));  //air corespd au centre de pic
				            
				          //---------for Marker--------------------
				            if(btnRange.getText()=="Range") {
				            Loggraph.domainAxis.setAutoRange(true);
				            Loggraph.rangeAxis.setAutoRange(true);
				            }else {
				            	Loggraph.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
				            	Loggraph.rangeAxis.setRange(0,Math.log(AirCentr)+Math.log(AirCentr)/2);	
				            }
							
				            Loggraph.plot.clearDomainMarkers();
				            Loggraph.start3 = new ValueMarker(zomDomainPeak);
				            Loggraph.start3.setStroke( new BasicStroke( 3 ) );
				            Loggraph.start3.setPaint(Color.RED);
		        		    int nbpk=clik+1;
		        		    Loggraph.start3.setLabel("Peak N�:"+nbpk+"  Cnl: "+zomDomainPeak+"   E: "+zomRangPeak+" Kev");
		        		    Loggraph.start3.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
		        		    Loggraph.start3.setLabelPaint(Color.RED);
		        		    Loggraph.start3.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		        		    Loggraph.start3.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
		        		    Loggraph.plot.addDomainMarker( Loggraph.start3);	    
		        		  //--------------------------------------
		        		 
			        		  Vchannel.setText(PeakSearch.centrePic.get(clik));
			      			  Vchannel.setBounds(300, 5, 90, 17);
			      			  pan2.add(Vchannel);
			      			    
			      			  Venrg.setText(PeakSearch.energyPic.get(clik)+" Kev");
			    			  Venrg.setBounds(280, 30, 90, 17);
			    			  pan2.add(Venrg);
			    			  
			    			  Vaer.setText("");
			    			  Vaer.setBounds(480, 5, 90, 17);
			    			  pan2.add(Vaer);
			    			  
			    			  VERe.setText("");
			    			  VERe.setBounds(480, 30, 90, 17);
			    			  pan2.add(VERe);
			    			  
			    			  VFHM.setText("");
			    			  VFHM.setBounds(480, 30, 90, 17);
			    			  pan2.add(VFHM);
			    			  
			    			  Vnucleid.setText("");
			    			  Vnucleid.setBounds(680, 5, 600, 17);
			    			  pan2.add(Vnucleid);
			    			  
			    			  VENRG.setText("");
			    			  VENRG.setBounds(680, 30, 600, 17);
			    			  pan2.add(VENRG);
			    			  
			    			  Vintensity.setText("");
			    			  Vintensity.setBounds(680, 55, 600, 17);
			    			  pan2.add(Vintensity);
			    			  
			    			  VHilfelife.setText("");
			    			  VHilfelife.setBounds(680, 75, 600, 17);
			    			  pan2.add(VHilfelife);
			    			  
			    			  VActivity.setText("");
			    			  VActivity.setBounds(880, 5, 600, 17);
			    			  pan2.add(VActivity);
			    			  
			    			  
			    			  
			    			  
			      			 textField.setText(Integer.toString(clik+1));
			      			 firstenter=3;		        		    
		        		     if(clik==PeakSearch.energyPic.size()-1) {clik=0;}else  {clik=clik+1;}
						
					}else {JOptionPane.showMessageDialog(null, "First click on the search peaks menu ");}
						}
					
					if(analyse==null) {
						
						if(Mainn.mntmPeakSearch.isSelected()) {
							
							if(firstenter==2) {if(clik==0) {clik=PeakSearch.centrePic.size()-1;
							}else if(clik==PeakSearch.centrePic.size()-1) {clik=0;}else{clik=clik+2;}				
							}if(clik>PeakSearch.centrePic.size()-1) {clik=PeakSearch.centrePic.size()-1;}
							
							zomDomainPeak =		Float.parseFloat(PeakSearch.centrePic.get(clik));//centroide de pic channel
				            zomRangPeak   =		Float.parseFloat(PeakSearch.energyPic.get(clik));  //energie correspend � centroide de pic
				            zomFwhmdPeak  =		Float.parseFloat(PeakSearch.RangPic.get(clik));// fwhm
				            AirCentr      =     Float.parseFloat(PeakSearch.AirPic.get(clik));  //air corespd au centre de pic
				            
						
				          //---------for Marker--------------------
				            if(btnRange.getText()=="Range") {
				            	Ggraphique.domainAxis.setAutoRange(true);
				            	Ggraphique.rangeAxis.setAutoRange(true);
				            }else {
				            	Ggraphique.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
				            	Ggraphique.rangeAxis.setRange(0,AirCentr+AirCentr/2);
				            	}
				           
		        		    Ggraphique.plot.clearDomainMarkers();
		        		    Ggraphique.start2 = new ValueMarker(zomDomainPeak);
		        		    Ggraphique.start2.setStroke( new BasicStroke( 3 ) );
		        		    Ggraphique.start2.setPaint(Color.RED);
		        		    int nbpk=clik+1;
		        		    Ggraphique.start2.setLabel("Peak N�:"+nbpk+"  Cnl: "+zomDomainPeak+"   E: "+zomRangPeak+" Kev");
		        		    Ggraphique.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
		        		    Ggraphique.start2.setLabelPaint(Color.RED);
		        		    Ggraphique.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		        		    Ggraphique.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
		        		    Ggraphique.plot.addDomainMarker( Ggraphique.start2);	    
		        		  //-------------------------------------------------------------------
		        		    
			        		  Vchannel.setText(PeakSearch.centrePic.get(clik));
			      			  Vchannel.setBounds(300, 5, 90, 17);
			      			  pan2.add(Vchannel);
			      			    
			      			  Venrg.setText(PeakSearch.energyPic.get(clik)+" Kev");
			    			  Venrg.setBounds(280, 30, 90, 17);
			    			  pan2.add(Venrg);
			    			  
			    			  Vaer.setText("");
			    			  Vaer.setBounds(480, 5, 90, 17);
			    			  pan2.add(Vaer);
			    			  
			    			  VERe.setText("");
			    			  VERe.setBounds(480, 30, 90, 17);
			    			  pan2.add(VERe);
			    			  
			    			  VFHM.setText("");
			    			  VFHM.setBounds(480, 30, 90, 17);
			    			  pan2.add(VFHM);
			    			  
			    			  Vnucleid.setText("");
			    			  Vnucleid.setBounds(680, 5, 600, 17);
			    			  pan2.add(Vnucleid);
			    			  
			    			  VENRG.setText("");
			    			  VENRG.setBounds(680, 30, 600, 17);
			    			  pan2.add(VENRG);
			    			  
			    			  Vintensity.setText("");
			    			  Vintensity.setBounds(680, 55, 600, 17);
			    			  pan2.add(Vintensity);
			    			  
			    			  VHilfelife.setText("");
			    			  VHilfelife.setBounds(680, 75, 600, 17);
			    			  pan2.add(VHilfelife);
			    			  
			    			  
			    			  VActivity.setText("");
			    			  VActivity.setBounds(880, 5, 600, 17);
			    			  pan2.add(VActivity);
			    			  
			    			  
			    			  textField.setText(Integer.toString(clik+1));
			      			 firstenter=3;		        		    
		        		     if(clik==PeakSearch.energyPic.size()-1) {clik=0;}else  {clik=clik+1;}
						
					}else {JOptionPane.showMessageDialog(null, "First click on the search peaks menu ");}
						}

					
					if(analyse=="g3") {
						panel.removeAll();
						repaint();
						ChartPanel frPk = null;
						
						if(firstenter==2) {if(clik==0) {clik=treatmentLog.DomainAxisPeakCmpr.size()-1;
						}else if(clik==treatmentLog.DomainAxisPeakCmpr.size()-1) {clik=0;}else{clik=clik+2;}				
						}if(clik>treatmentLog.DomainAxisPeakCmpr.size()-1) {clik=treatmentLog.DomainAxisPeakCmpr.size()-1;}
						
						zomDomainPeak =		Float.parseFloat(treatmentLog.DomainAxisPeakCmpr.get(clik));//centroide de pic
						crrespndEnergy =	Float.parseFloat(treatmentLog.EnergyAxisPeakCmpr.get(clik));						
			            zomRangPeak   =		Float.parseFloat(treatmentLog.RangAxisPeakCmpr.get(clik));  //air correspend � centroide de pic
			            zomBckgrndPeak=		Float.parseFloat(treatmentLog.BckgrdAxisPeakCmpr.get(clik));// moyen de Backgroud
			            zomFwhmdPeak  =		Float.parseFloat(treatmentLog.FwhmAxisPeakCmpr.get(clik));// fwhm
			            
			            if(btnRange.getText()=="Range") {
			            	treatmentLog.domainAxis.setAutoRange(true);
			            	treatmentLog.rangeAxis.setAutoRange(true);
				            }else {
				            	treatmentLog.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
	        		            treatmentLog.rangeAxis.setRange(zomBckgrndPeak-zomRangPeak/2,zomRangPeak+zomRangPeak/2);
	        		            }
	        		    frPk = treatmentLog.chartPanel;
	        		   
	        		    //---------for Marker--------------------
	        		    treatmentLog.plot.clearDomainMarkers();
	        		    treatmentLog.start2 = new ValueMarker(zomDomainPeak);
	        		    treatmentLog.start2.setStroke( new BasicStroke( 3 ) );
	        		    treatmentLog.start2.setPaint(Color.RED);
	        		    int nbpk=clik+1;
	        		    treatmentLog.start2.setLabel("Peak N�:"+nbpk+"  Cnl: "+treatmentLog.DomainAxisPeakCmpr.get(clik)+"   E: "+treatmentLog.EnergyAxisPeakCmpr.get(clik)+" Kev");
	        		    treatmentLog.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
	        		    treatmentLog.start2.setLabelPaint(Color.RED);
	        		    treatmentLog.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
	        		    treatmentLog.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
	        		    treatmentLog.plot.addDomainMarker(treatmentLog.start2);
	        		
	        		    //--------------------------------------
	        		    
		        		  Vchannel.setText(treatmentLog.DomainAxisPeakCmpr.get(clik));
		      			  Vchannel.setBounds(300, 5, 90, 17);
		      			  pan2.add(Vchannel);
		      			    
		      			  Venrg.setText(treatmentLog.EnergyAxisPeakCmpr.get(clik)+" Kev");
		    			  Venrg.setBounds(280, 30, 90, 17);
		    			  pan2.add(Venrg);
		    			  
		    			  Vaer.setText(treatmentLog.AreayAxisPeakCmpr.get(clik)+" Cnts");
		    			  Vaer.setBounds(480, 5, 90, 17);
		    			  pan2.add(Vaer);
		    			  
		    			  VERe.setText(treatmentLog.ErrorAxisPeakCmpr.get(clik)+" %");
		    			  VERe.setBounds(480, 30, 90, 17);
		    			  pan2.add(VERe);
		    			  
		    			  VFHM.setText(treatmentLog.FwhmAxisPeakCmpr.get(clik)+" Kev");
		    			  VFHM.setBounds(480, 55, 90, 17);
		    			  pan2.add(VFHM);
		    			  
		    			  Vnucleid.setText(radinucleidNuc.get(clik));
		    			  Vnucleid.setBounds(680, 5, 600, 17);
		    			  pan2.add(Vnucleid);
		    			  
		    			  VENRG.setText(nucleidEnergyNuc.get(clik));
		    			  VENRG.setBounds(680, 30, 600, 17);
		    			  pan2.add(VENRG);
		    			  
		    			  Vintensity.setText(nucIntensityNuc.get(clik));
		    			  Vintensity.setBounds(680, 55, 600, 17);
		    			  pan2.add(Vintensity);
		    			  
		    			  
		    			  VHilfelife.setText(hilflifeNuc.get(clik));
		    			  VHilfelife.setBounds(680, 75, 600, 17);
		    			  pan2.add(VHilfelife);
		    			 
		    			  String EffiCaljs,coffi1s, coffi2s, coffi3s, coffi4s, coffi5s, coffi6s, enrgjs;
		    			  Float EffiCalj = null,coffi1, coffi2, coffi3, coffi4, coffi5, coffi6, enrgj;
		    			  
		    			  
		    			  enrgjs  =nucleidEnergyNuc.get(clik).replaceAll("Kev", "").replaceAll("\\s+", "");
		    			 
		    			  
                         String cleanedStr = nucIntensityNuc.get(clik).replaceAll("[\\s%]", "");
		    		      
		    			  if (!cleanedStr.isEmpty()) {
		    		            // Convertir en float
		    		            float floatValue = Float.parseFloat(cleanedStr);
		    		            enrgj  =Float.parseFloat(enrgjs);
		    		            
		    		            
		    		            if(Mainn.formula.equals("Formula1")) {
			  		    			  coffi1s =textField1tpe.getText();					    
			  		    			  coffi2s =textField2tpe.getText();					    
			  		    			  coffi3s =textField3tpe.getText();					    
			  		    			  coffi4s =textField4tpe.getText();					    
			  		    			  coffi5s =textField5tpe.getText();					    	    
			  		    			  coffi6s =textField6tpe.getText();
			  		    			  
			  		    			  coffi1=Float.parseFloat(coffi1s);
			  				    	  coffi2=Float.parseFloat(coffi2s);
			  				 		  coffi3=Float.parseFloat(coffi3s);
			  				    	  coffi4=Float.parseFloat(coffi4s);
			  				    	  coffi5=Float.parseFloat(coffi5s);
			  				    	  coffi6=Float.parseFloat(coffi6s);
			  				    	EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgj) + coffi3 * Math.pow(Math.log(enrgj), 2) + coffi4 * Math.pow(Math.log(enrgj), 3)+ coffi5 * Math.pow(Math.log(enrgj), 4) + coffi6 * Math.pow(Math.log(enrgj), 5))));
			  		    			  };  
			  		    			if(Mainn.formula.equals("Formula2")) {
				  		    			  coffi1s =textField1tpeF2.getText();					    
				  		    			  coffi2s =textField2tpeF2.getText();					    
				  		    			  
				  		    			  coffi1=Float.parseFloat(coffi1s);
				  				    	  coffi2=Float.parseFloat(coffi2s);
				  				    	EffiCalj=(float)(coffi1* Math.pow(enrgj, coffi2));
				  				    	//EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgjeff) + coffi3 * Math.pow(Math.log(enrgjeff), 2) + coffi4 * Math.pow(Math.log(enrgjeff), 3)+ coffi5 * Math.pow(Math.log(enrgjeff), 4) + coffi6 * Math.pow(Math.log(enrgjeff), 5))));
				  		    			  };
				  		    			  
				  		    			if(Mainn.formula.equals("Formula3")) {
				  		    				coffi1s =textField1tpeF3.getText();					    
					  		    			  coffi2s =textField2tpeF3.getText();					    
					  		    			  coffi3s =textField3tpeF3.getText();					    
					  		    			  coffi4s =textField4tpeF3.getText();					    
					  		    			  coffi5s =textField5tpeF3.getText();					    	    
					  		    			  coffi6s =textField6tpeF3.getText();
					  		    			  
					  		    			  coffi1=Float.parseFloat(coffi1s);
					  				    	  coffi2=Float.parseFloat(coffi2s);
					  				 		  coffi3=Float.parseFloat(coffi3s);
					  				    	  coffi4=Float.parseFloat(coffi4s);
					  				    	  coffi5=Float.parseFloat(coffi5s);
					  				    	  coffi6=Float.parseFloat(coffi6s);
					  				    	EffiCalj=(float)( coffi1 + coffi2 * enrgj + coffi3 * Math.pow(enrgj, 2) + coffi4 * Math.pow(enrgj, 3) 
					  		              + coffi5 * Math.pow(enrgj, 4) + coffi6 * Math.pow(enrgj, 5));
					  		 
				  		    			};
				  		    			if(Mainn.formula.equals("Formula4")) {
				  		    				  coffi1s =textField1tpeF4.getText();					    
					  		    			  coffi2s =textField2tpeF4.getText();					    
					  		    			  coffi3s =textField3tpeF4.getText();					    
					  		    			  
					  		    			  coffi1=Float.parseFloat(coffi1s);
					  				    	  coffi2=Float.parseFloat(coffi2s);
					  				 		  coffi3=Float.parseFloat(coffi3s);
					  				    	  
					  				 		EffiCalj=(float)(  Math.exp(coffi1+ coffi2*enrgj+coffi3*Math.pow(enrgj, 2)));
					  				 		 
				  		    			};
			    		            
		    		          
		    		          
		    		            
		    		            Float acvti=Float.parseFloat(treatmentLog.AreayAxisPeakCmpr.get(clik))/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
				    			  
				    			  
				    			  float floatErreurArea = Float.parseFloat(treatmentLog.ErrorAxisPeakCmpr.get(clik));
				    			  Float floatErreurActivity=floatErreurArea/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
					    		  String ActivityErreur =Float.toString(acvti)+"    �  " + floatErreurActivity + "  "+ "Bq";	 
				    			  VActivity.setText(ActivityErreur);				    			  
				    		      //System.out.println(treatmentLog.ForIdentification.get(clik)+"      "+ActivityErreur ); 
				    			  
		    		        } else {
		    		        	VActivity.setText("");
		    		        }
		    			  
		    			  
		    			  VActivity.setBounds(880, 5, 600, 17);
		    			  pan2.add(VActivity);
		    			 
		      			    
		      			  textField.setText(Integer.toString(clik+1));
							
		      				panel.setLayout(new java.awt.BorderLayout());
							panel.add(frPk);
							panel.validate();
							firstenter=3;
	        		    
	        		    if(clik==treatmentLog.DomainAxisPeakCmpr.size()-1) {clik=0;}else  {clik=clik+1;}
						
					}
					if(analyse=="g") {
						panel.removeAll();
						repaint();
						ChartPanel frPk = null;
						if(firstenter==2) {if(clik==0) {clik=treatment1.DomainAxisPeak.size()-1;
						}else if(clik==treatment1.DomainAxisPeak.size()-1) {clik=0;}else{clik=clik+2;}				
						}if(clik>treatment1.DomainAxisPeak.size()-1) {clik=treatment1.DomainAxisPeak.size()-1;}	
						
						zomDomainPeak =		Float.parseFloat(treatment1.DomainAxisPeak.get(clik));//centroide de pic
			            zomRangPeak   =		Float.parseFloat(treatment1.RangAxisPeak.get(clik));  //air correspend � centroide de pic
			            zomBckgrndPeak=		Float.parseFloat(treatment1.BckgrdAxisPeak.get(clik));// moyen de Backgroud
			            zomFwhmdPeak  =		Float.parseFloat(treatment1.FwhmAxisPeak.get(clik));// fwhm	
			            
			            if(btnRange.getText()=="Range") {
			            	treatment1.domainAxis.setAutoRange(true);
			            	treatment1.rangeAxis.setAutoRange(true);
				            }else {
			            treatment1.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
	        		    treatment1.rangeAxis.setRange(zomBckgrndPeak-zomRangPeak/2,zomRangPeak+zomRangPeak/2);
				            }
	        		    frPk = treatment1.chartPanel;
	        		    
	        		  //---------for Marker--------------------
	        		    treatment1.plot.clearDomainMarkers();
	        		    treatment1.start2 = new ValueMarker(zomDomainPeak);
	        		    treatment1.start2.setPaint(Color.RED);
	        		    treatment1.start2.setStroke( new BasicStroke( 3 ) );
	        		    int nbpk=clik+1;
	        		    treatment1.start2.setLabel("Peak N�:"+nbpk+"  Cnl: "+treatment1.DomainAxisPeak.get(clik)+"   E: "+treatment1.EnergyAxisPeak.get(clik)+" Kev");
	        		    treatment1.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
	        		    treatment1.start2.setLabelPaint(Color.RED);
	        		    treatment1.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
	        		    treatment1.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
	        		    treatment1.plot.addDomainMarker(treatment1.start2);
	        		    
	        		    //--------------------------------------
	  
		        		  Vchannel.setText(treatment1.DomainAxisPeak.get(clik));
		      			  Vchannel.setBounds(300, 5, 90, 17);
		      			  pan2.add(Vchannel);
		      			    
		      			  Venrg.setText(treatment1.EnergyAxisPeak.get(clik)+" Kev");
		    			  Venrg.setBounds(280, 30, 90, 17);
		    			  pan2.add(Venrg);
		    			  
		    			  Vaer.setText(treatment1.AreayAxisPeak.get(clik)+" Cnts");
		    			  Vaer.setBounds(480, 5, 90, 17);
		    			  pan2.add(Vaer);
		    			  
		    			  VERe.setText(treatment1.ErrorAxisPeak.get(clik)+" %");
		    			  VERe.setBounds(480, 30, 90, 17);
		    			  pan2.add(VERe);
		    			  
		    			  VFHM.setText(treatment1.FwhmAxisPeak.get(clik)+" Kev");
		    			  VFHM.setBounds(480, 55, 90, 17);
		    			  pan2.add(VFHM);
		    			  
		    			  Vnucleid.setText(radinucleidNuc.get(clik));
		    			  Vnucleid.setBounds(680, 5, 600, 17);
		    			  pan2.add(Vnucleid);
		    			  
		    			  VENRG.setText(nucleidEnergyNuc.get(clik));
		    			  VENRG.setBounds(680, 30, 600, 17);
		    			  pan2.add(VENRG);
		    			  
		    			  Vintensity.setText(nucIntensityNuc.get(clik));
		    			  Vintensity.setBounds(680, 55, 600, 17);
		    			  pan2.add(Vintensity);
		    			  
		    			  VHilfelife.setText(hilflifeNuc.get(clik));
		    			  VHilfelife.setBounds(680, 75, 600, 17);
		    			  pan2.add(VHilfelife);
		    			  
		    			  String EffiCaljs,coffi1s, coffi2s, coffi3s, coffi4s, coffi5s, coffi6s, enrgjs;
		    			  Float EffiCalj = null,coffi1, coffi2, coffi3, coffi4, coffi5, coffi6, enrgj;
		    			  
		    			  enrgjs  =nucleidEnergyNuc.get(clik).replaceAll("Kev", "").replaceAll("\\s+", "");
		    			 
                          
                         String cleanedStr = nucIntensityNuc.get(clik).replaceAll("[\\s%]", "");
		    		      
		    			  if (!cleanedStr.isEmpty()) {
		    		            // Convertir en float
		    		            float floatValue = Float.parseFloat(cleanedStr);
		    		            enrgj  =Float.parseFloat(enrgjs);
		    		            
		    		            if(Mainn.formula.equals("Formula1")) {
			  		    			  coffi1s =textField1tpe.getText();					    
			  		    			  coffi2s =textField2tpe.getText();					    
			  		    			  coffi3s =textField3tpe.getText();					    
			  		    			  coffi4s =textField4tpe.getText();					    
			  		    			  coffi5s =textField5tpe.getText();					    	    
			  		    			  coffi6s =textField6tpe.getText();
			  		    			  
			  		    			  coffi1=Float.parseFloat(coffi1s);
			  				    	  coffi2=Float.parseFloat(coffi2s);
			  				 		  coffi3=Float.parseFloat(coffi3s);
			  				    	  coffi4=Float.parseFloat(coffi4s);
			  				    	  coffi5=Float.parseFloat(coffi5s);
			  				    	  coffi6=Float.parseFloat(coffi6s);
			  				    	EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgj) + coffi3 * Math.pow(Math.log(enrgj), 2) + coffi4 * Math.pow(Math.log(enrgj), 3)+ coffi5 * Math.pow(Math.log(enrgj), 4) + coffi6 * Math.pow(Math.log(enrgj), 5))));
			  		    			  }; 
			  		    			if(Mainn.formula.equals("Formula2")) {
				  		    			  coffi1s =textField1tpeF2.getText();					    
				  		    			  coffi2s =textField2tpeF2.getText();					    
				  		    			  
				  		    			  coffi1=Float.parseFloat(coffi1s);
				  				    	  coffi2=Float.parseFloat(coffi2s);
				  				    	EffiCalj=(float)(coffi1* Math.pow(enrgj, coffi2));
				  				    	//EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgjeff) + coffi3 * Math.pow(Math.log(enrgjeff), 2) + coffi4 * Math.pow(Math.log(enrgjeff), 3)+ coffi5 * Math.pow(Math.log(enrgjeff), 4) + coffi6 * Math.pow(Math.log(enrgjeff), 5))));
				  		    			  };
				  		    			  
				  		    			if(Mainn.formula.equals("Formula3")) {
				  		    				coffi1s =textField1tpeF3.getText();					    
					  		    			  coffi2s =textField2tpeF3.getText();					    
					  		    			  coffi3s =textField3tpeF3.getText();					    
					  		    			  coffi4s =textField4tpeF3.getText();					    
					  		    			  coffi5s =textField5tpeF3.getText();					    	    
					  		    			  coffi6s =textField6tpeF3.getText();
					  		    			  
					  		    			  coffi1=Float.parseFloat(coffi1s);
					  				    	  coffi2=Float.parseFloat(coffi2s);
					  				 		  coffi3=Float.parseFloat(coffi3s);
					  				    	  coffi4=Float.parseFloat(coffi4s);
					  				    	  coffi5=Float.parseFloat(coffi5s);
					  				    	  coffi6=Float.parseFloat(coffi6s);
					  				    	EffiCalj=(float)( coffi1 + coffi2 * enrgj + coffi3 * Math.pow(enrgj, 2) + coffi4 * Math.pow(enrgj, 3) 
					  		              + coffi5 * Math.pow(enrgj, 4) + coffi6 * Math.pow(enrgj, 5));
					  		 
				  		    			};
				  		    			if(Mainn.formula.equals("Formula4")) {
				  		    				  coffi1s =textField1tpeF4.getText();					    
					  		    			  coffi2s =textField2tpeF4.getText();					    
					  		    			  coffi3s =textField3tpeF4.getText();					    
					  		    			  
					  		    			  coffi1=Float.parseFloat(coffi1s);
					  				    	  coffi2=Float.parseFloat(coffi2s);
					  				 		  coffi3=Float.parseFloat(coffi3s);
					  				    	  
					  				 		EffiCalj=(float)(  Math.exp(coffi1+ coffi2*enrgj+coffi3*Math.pow(enrgj, 2)));
					  				 		  
					  				    	
				  		    			};
			    		            
		    		            
		    		            
			    		        
			    		              
		    		            
			    		        Float acvti=Float.parseFloat(treatment1.AreayAxisPeak.get(clik))/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
				    			  
				    			  float floatErreurArea = Float.parseFloat(treatment1.ErrorAxisPeak.get(clik));
				    			  Float floatErreurActivity=floatErreurArea/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
				    			  String ActivityErrer=Float.toString(acvti)+"    �  " + floatErreurActivity+ "  "+ "Bq" ;
				    			  VActivity.setText(ActivityErrer );
				    			  
				    			  //System.out.println(treatment1.ForIdentification1.get(clik)+"      "+ActivityErrer ); 
				    			  
		    		        } else {
		    		        	VActivity.setText("");
		    		        }
                         
		    			  
		    			  VActivity.setBounds(880, 5, 600, 17);
		    			  pan2.add(VActivity);
		    			  
		      			  textField.setText(Integer.toString(clik+1));
		      			
		      				panel.setLayout(new java.awt.BorderLayout());
							panel.add(frPk);
							panel.validate();
							firstenter=3;
						if(clik==treatment1.DomainAxisPeak.size()-1) {clik=0;}else  {clik=clik+1;}	
						
					
					}
				}
				
			}
		});
		btnNext.setBackground(SystemColor.activeCaptionBorder);
		btnNext.setToolTipText( "View next peak " ); 
		
		JButton btnPrevios = new JButton("Previous");
		btnPrevios.setForeground(Color.BLUE);
		btnPrevios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Identification.identif();
        		if(fichier==null){JOptionPane.showMessageDialog(null, "enter spectrum file ");}
				else{
        		  
					float zomDomainPeak ;
					float zomRangPeak ;
					float zomBckgrndPeak ;
					float zomFwhmdPeak ;
					float AirCentr;
					
                      if(analyse=="g2") {
						
						if(Mainn.mntmPeakSearch.isSelected()) {
							if(firstenter==3) {if(clik==0) {clik=PeakSearch.centrePic.size()-1;
							}else if(clik==PeakSearch.centrePic.size()-1) {clik=0;}else{clik=clik-2;}				
							}if(clik<0) {clik=0;}	
							
							zomDomainPeak =		Float.parseFloat(PeakSearch.centrePic.get(clik));//centroide de pic channel
				            zomRangPeak   =		Float.parseFloat(PeakSearch.energyPic.get(clik));  //energie correspend � centroide de pic
				            zomFwhmdPeak  =		Float.parseFloat(PeakSearch.RangPic.get(clik));// fwhm
				            AirCentr      =     Float.parseFloat(PeakSearch.AirPic.get(clik));  //air corespd au centre de pic
				            
        		            
						
				          //---------for Marker--------------------
				            if(btnRange.getText()=="Range") {
				            	Loggraph.domainAxis.setAutoRange(true);
				            	Loggraph.rangeAxis.setAutoRange(true);
				            }else {
				            	Loggraph.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
				            	Loggraph.rangeAxis.setRange(0,Math.log(AirCentr)+Math.log(AirCentr)/2);
				            	}
							
				            Loggraph.plot.clearDomainMarkers();
				            Loggraph.start3 = new ValueMarker(zomDomainPeak);
				            Loggraph.start3.setStroke( new BasicStroke( 3 ) );
				            Loggraph.start3.setPaint(Color.RED);
		        		    int nbpk=clik+1;
		        		    Loggraph.start3.setLabel("Peak N�:"+nbpk+"  Cnl: "+zomDomainPeak+"   E: "+zomRangPeak+" Kev");
		        		    Loggraph.start3.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
		        		    Loggraph.start3.setLabelPaint(Color.RED);
		        		    Loggraph.start3.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		        		    Loggraph.start3.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
		        		    Loggraph.plot.addDomainMarker( Loggraph.start3);	    
		        		  //--------------------------------------
		        		    
		        		    Vchannel.setText(PeakSearch.centrePic.get(clik));
			      			  Vchannel.setBounds(300, 5, 90, 17);
			      			  pan2.add(Vchannel);
			      			    
			      			  Venrg.setText(PeakSearch.energyPic.get(clik)+" Kev");
			    			  Venrg.setBounds(280, 30, 90, 17);
			    			  pan2.add(Venrg);
			    			  
			    			  Vaer.setText("");
			    			  Vaer.setBounds(480, 5, 90, 17);
			    			  pan2.add(Vaer);
			    			  
			    			  VERe.setText("");
			    			  VERe.setBounds(480, 30, 90, 17);
			    			  pan2.add(VERe);
			    			  
			    			  VFHM.setText("");
			    			  VFHM.setBounds(480, 30, 90, 17);
			    			  pan2.add(VFHM);
			    			  
			    			  Vnucleid.setText("");
			    			  Vnucleid.setBounds(680, 5, 600, 17);
			    			  pan2.add(Vnucleid);
			    			  
			    			  VENRG.setText("");
			    			  VENRG.setBounds(680, 30, 600, 17);
			    			  pan2.add(VENRG);
			    			  
			    			  Vintensity.setText("");
			    			  Vintensity.setBounds(680, 55, 600, 17);
			    			  pan2.add(Vintensity);
			    			  
			    			  VHilfelife.setText("");
			    			  VHilfelife.setBounds(680, 75, 600, 17);
			    			  pan2.add(VHilfelife);
			    			 
			    			  
			    			  VActivity.setText("");
			    			  VActivity.setBounds(880, 5, 600, 17);
			    			  pan2.add(VActivity);
			    			  
			      			 textField.setText(Integer.toString(clik+1));
			      			firstenter=2;
							if(clik==0) {clik=PeakSearch.energyPic.size()-1;} else {clik=clik-1;}

						}else {JOptionPane.showMessageDialog(null, "First click on the search peaks menu ");}
						}
					
					
                    if(analyse==null) {
						
						if(Mainn.mntmPeakSearch.isSelected()) {
							if(firstenter==3) {if(clik==0) {clik=PeakSearch.centrePic.size()-1;
							}else if(clik==PeakSearch.centrePic.size()-1) {clik=0;}else{clik=clik-2;}				
							}if(clik<0) {clik=0;}	
							
							zomDomainPeak =		Float.parseFloat(PeakSearch.centrePic.get(clik));//centroide de pic channel
				            zomRangPeak   =		Float.parseFloat(PeakSearch.energyPic.get(clik));  //energie correspend � centroide de pic
				            zomFwhmdPeak  =		Float.parseFloat(PeakSearch.RangPic.get(clik));// fwhm
				            AirCentr      =     Float.parseFloat(PeakSearch.AirPic.get(clik));  //air corespd au centre de pic
				            
        		            
						
				          //---------for Marker--------------------
				            if(btnRange.getText()=="Range") {
				            	Ggraphique.domainAxis.setAutoRange(true);
				            	Ggraphique.rangeAxis.setAutoRange(true);
				            }else {
				            	Ggraphique.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
				            	Ggraphique.rangeAxis.setRange(0,AirCentr+AirCentr/2);	
				            }
							
		        		    Ggraphique.plot.clearDomainMarkers();
		        		    Ggraphique.start2 = new ValueMarker(zomDomainPeak);
		        		    Ggraphique.start2.setStroke( new BasicStroke( 3 ) );
		        		    Ggraphique.start2.setPaint(Color.RED);
		        		    int nbpk=clik+1;
		        		    Ggraphique.start2.setLabel("Peak N�:"+nbpk+"  Cnl: "+zomDomainPeak+"   E: "+zomRangPeak+" Kev");
		        		    Ggraphique.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
		        		    Ggraphique.start2.setLabelPaint(Color.RED);
		        		    Ggraphique.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		        		    Ggraphique.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
		        		    Ggraphique.plot.addDomainMarker( Ggraphique.start2);	    
		        		  //--------------------------------------
		        		    Vchannel.setText(PeakSearch.centrePic.get(clik));
			      			  Vchannel.setBounds(300, 5, 90, 17);
			      			  pan2.add(Vchannel);
			      			    
			      			  Venrg.setText(PeakSearch.energyPic.get(clik)+" Kev");
			    			  Venrg.setBounds(280, 30, 90, 17);
			    			  pan2.add(Venrg);
			    			  
			    			  Vaer.setText("");
			    			  Vaer.setBounds(480, 5, 90, 17);
			    			  pan2.add(Vaer);
			    			  
			    			  VERe.setText("");
			    			  VERe.setBounds(480, 30, 90, 17);
			    			  pan2.add(VERe);
			    			  
			    			  VFHM.setText("");
			    			  VFHM.setBounds(480, 30, 90, 17);
			    			  pan2.add(VFHM);
			    			  
			    			  Vnucleid.setText("");
			    			  Vnucleid.setBounds(680, 5, 600, 17);
			    			  pan2.add(Vnucleid);
			    			  
			    			  VENRG.setText("");
			    			  VENRG.setBounds(680, 30, 600, 17);
			    			  pan2.add(VENRG);
			    			  
			    			  Vintensity.setText("");
			    			  Vintensity.setBounds(680, 55, 600, 17);
			    			  pan2.add(Vintensity);
			    			  
			    			  VHilfelife.setText("");
			    			  VHilfelife.setBounds(680, 75, 600, 17);
			    			  pan2.add(VHilfelife);
			    			  
			    			  
			    			  VActivity.setText("");
			    			  VActivity.setBounds(880, 5, 600, 17);
			    			  pan2.add(VActivity);
			    			 
			    			  
			      			 textField.setText(Integer.toString(clik+1));
			      			firstenter=2;
							if(clik==0) {clik=PeakSearch.energyPic.size()-1;} else {clik=clik-1;}

						}else {JOptionPane.showMessageDialog(null, "First click on the search peaks menu ");}
						}
					
					if(analyse=="g3") {
						panel.removeAll();
						repaint();
						ChartPanel frPk = null;
						if(firstenter==3) {if(clik==0) {clik=treatmentLog.DomainAxisPeakCmpr.size()-1;
						}else if(clik==treatmentLog.DomainAxisPeakCmpr.size()-1) {clik=0;}else{clik=clik-2;}				
						}if(clik<0) {clik=0;}
							    
	        		    
			            zomDomainPeak =		Float.parseFloat(treatmentLog.DomainAxisPeakCmpr.get(clik));//centroide de pic
			            zomRangPeak   =		Float.parseFloat(treatmentLog.RangAxisPeakCmpr.get(clik));  //air correspend � centroide de pic
			            zomBckgrndPeak=		Float.parseFloat(treatmentLog.BckgrdAxisPeakCmpr.get(clik));// moyen de Backgroud
			            zomFwhmdPeak  =		Float.parseFloat(treatmentLog.FwhmAxisPeakCmpr.get(clik));// fwhm
			            
			            if(btnRange.getText()=="Range") {
			            	treatmentLog.domainAxis.setAutoRange(true);
			            	treatmentLog.rangeAxis.setAutoRange(true);
				            }else {        
			                    treatmentLog.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
			        		    treatmentLog.rangeAxis.setRange(zomBckgrndPeak-zomRangPeak/2,zomRangPeak+zomRangPeak/2);
				            }
			        		    frPk = treatmentLog.chartPanel;
			        		    
			        		  //---------for Marker--------------------
			        		    treatmentLog.plot.clearDomainMarkers();
			        		    treatmentLog.start2 = new ValueMarker(zomDomainPeak);
			        		    treatmentLog.start2.setStroke( new BasicStroke( 3 ) );
			        		    treatmentLog.start2.setPaint(Color.RED);
			        		    int nbpk=clik+1;
			        		    treatmentLog.start2.setLabel("Peak N�:"+nbpk+"  Cnl: "+treatmentLog.DomainAxisPeakCmpr.get(clik)+"   E: "+treatmentLog.EnergyAxisPeakCmpr.get(clik)+" Kev");
			        		    treatmentLog.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
			        		    treatmentLog.start2.setLabelPaint(Color.RED);
			        		    treatmentLog.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
			        		    treatmentLog.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
			        		    treatmentLog.plot.addDomainMarker(treatmentLog.start2);
			        		    
			        		    //--------------------------------------
			        		    
			        		    //Vchannel = new JLabel(Float.toString(zomDomainPeak));
			        		    Vchannel.setText(treatmentLog.DomainAxisPeakCmpr.get(clik));
			      			    Vchannel.setBounds(300, 5, 90, 17);
			      			    pan2.add(Vchannel);
			      			    

			      			  Venrg.setText(treatmentLog.EnergyAxisPeakCmpr.get(clik)+" Kev");
			    			  Venrg.setBounds(280, 30, 90, 17);
			    			  pan2.add(Venrg);
			    			  
			    			  Vaer.setText(treatmentLog.AreayAxisPeakCmpr.get(clik)+" Cnts");
			    			  Vaer.setBounds(480, 5, 90, 17);
			    			  pan2.add(Vaer);
			    			  
			    			  VERe.setText(treatmentLog.ErrorAxisPeakCmpr.get(clik)+" %");
			    			  VERe.setBounds(480, 30, 90, 17);
			    			  pan2.add(VERe);
			    			  
			    			  VFHM.setText(treatmentLog.FwhmAxisPeakCmpr.get(clik)+" Kev");
			    			  VFHM.setBounds(480, 55, 90, 17);
			    			  pan2.add(VFHM);
			    			  
			    			  Vnucleid.setText(radinucleidNuc.get(clik));
			    			  Vnucleid.setBounds(680, 5, 600, 17);
			    			  pan2.add(Vnucleid);
			    			  
			    			  VENRG.setText(nucleidEnergyNuc.get(clik));
			    			  VENRG.setBounds(680, 30, 600, 17);
			    			  pan2.add(VENRG);
			    			  
			    			  Vintensity.setText(nucIntensityNuc.get(clik));
			    			  Vintensity.setBounds(680, 55, 600, 17);
			    			  pan2.add(Vintensity);
			    			  
			    			  VHilfelife.setText(hilflifeNuc.get(clik));
			    			  VHilfelife.setBounds(680, 75, 600, 17);
			    			  pan2.add(VHilfelife);
			      			    
			    			  String EffiCaljs,coffi1s, coffi2s, coffi3s, coffi4s, coffi5s, coffi6s, enrgjs;
			    			  Float EffiCalj = null,coffi1, coffi2, coffi3, coffi4, coffi5, coffi6, enrgj;
			    			  
			    			  enrgjs  =nucleidEnergyNuc.get(clik).replaceAll("Kev", "").replaceAll("\\s+", "");
			    			 
			    			  String cleanedStr = nucIntensityNuc.get(clik).replaceAll("[\\s%]", "");
			    		      
			    			  if (!cleanedStr.isEmpty()) {
			    		            // Convertir en float
			    		            float floatValue = Float.parseFloat(cleanedStr);
			    		            enrgj  =Float.parseFloat(enrgjs);
			    		            
			    		            if(Mainn.formula.equals("Formula1")) {
				  		    			  coffi1s =textField1tpe.getText();					    
				  		    			  coffi2s =textField2tpe.getText();					    
				  		    			  coffi3s =textField3tpe.getText();					    
				  		    			  coffi4s =textField4tpe.getText();					    
				  		    			  coffi5s =textField5tpe.getText();					    	    
				  		    			  coffi6s =textField6tpe.getText();
				  		    			  
				  		    			  coffi1=Float.parseFloat(coffi1s);
				  				    	  coffi2=Float.parseFloat(coffi2s);
				  				 		  coffi3=Float.parseFloat(coffi3s);
				  				    	  coffi4=Float.parseFloat(coffi4s);
				  				    	  coffi5=Float.parseFloat(coffi5s);
				  				    	  coffi6=Float.parseFloat(coffi6s);
				  				    	EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgj) + coffi3 * Math.pow(Math.log(enrgj), 2) + coffi4 * Math.pow(Math.log(enrgj), 3)+ coffi5 * Math.pow(Math.log(enrgj), 4) + coffi6 * Math.pow(Math.log(enrgj), 5))));
						    		       
			    		                  };
			    		                  if(Mainn.formula.equals("Formula2")) {
					  		    			  coffi1s =textField1tpeF2.getText();					    
					  		    			  coffi2s =textField2tpeF2.getText();					    
					  		    			  
					  		    			  coffi1=Float.parseFloat(coffi1s);
					  				    	  coffi2=Float.parseFloat(coffi2s);
					  				    	EffiCalj=(float)(coffi1* Math.pow(enrgj, coffi2));
					  				    	//EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgjeff) + coffi3 * Math.pow(Math.log(enrgjeff), 2) + coffi4 * Math.pow(Math.log(enrgjeff), 3)+ coffi5 * Math.pow(Math.log(enrgjeff), 4) + coffi6 * Math.pow(Math.log(enrgjeff), 5))));
					  		    			  };
					  		    			  
					  		    			if(Mainn.formula.equals("Formula3")) {
					  		    				coffi1s =textField1tpeF3.getText();					    
						  		    			  coffi2s =textField2tpeF3.getText();					    
						  		    			  coffi3s =textField3tpeF3.getText();					    
						  		    			  coffi4s =textField4tpeF3.getText();					    
						  		    			  coffi5s =textField5tpeF3.getText();					    	    
						  		    			  coffi6s =textField6tpeF3.getText();
						  		    			  
						  		    			  coffi1=Float.parseFloat(coffi1s);
						  				    	  coffi2=Float.parseFloat(coffi2s);
						  				 		  coffi3=Float.parseFloat(coffi3s);
						  				    	  coffi4=Float.parseFloat(coffi4s);
						  				    	  coffi5=Float.parseFloat(coffi5s);
						  				    	  coffi6=Float.parseFloat(coffi6s);
						  				    	EffiCalj=(float)( coffi1 + coffi2 * enrgj + coffi3 * Math.pow(enrgj, 2) + coffi4 * Math.pow(enrgj, 3) 
						  		              + coffi5 * Math.pow(enrgj, 4) + coffi6 * Math.pow(enrgj, 5));
						  		 
					  		    			};
					  		    			if(Mainn.formula.equals("Formula4")) {
					  		    				  coffi1s =textField1tpeF4.getText();					    
						  		    			  coffi2s =textField2tpeF4.getText();					    
						  		    			  coffi3s =textField3tpeF4.getText();					    
						  		    			  
						  		    			  coffi1=Float.parseFloat(coffi1s);
						  				    	  coffi2=Float.parseFloat(coffi2s);
						  				 		  coffi3=Float.parseFloat(coffi3s);
						  				    	  
						  				 		EffiCalj=(float)(  Math.exp(coffi1+ coffi2*enrgj+coffi3*Math.pow(enrgj, 2)));
						  				 		  
						  				    	
					  		    			};
				    		            
			    		            
				    		        
			    		            Float acvti=Float.parseFloat(treatmentLog.AreayAxisPeakCmpr.get(clik))/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
					    			  
					    			  
					    			  float floatErreurArea = Float.parseFloat(treatmentLog.ErrorAxisPeakCmpr.get(clik));
					    			  float floatErreurActivity = floatErreurArea/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
					    			  String ActivityErreur=Float.toString(acvti)+"    �  " + floatErreurActivity+ "  "+ "Bq";
					    			  
					    			  VActivity.setText(ActivityErreur );
					    			  
					    			  //System.out.println(treatmentLog.ForIdentification.get(clik)+"      "+ActivityErreur ); 
					    			   
					    			  
			    		        } else {
			    		        	VActivity.setText("");
			    		        }
			    			  
			    			  
			    			  VActivity.setBounds(880, 5, 600, 17);
			    			  pan2.add(VActivity);
			    			  
			      			   textField.setText(Integer.toString(clik+1));
			        		    
						panel.setLayout(new java.awt.BorderLayout());
						panel.add(frPk);
						panel.validate();
						firstenter=2;
						if(clik==0) {clik=treatmentLog.DomainAxisPeakCmpr.size()-1;} else {clik=clik-1;}
						
					}
					
					if(analyse=="g") {
						panel.removeAll();
						repaint();
						ChartPanel frPk = null;
					if(firstenter==3) {if(clik==0) {clik=treatment1.DomainAxisPeak.size()-1;
					}else if(clik==treatment1.DomainAxisPeak.size()-1) {clik=0;}else{clik=clik-2;}				
					}if(clik<0) {clik=0;}
						    
        		    
		            zomDomainPeak =		Float.parseFloat(treatment1.DomainAxisPeak.get(clik));//centroide de pic
		            zomRangPeak   =		Float.parseFloat(treatment1.RangAxisPeak.get(clik));  //air correspend � centroide de pic
		            zomBckgrndPeak=		Float.parseFloat(treatment1.BckgrdAxisPeak.get(clik));// moyen de Backgroud
		            zomFwhmdPeak  =		Float.parseFloat(treatment1.FwhmAxisPeak.get(clik));// fwhm
		            
		            if(btnRange.getText()=="Range") {
		            	treatment1.domainAxis.setAutoRange(true);
		            	treatment1.rangeAxis.setAutoRange(true);
			            }else {
		                    treatment1.domainAxis.setRange(zomDomainPeak-20*zomFwhmdPeak,zomDomainPeak+20*zomFwhmdPeak);
		        		    treatment1.rangeAxis.setRange(zomBckgrndPeak-zomRangPeak/2,zomRangPeak+zomRangPeak/2);
			            }
		        		    frPk = treatment1.chartPanel;
		        		    
		        		  //---------for Marker--------------------
		        		    treatment1.plot.clearDomainMarkers();
		        		    treatment1.start2 = new ValueMarker(zomDomainPeak);
		        		    treatment1.start2.setPaint(Color.RED);
		        		    treatment1.start2.setStroke( new BasicStroke( 3 ) );
		        		    int nbpk=clik+1;
		        		    treatment1.start2.setLabel("Peak N�:"+nbpk+"  Cnl: "+treatment1.DomainAxisPeak.get(clik)+"   E: "+treatment1.EnergyAxisPeak.get(clik)+" Kev");
		        		    treatment1.start2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
		        		    treatment1.start2.setLabelPaint(Color.RED);
		        		    treatment1.start2.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		        		    treatment1.start2.setLabelFont(new Font("Calibri (Body)", Font.BOLD, 12));
		        		    treatment1.plot.addDomainMarker(treatment1.start2);
		        		    
		        		    //--------------------------------------
		        		    
		        		    //Vchannel = new JLabel(Float.toString(zomDomainPeak));
		        		   Vchannel.setText(treatment1.DomainAxisPeak.get(clik));
		      			   Vchannel.setBounds(300, 5, 90, 17);
		      			   pan2.add(Vchannel);
		      			    
		      			  Venrg.setText(treatment1.EnergyAxisPeak.get(clik)+" Kev");
		    			  Venrg.setBounds(280, 30, 90, 17);
		    			  pan2.add(Venrg);
		    			  
		    			  Vaer.setText(treatment1.AreayAxisPeak.get(clik)+" Cnts");
		    			  Vaer.setBounds(480, 5, 90, 17);
		    			  pan2.add(Vaer);
		    			  
		    			  VERe.setText(treatment1.ErrorAxisPeak.get(clik)+" %");
		    			  VERe.setBounds(480, 30, 90, 17);
		    			  pan2.add(VERe);
		    			  
		    			  VFHM.setText(treatment1.FwhmAxisPeak.get(clik)+" Kev");
		    			  VFHM.setBounds(480, 55, 90, 17);
		    			  pan2.add(VFHM);
		    			  
		    			  Vnucleid.setText(radinucleidNuc.get(clik));
		    			  Vnucleid.setBounds(680, 5, 600, 17);
		    			  pan2.add(Vnucleid);
		    			  
		    			  VENRG.setText(nucleidEnergyNuc.get(clik));
		    			  VENRG.setBounds(680, 30, 600, 17);
		    			  pan2.add(VENRG);
		    			  
		    			  Vintensity.setText(nucIntensityNuc.get(clik));
		    			  Vintensity.setBounds(680, 55, 600, 17);
		    			  pan2.add(Vintensity);
		    			  
		    			  VHilfelife.setText(hilflifeNuc.get(clik));
		    			  VHilfelife.setBounds(680, 75, 600, 17);
		    			  pan2.add(VHilfelife);
		    			  
		    			  String EffiCaljs,coffi1s = null, coffi2s = null, coffi3s = null, coffi4s = null, coffi5s = null, coffi6s = null, enrgjs;
		    			  Float EffiCalj = null,coffi1 = null, coffi2 = null, coffi3 = null, coffi4 = null, coffi5 = null, coffi6 = null, enrgj;
		    			  
		    			  
		    			  
		    			  enrgjs  =nucleidEnergyNuc.get(clik).replaceAll("Kev", "").replaceAll("\\s+", "");
		    			 
		    			  
		    			  
		    			  String cleanedStr = nucIntensityNuc.get(clik).replaceAll("[\\s%]", "");
		    		      
		    			  if (!cleanedStr.isEmpty()) {
		    		            // Convertir en float
		    		            float floatValue = Float.parseFloat(cleanedStr);
		    		            enrgj  =Float.parseFloat(enrgjs);
		    		            
		    		            if(Mainn.formula.equals("Formula1")) {
		  		    			  coffi1s =textField1tpe.getText();					    
		  		    			  coffi2s =textField2tpe.getText();					    
		  		    			  coffi3s =textField3tpe.getText();					    
		  		    			  coffi4s =textField4tpe.getText();					    
		  		    			  coffi5s =textField5tpe.getText();					    	    
		  		    			  coffi6s =textField6tpe.getText();
		  		    			  
		  		    			  coffi1=Float.parseFloat(coffi1s);
		  				    	  coffi2=Float.parseFloat(coffi2s);
		  				 		  coffi3=Float.parseFloat(coffi3s);
		  				    	  coffi4=Float.parseFloat(coffi4s);
		  				    	  coffi5=Float.parseFloat(coffi5s);
		  				    	  coffi6=Float.parseFloat(coffi6s);
		  				    	 EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgj) + coffi3 * Math.pow(Math.log(enrgj), 2) + coffi4 * Math.pow(Math.log(enrgj), 3)+ coffi5 * Math.pow(Math.log(enrgj), 4) + coffi6 * Math.pow(Math.log(enrgj), 5))));
		  		    			  };
		  		    			if(Mainn.formula.equals("Formula2")) {
			  		    			  coffi1s =textField1tpeF2.getText();					    
			  		    			  coffi2s =textField2tpeF2.getText();					    
			  		    			  
			  		    			  coffi1=Float.parseFloat(coffi1s);
			  				    	  coffi2=Float.parseFloat(coffi2s);
			  				    	EffiCalj=(float)(coffi1* Math.pow(enrgj, coffi2));
			  				    	//EffiCalj=(float)(Math.exp((coffi1 + coffi2 * Math.log(enrgjeff) + coffi3 * Math.pow(Math.log(enrgjeff), 2) + coffi4 * Math.pow(Math.log(enrgjeff), 3)+ coffi5 * Math.pow(Math.log(enrgjeff), 4) + coffi6 * Math.pow(Math.log(enrgjeff), 5))));
			  		    			  };
			  		    			  
			  		    			if(Mainn.formula.equals("Formula3")) {
			  		    				coffi1s =textField1tpeF3.getText();					    
				  		    			  coffi2s =textField2tpeF3.getText();					    
				  		    			  coffi3s =textField3tpeF3.getText();					    
				  		    			  coffi4s =textField4tpeF3.getText();					    
				  		    			  coffi5s =textField5tpeF3.getText();					    	    
				  		    			  coffi6s =textField6tpeF3.getText();
				  		    			  
				  		    			  coffi1=Float.parseFloat(coffi1s);
				  				    	  coffi2=Float.parseFloat(coffi2s);
				  				 		  coffi3=Float.parseFloat(coffi3s);
				  				    	  coffi4=Float.parseFloat(coffi4s);
				  				    	  coffi5=Float.parseFloat(coffi5s);
				  				    	  coffi6=Float.parseFloat(coffi6s);
				  				    	EffiCalj=(float)( coffi1 + coffi2 * enrgj + coffi3 * Math.pow(enrgj, 2) + coffi4 * Math.pow(enrgj, 3) 
				  		              + coffi5 * Math.pow(enrgj, 4) + coffi6 * Math.pow(enrgj, 5));
				  		 
			  		    			};
			  		    			if(Mainn.formula.equals("Formula4")) {
			  		    				  coffi1s =textField1tpeF4.getText();					    
				  		    			  coffi2s =textField2tpeF4.getText();					    
				  		    			  coffi3s =textField3tpeF4.getText();					    
				  		    			  
				  		    			  coffi1=Float.parseFloat(coffi1s);
				  				    	  coffi2=Float.parseFloat(coffi2s);
				  				 		  coffi3=Float.parseFloat(coffi3s);
				  				    	  
				  				 		EffiCalj=(float)(  Math.exp(coffi1+ coffi2*enrgj+coffi3*Math.pow(enrgj, 2)));
				  				 		  
				  				    	
			  		    			};
		    		            
		    		            
			    		          

		    		            Float acvti=Float.parseFloat(treatment1.AreayAxisPeak.get(clik))/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
				    			  
				    			  float floatErreurArea = Float.parseFloat(treatment1.ErrorAxisPeak.get(clik));
				    			  Float floatErreurActivity=floatErreurArea/(Float.parseFloat(livetimS)*EffiCalj*floatValue/100);		    			  
				    			  String ActivityErreur=Float.toString(acvti)+"    �  " + floatErreurActivity+ "  "+ "Bq" ;
				    			  VActivity.setText(ActivityErreur);
				    			  //System.out.println(treatment1.ForIdentification1.get(clik)+"      "+ActivityErreur ); 
				    			  
				    			  
		    		        } else {
		    		        	VActivity.setText("");
		    		        }
		    			  
		    			  
		    			  
		    			  VActivity.setBounds(880, 5, 600, 17);
		    			  pan2.add(VActivity);
		      			    
		      			   textField.setText(Integer.toString(clik+1));
		        		    
					panel.setLayout(new java.awt.BorderLayout());
					panel.add(frPk);
					panel.validate();
					firstenter=2;
					if(clik==0) {clik=treatment1.DomainAxisPeak.size()-1;} else {clik=clik-1;}
					
				}				
				}				
			}
		});
		btnPrevios.setBackground(SystemColor.activeCaptionBorder);
		btnPrevios.setToolTipText( "View previous peak " ); 
		
		
		
			   
			  JLabel channel = new JLabel("Channel  : ");
			  channel.setForeground(Color.BLUE);
			  channel.setBounds(200, 5, 76, 17);
			  pan2.add(channel);
				
			  JLabel enrg = new JLabel("Energy    : ");
			  enrg.setForeground(Color.BLUE);
			  enrg.setBounds(200, 30, 76, 17);
			  pan2.add(enrg);
			  
			  JLabel aer = new JLabel("Net Area    : ");
			  aer.setForeground(Color.BLUE);
			  aer.setBounds(400, 5, 76, 17);
			  pan2.add(aer);
			  
			  JLabel ERe = new JLabel("Error           : ");
			  ERe.setForeground(Color.BLUE);
			  ERe.setBounds(400, 30, 76, 17);
			  pan2.add(ERe);
			  
			  JLabel FHM = new JLabel("FWHM         : ");
			  FHM.setForeground(Color.BLUE);
			  FHM.setBounds(400, 55, 76, 17);
			  pan2.add(FHM);
			  
			  JLabel nucleid = new JLabel("Nucleid   : ");
			  nucleid.setForeground(Color.BLUE);
			  nucleid.setBounds(600, 5, 76, 17);
			  pan2.add(nucleid);
			  
			  JLabel enrgyNcl = new JLabel("Energy    : ");
			  enrgyNcl.setForeground(Color.BLUE);
			  enrgyNcl.setBounds(600, 30, 76, 17);
			  pan2.add(enrgyNcl);
			  
			  JLabel intensity = new JLabel("Intensity : ");
			  intensity.setForeground(Color.BLUE);
			  intensity.setBounds(600, 55, 76, 17);
			  pan2.add(intensity);
			  
			  JLabel halfLife = new JLabel("half life    : ");
			  halfLife.setForeground(Color.BLUE);
			  halfLife.setBounds(600, 75, 76, 17);
			  pan2.add(halfLife);
			  
			  
			  JLabel Actvty = new JLabel("Activity   : ");
			  Actvty.setForeground(Color.BLUE);
			  Actvty.setBounds(800, 5, 76, 17);
			  pan2.add(Actvty);
			   
			   /*JPanel panelZomm= new JPanel();
				panelZomm.setBackground(Color.BLUE);
				panelZomm.setBounds(0, 0, 700, 500);
				pan.add(panelZomm);*/
		    
			   
			
			   
			   split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan, pan2);
		   
			   
			JLabel lblInfos = new JLabel("Info extracted from spectrum file");
			lblInfos.setForeground(SystemColor.inactiveCaptionBorder);
			lblInfos.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel nameFile = new JLabel("File name  : ");
			nameFile.setForeground(Color.BLUE);
			nameFile.setBounds(3, 30, 76, 17);
			pan.add(nameFile);
			
			JLabel start = new JLabel("Start time : ");
			start.setForeground(Color.BLUE);
			start.setBounds(3, 50, 76, 17);
			pan.add(start);
						
			JLabel startd = new JLabel("Start date : ");
			startd.setForeground(Color.BLUE);
			startd.setBounds(3, 70, 76, 17);
			pan.add(startd);
			
			JLabel real = new JLabel("Real          : ");			
			real.setForeground(Color.BLUE);
			real.setBounds(3, 90, 76, 17);
			pan.add(real);
			
			JLabel live = new JLabel("Live          : ");
			live.setForeground(Color.BLUE);
			live.setBounds(3, 110, 76, 17);
			pan.add(live);
			
			JLabel dead = new JLabel("Dead         : ");
			dead.setForeground(Color.BLUE);
			dead.setBounds(3, 130, 76, 17);
			pan.add(dead);
			
			JLabel energycalib = new JLabel("Energy calibration          : ");
			energycalib.setForeground(Color.BLUE);
			energycalib.setBounds(300, 30, 150, 17);
			pan.add(energycalib);
			
			JLabel shapecalib = new JLabel("Peak shape calibration  : ");
			shapecalib.setForeground(Color.BLUE);
			shapecalib.setBounds(300, 50, 150, 17);
			pan.add(shapecalib);
			
			
			JLabel DD = new JLabel("Detector description      : ");
			DD.setForeground(Color.BLUE);
			DD.setBounds(300, 70, 220, 17);
			pan.add(DD);
			
			JLabel SD = new JLabel("Sample description        : ");
			SD.setForeground(Color.BLUE);
			SD.setBounds(300, 90, 220, 17);
			pan.add(SD);
			
			JLabel RNG = new JLabel("Channel range                 : ");
			RNG.setForeground(Color.BLUE);
			RNG.setBounds(300, 110, 220, 17);
			pan.add(RNG);
			
			JLabel LDD = new JLabel("Length of detector description : ");
			LDD.setForeground(Color.BLUE);
			LDD.setBounds(950, 30, 220, 17);
			pan.add(LDD);
			
			JLabel DSD = new JLabel("Length of sample description    : ");
			DSD.setForeground(Color.BLUE);
			DSD.setBounds(950, 50, 220, 17);
			pan.add(DSD);
						
			
			GroupLayout gl_pan = new GroupLayout(pan);
			gl_pan.setHorizontalGroup(
				gl_pan.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_pan.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblInfos)						
						.addContainerGap(693, Short.MAX_VALUE))
			);
			gl_pan.setVerticalGroup(
				gl_pan.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_pan.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblInfos))
					    
					
			);
			pan.setLayout(gl_pan);
			
			JButton btnClearMarker = new JButton("Clear Marker");
			btnClearMarker.setForeground(Color.BLUE);
			btnClearMarker.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(analyse=="g3") {treatmentLog.plot.clearDomainMarkers();}
					if(analyse=="g") {treatment1.plot.clearDomainMarkers();}
					if(analyse==null) {Ggraphique.plot.clearDomainMarkers();}
					if(analyse=="g2") {Loggraph.plot.clearDomainMarkers();}
				}
			});
			btnClearMarker.setBackground(SystemColor.activeCaptionBorder);
			
			
			
			
	
			
			GroupLayout gl_pan2 = new GroupLayout(pan2);
			gl_pan2.setHorizontalGroup(
				gl_pan2.createParallelGroup(Alignment.LEADING)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
					.addGroup(gl_pan2.createSequentialGroup()
						.addGroup(gl_pan2.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_pan2.createSequentialGroup()
								.addContainerGap()
								.addComponent(textField, 0, 0, Short.MAX_VALUE))
							.addGroup(gl_pan2.createSequentialGroup()
								.addGap(10)
								.addComponent(lblNPeak, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)))
						.addGap(33)
						.addGroup(gl_pan2.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnPrevios, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnRange, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(btnClearMarker)
						.addGap(464))
			);
			gl_pan2.setVerticalGroup(
				gl_pan2.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pan2.createSequentialGroup()
						.addGroup(gl_pan2.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNPeak)
							.addComponent(btnNext))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pan2.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnPrevios))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pan2.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRange)
							.addComponent(btnClearMarker))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE))
			);
			pan2.setLayout(gl_pan2);
			split.setDividerLocation(0);
			split.setDividerSize(8);
			split.setResizeWeight(0);
			split.setOneTouchExpandable(true);
			split.setContinuousLayout(true);
			split.setForeground(Color.GRAY);
			split.setBackground(Color.BLACK);
			panel_1.setLayout(new java.awt.BorderLayout());
			panel_1.add(split);
			panel_1.validate();
			
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public static void ClibEnrgyByGraph(){
		
		//________________________________calibration_Energy_by_graphe___________________________
			
				JDialog framecali1 = new JDialog((Frame)null, "calibration Energy by graph", true);
				
				JPanel panelcali1=new JPanel();
				panelcali1.setBounds(191, 23, 230, 153);
				panelcali1.setLayout(null);
				framecali1.getContentPane().add(panelcali1);
				
				JLabel lblAcali2 = new JLabel("Channel :");
				//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
				//lblAcali2.setForeground(Color.RED);
				lblAcali2.setBounds(10, 35, 180, 17);
				panelcali1.add(lblAcali2);
				
				//TextField textField1f = new TextField("0.731");
				textFieldcali1.setBounds(200, 35, 86, 20);				
				panelcali1.add(textFieldcali1);
				
				JLabel lblAcali3 = new JLabel("Corresponding energy(kev) :");
				//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				//lblAcali3.setForeground(Color.RED);
				lblAcali3.setBounds(10, 75, 180, 17);
				panelcali1.add(lblAcali3);
				
				//TextField textField2f = new TextField("0.038");
				textFieldcali2.setBounds(200, 75, 86, 20);				
				panelcali1.add(textFieldcali2);
				
				//txtAC1=textFieldcali1.getText();
				//txtAC2=textFieldcali2.getText();
				textFieldcali2.setText("");
				
				JButton btncali1 = new JButton(" OK");
				btncali1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(Ggraphique.cali==1 || Loggraph.cali==1){
							   String clr1 =textFieldcali1.getText();
				               textFieldM1.setText(clr1);
				             
				               // textFieldcali2.setText(" ");
				               String clr11 =textFieldcali2.getText();
				               textFieldM11.setText(clr11);
				             
				                String  cm1 =textFieldM1.getText();	
								Float nc1=Float.parseFloat(cm1);
							   
							    
								String  cm2 =textFieldM2.getText();	
							    Float nc2=Float.parseFloat(cm2);
							    
							    
							    String em1 =textFieldM11.getText();
							    Float ne1=Float.parseFloat(em1);
							   // textField1.setText(EM1);
							    
							    String em2 =textFieldM22.getText();
							    Float ne2=Float.parseFloat(em2);
				                Float be=(ne1-ne2)/(nc1-nc2);
							    Float ae= ne2-be*nc2;
							    
							    String Sae = Float.toString(ae);
							    String Sbe = Float.toString(be);
							    
							    textField1.setText(Sae);
							    textField2.setText(Sbe);
						}
						
						if(Ggraphique.cali==2 || Loggraph.cali==2){
							    String clr2 =textFieldcali1.getText();
				                textFieldM2.setText(clr2);
				             
				                //textFieldcali2.setText(" ");
				                String clr22 =textFieldcali2.getText();
				                textFieldM22.setText(clr22);
				             
				                String  cm1 =textFieldM1.getText();	
								Float nc1=Float.parseFloat(cm1);
							   
								String  cm2 =textFieldM2.getText();	
							    Float nc2=Float.parseFloat(cm2);
							    
							    
							    String em1 =textFieldM11.getText();
							    Float ne1=Float.parseFloat(em1);
							   // textField1.setText(EM1);
							    
							    String em2 =textFieldM22.getText();
							    Float ne2=Float.parseFloat(em2);
				                Float be=(ne1-ne2)/(nc1-nc2);
							    Float ae= ne2-be*nc2;
							    
							    String Sae = Float.toString(ae);
							    String Sbe = Float.toString(be);
							    
							    textField1.setText(Sae);
							    textField2.setText(Sbe);
						}
						
						if(Ggraphique.cali==3 || Loggraph.cali==3){
							    String clr3 =textFieldcali1.getText();
				                textFieldM3.setText(clr3);
				             
				                //textFieldcali2.setText("");
				                String clr33 =textFieldcali2.getText();
				                textFieldM33.setText(clr33);
				             
				                String  cm1 =textFieldM1.getText();	
								Float nc1=Float.parseFloat(cm1);
							   
								String  cm2 =textFieldM2.getText();	
							    Float nc2=Float.parseFloat(cm2);
							    
							    String em1 =textFieldM11.getText();
							    Float ne1=Float.parseFloat(em1);
							   // textField1.setText(EM1);
							    
							    String em2 =textFieldM22.getText();
							    Float ne2=Float.parseFloat(em2);
				                Float be=(ne1-ne2)/(nc1-nc2);
							    Float ae= ne2-be*nc2;
							    
							    String Sae = Float.toString(ae);
							    String Sbe = Float.toString(be);
							    
							    textField1.setText(Sae);
							    textField2.setText(Sbe);
						}
						
						if(Ggraphique.cali==4 || Loggraph.cali==4){
							    String clr4 =textFieldcali1.getText();
				                textFieldM4.setText(clr4);
				             
				                //textFieldcali2.setText("");
				                String clr44 =textFieldcali2.getText();
				                textFieldM44.setText(clr44);
				            
				                String  cm1 =textFieldM1.getText();	
								Float nc1=Float.parseFloat(cm1);
							   
							    
								String  cm2 =textFieldM2.getText();	
							    Float nc2=Float.parseFloat(cm2);
							    
							    
							    String em1 =textFieldM11.getText();
							    Float ne1=Float.parseFloat(em1);
							   // textField1.setText(EM1);
							    
							    String em2 =textFieldM22.getText();
							    Float ne2=Float.parseFloat(em2);
				                Float be=(ne1-ne2)/(nc1-nc2);
							    Float ae= ne2-be*nc2;
							    
							    String Sae = Float.toString(ae);
							    String Sbe = Float.toString(be);
							    
							    textField1.setText(Sae);
							    textField2.setText(Sbe);
				             
						}
					
					    framecali1.dispose();
					}
				});
				btncali1.setBounds(100, 135, 70, 23);
				panelcali1.add(btncali1);
				
				
				JButton btncali2 = new JButton("Cancel");
				btncali2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {					    
						 framecali1.dispose();			   
					}
				});
				btncali2.setBounds(200, 135, 100, 23);
				panelcali1.add(btncali2);
				
				framecali1.setSize(350,200);
				framecali1.setResizable(false);
				framecali1.setVisible(true);
				
			
	}
}
