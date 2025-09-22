/*
    This method reverses a portion of a singly linked list between two given positions m and n.

    It uses a dummy node to simplify edge cases, locates the node before the reversal start (prev),
    and then iteratively moves nodes from the sublist to the front of the reversed section.

    Finally, it updates the head of the list to reflect the changes.
 */

class Solution {
    public void reverseBetween(int m, int n) {
        if (length == 0 || m == n) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }

        Node curr = prev.next;

        for (int i = 0; i < n - m; i++) {
            Node after = curr.next;
            curr.next = after.next;
            after.next = prev.next;
            prev.next = after;
        }

        head = dummy.next;
    }
}