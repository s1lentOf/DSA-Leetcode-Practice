/*
    My approach is to use Bottom-Up recursive calculation with memoization. For each start index, we have two ways of moving forward:
        1) Include only one digit and move to the next index;
        2) Include two adjacent digits and move 2 steps to the front;
    A current decode way is correct if we reach the end of the array.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    public static int numDecodings(String s) {
        if (s.isEmpty()) return 0;

        return helper(s, 0, new Integer[s.length()]);
    }

    public static int helper(String s, int start, Integer[] memo) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;
        if (memo[start] != null) return memo[start];

        int ways = helper(s, start + 1, memo);

        if (start + 1 < s.length() && Integer.parseInt(s.substring(start, start + 2)) <= 26) {
            ways += helper(s, start + 2, memo);
        }
        memo[start] = ways;

        return memo[start];
    }
}