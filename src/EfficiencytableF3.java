import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class EfficiencytableF3 extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DefaultTableModel tableF3ModelF3;
    static JTable tableF3;
    

    public EfficiencytableF3(JDialog effF3) {
        super(effF3, "efficiency table", true);  // 'true' rend le JDialog modal
        
        // Créer le modèle de tableF3
        String[] columnNames = {"Nuclide", "Energy (keV)", "EmissionProbability(%)", "Efficiency (effF3)"};
        tableF3ModelF3 = new DefaultTableModel(columnNames, 0);
        tableF3 = new JTable(tableF3ModelF3);

        // Charger les données depuis le fichier
        loadtableF3Data(Mainn.filenameEfficienF3);

        // Ajouter des boutons pour ajouter, supprimer et sauvegarder des lignes
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savetableF3Data(Mainn.filenameEfficienF3);
             
                
                
             //---------Supprimer le contenu du fichier et écrire la valeur du Spinner(degre de equation)
                try (PrintWriter writer = new PrintWriter(new FileWriter(Mainn.filenameDegreF3))) {
                    // Écrire la valeur du Spinner dans le fichier
                    writer.println(Mainn.spinnerF3.getValue());
                    writer.flush(); // S'assurer que toutes les données sont écrites
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Mainn.filenameDegreF3="Detectors/degreeOfEquationF3.txt";
        		try (BufferedReader brDegre = new BufferedReader(new FileReader(Mainn.filenameDegreF3))) {
                    String lineDegre = brDegre.readLine(); // Lire la première ligne
                    Mainn.savedValueF3 = Integer.parseInt(lineDegre.trim());
                      
                } catch (IOException ed) {
                    ed.printStackTrace(); // Afficher l'erreur d'entrée/sortie
                }  ;
                                //--------------------------------
                int N = (int) Mainn.spinnerF3.getValue();
                
                String filename = Mainn.filenameEfficienF3; 
               
                try {
                    EfficiencyCalibrationF3 calibration = new EfficiencyCalibrationF3(N); // You can change the degree here
                    calibration.readData(filename); // Replace with the actual file path
                    calibration.fit();
                    calibration.printCoefficients();
                } catch (IOException e1) {
                    System.out.println("Error reading the file: " + e1.getMessage());
                }
                
                //EfficiencyCalibrationF3 calibration = new EfficiencyCalibrationF3(Mainn.filenameEfficienF3);
                // double[] coefficients = calibration.calculateCoefficients(N);
                //  calibration.displayCoefficients(coefficients, N);
                    
             // Afficher les coefficients dans la console et les assigner aux champs de texte
             //System.out.println("Coefficients :");
             for (int i = 0; i < EfficiencyCalibrationF3.coefficients.length; i++) {
                 //System.out.println("Coefficient " + (i + 1) + ": " + coefficients[i]);
            	 
                 // Assigner les coefficients aux champs de texte de manière successive
                 switch(i) {
                     case 0:
                       Mainn.textField1tpeF3.setText(Double.toString(EfficiencyCalibrationF3.coefficients[i]));
                      
                         break;
                     case 1:
                         Mainn.textField2tpeF3.setText(Double.toString(EfficiencyCalibrationF3.coefficients[i]));
                         break;
                     case 2:
                         Mainn.textField3tpeF3.setText(Double.toString(EfficiencyCalibrationF3.coefficients[i]));
                         break;
                     case 3:
                         Mainn.textField4tpeF3.setText(Double.toString(EfficiencyCalibrationF3.coefficients[i]));
                         break;
                     case 4:
                         Mainn.textField5tpeF3.setText(Double.toString(EfficiencyCalibrationF3.coefficients[i]));
                         break;
                     case 5:
                         Mainn.textField6tpeF3.setText(Double.toString(EfficiencyCalibrationF3.coefficients[i]));
                         break;
                     default:
                         // Si jamais il y a plus de coefficients que de champs de texte disponibles
                         System.out.println("Il y a plus de coefficients que de champs de texte disponibles.");
                         break;
                 }
             }
             if(N==1) {Mainn.textField3tpeF3.setText(Double.toString(0));Mainn.textField4tpeF3.setText(Double.toString(0));
             Mainn.textField5tpeF3.setText(Double.toString(0));Mainn.textField6tpeF3.setText(Double.toString(0));};
             if(N==2) {Mainn.textField4tpeF3.setText(Double.toString(0));Mainn.textField5tpeF3.setText(Double.toString(0));
             Mainn.textField6tpe.setText(Double.toString(0));};
             if(N==3) {Mainn.textField5tpeF3.setText(Double.toString(0));Mainn.textField6tpeF3.setText(Double.toString(0));};
             if(N==4) {Mainn.textField6tpeF3.setText(Double.toString(0));};
             
             
             /*String filename = Mainn.filenameEfficienF3; 
             EfficiencyCalibrationF3 calibration = new EfficiencyCalibrationF3(Mainn.filenameEfficienF3);
             // Calcul des coefficients pour N = 2, 3, 4, 5              
             int N = (int) Mainn.spinnerF3.getValue();
             calibration.calculateAndPrintCoefficients(N);*/
             //----------save and repaint graph----------
             Formule3Efficiency.subPanelF3.removeAll();
				repaint();				        
		        JPanel pnmpp = new JPanel();
		        try {
		        	pnmpp = new EfficiencyGraphF3();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 			        
		        Formule3Efficiency.subPanelF3.setBounds(145, 360, 350, 185);
		        //Mainn.panel1tpe.add(Formule3Efficiency.subPanelF3);
		        Formule3Efficiency.subPanelF3.add(EfficiencyGraphF3.chartPanelEfficiencyF3);
		        Formule3Efficiency.subPanelF3.revalidate();
		        Formule3Efficiency.subPanelF3.repaint();
		        
		        //---------------------------------
		        dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        // Créer un JScrollPane pour le tableF3au
        JScrollPane scrollPane = new JScrollPane(tableF3);

        // Configurer la boîte de dialogue
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setSize(600, 300);
        setLocationRelativeTo(effF3); // Centrer la boîte de dialogue par rapport à la fenêtre principale
    }

    private void loadtableF3Data(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Ignore la première ligne si c'est l'en-tête
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Utiliser un espace comme séparateur
                if (parts.length >= 4) {
                    tableF3ModelF3.addRow(new Object[]{
                        parts[0],
                        Double.parseDouble(parts[1]),
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur de chargement des données.");
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format dans les données.");
        }
    }

    private void savetableF3Data(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) { // false pour écraser le fichier
            // Écrire l'en-tête
            bw.write("Nuclide Energy (keV) EmissionProbability(%) Efficiency (Eff)");
            bw.newLine();

            // Écrire les données du tableF3au
            for (int row = 0; row < tableF3ModelF3.getRowCount(); row++) {
                StringBuilder rowData = new StringBuilder();
                for (int col = 0; col < tableF3ModelF3.getColumnCount(); col++) {
                    Object value = tableF3ModelF3.getValueAt(row, col);
                    // Ajouter une vérification pour éviter d'écrire une valeur null
                    rowData.append(value != null ? value.toString() : "").append(" ");
                }
                // Vérifiez si rowData n'est pas vide avant de l'écrire
                if (rowData.toString().trim().length() > 0) {
                    bw.write(rowData.toString().trim());
                    bw.newLine();
                }
            }

            JOptionPane.showMessageDialog(this, "Changes saved successfully !");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data.");
        }
    }

    private void addRow() {
        // Ajouter une ligne vide pour saisir de nouvelles données
        tableF3ModelF3.addRow(new Object[]{"", "", "", ""});
    }

    private void deleteRow() {
        int selectedRow = tableF3.getSelectedRow();
        if (selectedRow != -1) {
            tableF3ModelF3.removeRow(selectedRow); // Supprimer la ligne sélectionnée
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer.");
        }
    }
}
