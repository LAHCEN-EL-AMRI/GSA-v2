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

            // Sauter la première ligne qui contient les en-têtes
            reader.readLine();

            // Lire les données ligne par ligne
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+"); // Séparer par espaces multiples
                double energy = Double.parseDouble(values[1]);  // Deuxième colonne : énergie
                double efficiency = Double.parseDouble(values[3]);  // Quatrième colonne : efficacité

                // Ajouter aux listes
                energies.add(energy);
                efficiencies.add(efficiency);
            }

            // Fermer le fichier
            reader.close();

            // Effectuer la régression pour trouver a et b
            result = linearRegression(energies, efficiencies);
            double a = result[0];
            double b = result[1];

            // Afficher les résultats
            System.out.println("Coefficient a : " + a);
            System.out.println("Coefficient b : " + b);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour effectuer la régression linéaire sur ln(energie) et ln(efficacité)
    public static double[] linearRegression(ArrayList<Double> energies, ArrayList<Double> efficiencies) {
        int n = energies.size();
        double sumLnE = 0, sumLnEff = 0, sumLnELnE = 0, sumLnELnEff = 0;

        // Calcul des sommes pour ln(energie) et ln(efficacité)
        for (int i = 0; i < n; i++) {
            double lnE = Math.log(energies.get(i));
            double lnEff = Math.log(efficiencies.get(i));

            sumLnE += lnE;
            sumLnEff += lnEff;
            sumLnELnE += lnE * lnE;
            sumLnELnEff += lnE * lnEff;
        }

        // Calcul de la pente (b) et de l'ordonnée à l'origine (ln(a))
        double b = (n * sumLnELnEff - sumLnE * sumLnEff) / (n * sumLnELnE - sumLnE * sumLnE);
        double lnA = (sumLnEff - b * sumLnE) / n;

        // Convertir ln(a) en a
        double a = Math.exp(lnA);

        return new double[]{a, b};
    }
}
