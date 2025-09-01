// To find the Middle node of the LinkedList, we need to use two pointers:
// one pointer moving twice faster than the other. That way, when 'fast' pointer will reach the end of the LL
// the slow pointer would be exactly on the middle (if the length of the LL is odd number) or on the next node
// after the middle (if the length of the LL is even number).

class Solution {
    public Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        if (slow == null) return null;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}