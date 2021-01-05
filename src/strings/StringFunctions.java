package strings;

import java.util.HashMap;
import java.util.Map;

public class StringFunctions {

    public boolean checkAnagram(String firstTerm, String secondTerm, int optimize) {

        int iterations = 0;//tracks how many executions are made

        switch(optimize) {
            case 0://best solution O(n) + O(l)
                int firstSum = 0;
                for (int i = 0; i < firstTerm.length(); i++) {//convert each letter to ascii values
                    iterations++;
                    char letter = Character.toLowerCase(firstTerm.charAt(i));//convert to lowercase
                    if (letter != ' ') {//ignore spaces
                        firstSum += letter;//sum all the characters
                    }
                }

                int secondSum = 0;
                for (int i = 0; i < secondTerm.length(); i++) {//convert each letter to ascii values
                    iterations++;
                    char letter = Character.toLowerCase(secondTerm.charAt(i));//convert to lowercase
                    if (letter != ' ') {//ignore spaces
                        secondSum += letter;//sum all the characters
                    }
                }

                System.out.println("Iterations: " + iterations);
                return firstSum == secondSum;//anagrams will have equal sums
            default://worst solution O(n) + O(l) same time complexity, worse space complexity
                Map<Character, Integer> charFrequency = new HashMap<>();

                for (int i = 0; i < firstTerm.length(); i++) {
                    char letter = Character.toLowerCase(firstTerm.charAt(i));
                    if (letter != ' ') {//ignore spaces
                        if (charFrequency.containsKey(letter)) {
                            charFrequency.put(letter, charFrequency.get(letter) + 1);
                        } else {
                            charFrequency.put(letter, 1);
                        }
                    }
                }

                for (int i = 0; i < secondTerm.length(); i++) {
                    char letter = Character.toLowerCase(secondTerm.charAt(i));
                    if (letter != ' ') {//ignore spaces
                        if (charFrequency.containsKey(letter)) {
                            charFrequency.put(letter, charFrequency.get(letter) - 1);
                        }
                        if (charFrequency.get(letter) == 0) {
                            charFrequency.remove(letter);
                        }
                    }

                }

                return charFrequency.isEmpty();
        }

    }

}
