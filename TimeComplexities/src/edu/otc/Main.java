package edu.otc;

/**
 * Main execution location of the program.
 * @author Daniel Wade
 */
public class Main {
    public static void main(String[] args) {
        // Create integer array with a defined size of 100,000.
        int arrayLength = 100_000;
        int[] numArr = new int[arrayLength];
        // Populate array with numbers of 1 through total length.
        for (int i = 0; i < arrayLength; i++) {
            numArr[i] = 1 + i;
        }

        // Instansiate AsymptoticAnalysis object with its new array.
        var stepAnalyzer = new AsymptoticAnalysis();
        stepAnalyzer.setArrayAnalyzed(numArr);

        // Call linear method to get steps taken to display the array contents.
        System.out.println("Linear Complexity\n-----------------");
        System.out.println("Steps taken: " + stepAnalyzer.linear());
        // Call constant method to get the steps taken to find product of two numbers.
        System.out.println("Constant Complexity\n-------------------");
        System.out.println("Steps taken: " + stepAnalyzer.constant(5, 2.5));
        // Call logarithm method to get the steps taken to locate a value
        // in a sorted array of integers.
        System.out.println("\nLogarithm Complexity\n--------------------");
        System.out.println("Steps taken: " + stepAnalyzer.logarithm(stepAnalyzer.getArrayAnalyzed(), 0, 20, 0, arrayLength - 1));
        // Call quadratic method to get the steps taken to decrement a number using nested loops.
        System.out.println("\nQuadratic Complexity\n--------------------");
        System.out.println("Steps taken: " + stepAnalyzer.quadratic(5));
    }
}
