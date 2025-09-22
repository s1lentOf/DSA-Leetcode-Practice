/*
    This method swap each pair of nodes in the Linked List.

    I use tree pointers to make this swap:
        - Current = The first node to swap
        - Prev = The previous node of the current
        - After = The second node to swap

    Additionally, I use the dummy node, which points to the Head.

    Then, by updating each pointer I swap the pair of pointers.
    In the end, the head is updated.
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

            // Swap
            curr.next = after.next;
            after.next = curr;
            prev.next = after;

            // Move pointers
            prev = curr;
            curr = curr.next;
        }

        head = dummy.next;

    }
}