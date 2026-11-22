/*
    My solution uses 0/1 Knapsack DP approach. I create a helper 'dp' array of booleans, where each index identifies 
    if this sum (the index itself) can be accumulated. As the nums array has to be partitioned into two arrays of equal sum,
    we have to determine if the half sum of the nums array can be reached.

    For each num in the nums array:
        Iterate from the right to left:
            If the difference between num and i can be accumulated (dp[i - num]), set the current i to be true (dp[i]);

    Time Complexity: O(n * k), where k - target
    Space Complexity: O(k)
*/

class Solution {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) dp[i] = true;
            }
        }

        return dp[target];
    }
}