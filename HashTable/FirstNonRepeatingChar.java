/*
    The solution to the problem is implemented by using HashMap.

    1. Iterate over each character in the given String and set its value in the HashMap depending on its previous occurence
    2. Iterate over each charecter in the given String and find the first element with the value 1 in the HashMap.
 */

class Solution {
    public static Character firstNonRepeatingChar(String word) {
        HashMap<Character, Integer> dataMap = new HashMap<>();
        char[] letters = word.toCharArray();

        for (char letter : letters) {
            dataMap.put(letter, dataMap.getOrDefault(letter, 0) + 1);
        }

        for (char letter : letters) {
            if (dataMap.get(letter) == 1) return letter;
        }

        return null;
    }
}