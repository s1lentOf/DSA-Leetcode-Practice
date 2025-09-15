/*
    The soltuion to the problem of determining if a given string contains ionly unique characters.

    In this solution I use HashSet, which gives me a constant access time.

    - Iterate over each character in the given array
    - If current character is already in the HashSet, I return false straightaway
    - Otherwise, I put this character to the HashSet
 */

class Solution {
    public static boolean hasUniqueChars(String string) {
        Set<Character> letters = new HashSet<>();

        for (char letter : string.toCharArray()) {
            if (letters.contains(letter)) {
                return false;
            }
            letters.add(letter);
        }

        return true;
    }
}