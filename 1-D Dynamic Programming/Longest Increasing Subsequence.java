/*
    My solution uses Bottom-Up DP approach, where each element in the array stores the length of the LIS 
    and the end of the LIS up until this point. 

    dp array stores other arrays in this format: [length, end number of the LIS];

    For each element in the nums:
        1) Find the LIS, where end number is smaller than current num;
        2) Find the longest of possible LISs, and update current index;

    Time Complexity: O(n^2)
    Space Complexity: O(n)
*/

class Solution {
    public static int lengthOfLIS(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            int value = curr;
            int length = 1;
            for (int j = 0; j < i; j++) {
                int[] temp = dp[j];

                if (value > temp[1]) {
                    length = Math.max(length, temp[0] + 1);
                }
            }

            answer = Math.max(length, answer);
            dp[i] = new int[]{length, value};
        }

        return answer;
    }
}