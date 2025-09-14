/*
    Solution: I use a HashMap to track occurrences of each number.

    1. Iterate through each number in the array.
        - If the number already exists in the HashMap, increase its count by 1.
            - If the count becomes 2, add the number to the duplicates list.
        - If the number is not in the HashMap, put it with a count of 1.
 */

class Solution {
    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> dataMap = new HashMap<>();
        ArrayList<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            if (dataMap.containsKey(num)) {
                if (dataMap.get(num) == 1) duplicates.add(num);
                dataMap.put(num, dataMap.get(num) + 1);
            } else {
                dataMap.put(num, 1);
            }
        }

        return duplicates;
    }
}