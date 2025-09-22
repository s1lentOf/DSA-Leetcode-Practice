/*
    The solution to the problem of finding the subarray of maximum sum in the given array.

    To solve this problem I have used the Kadane's Algorithm of finding the maximum subarray.

    Approach:
        - Calculate the current sum by adding the sum of the previous elements to current number
        - If it is greater than the current number, we just assign current sum to be the current number
        - Update maximum sum
 */

class Solution {
    public static int maxSubarray(int[] nums) {
        if (nums.length == 0) return 0;

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}