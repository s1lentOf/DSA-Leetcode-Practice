/*
    This method takes a sorted array and builds a balanced Binary Search Tree (BST).

    The idea is to always pick the middle element of the current array range as the root,
    so that the left and right subtrees are roughly the same size, keeping the tree balanced.

    - The "middle" element becomes the root node.
    - Recursively, the left half of the array builds the left subtree.
    - Recursively, the right half of the array builds the right subtree.

*/

class Solution {
    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int middle = left + (right - left) / 2;

        Node root = new Node (nums[middle]);

        root.left = sortedArrayToBST(nums, left, middle - 1);
        root.right = sortedArrayToBST(nums, middle + 1, right);

        return root;
    }
}