import arrays.ArrayFunctions;
import strings.StringFunctions;

import java.util.Arrays;

public class Main {

    private static final ArrayFunctions arrayFunctions = new ArrayFunctions();
    private static final StringFunctions stringFunctions = new StringFunctions();

    private static final int[] unsortedArray = {8, 7, 2, 5, 3, 1};
    private static final int sumValue = 50;

    public static void main(String[] args) {
        int[] randomArray = arrayFunctions.generateUnsortedArray(50000, 100);

        int optimize = 0;//select the optimized solution (0 is best, greater than 0 gets progressively worse)

        long startTime = System.nanoTime();

        //runPairSum(randomArray, optimize);
        runAnagram(optimize);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Duration: " + duration);

    }

    private static void runAnagram(int optimize) {

        System.out.println("Performing Anagram check...");
        System.out.println("Anagram: " + stringFunctions.checkAnagram("Tom Marvolo Riddle", "I Am Lord Voldemort", optimize));

    }

    private static void runPairSum(int[] array, int optimize) {

        System.out.println("Performing pair sum check...");
        int[] pairSum = arrayFunctions.pairSum(array, sumValue, optimize);
        if (pairSum != null) {
            System.out.println("Pair sum: " + array[pairSum[0]] + " + " + array[pairSum[1]] + " = " + sumValue);
        } else {
            System.out.println("Pair sum was not possible with the given array.");
        }
        System.out.println();

    }

}
