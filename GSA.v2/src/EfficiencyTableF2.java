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

public class EfficiencyTableF2 extends JDialog {

    static DefaultTableModel tableModelF2;
    static JTable tableF2;
    

    public EfficiencyTableF2(JDialog effI) {
        super(effI, "efficiency table", true);  // 'true' rend le JDialog modal
        
        // Créer le modèle de table
        String[] columnNames = {"Nuclide", "Energy (keV)", "EmissionProbability(%)", "Efficiency (effI)"};
        tableModelF2 = new DefaultTableModel(columnNames, 0);
        tableF2 = new JTable(tableModelF2);

        // Charger les données depuis le fichier
        loadTableData(Mainn.filenameEfficienF2);

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
                saveTableData(Mainn.filenameEfficienF2);
                
                
                if(Mainn.mntmEfficiencyCalibration1.isSelected()){Mainn.mntmEfficiencyCalibration.setSelected(false);
                Mainn.mntmEfficiencyCalibration2.setSelected(false);Mainn.mntmEfficiencyCalibration3.setSelected(false);}
				
                
                
                EfficiencyCalibrationF2.EfficiencyCalibrationF2();
                
                       Mainn.textField1tpeF2.setText(Double.toString(EfficiencyCalibrationF2.result[0]));
                      
                       Mainn.textField2tpeF2.setText(Double.toString(EfficiencyCalibrationF2.result[1]));
                         
             
             //----------save and repaint graph----------
                       Formule2Efficiency.subPanelF2.removeAll();
				repaint();				        
		        JPanel pnmpp = new JPanel();
		        try {
					pnmpp = new EfficiencyGraphF2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 			        
		        Formule2Efficiency.subPanelF2.setBounds(145, 360, 350, 185);
		        //Mainn.panel1tpe.add(Mainn.subPanel);
		        Formule2Efficiency.subPanelF2.add(EfficiencyGraphF2.chartPanelEfficiencyF2);
		        Formule2Efficiency.subPanelF2.revalidate();
		        Formule2Efficiency.subPanelF2.repaint();
		        
		        //---------------------------------
		        dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        // Créer un JScrollPane pour le tableau
        JScrollPane scrollPane = new JScrollPane(tableF2);

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
                    tableModelF2.addRow(new Object[]{
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
            for (int row = 0; row < tableModelF2.getRowCount(); row++) {
                StringBuilder rowData = new StringBuilder();
                for (int col = 0; col < tableModelF2.getColumnCount(); col++) {
                    Object value = tableModelF2.getValueAt(row, col);
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
        tableModelF2.addRow(new Object[]{"", "", "", ""});
    }

    private void deleteRow() {
        int selectedRow = tableF2.getSelectedRow();
        if (selectedRow != -1) {
            tableModelF2.removeRow(selectedRow); // Supprimer la ligne sélectionnée
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer.");
        }
    }
}
