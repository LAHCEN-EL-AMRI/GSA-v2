import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EfficiencyCalibrationF4 {
    // Variables pour stocker les coefficients a, b, et c
    static double asolution, bsolution, csolution;
    
	static ArrayList<Double> energiesF4;	
	static ArrayList<Double> efficienciesF4;
	
	
	

    // Méthode pour lire les données du fichier texte
    public static void EfficiencyCalibrationF4() {
    	
    	EfficiencyCalibrationF4 calibration = new EfficiencyCalibrationF4();
         energiesF4 = new ArrayList<>();
         efficienciesF4 = new ArrayList<>();

        // Chemin du fichier .txt
        String filePath = Mainn.filenameEfficienF4; 

    	
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignorer l'entête
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                double energy = Double.parseDouble(values[1]);
                double efficiency = Double.parseDouble(values[3]);
                energiesF4.add(energy);
                efficienciesF4.add(efficiency);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier: " + e.getMessage());
        }
    }

    // Méthode pour calculer les coefficients a, b, et c
    public void calculateCoefficients(ArrayList<Double> energiesF4, ArrayList<Double> efficienciesF4) {
        int n = energiesF4.size();
        double sumE = 0, sumE2 = 0, sumE3 = 0, sumE4 = 0;
        double sumLnEff = 0, sumELnEff = 0, sumE2LnEff = 0;

        for (int i = 0; i < n; i++) {
            double E = energiesF4.get(i);
            double lnEff = Math.log(efficienciesF4.get(i));

            sumE += E;
            sumE2 += E * E;
            sumE3 += E * E * E;
            sumE4 += E * E * E * E;

            sumLnEff += lnEff;
            sumELnEff += E * lnEff;
            sumE2LnEff += E * E * lnEff;
        }

        // Résolution du système linéaire pour trouver a, b et c
        double[][] matrix = {
            {n, sumE, sumE2},
            {sumE, sumE2, sumE3},
            {sumE2, sumE3, sumE4}
        };

        double[] rhs = {sumLnEff, sumELnEff, sumE2LnEff};

        double[] solution = gaussianElimination(matrix, rhs);
        asolution = solution[0];
        bsolution = solution[1];
        csolution = solution[2];
    }

    // Méthode pour résoudre le système d'équations par élimination gaussienne
    private double[] gaussianElimination(double[][] matrix, double[] rhs) {
        int n = rhs.length;
        for (int i = 0; i < n; i++) {
            // Recherche du pivot
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[max][i])) {
                    max = j;
                }
            }

            // Échange des lignes
            double[] temp = matrix[i];
            matrix[i] = matrix[max];
            matrix[max] = temp;

            double t = rhs[i];
            rhs[i] = rhs[max];
            rhs[max] = t;

            // Mise à l'échelle
            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                rhs[j] -= factor * rhs[i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }

        // Résolution
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (rhs[i] - sum) / matrix[i][i];
        }

        return solution;
    }

    // Méthode pour afficher les coefficients
    public void displayCoefficients() {
        System.out.println("Coefficient a: " + asolution);
        System.out.println("Coefficient b: " + bsolution);
        System.out.println("Coefficient c: " + csolution);
    }

    
        
    
}
