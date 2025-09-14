/*
    The solution finds the start and end indices of a subarray that sums to the target.
    The following solution uses a HashMap to store consecuative sums and their indices.

    - For each element, check if (currentSum - target) exists in the map.
    - If yes, return the subarray from map.get(currentSum - target) + 1 to the current index.
    - Otherwise, just add the currentSum with its respective index to the HashMap.
 */

class Solution {
    public static int[] subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> dataMap = new HashMap<>();

        dataMap.put(0, -1);
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            int remainder = Math.abs(target - totalSum);

            if (dataMap.containsKey(remainder)) {
                return new int[]{dataMap.get(remainder + 1), i};
            }

            dataMap.put(totalSum, i);
        }

        return new int[]{};
    }
}