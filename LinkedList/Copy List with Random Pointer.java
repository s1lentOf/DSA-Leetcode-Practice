/*
    My approach is to use HashMap to store 'original' nodes with its corresponding 'clone'.
    We initially iterate over Linked List to create a 'clone' for each node. Then, we assign 'clone's next and random pointers
    by retreiving these nodes from the HasmMap:

    {
        original            : clone
        (original.next)     : clone
        (original.random)   : clone
    }

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}