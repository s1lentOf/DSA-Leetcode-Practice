// The most common approach to solve this problem is to use
// 'Floyd's cycle finding algorithm or Hare-Tortoise algorithm'. This algorithm requires two pointers:
// a fast one, which would move two steps at time and a slow one, which will go one Node at time.
// If, at some point, fast and slow pointers will point to the same node, it means the LL has a cycle.

class Solution {
    public boolean hasLoop(Node head) {
        LinkedList.Node slow = head;
        LinkedList.Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}