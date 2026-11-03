/*
    Here is the implementation of the merge function in the MergeSort algorithm on the Linked Lists.

    This method merges another sorted linked list into the current linked list while maintaining
    the sorted order.

    It uses a dummy node to simplify pointer management and updates the head of the list after merging.
    The overall length of the list is also adjusted to include the merged nodes.

 */

class Solution {
    public void merge(LinkedList otherList) {
        Node otherHead = otherList.getHead();
        Node dummy = new Node(0);
        Node current = dummy;

        while (otherHead != null && head != null) {
            if (head.value < otherHead.value) {
                current.next = head;
                head = head.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }

            current = current.next;
        }

        while (otherHead != null) {
            current.next = otherHead;
            current = current.next;
            otherHead = otherHead.next;
        }

        while (head != null) {
            current.next = head;
            current = current.next;
            head = head.next;
        }

        head = dummy.next;
        length += otherList.getLength();
    }
}