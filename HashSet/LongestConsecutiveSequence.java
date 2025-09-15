/*
     This function finds the length of the longest consecutive sequence in an array.

     I use a HashSet to store all numbers for O(1) lookup.

     - For each number, it only starts counting when there is no smaller number,
     meaning that this number is the start of a sequence.
     - Then it counts forward until the sequence ends, keeping track of the longest sequence found.

     Time Complexity: O(n)
     Space Complexity: O(n)
*/

class Solution {
    public static int longestConsecutiveSequence(int[] numbers) {
        HashSet<Integer> dataMap = new HashSet<>();
        int longestSequence = 0;
        int currentSequence = 0;

        for (int num : numbers) {
            dataMap.add(num);
        }

        for (int num : numbers) {
            if (!dataMap.contains(num - 1)) {
                int currentNum = num;
                currentSequence = 1;
                while (dataMap.contains(currentNum + 1)) {
                    currentSequence += 1;
                    currentNum = currentNum + 1;
                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }
}