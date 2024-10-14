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


public class Formule2Efficiency {
	JDialog effF2;
    JPanel panelDetector1;
    static JPanel subPanelF2;
    static String filePath1F2, KeyDetectorF2 ;
    
    
    public static void Formule2Efficiency() {
	
	JDialog effF2 = new JDialog((Frame)null, "Efficiency calibration", true);
	effF2.getContentPane().setLayout(null);
	
	JPanel panelDetector1=new JPanel();
	panelDetector1.setBackground(Color.LIGHT_GRAY); // Gris clair
	//panelDetector1.setBackground(Color.GRAY);
	panelDetector1.setBounds(5, 0, 110, 600);
	panelDetector1.setLayout(null);
	effF2.getContentPane().add(panelDetector1);
	

	
    JPanel panel1tpeF2=new JPanel();
    panel1tpeF2.setBackground(Color.LIGHT_GRAY); // Gris clair
	panel1tpeF2.setBounds(120, 0, 500, 600);
	panel1tpeF2.setLayout(null);
	effF2.getContentPane().add(panel1tpeF2);
	
	
	
	JLabel  samplename = new JLabel(" sample name :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	samplename.setBounds(23, 35, 100, 17);
	panel1tpeF2.add(samplename); 
	
	TextField textFieldsamplename = new TextField(" ");
	textFieldsamplename.setBounds(170, 35, 150, 17);				
	panel1tpeF2.add(textFieldsamplename);
	
	
	JLabel  position = new JLabel(" position      :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	position.setBounds(23, 65, 100, 17);
	panel1tpeF2.add(position); 
	
	TextField textFieldPosition = new TextField(" ");
	textFieldPosition.setBounds(170, 65, 150, 17);				
	panel1tpeF2.add(textFieldPosition);
	
	JLabel  otherinfo = new JLabel(" Other info    :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	otherinfo.setBounds(23, 95, 100, 17);
	panel1tpeF2.add(otherinfo); 
	
	TextArea textareainfos = new TextArea("   ");
	textareainfos.setBounds(170, 95, 250, 200);				
	panel1tpeF2.add(textareainfos);
	
	JButton showTableButton = new JButton("Select the calibration nuclides");
    showTableButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	EfficiencyTableF2 dialog = new EfficiencyTableF2(effF2);  // Remplacez parentFrame par le nom de votre fenêtre principale
            dialog.setAlwaysOnTop(true);  // Assure que la fenêtre apparaît en avant
            dialog.setVisible(true);      // Affiche la boîte de dialogue
        }
    });
    showTableButton.setBounds(23, 310, 250, 22);		        
    panel1tpeF2.add(showTableButton, BorderLayout.SOUTH);
    
	JLabel lblA_11tpe = new JLabel("eff= a*E^(-b) ");
	//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_11tpe.setBounds(23, 11+330, 380, 17);
	lblA_11tpe.setForeground(Color.BLUE);
	panel1tpeF2.add(lblA_11tpe);
	
	JLabel lblA_12tpe = new JLabel("  a =");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_12tpe.setBounds(23, 35+360, 46, 17);
	panel1tpeF2.add(lblA_12tpe);
	
	//TextField textField1tpeF2 = new TextField("1");
	Mainn.textField1tpeF2.setBounds(75, 35+360, 56, 20);				
	panel1tpeF2.add(Mainn.textField1tpeF2);
	
	JLabel lblA_13tpe = new JLabel("-b =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_13tpe.setBounds(23, 57+360, 46, 17);
	panel1tpeF2.add(lblA_13tpe);
	
	//TextField textField2tpeF2 = new TextField("3");
	Mainn.textField2tpeF2.setBounds(75, 55+360, 56, 20);				
	panel1tpeF2.add(Mainn.textField2tpeF2);
	
	
	
	Color defaultColor = UIManager.getColor("Button.background");
	
	
	JButton detector1F2 = new JButton("Det01(Cal01)");
	JButton detector2F2 = new JButton("Det01(Cal02)");
	JButton detector3F2 = new JButton("Det01(Cal03)");
	JButton detector4F2 = new JButton("Det01(Cal04)");
	JButton detector5F2 = new JButton("Det01(Cal05)");
	JButton save1F2 = new JButton(" save");
	
	//--------------pour sauvegarder infos de detecteur en premier ouvertir de logiciel---
	
       try (BufferedReader readerF2 = new BufferedReader(new FileReader("Detectors\\saveF2.txt"))) {
    	    KeyDetectorF2 = readerF2.readLine();
    	   if(KeyDetectorF2.equals("Detector1")) { 
        	   SwingUtilities.invokeLater(() -> detector1F2.doClick());
             } else if(KeyDetectorF2.equals("Detector2")) { 
        	   SwingUtilities.invokeLater(() -> detector2F2.doClick());
             } else if(KeyDetectorF2.equals("Detector3")) { 
        	   SwingUtilities.invokeLater(() -> detector3F2.doClick());
             } else if(KeyDetectorF2.equals("Detector4")) { 
        	   SwingUtilities.invokeLater(() -> detector4F2.doClick());
             } else if(KeyDetectorF2.equals("Detector5")) { 
        	   SwingUtilities.invokeLater(() -> detector5F2.doClick());
             } else {
            	 SwingUtilities.invokeLater(() -> detector1F2.doClick());
             };
             
        } catch (IOException e) {
            e.printStackTrace();
        }
	
       //subPanelF2 = new JPanel();
	
       subPanelF2 = new JPanel();


	//--------------------Detector1-----------------
    
	detector1F2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF2="Detectors/Efficiency1F2.txt"; 
			KeyDetectorF2 = "Detector1";
									
			filePath1F2= "Detectors\\detector1F2.txt";
		    
		
			detector1F2.setBackground(Color.BLUE); 
			detector2F2.setBackground(defaultColor);
			detector3F2.setBackground(defaultColor);
			detector4F2.setBackground(defaultColor);
			detector5F2.setBackground(defaultColor);
			save1F2.setBackground(defaultColor);
			
			
			
    try (BufferedReader readerF2 = new BufferedReader(new FileReader(filePath1F2))) {
        textFieldsamplename.setText(readerF2.readLine()); // 1st line
        textFieldPosition.setText(readerF2.readLine());  // 2nd line
        Mainn.textField1tpeF2.setText(readerF2.readLine());      // 3rd line		           
        Mainn.textField2tpeF2.setText(readerF2.readLine());      // 5th line
            
        StringBuilder infos = new StringBuilder();
        String line;
        boolean capture = false;
        while ((line = readerF2.readLine()) != null) {
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
    subPanelF2.removeAll();
    subPanelF2.repaint();
    JPanel pnmpp = new JPanel();
    try {
		pnmpp = new EfficiencyGraphF2();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    
    
    subPanelF2.setBounds(145, 360, 350, 185);
    panel1tpeF2.add(subPanelF2);
    subPanelF2.add(EfficiencyGraphF2.chartPanelEfficiencyF2);
    subPanelF2.revalidate();
    subPanelF2.repaint();
    
		
		}
	});
	
	detector1F2.setBounds(5, 0, 120, 23);
	panelDetector1.add(detector1F2);
	

	//--------------------Detector2----------------------------------
	
	
	detector2F2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF2="Detectors/Efficiency2F2.txt";
			KeyDetectorF2 = "Detector2";
			detector1F2.setBackground(defaultColor); // Gris
			detector2F2.setBackground(Color.BLUE);
			detector3F2.setBackground(defaultColor);
			detector4F2.setBackground(defaultColor);
			detector5F2.setBackground(defaultColor);
			save1F2.setBackground(defaultColor);
			
			filePath1F2= "Detectors\\Detector2F2.txt";
			
	        try (BufferedReader readerF2 = new BufferedReader(new FileReader(filePath1F2))) {
	            textFieldsamplename.setText(readerF2.readLine()); // 1st line
	            textFieldPosition.setText(readerF2.readLine());  // 2nd line
	            Mainn.textField1tpeF2.setText(readerF2.readLine());      // 3rd line		           
	            Mainn.textField2tpeF2.setText(readerF2.readLine());      // 5th line
	                
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF2.readLine()) != null) {
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
	        subPanelF2.removeAll();
	        subPanelF2.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
				pnmpp = new EfficiencyGraphF2();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF2.setBounds(145, 360, 350, 185);
	        panel1tpeF2.add(subPanelF2);
	        subPanelF2.add(EfficiencyGraphF2.chartPanelEfficiencyF2);
	        subPanelF2.revalidate();
	        subPanelF2.repaint();
	        
		}
	});
	detector2F2.setBounds(5, 40, 120, 23);
	panelDetector1.add(detector2F2);
	//-----------------------Detecor3----------------------
	
	detector3F2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF2="Detectors/Efficiency3F2.txt";
			KeyDetectorF2 = "Detector3";
			detector1F2.setBackground(defaultColor); // Gris
			detector2F2.setBackground(defaultColor);
			detector3F2.setBackground(Color.BLUE);
			detector4F2.setBackground(defaultColor);
			detector5F2.setBackground(defaultColor);
			save1F2.setBackground(defaultColor);
		    
			filePath1F2= "Detectors\\Detector3F2.txt";
			
	        try (BufferedReader readerF2 = new BufferedReader(new FileReader(filePath1F2))) {
	            textFieldsamplename.setText(readerF2.readLine()); // 1st line
	            textFieldPosition.setText(readerF2.readLine());  // 2nd line
	            Mainn.textField1tpeF2.setText(readerF2.readLine());      // 3rd line		           
	            Mainn.textField2tpeF2.setText(readerF2.readLine());      // 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF2.readLine()) != null) {
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
	        subPanelF2.removeAll();
	        subPanelF2.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
				pnmpp = new EfficiencyGraphF2();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        
	        subPanelF2.setBounds(145, 360, 350, 185);
	        panel1tpeF2.add(subPanelF2);
	        subPanelF2.add(EfficiencyGraphF2.chartPanelEfficiencyF2);
	        subPanelF2.revalidate();
	        subPanelF2.repaint();
			
		}
	});
	detector3F2.setBounds(5, 80, 120, 23);
	panelDetector1.add(detector3F2);
	
	//----------------Detector4---------------------
	
	detector4F2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF2="Detectors/Efficiency4F2.txt";
			KeyDetectorF2 = "Detector4";
			detector1F2.setBackground(defaultColor); // Gris
			detector2F2.setBackground(defaultColor);
			detector3F2.setBackground(defaultColor);
			detector4F2.setBackground(Color.BLUE);
			detector5F2.setBackground(defaultColor);
			save1F2.setBackground(defaultColor);
			
			filePath1F2= "Detectors\\Detector4F2.txt";
			
	        try (BufferedReader readerF2 = new BufferedReader(new FileReader(filePath1F2))) {
	            textFieldsamplename.setText(readerF2.readLine()); // 1st line
	            textFieldPosition.setText(readerF2.readLine());  // 2nd line
	            Mainn.textField1tpeF2.setText(readerF2.readLine());      // 3rd line		           
	            Mainn.textField2tpeF2.setText(readerF2.readLine());      // 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF2.readLine()) != null) {
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
	        subPanelF2.removeAll();
	        subPanelF2.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
				pnmpp = new EfficiencyGraphF2();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF2.setBounds(145, 360, 350, 185);
	        panel1tpeF2.add(subPanelF2);
	        subPanelF2.add(EfficiencyGraphF2.chartPanelEfficiencyF2);
	        subPanelF2.revalidate();
	        subPanelF2.repaint();
			
		}
	});
	detector4F2.setBounds(5, 120, 120, 23);
	panelDetector1.add(detector4F2);
	
	//----------------------Detector5-------------------------
	
	detector5F2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF2="Detectors/Efficiency5F2.txt";
			KeyDetectorF2 = "Detector5";
			detector1F2.setBackground(defaultColor); // Gris
			detector2F2.setBackground(defaultColor);
			detector3F2.setBackground(defaultColor);
			detector4F2.setBackground(defaultColor);
			detector5F2.setBackground(Color.BLUE);
			save1F2.setBackground(defaultColor);
		    
			filePath1F2= "Detectors\\Detector5F2.txt";
			
	        try (BufferedReader readerF2 = new BufferedReader(new FileReader(filePath1F2))) {
	            textFieldsamplename.setText(readerF2.readLine()); // 1st line
	            textFieldPosition.setText(readerF2.readLine());  // 2nd line
	            Mainn.textField1tpeF2.setText(readerF2.readLine());      // 3rd line		           
	            Mainn.textField2tpeF2.setText(readerF2.readLine());      // 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF2.readLine()) != null) {
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
	        subPanelF2.removeAll();
	        subPanelF2.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
				pnmpp = new EfficiencyGraphF2();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF2.setBounds(145, 360, 350, 185);
	        panel1tpeF2.add(subPanelF2);
	        subPanelF2.add(EfficiencyGraphF2.chartPanelEfficiencyF2);
	        subPanelF2.revalidate();
	        subPanelF2.repaint();
			 
		}
	});
	detector5F2.setBounds(5, 160, 120, 23);
	panelDetector1.add(detector5F2);
	
	Mainn.mntmEfficiencyCalibration1.setSelected(false);
	if(Mainn.formula.equals("Formula2")) {Mainn.mntmEfficiencyCalibration1.setSelected(true);}
	
    
	save1F2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Mainn.mntmEfficiencyCalibration.setSelected(false);
            Mainn.mntmEfficiencyCalibration2.setSelected(false);
            Mainn.mntmEfficiencyCalibration3.setSelected(false);
            Mainn.mntmEfficiencyCalibration1.setSelected(true);  
			Mainn.formula = "Formula2";
			
			
			
			save1F2.setBackground(Color.BLUE); 
		    
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath1F2))) {
	            writer.write(textFieldsamplename.getText() + "\n");
	            writer.write(textFieldPosition.getText() + "\n");
	            writer.write(Mainn.textField1tpeF2.getText() + "\n");         
	            writer.write(Mainn.textField2tpeF2.getText() + "\n");	            
	            writer.write("$\n" + textareainfos.getText() + "\n$\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Detectors\\saveF2.txt"))) {
	        	writer.write(KeyDetectorF2 + "\n");	
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
	      //---------Fichier Coeffi_Formula2 pour les cofficients efficacité
	        try (BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Coeffi_Formula2.txt"))) {
	            
	            writerF3.write(Mainn.textField1tpeF2.getText() + "\n");         
	            writerF3.write(Mainn.textField2tpeF2.getText() + "\n");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        //-------fichier formula----
try       (BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Formula.txt"))) {
	           
	            writerF3.write("Formula2");         
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        //-------------------------
	        
	        //----------save and repaint graph----------
	        subPanelF2.removeAll();
	        subPanelF2.repaint();				        
	        JPanel pnmpp = new JPanel();
	        try {
				pnmpp = new EfficiencyGraphF2();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			        
	        subPanelF2.setBounds(145, 360, 350, 185);
	        panel1tpeF2.add(subPanelF2);
	        subPanelF2.add(EfficiencyGraphF2.chartPanelEfficiencyF2);
	        subPanelF2.revalidate();
	        subPanelF2.repaint();
	        
	        //---------------------------------
	        
		}
	});
	save1F2.setBounds(380, 5, 120, 25);
	panel1tpeF2.add(save1F2);
    
	//------------------------------------------
	
	JButton btnOktpe = new JButton(" OK");
	btnOktpe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Mainn.AfpeF2 =Mainn.textField1tpeF2.getText();					    
			Mainn.textField1tpeF2.setText(Mainn.AfpeF2);
		    
		    
		    Mainn.Afp2eF2 =Mainn.textField2tpeF2.getText();					    
		    Mainn.textField2tpeF2.setText(Mainn.Afp2eF2);
		    
		    effF2.dispose();
		}
	});
	btnOktpe.setBounds(100, 190+360, 70, 23);
	panel1tpeF2.add(btnOktpe);
	
	JButton btnOk1tpe = new JButton("Cancel");
	btnOk1tpe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    
								    
			Mainn.textField1tpeF2.setText(Mainn.AfpeF2);
		    				    
			Mainn.textField2tpeF2.setText(Mainn.Afp2eF2);
		    		    
			effF2.dispose();	

		}
	});
	btnOk1tpe.setBounds(200, 190+360, 100, 23);
	panel1tpeF2.add(btnOk1tpe);	
	
	JButton inialize1 = new JButton("inialize");
	inialize1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    
			Mainn.textField1tpeF2.setText("0");
			Mainn.textField2tpeF2.setText("0");
			
		}
	});
	inialize1.setBounds(330,190+360, 80, 23);
	panel1tpeF2.add(inialize1);
	
	effF2.setSize(650,660);
	effF2.setResizable(false);
	effF2.setVisible(true);

}

	
}

