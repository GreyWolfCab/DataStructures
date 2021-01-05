import arrays.Functions;

import java.util.Arrays;

public class Main {

    private static final Functions arrayFunctions = new Functions();

    private static final int[] unsortedArray = {8, 7, 4, 4, 4, 1};
    private static final int sumValue = 50;

    public static void main(String[] args) {
        int[] randomArray = arrayFunctions.generateUnsortedArray(50, 100);
        System.out.println(Arrays.toString(randomArray));

        int optimize = 0;//select the optimized solution (0 is best, greater than 0 gets progressively worse)

        runPairSum(randomArray, optimize);

    }

    private static void runPairSum(int[] array, int optimize) {

        System.out.println("Performing pair sum check...");
        int[] pairSum = arrayFunctions.pairSum(array, sumValue, optimize);
        if (pairSum != null) {
            System.out.println("Pair sum: " + pairSum[0] + " + " + pairSum[1] + " = " + sumValue);
        } else {
            System.out.println("Pair sum was not possible with the given array.");
        }
        System.out.println();

    }

}
