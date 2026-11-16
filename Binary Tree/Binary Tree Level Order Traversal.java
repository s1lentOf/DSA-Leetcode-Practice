/*
    My approach is to use the regular implementation of the BFS algorithm to travers the tree level-by-level. To store the levels in 
    different lists in the result list, I decided to create Pair object, that would store the node and its level in the tree.

    Time Complexity: O(n), where n - number of nodes in the given tree
    Space Complexity: O(n)
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Pair> queue = new LinkedList<>();

        List<Integer> temp = new ArrayList<>();
        int lastSeen = 0;

        result.add(temp);
        queue.add(new Pair(root, lastSeen));

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            int level = currPair.level;
            TreeNode node = currPair.node;

            if (lastSeen != level) {
                temp = new ArrayList<>();
                result.add(temp);
            }

            temp.add(node.val);
            lastSeen = level;

            if (node.left != null) queue.add(new Pair(node.left, level + 1));
            if (node.right != null) queue.add(new Pair(node.right, level + 1));
        }

        return result;
    }
}

class Pair {
    TreeNode node;
    int level;

    public Pair(TreeNode root, int i) {
        this.node = root;
        this.level = i;
    }
}