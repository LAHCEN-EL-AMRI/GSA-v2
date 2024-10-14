import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Formule4Efficiency {
	JDialog effF4;
    JPanel panelDetector1;
    static JPanel subPanelF4;
    static String filePath1F4, KeyDetectorF4 ;
    
    
    public static void Formule4Efficiency() {
	
	JDialog effF4 = new JDialog((Frame)null, "Efficiency calibration", true);
	effF4.getContentPane().setLayout(null);
	
	JPanel panelDetector1=new JPanel();
	panelDetector1.setBackground(Color.LIGHT_GRAY); // Gris clair
	//panelDetector1.setBackground(Color.GRAY);
	panelDetector1.setBounds(5, 0, 110, 600);
	panelDetector1.setLayout(null);
	effF4.getContentPane().add(panelDetector1);
	

	
    JPanel panel1tpeF4=new JPanel();
    panel1tpeF4.setBackground(Color.LIGHT_GRAY); // Gris clair
	panel1tpeF4.setBounds(120, 0, 500, 600);
	panel1tpeF4.setLayout(null);
	effF4.getContentPane().add(panel1tpeF4);
	
	
	
	JLabel  samplename = new JLabel(" sample name :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	samplename.setBounds(23, 35, 100, 17);
	panel1tpeF4.add(samplename); 
	
	TextField textFieldsamplename = new TextField(" ");
	textFieldsamplename.setBounds(170, 35, 150, 17);				
	panel1tpeF4.add(textFieldsamplename);
	
	
	JLabel  position = new JLabel(" position      :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	position.setBounds(23, 65, 100, 17);
	panel1tpeF4.add(position); 
	
	TextField textFieldPosition = new TextField(" ");
	textFieldPosition.setBounds(170, 65, 150, 17);				
	panel1tpeF4.add(textFieldPosition);
	
	JLabel  otherinfo = new JLabel(" Other info    :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	otherinfo.setBounds(23, 95, 100, 17);
	panel1tpeF4.add(otherinfo); 
	
	TextArea textareainfos = new TextArea("   ");
	textareainfos.setBounds(170, 95, 250, 200);				
	panel1tpeF4.add(textareainfos);
	
	JButton showTableButton = new JButton("Select the calibration nuclides");
    showTableButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	EfficiencyTableF4 dialog = new EfficiencyTableF4(effF4);// Remplacez parentFrame par le nom de votre fenêtre principale
        	dialog.setAlwaysOnTop(true);  // Assure que la fenêtre apparaît en avant
            dialog.setVisible(true);      // Affiche la boîte de dialogue
        	
        }
    });
    showTableButton.setBounds(23, 310, 250, 22);		        
    panel1tpeF4.add(showTableButton, BorderLayout.SOUTH);
    
	JLabel lblA_11tpe = new JLabel("eff= exp(a+b*E+c*E^(2))");
	//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_11tpe.setBounds(23, 11+330, 380, 17);
	lblA_11tpe.setForeground(Color.BLUE);
	panel1tpeF4.add(lblA_11tpe);
	
	JLabel lblA_12tpe = new JLabel("  a =");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_12tpe.setBounds(23, 35+360, 46, 17);
	panel1tpeF4.add(lblA_12tpe);
	
	//TextField textField1tpeF4 = new TextField("1");
	Mainn.textField1tpeF4.setBounds(75, 35+360, 56, 20);				
	panel1tpeF4.add(Mainn.textField1tpeF4);
	
	JLabel lblA_13tpe = new JLabel("  b =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_13tpe.setBounds(23, 57+360, 46, 17);
	panel1tpeF4.add(lblA_13tpe);
	
	//TextField textField2tpeF4 = new TextField("3");
	Mainn.textField2tpeF4.setBounds(75, 55+360, 56, 20);				
	panel1tpeF4.add(Mainn.textField2tpeF4);
	
	JLabel lblA_14tpe = new JLabel("  c =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_14tpe.setBounds(23, 80+360, 46, 17);
	panel1tpeF4.add(lblA_14tpe);
	
	//TextField textField2tpeF4 = new TextField("3");
	Mainn.textField3tpeF4.setBounds(75, 80+360, 56, 20);				
	panel1tpeF4.add(Mainn.textField3tpeF4);
	
	
	
	Color defaultColor = UIManager.getColor("Button.background");
	
	
	JButton detector1F4 = new JButton("Det01(Cal01)");
	JButton detector2F4 = new JButton("Det01(Cal02)");
	JButton detector3F4 = new JButton("Det01(Cal03)");
	JButton detector4F4 = new JButton("Det01(Cal04)");
	JButton detector5F4 = new JButton("Det01(Cal05)");
	JButton save1F4 = new JButton(" save");
	
	//--------------pour sauvegarder infos de detecteur en premier ouvertir de logiciel---
	
       try (BufferedReader readerF4 = new BufferedReader(new FileReader("Detectors\\saveF4.txt"))) {
    	    KeyDetectorF4 = readerF4.readLine();
    	   if(KeyDetectorF4.equals("Detector1")) { 
        	   SwingUtilities.invokeLater(() -> detector1F4.doClick());
             } else if(KeyDetectorF4.equals("Detector2")) { 
        	   SwingUtilities.invokeLater(() -> detector2F4.doClick());
             } else if(KeyDetectorF4.equals("Detector3")) { 
        	   SwingUtilities.invokeLater(() -> detector3F4.doClick());
             } else if(KeyDetectorF4.equals("Detector4")) { 
        	   SwingUtilities.invokeLater(() -> detector4F4.doClick());
             } else if(KeyDetectorF4.equals("Detector5")) { 
        	   SwingUtilities.invokeLater(() -> detector5F4.doClick());
             } else {
            	 SwingUtilities.invokeLater(() -> detector1F4.doClick());
             };
             
        } catch (IOException e) {
            e.printStackTrace();
        }
	
       //subPanelF4 = new JPanel();
	
       subPanelF4 = new JPanel();


	//--------------------Detector1-----------------
    
	detector1F4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF4="Detectors/Efficiency1F4.txt";
			
			KeyDetectorF4 = "Detector1";
									
			filePath1F4= "Detectors\\detector1F4.txt";
		    
		
			detector1F4.setBackground(Color.BLUE); 
			detector2F4.setBackground(defaultColor);
			detector3F4.setBackground(defaultColor);
			detector4F4.setBackground(defaultColor);
			detector5F4.setBackground(defaultColor);
			save1F4.setBackground(defaultColor);
			
			
			
    try (BufferedReader readerF4 = new BufferedReader(new FileReader(filePath1F4))) {
        textFieldsamplename.setText(readerF4.readLine()); // 1st line
        textFieldPosition.setText(readerF4.readLine());  // 2nd line
        Mainn.textField1tpeF4.setText(readerF4.readLine());      // 3rd line		           
        Mainn.textField2tpeF4.setText(readerF4.readLine());
        Mainn.textField3tpeF4.setText(readerF4.readLine());// 5th line
            
        StringBuilder infos = new StringBuilder();
        String line;
        boolean capture = false;
        while ((line = readerF4.readLine()) != null) {
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
    subPanelF4.removeAll();
    subPanelF4.repaint();
    JPanel pnmpp = new JPanel();
    try {
    	pnmpp = new EfficiencyGraphF4();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    
    
    subPanelF4.setBounds(145, 360, 350, 185);
    panel1tpeF4.add(subPanelF4);
    subPanelF4.add(EfficiencyGraphF4.chartPanelEfficiencyF4);
    subPanelF4.revalidate();
    subPanelF4.repaint();
    
		
		}
	});
	
	detector1F4.setBounds(5, 0, 120, 23);
	panelDetector1.add(detector1F4);
	

	//--------------------Detector2----------------------------------
	
	
	detector2F4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF4="Detectors/Efficiency2F4.txt";
			KeyDetectorF4 = "Detector2";
			detector1F4.setBackground(defaultColor); // Gris
			detector2F4.setBackground(Color.BLUE);
			detector3F4.setBackground(defaultColor);
			detector4F4.setBackground(defaultColor);
			detector5F4.setBackground(defaultColor);
			save1F4.setBackground(defaultColor);
			
			filePath1F4= "Detectors\\Detector2F4.txt";
			
	        try (BufferedReader readerF4 = new BufferedReader(new FileReader(filePath1F4))) {
	            textFieldsamplename.setText(readerF4.readLine()); // 1st line
	            textFieldPosition.setText(readerF4.readLine());  // 2nd line
	            Mainn.textField1tpeF4.setText(readerF4.readLine());      // 3rd line		           
	            Mainn.textField2tpeF4.setText(readerF4.readLine());  
	            Mainn.textField3tpeF4.setText(readerF4.readLine());   
	                
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF4.readLine()) != null) {
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
	        subPanelF4.removeAll();
	        subPanelF4.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF4();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF4.setBounds(145, 360, 350, 185);
	        panel1tpeF4.add(subPanelF4);
	        subPanelF4.add(EfficiencyGraphF4.chartPanelEfficiencyF4);
	        subPanelF4.revalidate();
	        subPanelF4.repaint();
	        
		}
	});
	detector2F4.setBounds(5, 40, 120, 23);
	panelDetector1.add(detector2F4);
	//-----------------------Detecor3----------------------
	
	detector3F4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF4="Detectors/Efficiency3F4.txt";
			KeyDetectorF4 = "Detector3";
			detector1F4.setBackground(defaultColor); // Gris
			detector2F4.setBackground(defaultColor);
			detector3F4.setBackground(Color.BLUE);
			detector4F4.setBackground(defaultColor);
			detector5F4.setBackground(defaultColor);
			save1F4.setBackground(defaultColor);
		    
			filePath1F4= "Detectors\\Detector3F4.txt";
			
	        try (BufferedReader readerF4 = new BufferedReader(new FileReader(filePath1F4))) {
	            textFieldsamplename.setText(readerF4.readLine()); // 1st line
	            textFieldPosition.setText(readerF4.readLine());  // 2nd line
	            Mainn.textField1tpeF4.setText(readerF4.readLine());      // 3rd line		           
	            Mainn.textField2tpeF4.setText(readerF4.readLine()); 
	            Mainn.textField3tpeF4.setText(readerF4.readLine()); // 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF4.readLine()) != null) {
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
	        subPanelF4.removeAll();
	        subPanelF4.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF4();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        
	        subPanelF4.setBounds(145, 360, 350, 185);
	        panel1tpeF4.add(subPanelF4);
	        subPanelF4.add(EfficiencyGraphF4.chartPanelEfficiencyF4);
	        subPanelF4.revalidate();
	        subPanelF4.repaint();
			
		}
	});
	detector3F4.setBounds(5, 80, 120, 23);
	panelDetector1.add(detector3F4);
	
	//----------------Detector4---------------------
	
	detector4F4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF4="Detectors/Efficiency4F4.txt";
			KeyDetectorF4 = "Detector4";
			detector1F4.setBackground(defaultColor); // Gris
			detector2F4.setBackground(defaultColor);
			detector3F4.setBackground(defaultColor);
			detector4F4.setBackground(Color.BLUE);
			detector5F4.setBackground(defaultColor);
			save1F4.setBackground(defaultColor);
			
			filePath1F4= "Detectors\\Detector4F4.txt";
			
	        try (BufferedReader readerF4 = new BufferedReader(new FileReader(filePath1F4))) {
	            textFieldsamplename.setText(readerF4.readLine()); // 1st line
	            textFieldPosition.setText(readerF4.readLine());  // 2nd line
	            Mainn.textField1tpeF4.setText(readerF4.readLine());      // 3rd line		           
	            Mainn.textField2tpeF4.setText(readerF4.readLine()); 
	            Mainn.textField3tpeF4.setText(readerF4.readLine()); // 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF4.readLine()) != null) {
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
	        subPanelF4.removeAll();
	        subPanelF4.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF4();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF4.setBounds(145, 360, 350, 185);
	        panel1tpeF4.add(subPanelF4);
	        subPanelF4.add(EfficiencyGraphF4.chartPanelEfficiencyF4);
	        subPanelF4.revalidate();
	        subPanelF4.repaint();
			
		}
	});
	detector4F4.setBounds(5, 120, 120, 23);
	panelDetector1.add(detector4F4);
	
	//----------------------Detector5-------------------------
	
	detector5F4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF4="Detectors/Efficiency5F4.txt";
			KeyDetectorF4 = "Detector5";
			detector1F4.setBackground(defaultColor); // Gris
			detector2F4.setBackground(defaultColor);
			detector3F4.setBackground(defaultColor);
			detector4F4.setBackground(defaultColor);
			detector5F4.setBackground(Color.BLUE);
			save1F4.setBackground(defaultColor);
		    
			filePath1F4= "Detectors\\Detector5F4.txt";
			
	        try (BufferedReader readerF4 = new BufferedReader(new FileReader(filePath1F4))) {
	            textFieldsamplename.setText(readerF4.readLine()); // 1st line
	            textFieldPosition.setText(readerF4.readLine());  // 2nd line
	            Mainn.textField1tpeF4.setText(readerF4.readLine());      // 3rd line		           
	            Mainn.textField2tpeF4.setText(readerF4.readLine());
	            Mainn.textField3tpeF4.setText(readerF4.readLine());// 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF4.readLine()) != null) {
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
	        subPanelF4.removeAll();
	        subPanelF4.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF4();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF4.setBounds(145, 360, 350, 185);
	        panel1tpeF4.add(subPanelF4);
	        subPanelF4.add(EfficiencyGraphF4.chartPanelEfficiencyF4);
	        subPanelF4.revalidate();
	        subPanelF4.repaint();
			 
		}
	});
	detector5F4.setBounds(5, 160, 120, 23);
	panelDetector1.add(detector5F4);
	
	Mainn.mntmEfficiencyCalibration3.setSelected(false);
	if(Mainn.formula.equals("Formula4")) {Mainn.mntmEfficiencyCalibration3.setSelected(true);}
	
	
    
	save1F4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Mainn.mntmEfficiencyCalibration.setSelected(false);
            Mainn.mntmEfficiencyCalibration1.setSelected(false);
            Mainn.mntmEfficiencyCalibration2.setSelected(false);
            Mainn.mntmEfficiencyCalibration3.setSelected(true);
			Mainn.formula = "Formula4";
			
			
			save1F4.setBackground(Color.BLUE); 
		    
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath1F4))) {
	            writer.write(textFieldsamplename.getText() + "\n");
	            writer.write(textFieldPosition.getText() + "\n");
	            writer.write(Mainn.textField1tpeF4.getText() + "\n");         
	            writer.write(Mainn.textField2tpeF4.getText() + "\n");
	            writer.write(Mainn.textField3tpeF4.getText() + "\n");
	            writer.write("$\n" + textareainfos.getText() + "\n$\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Detectors\\saveF4.txt"))) {
	        	writer.write(KeyDetectorF4 + "\n");	
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	      //---------Fichier Coeffi_Formula3 pour les cofficients efficacité
	        try (BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Coeffi_Formula4.txt"))) {
	            
	            writerF3.write(Mainn.textField1tpeF4.getText() + "\n");         
	            writerF3.write(Mainn.textField2tpeF4.getText() + "\n");
	            writerF3.write(Mainn.textField3tpeF4.getText() + "\n");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	      //-------fichier formula----
	        try(BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Formula.txt"))) {
	        	           
	        	            writerF3.write("Formula4");         
	        	            
	        	        } catch (IOException e) {
	        	            e.printStackTrace();
	        	        }
	        	        //-------------------------
	        
	        //----------save and repaint graph----------
	        subPanelF4.removeAll();
	        subPanelF4.repaint();				        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF4();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			        
	        subPanelF4.setBounds(145, 360, 350, 185);
	        panel1tpeF4.add(subPanelF4);
	        subPanelF4.add(EfficiencyGraphF4.chartPanelEfficiencyF4);
	        subPanelF4.revalidate();
	        subPanelF4.repaint();
	        
	        //---------------------------------
	        
		}
	});
	save1F4.setBounds(380, 5, 120, 25);
	panel1tpeF4.add(save1F4);
    
	//------------------------------------------
	
	JButton btnOktpe = new JButton(" OK");
	btnOktpe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Mainn.AfpeF4 =Mainn.textField1tpeF4.getText();					    
			Mainn.textField1tpeF4.setText(Mainn.AfpeF4);
		    
		    
		    Mainn.Afp2eF4 =Mainn.textField2tpeF4.getText();					    
		    Mainn.textField2tpeF4.setText(Mainn.Afp2eF4);
		    
		    Mainn.Afp3eF4 =Mainn.textField3tpeF4.getText();					    
		    Mainn.textField3tpeF4.setText(Mainn.Afp3eF4);
		    
		    effF4.dispose();
		}
	});
	btnOktpe.setBounds(100, 190+360, 70, 23);
	panel1tpeF4.add(btnOktpe);
	
	JButton btnOk1tpe = new JButton("Cancel");
	btnOk1tpe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    				    
			Mainn.textField1tpeF4.setText(Mainn.AfpeF4);				    
			Mainn.textField2tpeF4.setText(Mainn.Afp2eF4);
			Mainn.textField3tpeF4.setText(Mainn.Afp3eF4);
		    		    
			effF4.dispose();	

		}
	});
	btnOk1tpe.setBounds(200, 190+360, 100, 23);
	panel1tpeF4.add(btnOk1tpe);	
	
	JButton inialize1 = new JButton("inialize");
	inialize1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    
			Mainn.textField1tpeF4.setText("0");
			Mainn.textField2tpeF4.setText("0");
			Mainn.textField3tpeF4.setText("0");
			
		}
	});
	inialize1.setBounds(330,190+360, 80, 23);
	panel1tpeF4.add(inialize1);
	
	effF4.setSize(650,660);
	effF4.setResizable(false);
	effF4.setVisible(true);

}

	
}

