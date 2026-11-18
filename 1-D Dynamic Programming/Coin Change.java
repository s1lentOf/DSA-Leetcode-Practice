/*  
    My approach is to use 1-D array, where each element in the array would represent the minimum amount of coins needed to get that number.
    dp[target] would be the answer. 

    We iterate over an array of coins and for each coin: 
        Iterate over numbers from 'coin' to 'amount':
            If the previous number is set, set the current number to be the min of (dp[i - coin] + 1, dp[i])

    Time Complexity: O(coins * amount)
    Space Complexity: O(amount)
*/

class Solution {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}