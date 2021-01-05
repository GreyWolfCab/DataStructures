package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Functions {

    /**
     * returns the indices of a pair of ints whose sum equals the specified value
     * @param array search for the pair within this array
     * @param sumValue pair sum to find
     * @param optimizedSolution which solution to use
     * @return the pair that creates the sum, null if they don't exist
     */
    public int[] pairSum(int[] array, int sumValue, int optimizedSolution) {

        int iterations = 0;//tracks how many executions are made

        switch (optimizedSolution) {
            case 0: //best solution O(n)
                Map<Integer, Integer> hash = new HashMap<>();
                for (int i = 0; i < array.length; i++) {// O(n) iterate through the array
                    iterations++;
                    hash.put(array[i], i);//place value before check to allow for duplicate elements
                    int tempDifference = sumValue - array[i];//calculate required difference
                    if (hash.containsKey(tempDifference)) {//check for difference
                        System.out.println("Iterations: " + iterations);
                        return new int[] {hash.get(tempDifference), i};//return current index and difference's index
                    }
                }
                break;
            case 1: //2nd best solution
                // Overall time complexity: O(n Log(n)) + O(n) + O(n)
                int[] unsortedArray = Arrays.copyOf(array, array.length);
                Arrays.sort(unsortedArray);//uses dual pivot quicksort O(n Log(n))
                int low = 0, high = unsortedArray.length-1;//use two points to iterate through array
                while (low <= high) {// O(n)
                    iterations++;
                    int tempSum = unsortedArray[low] + unsortedArray[high];
                    if (tempSum == sumValue) {
                        //found the correct sum
                        break;
                        //return new int[] {low, high};
                    } else if (tempSum < sumValue) {//if tempSum is < sum increment left pointer
                        low++;
                    } else {//if tempSum is > sum decrement right pointer
                        high--;
                    }
                }
                int firstTerm = -1, secondTerm = -1;
                //re-align indices of the sorted array with the original array
                for (int i = 0; i < array.length; i++) {// O(n)
                    iterations++;
                    if (array[i] == unsortedArray[low]) {//find a match with one element
                        firstTerm = i;
                    }
                    if (array[i] == unsortedArray[high]) {//find a match with second element (allow duplicates)
                        secondTerm = i;
                    }
                    if (firstTerm != -1 && secondTerm != -1) {//end original array search
                        System.out.println("Iterations: " + iterations);
                        return new int[] {firstTerm, secondTerm};
                    }
                }
                break;
            default: //naive solution
                // time complexity O(n^2)
                for (int i = 0; i < array.length; i++) {//iterate through array

                    for (int j = 0; j < array.length; j++) {//iterate through array again
                        iterations++;
                        if (array[i] + array[j] == sumValue) {//seek pair that create the sum
                            System.out.println("Iterations: " + iterations);
                            return new int[] {i, j};
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
