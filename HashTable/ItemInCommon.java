/*
    One of the most efficient ways to solve this problem is by using a HashMap.

    With this approach, the time complexity is O(n), since we only need to iterate through
    each array once.

    The solution works as follows:
    1. Iterate through the first array and store each number in the HashMap.
    2. Iterate through the second array and check if any number exists in the HashMap.
       - If we find a match, it means that the two arrays have an item in common, and we can return true immediately.
    3. If no matches are found after iterating through both arrays, return false.
 */

class Solution {
    public boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> dataMap = new HashMap<>();

        for (int j : array1) {
            dataMap.put(j, true);
        }

        for (int k : array2) {
            if (dataMap.get(k) != null) {
                return true;
            }
        }

        return false;
    }
}