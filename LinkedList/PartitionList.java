/*
    Example Input:
        5 -> 1 -> 0 -> 4 -> 3 -> null           x = 2

    Output:
        1 -> 0 -> 5 -> 4 -> 3 -> null

        To solve this problem we create two 'dummy' nodes. One, dummy1, for keeping track of values >= x.
        Another, dummy2, for values < x. We also need two pointers to track dummy1 and dummy2.
        Then we iterate over the LL and, depending on the current node's value, change the two pointers.
        In the end, we assign the last element of the pointer of the dummy1 to be null, to avaid cycles.
        Additionally, we 'connect' the dummy2 to the dummy1 and move head to the front of the partitioned list.
*/

class Solution {
    public void partitionList(Node head, int x) {
        if (length <= 1) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;

        while(current != null) {
            if(current.value >= x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }

            current = current.next;
        }

        prev1.next = null;
        prev2.next = dummy1.next;

        head = dummy2.next;
    }
}