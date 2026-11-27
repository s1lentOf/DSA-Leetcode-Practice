/*
    My approach is to recursively calculate the maximum path among two different options:
        1. Math.max(curr.value + maxLeft, curr.value + maxRight) or just curr.value - single side moving
        2. curr.value + maxLeft + maxRight - both sides moving
    Then, I get the largest and update the general maximum path. Additionally, I then return the single side moving maximum path
    so it can be included in the higher nodes paths.

    Time Complexity: O(n), where n - total number of nodes
    Space Complexity: O(1)
*/

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;

        int temp = helper(root, result);

        return result[0];
    }

    public int helper(TreeNode root, int[] temp) {
        if (root == null) return 0;

        int maxLeft = helper(root.left, temp);
        int maxRight = helper(root.right, temp);

        int maxSingleSide = Math.max(root.val, Math.max(maxLeft + root.val, maxRight + root.val));
        int maxBothSides = maxLeft + maxRight + root.val;
        int maxCurr = Math.max(maxBothSides, maxSingleSide);

        temp[0] = Math.max(temp[0], maxCurr);

        return maxSingleSide;
    }
}