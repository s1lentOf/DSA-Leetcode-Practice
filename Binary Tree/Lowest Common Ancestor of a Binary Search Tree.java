/*
    My approach is to use the properties of the Binary Search Tree to detemine where in the given Tree nodes p and q are.
    There are 3 potential scenarios: 
        1. Two nodes are to the left of the root: move to the left and search for smaller values.
        2. Two nodes are to the right of the root: move to the right and search for LCA in that T
        3. Any other scenario (p or q is the root): return the root

    Time Complexity: O(log(n)), where n - the number of Nodes in the BST
    Space Complexity: O(1)
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (bothLeft(root, p, q)) return lowestCommonAncestor(root.left, p, q);
        if (bothRight(root, p, q)) return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public boolean bothLeft(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < root.val && q.val < root.val;
    }

    public boolean bothRight(TreeNode root, TreeNode p, TreeNode q) {
        return p.val > root.val && q.val > root.val;
    }
}