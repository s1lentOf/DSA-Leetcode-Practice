/*
    My approach is to use Pre-Order Tree Traversal to iterate over the tree. By using Pre-Order method, at each node of the tree we 
    would have information about nodes, that are above the current node, becuase we have already processed them by that moment.

    Time Complexity: O(n), where n - number of nodes in the tree
    Space Complexity: O(1)
*/

class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    public int helper(TreeNode treeNode, int maxSeen) {
        if (treeNode == null) return 0;

        int temp = 0;
        if (treeNode.val >= maxSeen) temp++;

        return temp + helper(treeNode.left, Math.max(treeNode.val, maxSeen)) + helper(treeNode.right, Math.max(treeNode.val, maxSeen));
    }
}