package edu.otc;

/**
 * This class provides several methods to calculate how many steps it takes
 * for an operation to be completed.
 * @author Daniel Wade
 */
public class AsymptoticAnalysis {
    private int[] arrayAnalyzed;

    /**
     * Loops through the class defined array and writes each item to the console.
     * Through each iteration increment a counter to track steps needed
     * to complete the loop.
     * @return Number of iterations it took to read whole array.
     */
    public int linear() {
        int stepsTaken = 0;

        for (int data : arrayAnalyzed) {
            // Print out data in the current loop iteration.
            System.out.println(data);
            // Increment steps required for execution.
            stepsTaken++;
        }
        return stepsTaken;
    }

    /**
     * Takes two numbers as doubles and multiplies them together and writes the result to the console.
     * After calculation increment a counter to tracks steps occurring.
     * @param x Double used in multiplying.
     * @param y Double multiplied against to find the product.
     * @return Number of steps taken to calculate the product of two provided numbers.
     */
    public double constant(double x, double y) {
        int stepsTaken = 0;
        // Print product of the numbers provided to the console.
        System.out.println(x * y);
        // Increment steps required for execution.
        stepsTaken++;
        return stepsTaken;
    }

    /**
     * Receives an array to search through for a specific value within an initial range.
     * Will call itself with a modified start or end depending on where the key is in the array
     * until the index of the key is found in the array.
     * @param arrayToSearch Integer array to search for the key.
     * @param searchKey Integer value that the method is trying to locate.
     * @param startIndex Index that defines the start of the search range.
     * @param endIndex Index that defines the end of the search range.
     * @return Number of steps taken to find the key.
     */
    public int logarithm(int[] arrayToSearch, int initialStep, int searchKey, int startIndex, int endIndex) {
        // If starting index exceeds the ending index then exit the call with a failing value.
        if (startIndex > endIndex)
            return -1;

        // Increment steps taken for each call.
        initialStep++;
        // Calculate index to be closer to the key, roughly decreases options by half.
        int indexAttempt = (startIndex + endIndex) / 2;
        // When the array is indexed to be less than the key then re-call method
        // with one higher than the index as the starting point.
        if (arrayToSearch[indexAttempt] < searchKey)
            return logarithm(arrayToSearch, initialStep, searchKey, indexAttempt + 1, endIndex);
        // When the array is indexed to be greater than the key then re-call method
        // with one lower than the index as the ending point.
        else if (arrayToSearch[indexAttempt] > searchKey)
            return logarithm(arrayToSearch, initialStep, searchKey, startIndex, indexAttempt - 1);

        // Will return the final number of steps taken to find the key provided.
       return initialStep;
    }

    /**
     * Takes a number that will be decremented to zero and within that loop a for loop
     * will increase steps for the current number left.
     * @param num Integer value that will loop until it reaches zero.
     * @return Number of steps it took to make the number reach zero.
     */
    public int quadratic(int num) {
        int stepsTaken = 0;

        // Loops until number entered has reached zero.
        while (num > 0) {
            // Increment current step count by looping it by the
            // number of the input remaining.
            for (int i = 0; i < num; i++) {
                stepsTaken++;
            }
            // Decrease loop number so it'll eventually end.
            num--;
        }

        // Will return the total steps after both loops are finished.
        return stepsTaken;
    }

    /**
     * Will allow public access to the linear method Integer array.
     * @return Retrieves the class level array used in the linear method.
     */
    public int[] getArrayAnalyzed() {
        return arrayAnalyzed;
    }

    /**
     * Allows public setting of the class property used in the linear method.
     * @param arrayAnalyzed Takes an Integer array to set the value to the property.
     */
    public void setArrayAnalyzed(int[] arrayAnalyzed) {
        this.arrayAnalyzed = arrayAnalyzed;
    }
}
