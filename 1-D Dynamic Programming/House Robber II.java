/*
    My approach is to use Top-Down recursion with memoization. For each house, we recursively check what would be greater: 
        a) Rob this house and the house two steps before;
        b) Just rob previous house and skip this one;
    As the houses are arranged in a circle, we have to create two linear checks:
        1) Not including last house;
        2) Not including first house;

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(
                helper(nums, 0, nums.length - 2, new int[nums.length], new boolean[nums.length]),
                helper(nums, 1, nums.length - 1, new int[nums.length], new boolean[nums.length])
        );
    }

    public static int helper(int[] nums, int start, int end, int[] memo, boolean[] visited) {
        if (start > end) return 0;
        if (start == end) return nums[start];
        if (visited[end]) return memo[end];

        memo[end] = Math.max(
                nums[end] + helper(nums, start, end - 2, memo, visited),
                helper(nums, start, end - 1, memo, visited)
        );
        visited[end] = true;

        return memo[end];
    }
}