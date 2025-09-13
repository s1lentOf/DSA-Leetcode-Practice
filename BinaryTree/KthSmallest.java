/*
    Approach: Iterative DFS (InOrder Traversal)

    1. We want the kth smallest element in a Binary Search Tree (BST).
       - InOrder traversal of a BST gives nodes in sorted (ascending) order.

    2. Instead of recursion, we use an iterative approach with a Stack.
       - This allows us to simulate the recursive call stack and find the kth smallest element faster
       than using the recursive approach.

    Algorithm steps:
    - Initialize a pointer 'node' at the root.
    - Traverse left subtree first:
        * Push nodes onto the stack until we reach the leftmost node.
    - Process nodes in InOrder sequence:
        * Pop the top node from the stack.
        * Decrement 'k'. If 'k == 0', this is our kth smallest element.
    - Move to the right child and repeat the process.
    - Continue until the element is found or the stack is empty.
 */

class Solution {
    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            k--;
            if (k == 0) return node.value;
            node = node.right;
        }

        return null;
    }
}