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

public class EfficiencyTable extends JDialog {

    static DefaultTableModel tableModel;
    static JTable table;
    

    public EfficiencyTable(JDialog effI) {
        super(effI, "efficiency table", true);  // 'true' rend le JDialog modal
        
        // Créer le modèle de table
        String[] columnNames = {"Nuclide", "Energy (keV)", "EmissionProbability(%)", "Efficiency (effI)"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Charger les données depuis le fichier
        loadTableData(Mainn.filenameEfficien);

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
                saveTableData(Mainn.filenameEfficien);
             
                
             //---------Supprimer le contenu du fichier et écrire la valeur du Spinner(degre de equation)
                try (PrintWriter writer = new PrintWriter(new FileWriter(Mainn.filenameDegre))) {
                    // Écrire la valeur du Spinner dans le fichier
                    writer.println(Mainn.spinner.getValue());
                    writer.flush(); // S'assurer que toutes les données sont écrites
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Mainn.filenameDegre="Detectors/degreeOfEquation.txt";
        		try (BufferedReader brDegre = new BufferedReader(new FileReader(Mainn.filenameDegre))) {
                    String lineDegre = brDegre.readLine(); // Lire la première ligne
                    Mainn.savedValue = Integer.parseInt(lineDegre.trim());
                      
                } catch (IOException ed) {
                    ed.printStackTrace(); // Afficher l'erreur d'entrée/sortie
                }  ;
                                //--------------------------------
                int N = (int) Mainn.spinner.getValue();
                
                String filename = Mainn.filenameEfficien; 
               
                
                try {
                    EfficiencyCalibration calibration = new EfficiencyCalibration(N); // You can change the degree here
                    calibration.readData(filename); // Replace with the actual file path
                    calibration.fit();
                    calibration.printCoefficients();
                } catch (IOException e1) {
                    System.out.println("Error reading the file: " + e1.getMessage());
                }
                
                //EfficiencyCalibration calibration = new EfficiencyCalibration(Mainn.filenameEfficien);
               // double[] coefficients = calibration.calculateCoefficients(N);
                  //  calibration.displayCoefficients(coefficients, N);
                    
             // Afficher les coefficients dans la console et les assigner aux champs de texte
             //System.out.println("Coefficients :");
             for (int i = 0; i < EfficiencyCalibration.coefficients.length; i++) {
                 //System.out.println("Coefficient " + (i + 1) + ": " + coefficients[i]);
            	 
                 // Assigner les coefficients aux champs de texte de manière successive
                 switch(i) {
                     case 0:
                       Mainn.textField1tpe.setText(Double.toString(EfficiencyCalibration.coefficients[i]));
                      
                         break;
                     case 1:
                         Mainn.textField2tpe.setText(Double.toString(EfficiencyCalibration.coefficients[i]));
                         break;
                     case 2:
                         Mainn.textField3tpe.setText(Double.toString(EfficiencyCalibration.coefficients[i]));
                         break;
                     case 3:
                         Mainn.textField4tpe.setText(Double.toString(EfficiencyCalibration.coefficients[i]));
                         break;
                     case 4:
                         Mainn.textField5tpe.setText(Double.toString(EfficiencyCalibration.coefficients[i]));
                         break;
                     case 5:
                         Mainn.textField6tpe.setText(Double.toString(EfficiencyCalibration.coefficients[i]));
                         break;
                     default:
                         // Si jamais il y a plus de coefficients que de champs de texte disponibles
                         System.out.println("Il y a plus de coefficients que de champs de texte disponibles.");
                         break;
                 }
             }
             if(N==1) {Mainn.textField3tpe.setText(Double.toString(0));Mainn.textField4tpe.setText(Double.toString(0));
             Mainn.textField5tpe.setText(Double.toString(0));Mainn.textField6tpe.setText(Double.toString(0));};
             if(N==2) {Mainn.textField4tpe.setText(Double.toString(0));Mainn.textField5tpe.setText(Double.toString(0));
             Mainn.textField6tpe.setText(Double.toString(0));};
             if(N==3) {Mainn.textField5tpe.setText(Double.toString(0));Mainn.textField6tpe.setText(Double.toString(0));};
             if(N==4) {Mainn.textField6tpe.setText(Double.toString(0));};
             
             
             /*String filename = Mainn.filenameEfficien; 
             EfficiencyCalibration calibration = new EfficiencyCalibration(Mainn.filenameEfficien);
             // Calcul des coefficients pour N = 2, 3, 4, 5              
             int N = (int) Mainn.spinner.getValue();
             calibration.calculateAndPrintCoefficients(N);*/
             //----------save and repaint graph----------
		        Mainn.subPanel.removeAll();
				repaint();				        
		        JPanel pnmpp = new JPanel();
		        try {
					pnmpp = new EfficiencyGraph();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 			        
		        Mainn.subPanel.setBounds(145, 360, 350, 185);
		        //Mainn.panel1tpe.add(Mainn.subPanel);
		        Mainn.subPanel.add(EfficiencyGraph.chartPanelEfficiency);
		        Mainn.subPanel.revalidate();
		        Mainn.subPanel.repaint();
		        
		        //---------------------------------
		        dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        // Créer un JScrollPane pour le tableau
        JScrollPane scrollPane = new JScrollPane(table);

        // Configurer la boîte de dialogue
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setSize(600, 300);
        setLocationRelativeTo(effI); // Centrer la boîte de dialogue par rapport à la fenêtre principale
    }

    private void loadTableData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Ignore la première ligne si c'est l'en-tête
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Utiliser un espace comme séparateur
                if (parts.length >= 4) {
                    tableModel.addRow(new Object[]{
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

    private void saveTableData(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) { // false pour écraser le fichier
            // Écrire l'en-tête
            bw.write("Nuclide Energy (keV) EmissionProbability(%) Efficiency (Eff)");
            bw.newLine();

            // Écrire les données du tableau
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                StringBuilder rowData = new StringBuilder();
                for (int col = 0; col < tableModel.getColumnCount(); col++) {
                    Object value = tableModel.getValueAt(row, col);
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
        tableModel.addRow(new Object[]{"", "", "", ""});
    }

    private void deleteRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow); // Supprimer la ligne sélectionnée
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer.");
        }
    }
}
