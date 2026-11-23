/*
    My solution uses 2-D DP approach. The logic is that, if the string, starting at index i and ending at index j is palindrome, 
    then if I add two letters, one to the end, and another to the beginning, and they are the same, this string is also a palindrome.
    So I create a 2D array, where i means the beginning of the string and j the end respectively. Starting from the end of the given string,
    my algorithm walks backwards and checks for the specified condition.

    Time Complexity: O(n^2)
    Space Complexity: O(n^2)
*/

class Solution {
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        char[] chars = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (chars[i] == chars[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }

        return res;
    }
}