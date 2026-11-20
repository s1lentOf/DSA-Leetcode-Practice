/*
    My approach is to use Bottom-Up DP strategy, where value at index i determines if the s can be segmented up until this point.
    For each i, the following computations have to be made:
        1) Find some index j, where dp[j] is true;
        2) Determine if the substring from j to i is in the Set of words;

    s = "catsandog"
    wordDict = ["cats","dog","sand","and","cat"]

    c a t s a n d o g
                      i

    i = 9
    j = 7

    dp = [T, F, F, T, T, F, F, T, F, F]

    Time Complexity: O(n^3)
    Space Complexity: O(n)
*/

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}