import java.io.*;
import java.util.ArrayList;

public class EfficiencyCalibrationF2 {

    protected static double[] result;

	public static void EfficiencyCalibrationF2() {
        ArrayList<Double> energies = new ArrayList<>();
        ArrayList<Double> efficiencies = new ArrayList<>();
        String filenameF2 = Mainn.filenameEfficienF2;
        
        try {
            // Lecture du fichier texte
            BufferedReader reader = new BufferedReader(new FileReader(filenameF2));
            String line;

            // Sauter la premi�re ligne qui contient les en-t�tes
            reader.readLine();

            // Lire les donn�es ligne par ligne
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+"); // S�parer par espaces multiples
                double energy = Double.parseDouble(values[1]);  // Deuxi�me colonne : �nergie
                double efficiency = Double.parseDouble(values[3]);  // Quatri�me colonne : efficacit�

                // Ajouter aux listes
                energies.add(energy);
                efficiencies.add(efficiency);
            }

            // Fermer le fichier
            reader.close();

            // Effectuer la r�gression pour trouver a et b
            result = linearRegression(energies, efficiencies);
            double a = result[0];
            double b = result[1];

            // Afficher les r�sultats
            System.out.println("Coefficient a : " + a);
            System.out.println("Coefficient b : " + b);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // M�thode pour effectuer la r�gression lin�aire sur ln(energie) et ln(efficacit�)
    public static double[] linearRegression(ArrayList<Double> energies, ArrayList<Double> efficiencies) {
        int n = energies.size();
        double sumLnE = 0, sumLnEff = 0, sumLnELnE = 0, sumLnELnEff = 0;

        // Calcul des sommes pour ln(energie) et ln(efficacit�)
        for (int i = 0; i < n; i++) {
            double lnE = Math.log(energies.get(i));
            double lnEff = Math.log(efficiencies.get(i));

            sumLnE += lnE;
            sumLnEff += lnEff;
            sumLnELnE += lnE * lnE;
            sumLnELnEff += lnE * lnEff;
        }

        // Calcul de la pente (b) et de l'ordonn�e � l'origine (ln(a))
        double b = (n * sumLnELnEff - sumLnE * sumLnEff) / (n * sumLnELnE - sumLnE * sumLnE);
        double lnA = (sumLnEff - b * sumLnE) / n;

        // Convertir ln(a) en a
        double a = Math.exp(lnA);

        return new double[]{a, b};
    }
}
