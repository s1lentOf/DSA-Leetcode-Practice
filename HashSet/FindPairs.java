/*
    Problem: FInd all the pairs of numbers from two arrays that add up to target

    To make the solution more efficient, I use the HashSet, which gives me a constant access time.

    Here is the logic of the solution:
    - Add all numbers from the first array to the HashSet
    - Iterate over the second array and check if there is a required number in the HashSet
    - If there is, we add a new pair to the ArrayList of correct pairs.
 */

class Solution {
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> numbers = new HashSet<>();
        ArrayList<int[]> pairs = new ArrayList<>();

        for (int num : arr1) {
            numbers.add(num);
        }

        for (int num : arr2) {
            int remainder = target - num;
            if (numbers.contains(remainder)) {
                pairs.add(new int[]{remainder, num});
            }
        }

        return pairs;
    }
}