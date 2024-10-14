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

public class EfficiencyTableF4 extends JDialog {

    static DefaultTableModel tableModelF4;
    static JTable tableF4;
    

    public EfficiencyTableF4(JDialog effI) {
        super(effI, "efficiency table", true);  // 'true' rend le JDialog modal
        
        // Cr�er le mod�le de table
        String[] columnNames = {"Nuclide", "Energy (keV)", "EmissionProbability(%)", "Efficiency (effI)"};
        tableModelF4 = new DefaultTableModel(columnNames, 0);
        tableF4 = new JTable(tableModelF4);

        // Charger les donn�es depuis le fichier
        loadTableData(Mainn.filenameEfficienF4);

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
                saveTableData(Mainn.filenameEfficienF4);
             
                
                EfficiencyCalibrationF4 calibration = new EfficiencyCalibrationF4();
                calibration.EfficiencyCalibrationF4(); // Lire les donn�es
                calibration.calculateCoefficients(EfficiencyCalibrationF4.energiesF4, EfficiencyCalibrationF4.efficienciesF4); // Calculer les coefficients

                 Mainn.textField1tpeF4.setText(Double.toString(EfficiencyCalibrationF4.asolution));
                 Mainn.textField2tpeF4.setText(Double.toString(EfficiencyCalibrationF4.bsolution));
                 Mainn.textField3tpeF4.setText(Double.toString(EfficiencyCalibrationF4.csolution));
                         
                 System.out.println( EfficiencyCalibrationF4.asolution+"::::"+EfficiencyCalibrationF4.bsolution+"::::"+EfficiencyCalibrationF4.csolution);
             //----------save and repaint graph----------
                       Formule4Efficiency.subPanelF4.removeAll();
				repaint();				        
		        JPanel pnmpp = new JPanel();
		        try {
					pnmpp = new EfficiencyGraphF4();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 			        
		        Formule4Efficiency.subPanelF4.setBounds(145, 360, 350, 185);
		        //Mainn.panel1tpe.add(Mainn.subPanel);
		        Formule4Efficiency.subPanelF4.add(EfficiencyGraphF4.chartPanelEfficiencyF4);
		        Formule4Efficiency.subPanelF4.revalidate();
		        Formule4Efficiency.subPanelF4.repaint();
		        
		        //---------------------------------
		        dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        // Cr�er un JScrollPane pour le tableau
        JScrollPane scrollPane = new JScrollPane(tableF4);

        // Configurer la bo�te de dialogue
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setSize(600, 300);
        setLocationRelativeTo(effI); // Centrer la bo�te de dialogue par rapport � la fen�tre principale
    }

    private void loadTableData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Ignore la premi�re ligne si c'est l'en-t�te
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Utiliser un espace comme s�parateur
                if (parts.length >= 4) {
                    tableModelF4.addRow(new Object[]{
                        parts[0],
                        Double.parseDouble(parts[1]),
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur de chargement des donn�es.");
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format dans les donn�es.");
        }
    }

    private void saveTableData(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) { // false pour �craser le fichier
            // �crire l'en-t�te
            bw.write("Nuclide Energy (keV) EmissionProbability(%) Efficiency (Eff)");
            bw.newLine();

            // �crire les donn�es du tableau
            for (int row = 0; row < tableModelF4.getRowCount(); row++) {
                StringBuilder rowData = new StringBuilder();
                for (int col = 0; col < tableModelF4.getColumnCount(); col++) {
                    Object value = tableModelF4.getValueAt(row, col);
                    // Ajouter une v�rification pour �viter d'�crire une valeur null
                    rowData.append(value != null ? value.toString() : "").append(" ");
                }
                // V�rifiez si rowData n'est pas vide avant de l'�crire
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
        // Ajouter une ligne vide pour saisir de nouvelles donn�es
        tableModelF4.addRow(new Object[]{"", "", "", ""});
    }

    private void deleteRow() {
        int selectedRow = tableF4.getSelectedRow();
        if (selectedRow != -1) {
            tableModelF4.removeRow(selectedRow); // Supprimer la ligne s�lectionn�e
        } else {
            JOptionPane.showMessageDialog(this, "S�lectionnez une ligne � supprimer.");
        }
    }
}
