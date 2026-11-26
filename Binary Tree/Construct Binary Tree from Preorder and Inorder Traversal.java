/*
    My approach is to use the result of the Inorder Tree Traversal to determine where (to the left or to the right) the current value 
    would be comparing to each node starting from the root. Then, using the result of the Preorder Tree Traversal, I iterate over that 
    array and, starting from the root, determin where to move next. When the null is reached, the new node is created.

    Time Complexity: O(n * h), where h - height of the tree
    Space Complexity: O(n)
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> locations = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            int curr = inorder[i];
            locations.put(curr, i);
        }

        TreeNode head = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            int curr = preorder[i];
            insert(locations, head, curr);
        }

        return head;
    }

    public void insert(Map<Integer, Integer> locations, TreeNode curr, int value) {
        boolean isLeft = locations.get(curr.val) > locations.get(value);
        if (isLeft) {
             if (curr.left == null) {
                 curr.left = new TreeNode(value);
             } else {
                 insert(locations, curr.left, value);
             }
        } else {
            if (curr.right == null) {
                curr.right = new TreeNode(value);
            } else {
                insert(locations, curr.right, value);
            }
        }
    }
}