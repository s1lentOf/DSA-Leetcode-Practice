/*
    My approach is to use Breadth-First Search to iterate over levels in the Binary Tree. At each occassion, where the level switches, 
    I add the previous element to the result list, because it means it is in the end of the current level.

    Time Complexity: O(n), where n is the total number of nodes
    Space Complexity: O(n)
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            
            if (queue.isEmpty() || curr.level != queue.peek().level) result.add(curr.node.val);
            if (curr.node.left != null) queue.add(new Pair(curr.node.left, curr.level + 1));
            if (curr.node.right != null) queue.add(new Pair(curr.node.right, curr.level + 1));
        }

        return result;
    }
}

class Pair {
    TreeNode node;
    int level;

    public Pair(TreeNode node, int i) {
        this.node = node;
        this.level = i;
    }
}