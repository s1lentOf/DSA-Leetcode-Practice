// To solve this problem and find the kth node from the end, we firstly have to create a gap, or range,
// between two pointer of the size k. If we have created this gap without reaching the end, it means
// the LL has node at index k from the end. Otherwise, the length of the LL is smaller than k.
// Then, we move two pointers simultaneously and when we reach the end of the LL (faster pointer == null)
// slow.next will be the kth node from the end.

class Solution {
    public Node findKthFromEnd(Node head, int k) {
        if (k <= 0) return null;
        if (k == 1) return tail;

        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}