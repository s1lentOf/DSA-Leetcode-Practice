/*
    The main idea of the solution is to invert the left and right nodes for each parent node.
    That's why I use recursion, as the pattern of actions is the same:

    1. Base Case: currentNode either equals null, or both children nodes of the current node
    equals null (we are skipping two unnecessary checks)
    2. Left node of the current node equals the inverted version of the right node
    3. Right node of the current node equals the inverted version of the left node
 */

class Solution {
    private Node invertTree(Node currentNode) {
        if (currentNode == null) return null;
        if (currentNode.left == null && currentNode.right == null) return currentNode;

        Node temp = currentNode.left;
        currentNode.left = invertTree(currentNode.right);
        currentNode.right = invertTree(temp);

        return currentNode;
    }
}