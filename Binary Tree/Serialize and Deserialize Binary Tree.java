/*  
    My approach is to use Breadth-First Search to store the values in the String.

    Example:
          1
         / \
        2   3
           / \
          4   5 
        
    After serialization:
    "1,2,3,null,null,4,5,null,null,null,null"

    To deserialize, I use a pointer, using which I can easily calculate the index of the left and right child of the current node.

    Time Complexity: O(n), where n - number of nodes in the tree
    Space Complexity: O(n)
*/

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr != null) {
                queue.add(curr.left);
                queue.add(curr.right);
            }

            stringBuilder.append(curr != null ? curr.val : "null");
            if (!queue.isEmpty()) stringBuilder.append(",");
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nums = data.split(",");

        if (nums[0].equals("null")) return null;

        TreeNode head = new TreeNode(Integer.parseInt(nums[0]));
        int i = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty() && i < nums.length) {
            TreeNode curr = queue.poll();

            if (!nums[i + 1].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nums[i + 1]));
                queue.add(curr.left);
            }

            if (!nums[i + 2].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nums[i + 2]));
                queue.add(curr.right);
            }

            i += 2;
        }

        return head;
    }
}