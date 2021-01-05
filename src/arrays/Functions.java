package arrays;

import java.util.Arrays;
import java.util.Random;

public class Functions {

    /**
     * returns a pair of ints whose sum equals the specified value
     * @param unsortedArray search for the pair within this array
     * @param sumValue pair sum to find
     * @param optimizedSolution which solution to use
     * @return the pair that creates the sum, null if they don't exist
     */
    public int[] pairSum(int[] unsortedArray, int sumValue, int optimizedSolution) {

        int iterations = 0;//tracks how many executions are made

        switch (optimizedSolution) {
            case 0: //best solution
                //use hashing
                System.out.println("TODO: Implement hashing...");
                break;
            case 1: //2nd best solution
                // Overall time complexity: O(n Log(n)) + O(n)
                Arrays.sort(unsortedArray);//uses dual pivot quicksort O(n Log(n))
                int low = 0, high = unsortedArray.length-1;//use two points to iterate through array
                while (low <= high) {// O(n)
                    iterations++;
                    int tempSum = unsortedArray[low] + unsortedArray[high];
                    if (tempSum == sumValue) {//found the correct sum
                        System.out.println("Iterations: " + iterations);
                        return new int[] {unsortedArray[low], unsortedArray[high]};
                    } else if (tempSum < sumValue) {//if tempSum is < sum increment left pointer
                        low++;
                    } else {//if tempSum is > sum decrement right pointer
                        high--;
                    }
                }
                break;
            default: //naive solution
                // time complexity O(n^2)
                for (int i = 0; i < unsortedArray.length; i++) {//iterate through array

                    for (int j = 0; j < unsortedArray.length; j++) {//iterate through array again
                        iterations++;
                        if (unsortedArray[i] + unsortedArray[j] == sumValue) {//seek pair that create the sum
                            System.out.println("Iterations: " + iterations);
                            return new int[] {unsortedArray[i], unsortedArray[j]};
                        }
                    }

                }
                break;
        }

        System.out.println("Iterations: " + iterations);

        return null;

    }

    /**
     * generate a random array of ints
     * @param size the size of the array to generate
     * @param range the range each element may be
     * @return the randomly generated array
     */
    public int[] generateUnsortedArray(int size, int range) {

        int[] array = new int[size];//create the array
        Random rand = new Random();

        for (int i = 0; i < size; i++) {//generate random values for each element
            array[i] = rand.nextInt(range + 1);
        }

        return array;

    }

}
