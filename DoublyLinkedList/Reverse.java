/*
    The solution to this problem is by using two temporary Nodes and reversersing each Node in place

    prev    curr
      |      |
      |  ->  |  ->   ->   ->
    null     1     2    3   null
         <-     <-   <-   <-

    Then we just move each node in place and move prev and curr Nodes forward.
 */

class Solution {
    public void reverse() {
        if (length <= 1) return;

        Node current = head;
        Node prev = null;

        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }

        current = head;
        head = tail;
        tail = current;
    }
}