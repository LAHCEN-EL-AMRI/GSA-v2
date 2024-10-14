import java.io.*;
import java.util.*;

public class EfficiencyCalibration {
    private int degree;
    static double[] coefficients;
    private List<Double> energies = new ArrayList<>();
    private List<Double> efficiencies = new ArrayList<>();

    // Constructor to set the degree of the polynomial
    public EfficiencyCalibration(int degree) {
        this.degree = degree;
        this.coefficients = new double[degree + 1]; // We will have degree + 1 coefficients
    }

    // Method to read data from a file
    public void readData(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        // Skip the header line
        reader.readLine();

        // Read the data lines
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split("\\s+"); // Split by spaces or tabs
            double energy = Double.parseDouble(columns[1]);
            double efficiency = Double.parseDouble(columns[3]);

            energies.add(energy);
            efficiencies.add(efficiency);
        }

        reader.close();
    }

    // Method to calculate the natural logarithm of values in a list
    private double[] calculateLog(List<Double> values) {
        double[] logValues = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            logValues[i] = Math.log(values.get(i));
        }
        return logValues;
    }

    // Method to perform the least squares fitting
    public void fit() {
        int n = energies.size(); // Number of data points
        double[][] matrix = new double[degree + 1][degree + 2]; // Matrix for the normal equations

        // Calculate ln(Energy) and ln(Efficiency)
        double[] logEnergies = calculateLog(energies);
        double[] logEfficiencies = calculateLog(efficiencies);

        // Populate the normal equation matrix
        for (int row = 0; row <= degree; row++) {
            for (int col = 0; col <= degree; col++) {
                matrix[row][col] = sumOfPowers(logEnergies, row + col);
            }
            matrix[row][degree + 1] = sumOfProducts(logEnergies, logEfficiencies, row);
        }

        // Solve the system of equations using Gaussian elimination
        gaussianElimination(matrix);

        // Extract the coefficients
        for (int i = 0; i <= degree; i++) {
            coefficients[i] = matrix[i][degree + 1];
        }
    }

    // Method to sum powers of log(Energy)
    private double sumOfPowers(double[] logEnergies, int power) {
        double sum = 0;
        for (double logE : logEnergies) {
            sum += Math.pow(logE, power);
        }
        return sum;
    }

    // Method to sum products of log(Energy)^k and log(Efficiency)
    private double sumOfProducts(double[] logEnergies, double[] logEfficiencies, int power) {
        double sum = 0;
        for (int i = 0; i < logEnergies.length; i++) {
            sum += Math.pow(logEnergies[i], power) * logEfficiencies[i];
        }
        return sum;
    }

    // Method to perform Gaussian elimination
    private void gaussianElimination(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // Partial pivoting
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[i][i]) < Math.abs(matrix[k][i])) {
                    double[] temp = matrix[i];
                    matrix[i] = matrix[k];
                    matrix[k] = temp;
                }
            }

            // Elimination process
            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i] / matrix[i][i];
                for (int j = i; j <= n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }

        // Back substitution
        for (int i = n - 1; i >= 0; i--) {
            matrix[i][n] /= matrix[i][i];
            matrix[i][i] = 1;
            for (int k = i - 1; k >= 0; k--) {
                matrix[k][n] -= matrix[k][i] * matrix[i][n];
            }
        }
    }

    // Method to print the coefficients
    public void printCoefficients() {
        System.out.println("Coefficients of the polynomial:");
        for (int i = 0; i <= degree; i++) {
            System.out.printf("a%d = %.10f\n", i, coefficients[i]);
        }
    }

    // Main method for testing
    
        
    
}
