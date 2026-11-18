/*
    My approach is to Unbounded Knapsack DP Programming to solve this problem. The 1-D array represents the mincost for that specific day.
    We iterate over numbers from 1 to lastDay and if this number is a traveling day, we find the minimum cost of tickets we can spend 
    at that day, by comparing three types of given tickets. If that number is not traveling day, we just extend the last seen amount.

    Time Complexity: O(L), where L = lastDay
    Space Complexity: O(L)
*/

class Solution {
    public static int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelingDays = new HashSet<>();
        int lastDay = days[days.length - 1];
        for (int day : days) {
            travelingDays.add(day);
        }

        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {
            if (travelingDays.contains(i)) {
                int oneDay = costs[0] + dp[i - 1];
                int sevenDays = costs[1] + dp[Math.max(0, i - 7)];
                int thirtyDays = costs[2] + dp[Math.max(0, i - 30)];

                dp[i] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[lastDay];
    }
}