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


public class Formule3Efficiency {
	JDialog effF3;
    JPanel panelDetector1;
    static JPanel subPanelF3;
    static String filePath1F3, KeyDetectorF3 ;
    
    
    public static void Formule3Efficiency() {
	
	JDialog effF3 = new JDialog((Frame)null, "Efficiency calibration", true);
	effF3.getContentPane().setLayout(null);
	
	JPanel panelDetector1=new JPanel();
	panelDetector1.setBackground(Color.LIGHT_GRAY); // Gris clair
	//panelDetector1.setBackground(Color.GRAY);
	panelDetector1.setBounds(5, 0, 110, 600);
	panelDetector1.setLayout(null);
	effF3.getContentPane().add(panelDetector1);
	

	
    JPanel panel1tpeF3=new JPanel();
    panel1tpeF3.setBackground(Color.LIGHT_GRAY); // Gris clair
	panel1tpeF3.setBounds(120, 0, 500, 600);
	panel1tpeF3.setLayout(null);
	effF3.getContentPane().add(panel1tpeF3);
	
	
	
	JLabel  samplename = new JLabel(" sample name :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	samplename.setBounds(23, 35, 100, 17);
	panel1tpeF3.add(samplename); 
	
	TextField textFieldsamplename = new TextField(" ");
	textFieldsamplename.setBounds(170, 35, 150, 17);				
	panel1tpeF3.add(textFieldsamplename);
	
	
	JLabel  position = new JLabel(" position      :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	position.setBounds(23, 65, 100, 17);
	panel1tpeF3.add(position); 
	
	TextField textFieldPosition = new TextField(" ");
	textFieldPosition.setBounds(170, 65, 150, 17);				
	panel1tpeF3.add(textFieldPosition);
	
	JLabel  otherinfo = new JLabel(" Other info    :  ");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	otherinfo.setBounds(23, 95, 100, 17);
	panel1tpeF3.add(otherinfo); 
	
	TextArea textareainfos = new TextArea("   ");
	textareainfos.setBounds(170, 95, 250, 200);				
	panel1tpeF3.add(textareainfos);
	
	JButton showTableButton = new JButton("Select the calibration nuclides");
    showTableButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	EfficiencytableF3 dialog = new EfficiencytableF3(effF3);
        	// Remplacez parentFrame par le nom de votre fenêtre principale
        	dialog.setAlwaysOnTop(true);  // Assure que la fenêtre apparaît en avant
            dialog.setVisible(true);      // Affiche la boîte de dialogue
        	
        }
    });
    showTableButton.setBounds(23, 310, 250, 22);		        
    panel1tpeF3.add(showTableButton, BorderLayout.SOUTH);
    
    JLabel DegreeNF3 = new JLabel("Degree of the equation n =");
	//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
    DegreeNF3.setBounds(280, 310, 160, 22);
    DegreeNF3.setForeground(Color.BLUE);
	panel1tpeF3.add(DegreeNF3);
    
	
 // Créer un JSpinner pour les valeurs de 2 à 5
    SpinnerModel modelF3 = new SpinnerNumberModel(Mainn.savedValueF3, 1, 5, 1); // Valeur initiale, min, max, pas
    Mainn.spinnerF3 = new JSpinner(modelF3);
    Mainn.spinnerF3.setBounds(450, 310, 50, 22);
    Mainn.spinnerF3.setForeground(Color.BLUE);
    JFormattedTextField txt = ((JSpinner.DefaultEditor) Mainn.spinnerF3.getEditor()).getTextField();
    txt.setForeground(Color.BLUE);
    panel1tpeF3.add(Mainn.spinnerF3);
    
	JLabel lblA_11tpe = new JLabel("eff= a+b*E+c*E^(2)+....+f*E^(n))");
	//lblA_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_11tpe.setBounds(23, 11+330, 380, 17);
	lblA_11tpe.setForeground(Color.BLUE);
	panel1tpeF3.add(lblA_11tpe);
	
	JLabel lblA_12tpe = new JLabel("  a =");
	//lblA_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_12tpe.setBounds(23, 35+360, 46, 17);
	panel1tpeF3.add(lblA_12tpe);
	
	//TextField textField1tpeF3 = new TextField("1");
	Mainn.textField1tpeF3.setBounds(75, 35+360, 56, 20);				
	panel1tpeF3.add(Mainn.textField1tpeF3);
	
	JLabel lblA_13tpe = new JLabel("  b =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_13tpe.setBounds(23, 57+360, 46, 17);
	panel1tpeF3.add(lblA_13tpe);
	
	//TextField textField2tpeF3 = new TextField("3");
	Mainn.textField2tpeF3.setBounds(75, 55+360, 56, 20);				
	panel1tpeF3.add(Mainn.textField2tpeF3);
	
	JLabel lblA_14tpe = new JLabel("  c =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_14tpe.setBounds(23, 80+360, 46, 17);
	panel1tpeF3.add(lblA_14tpe);
	
	//TextField textField2tpeF3 = new TextField("3");
	Mainn.textField3tpeF3.setBounds(75, 80+360, 56, 20);				
	panel1tpeF3.add(Mainn.textField3tpeF3);
	
	JLabel lblA_15tpe = new JLabel("  d =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_15tpe.setBounds(23, 105+360, 46, 17);
	panel1tpeF3.add(lblA_15tpe);
	
	//TextField textField4tp = new TextField("1");
	Mainn.textField4tpeF3.setBounds(75, 105+360, 56, 20);				
	panel1tpeF3.add(Mainn.textField4tpeF3);
	
	JLabel lblA_16tpe = new JLabel("  e =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_16tpe.setBounds(23, 130+360, 46, 17);
	panel1tpeF3.add(lblA_16tpe);
	
	//TextField textField5tp = new TextField("20");
	Mainn.textField5tpeF3.setBounds(75, 130+360, 56, 20);				
	panel1tpeF3.add(Mainn.textField5tpeF3);
	
	JLabel lblA_17tpe = new JLabel("  f =");
	//lblA_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblA_17tpe.setBounds(23, 155+360, 46, 17);
	panel1tpeF3.add(lblA_17tpe);
	
	//TextField textField5tp = new TextField("20");
	Mainn.textField6tpeF3.setBounds(75, 155+360, 56, 20);				
	panel1tpeF3.add(Mainn.textField6tpeF3);
	
	
	Color defaultColor = UIManager.getColor("Button.background");
	
	
	JButton detector1F3 = new JButton("Det01(Cal01)");
	JButton detector2F3 = new JButton("Det01(Cal02)");
	JButton detector3F3 = new JButton("Det01(Cal03)");
	JButton detector4F3 = new JButton("Det01(Cal04)");
	JButton detector5F3 = new JButton("Det01(Cal05)");
	JButton save1F3 = new JButton(" save");
	
	//--------------pour sauvegarder infos de detecteur en premier ouvertir de logiciel---
	
       try (BufferedReader readerF3 = new BufferedReader(new FileReader("Detectors\\saveF3.txt"))) {
    	    KeyDetectorF3 = readerF3.readLine();
    	   if(KeyDetectorF3.equals("Detector1")) { 
        	   SwingUtilities.invokeLater(() -> detector1F3.doClick());
             } else if(KeyDetectorF3.equals("Detector2")) { 
        	   SwingUtilities.invokeLater(() -> detector2F3.doClick());
             } else if(KeyDetectorF3.equals("Detector3")) { 
        	   SwingUtilities.invokeLater(() -> detector3F3.doClick());
             } else if(KeyDetectorF3.equals("Detector4")) { 
        	   SwingUtilities.invokeLater(() -> detector4F3.doClick());
             } else if(KeyDetectorF3.equals("Detector5")) { 
        	   SwingUtilities.invokeLater(() -> detector5F3.doClick());
             } else {
            	 SwingUtilities.invokeLater(() -> detector1F3.doClick());
             };
             
        } catch (IOException e) {
            e.printStackTrace();
        }
	
       //subPanelF3 = new JPanel();
	
       subPanelF3 = new JPanel();


	//--------------------Detector1-----------------
    
	detector1F3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF3="Detectors/Efficiency1F3.txt";
			
			KeyDetectorF3 = "Detector1";
									
			filePath1F3= "Detectors\\detector1F3.txt";
		    
		
			detector1F3.setBackground(Color.BLUE); 
			detector2F3.setBackground(defaultColor);
			detector3F3.setBackground(defaultColor);
			detector4F3.setBackground(defaultColor);
			detector5F3.setBackground(defaultColor);
			save1F3.setBackground(defaultColor);
			
			//---------Supprimer le contenu du fichier et écrire la valeur du Spinner(degre de equation)
            try (PrintWriter writer = new PrintWriter(new FileWriter(Mainn.filenameDegreF3))) {
                // Écrire la valeur du Spinner dans le fichier
                writer.println(Mainn.spinnerF3.getValue());
                writer.flush(); // S'assurer que toutes les données sont écrites
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Mainn.filenameDegreF3="Detectors/degreeOfEquation1F3.txt";
    		try (BufferedReader brDegre = new BufferedReader(new FileReader(Mainn.filenameDegreF3))) {
                String lineDegre = brDegre.readLine(); // Lire la première ligne
                Mainn.savedValue = Integer.parseInt(lineDegre.trim());
                  
            } catch (IOException ed) {
                ed.printStackTrace(); // Afficher l'erreur d'entrée/sortie
            }  ;
                            //--------------------------------
			
			
    try (BufferedReader readerF3 = new BufferedReader(new FileReader(filePath1F3))) {
        textFieldsamplename.setText(readerF3.readLine()); // 1st line
        textFieldPosition.setText(readerF3.readLine());  // 2nd line
        Mainn.textField1tpeF3.setText(readerF3.readLine());      // 3rd line		           
        Mainn.textField2tpeF3.setText(readerF3.readLine());
        Mainn.textField3tpeF3.setText(readerF3.readLine());// 5th line
        Mainn.textField4tpeF3.setText(readerF3.readLine());      // 3rd line		           
        Mainn.textField5tpeF3.setText(readerF3.readLine());
        Mainn.textField6tpeF3.setText(readerF3.readLine());
            
        StringBuilder infos = new StringBuilder();
        String line;
        boolean capture = false;
        while ((line = readerF3.readLine()) != null) {
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
    subPanelF3.removeAll();
    subPanelF3.repaint();
    JPanel pnmpp = new JPanel();
    try {
    	pnmpp = new EfficiencyGraphF3();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    
    subPanelF3.setBounds(145, 360, 350, 185);
    panel1tpeF3.add(subPanelF3);
    subPanelF3.add(EfficiencyGraphF3.chartPanelEfficiencyF3);
    subPanelF3.revalidate();
    subPanelF3.repaint();
    
  //-------pour sauvergarder le numero de degré efficacité----------
    double txtDeg6F3 = Double.parseDouble(Mainn.textField6tpeF3.getText());
    double txtDeg5F3 = Double.parseDouble(Mainn.textField5tpeF3.getText());
    double txtDeg4F3 = Double.parseDouble(Mainn.textField4tpeF3.getText());
    double txtDeg3F3 = Double.parseDouble(Mainn.textField3tpeF3.getText());
    if(txtDeg6F3!=0.0) {Mainn.savedValueDegreeF3=5;};
    if(txtDeg6F3==0.0) {Mainn.savedValueDegreeF3=4;};
    if(txtDeg6F3==0.0 && txtDeg5F3==0.0 ) {Mainn.savedValueDegreeF3=3;};
    if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0) {Mainn.savedValueDegreeF3=2;};
    if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0 && txtDeg3F3==0.0) {Mainn.savedValueDegreeF3=1;};
    //System.out.println("   savedValueDegree    :"+savedValueDegree);
    Mainn.spinnerF3.setValue(Mainn.savedValueDegreeF3);
                    //-----------------------------------
		
		}
	});
	
	detector1F3.setBounds(5, 0, 120, 23);
	panelDetector1.add(detector1F3);
	

	//--------------------Detector2----------------------------------
	
	
	detector2F3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF3="Detectors/Efficiency2F3.txt";
			KeyDetectorF3 = "Detector2";
			detector1F3.setBackground(defaultColor); // Gris
			detector2F3.setBackground(Color.BLUE);
			detector3F3.setBackground(defaultColor);
			detector4F3.setBackground(defaultColor);
			detector5F3.setBackground(defaultColor);
			save1F3.setBackground(defaultColor);
			
			filePath1F3= "Detectors\\Detector2F3.txt";
			
			//---------Supprimer le contenu du fichier et écrire la valeur du Spinner(degre de equation)
            try (PrintWriter writer = new PrintWriter(new FileWriter(Mainn.filenameDegreF3))) {
                // Écrire la valeur du Spinner dans le fichier
                writer.println(Mainn.spinnerF3.getValue());
                writer.flush(); // S'assurer que toutes les données sont écrites
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Mainn.filenameDegreF3="Detectors/degreeOfEquation2F3.txt";
    		try (BufferedReader brDegre = new BufferedReader(new FileReader(Mainn.filenameDegreF3))) {
                String lineDegre = brDegre.readLine(); // Lire la première ligne
                Mainn.savedValueF3 = Integer.parseInt(lineDegre.trim());
                  
            } catch (IOException ed) {
                ed.printStackTrace(); // Afficher l'erreur d'entrée/sortie
            }  ;
                            //--------------------------------
			
			
	        try (BufferedReader readerF3 = new BufferedReader(new FileReader(filePath1F3))) {
	            textFieldsamplename.setText(readerF3.readLine()); // 1st line
	            textFieldPosition.setText(readerF3.readLine());  // 2nd line
	            Mainn.textField1tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField2tpeF3.setText(readerF3.readLine());  
	            Mainn.textField3tpeF3.setText(readerF3.readLine());
	            Mainn.textField4tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField5tpeF3.setText(readerF3.readLine());  
	            Mainn.textField6tpeF3.setText(readerF3.readLine());
	                
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF3.readLine()) != null) {
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
	        subPanelF3.removeAll();
	        subPanelF3.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF3();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF3.setBounds(145, 360, 350, 185);
	        panel1tpeF3.add(subPanelF3);
	        subPanelF3.add(EfficiencyGraphF3.chartPanelEfficiencyF3);
	        subPanelF3.revalidate();
	        subPanelF3.repaint();
	        
	      //-------pour sauvergarder le numero de degré efficacité----------
	        double txtDeg6F3 = Double.parseDouble(Mainn.textField6tpeF3.getText());
	        double txtDeg5F3 = Double.parseDouble(Mainn.textField5tpeF3.getText());
	        double txtDeg4F3 = Double.parseDouble(Mainn.textField4tpeF3.getText());
	        double txtDeg3F3 = Double.parseDouble(Mainn.textField3tpeF3.getText());
	        if(txtDeg6F3!=0.0) {Mainn.savedValueDegreeF3=5;};
	        if(txtDeg6F3==0.0) {Mainn.savedValueDegreeF3=4;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 ) {Mainn.savedValueDegreeF3=3;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0) {Mainn.savedValueDegreeF3=2;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0 && txtDeg3F3==0.0) {Mainn.savedValueDegreeF3=1;};
	        //System.out.println("   savedValueDegree    :"+savedValueDegree);
	        Mainn.spinnerF3.setValue(Mainn.savedValueDegreeF3);
	                        //-----------------------------------
	        
		}
	});
	detector2F3.setBounds(5, 40, 120, 23);
	panelDetector1.add(detector2F3);
	//-----------------------Detecor3----------------------
	
	detector3F3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF3="Detectors/Efficiency3F3.txt";
			KeyDetectorF3 = "Detector3";
			detector1F3.setBackground(defaultColor); // Gris
			detector2F3.setBackground(defaultColor);
			detector3F3.setBackground(Color.BLUE);
			detector4F3.setBackground(defaultColor);
			detector5F3.setBackground(defaultColor);
			save1F3.setBackground(defaultColor);
		    
			filePath1F3= "Detectors\\Detector3F3.txt";
			
	        try (BufferedReader readerF3 = new BufferedReader(new FileReader(filePath1F3))) {
	            textFieldsamplename.setText(readerF3.readLine()); // 1st line
	            textFieldPosition.setText(readerF3.readLine());  // 2nd line
	            Mainn.textField1tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField2tpeF3.setText(readerF3.readLine()); 
	            Mainn.textField3tpeF3.setText(readerF3.readLine());
	            Mainn.textField4tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField5tpeF3.setText(readerF3.readLine()); 
	            Mainn.textField6tpeF3.setText(readerF3.readLine());// 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF3.readLine()) != null) {
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
	        subPanelF3.removeAll();
	        subPanelF3.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF3();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        
	        subPanelF3.setBounds(145, 360, 350, 185);
	        panel1tpeF3.add(subPanelF3);
	        subPanelF3.add(EfficiencyGraphF3.chartPanelEfficiencyF3);
	        subPanelF3.revalidate();
	        subPanelF3.repaint();
	        
	      //-------pour sauvergarder le numero de degré efficacité----------
	        double txtDeg6F3 = Double.parseDouble(Mainn.textField6tpeF3.getText());
	        double txtDeg5F3 = Double.parseDouble(Mainn.textField5tpeF3.getText());
	        double txtDeg4F3 = Double.parseDouble(Mainn.textField4tpeF3.getText());
	        double txtDeg3F3 = Double.parseDouble(Mainn.textField3tpeF3.getText());
	        if(txtDeg6F3!=0.0) {Mainn.savedValueDegreeF3=5;};
	        if(txtDeg6F3==0.0) {Mainn.savedValueDegreeF3=4;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 ) {Mainn.savedValueDegreeF3=3;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0) {Mainn.savedValueDegreeF3=2;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0 && txtDeg3F3==0.0) {Mainn.savedValueDegreeF3=1;};
	        //System.out.println("   savedValueDegree    :"+savedValueDegree);
	        Mainn.spinnerF3.setValue(Mainn.savedValueDegreeF3);
	                        //-----------------------------------
			
		}
	});
	detector3F3.setBounds(5, 80, 120, 23);
	panelDetector1.add(detector3F3);
	
	//----------------Detector4---------------------
	
	detector4F3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF3="Detectors/Efficiency4F3.txt";
			KeyDetectorF3 = "Detector4";
			detector1F3.setBackground(defaultColor); // Gris
			detector2F3.setBackground(defaultColor);
			detector3F3.setBackground(defaultColor);
			detector4F3.setBackground(Color.BLUE);
			detector5F3.setBackground(defaultColor);
			save1F3.setBackground(defaultColor);
			
			filePath1F3= "Detectors\\Detector4F3.txt";
			
	        try (BufferedReader readerF3 = new BufferedReader(new FileReader(filePath1F3))) {
	            textFieldsamplename.setText(readerF3.readLine()); // 1st line
	            textFieldPosition.setText(readerF3.readLine());  // 2nd line
	            Mainn.textField1tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField2tpeF3.setText(readerF3.readLine()); 
	            Mainn.textField3tpeF3.setText(readerF3.readLine());
	            Mainn.textField4tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField5tpeF3.setText(readerF3.readLine()); 
	            Mainn.textField6tpeF3.setText(readerF3.readLine());// 5th line
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF3.readLine()) != null) {
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
	        subPanelF3.removeAll();
	        subPanelF3.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF3();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF3.setBounds(145, 360, 350, 185);
	        panel1tpeF3.add(subPanelF3);
	        subPanelF3.add(EfficiencyGraphF3.chartPanelEfficiencyF3);
	        subPanelF3.revalidate();
	        subPanelF3.repaint();
	        
	      //-------pour sauvergarder le numero de degré efficacité----------
	        double txtDeg6F3 = Double.parseDouble(Mainn.textField6tpeF3.getText());
	        double txtDeg5F3 = Double.parseDouble(Mainn.textField5tpeF3.getText());
	        double txtDeg4F3 = Double.parseDouble(Mainn.textField4tpeF3.getText());
	        double txtDeg3F3 = Double.parseDouble(Mainn.textField3tpeF3.getText());
	        if(txtDeg6F3!=0.0) {Mainn.savedValueDegreeF3=5;};
	        if(txtDeg6F3==0.0) {Mainn.savedValueDegreeF3=4;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 ) {Mainn.savedValueDegreeF3=3;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0) {Mainn.savedValueDegreeF3=2;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0 && txtDeg3F3==0.0) {Mainn.savedValueDegreeF3=1;};
	        //System.out.println("   savedValueDegree    :"+savedValueDegree);
	        Mainn.spinnerF3.setValue(Mainn.savedValueDegreeF3);
	                        //-----------------------------------
			
		}
	});
	detector4F3.setBounds(5, 120, 120, 23);
	panelDetector1.add(detector4F3);
	
	//----------------------Detector5-------------------------
	
	detector5F3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mainn.filenameEfficienF3="Detectors/Efficiency5F3.txt";
			KeyDetectorF3 = "Detector5";
			detector1F3.setBackground(defaultColor); // Gris
			detector2F3.setBackground(defaultColor);
			detector3F3.setBackground(defaultColor);
			detector4F3.setBackground(defaultColor);
			detector5F3.setBackground(Color.BLUE);
			save1F3.setBackground(defaultColor);
		    
			filePath1F3= "Detectors\\Detector5F3.txt";
			
	        try (BufferedReader readerF3 = new BufferedReader(new FileReader(filePath1F3))) {
	            textFieldsamplename.setText(readerF3.readLine()); // 1st line
	            textFieldPosition.setText(readerF3.readLine());  // 2nd line
	            Mainn.textField1tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField2tpeF3.setText(readerF3.readLine()); 
	            Mainn.textField3tpeF3.setText(readerF3.readLine());
	            Mainn.textField4tpeF3.setText(readerF3.readLine());      // 3rd line		           
	            Mainn.textField5tpeF3.setText(readerF3.readLine()); 
	            Mainn.textField6tpeF3.setText(readerF3.readLine());
	            
	            StringBuilder infos = new StringBuilder();
	            String line;
	            boolean capture = false;
	            while ((line = readerF3.readLine()) != null) {
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
	        subPanelF3.removeAll();
	        subPanelF3.repaint();
	        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF3();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        subPanelF3.setBounds(145, 360, 350, 185);
	        panel1tpeF3.add(subPanelF3);
	        subPanelF3.add(EfficiencyGraphF3.chartPanelEfficiencyF3);
	        subPanelF3.revalidate();
	        subPanelF3.repaint();
	      //-------pour sauvergarder le numero de degré efficacité----------
	        double txtDeg6F3 = Double.parseDouble(Mainn.textField6tpeF3.getText());
	        double txtDeg5F3 = Double.parseDouble(Mainn.textField5tpeF3.getText());
	        double txtDeg4F3 = Double.parseDouble(Mainn.textField4tpeF3.getText());
	        double txtDeg3F3 = Double.parseDouble(Mainn.textField3tpeF3.getText());
	        if(txtDeg6F3!=0.0) {Mainn.savedValueDegreeF3=5;};
	        if(txtDeg6F3==0.0) {Mainn.savedValueDegreeF3=4;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 ) {Mainn.savedValueDegreeF3=3;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0) {Mainn.savedValueDegreeF3=2;};
	        if(txtDeg6F3==0.0 && txtDeg5F3==0.0 && txtDeg4F3==0.0 && txtDeg3F3==0.0) {Mainn.savedValueDegreeF3=1;};
	        //System.out.println("   savedValueDegree    :"+savedValueDegree);
	        Mainn.spinnerF3.setValue(Mainn.savedValueDegreeF3);
	                        //----------------------------------- 
	        
		}
	});
	detector5F3.setBounds(5, 160, 120, 23);
	panelDetector1.add(detector5F3);
	
	Mainn.mntmEfficiencyCalibration2.setSelected(false);
	if(Mainn.formula.equals("Formula3")) {Mainn.mntmEfficiencyCalibration2.setSelected(true);}
	
	
    
	save1F3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Mainn.mntmEfficiencyCalibration.setSelected(false);
            Mainn.mntmEfficiencyCalibration1.setSelected(false);
            Mainn.mntmEfficiencyCalibration3.setSelected(false);
            Mainn.mntmEfficiencyCalibration2.setSelected(true);
			Mainn.formula = "Formula3";
			
			
			save1F3.setBackground(Color.BLUE); 
		    
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath1F3))) {
	            writer.write(textFieldsamplename.getText() + "\n");
	            writer.write(textFieldPosition.getText() + "\n");
	            writer.write(Mainn.textField1tpeF3.getText() + "\n");         
	            writer.write(Mainn.textField2tpeF3.getText() + "\n");
	            writer.write(Mainn.textField3tpeF3.getText() + "\n");
	            writer.write(Mainn.textField4tpeF3.getText() + "\n");         
	            writer.write(Mainn.textField5tpeF3.getText() + "\n");
	            writer.write(Mainn.textField6tpeF3.getText() + "\n");
	            writer.write("$\n" + textareainfos.getText() + "\n$\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Detectors\\saveF3.txt"))) {
	        	writer.write(KeyDetectorF3 + "\n");	
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
	        //---------Fichier Coeffi_Formula3 pour les cofficients efficacité
	        try (BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Coeffi_Formula3.txt"))) {
	            
	            writerF3.write(Mainn.textField1tpeF3.getText() + "\n");         
	            writerF3.write(Mainn.textField2tpeF3.getText() + "\n");
	            writerF3.write(Mainn.textField3tpeF3.getText() + "\n");
	            writerF3.write(Mainn.textField4tpeF3.getText() + "\n");         
	            writerF3.write(Mainn.textField5tpeF3.getText() + "\n");
	            writerF3.write(Mainn.textField6tpeF3.getText() + "\n");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	      //-------fichier formula----
	        try(BufferedWriter writerF3 = new BufferedWriter(new FileWriter("Detectors\\Formula.txt"))) {
	        	           
	        	            writerF3.write("Formula3");         
	        	            
	        	        } catch (IOException e) {
	        	            e.printStackTrace();
	        	        }
	        	        //-------------------------
	        
	        //----------save and repaint graph----------
	        subPanelF3.removeAll();
	        subPanelF3.repaint();				        
	        JPanel pnmpp = new JPanel();
	        try {
	        	pnmpp = new EfficiencyGraphF3();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			        
	        subPanelF3.setBounds(145, 360, 350, 185);
	        panel1tpeF3.add(subPanelF3);
	        subPanelF3.add(EfficiencyGraphF3.chartPanelEfficiencyF3);
	        subPanelF3.revalidate();
	        subPanelF3.repaint();
	        
	        //---------------------------------
	        
		}
	});
	save1F3.setBounds(380, 5, 120, 25);
	panel1tpeF3.add(save1F3);
    
	//------------------------------------------
	
	JButton btnOktpe = new JButton(" OK");
	btnOktpe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Mainn.AfpeF3 =Mainn.textField1tpeF3.getText();					    
			Mainn.textField1tpeF3.setText(Mainn.AfpeF3);
		    
		    
		    Mainn.Afp2eF3 =Mainn.textField2tpeF3.getText();					    
		    Mainn.textField2tpeF3.setText(Mainn.Afp2eF3);
		    
		    Mainn.Afp3eF3 =Mainn.textField3tpeF3.getText();					    
		    Mainn.textField3tpeF3.setText(Mainn.Afp3eF3);
		    
		    Mainn.Afp4eF3 =Mainn.textField4tpeF3.getText();					    
		    Mainn.textField4tpeF3.setText(Mainn.Afp4eF3);
		    
		    Mainn.Afp5eF3 =Mainn.textField5tpeF3.getText();					    
		    Mainn.textField5tpeF3.setText(Mainn.Afp5eF3);
		    
		    Mainn.Afp6eF3 =Mainn.textField6tpeF3.getText();					    
		    Mainn.textField6tpeF3.setText(Mainn.Afp6eF3);
		    
		    effF3.dispose();
		}
	});
	btnOktpe.setBounds(100, 190+360, 70, 23);
	panel1tpeF3.add(btnOktpe);
	
	JButton btnOk1tpe = new JButton("Cancel");
	btnOk1tpe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    				    
			Mainn.textField1tpeF3.setText(Mainn.AfpeF3);				    
			Mainn.textField2tpeF3.setText(Mainn.Afp2eF3);
			Mainn.textField3tpeF3.setText(Mainn.Afp3eF3);
			Mainn.textField4tpeF3.setText(Mainn.Afp4eF3);
			Mainn.textField5tpeF3.setText(Mainn.Afp5eF3);
			Mainn.textField6tpeF3.setText(Mainn.Afp6eF3);
		    		    
			effF3.dispose();	

		}
	});
	btnOk1tpe.setBounds(200, 190+360, 100, 23);
	panel1tpeF3.add(btnOk1tpe);	
	
	JButton inialize1 = new JButton("inialize");
	inialize1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    
			Mainn.textField1tpeF3.setText("0");
			Mainn.textField2tpeF3.setText("0");
			Mainn.textField3tpeF3.setText("0");
			Mainn.textField4tpeF3.setText("0");
			Mainn.textField5tpeF3.setText("0");
			Mainn.textField6tpeF3.setText("0");
			
		}
	});
	inialize1.setBounds(330,190+360, 80, 23);
	panel1tpeF3.add(inialize1);
	
	effF3.setSize(650,660);
	effF3.setResizable(false);
	effF3.setVisible(true);

}

	
}

