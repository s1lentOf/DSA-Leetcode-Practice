/*
    This method swap each pair of nodes in the Doubly Linked List.

    I use three pointers:
        - curr: first node in the pair
        - prev: node before the pair
        - after: second node in the pair

    A dummy node is used for easier head handling.
 */

class Solution {
    public void swapPairs() {
        if (head == null || head.next == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        Node curr = prev.next;

        while (curr != null && curr.next != null) {
            Node after = curr.next;

            curr.next = after.next;

            if (after.next != null) after.next.prev = curr;

            after.next = curr;
            if (prev != dummy) {
                after.prev = prev;
            } else {
                after.prev = null;
            }

            prev.next = after;
            curr.prev = prev.next;

            prev = curr;
            curr = curr.next;
        }

        head = dummy.next;
        dummy.next = null;
    }
}