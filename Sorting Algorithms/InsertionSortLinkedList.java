/*
    This code implements the insertion sort algorithm on a singly linked list.

    It rearranges the nodes in ascending order by iteratively taking nodes from
    the unsorted part of the list and inserting them into the correct position
    in the sorted part.

    The head and tail pointers are updated accordingly.
*/

class Solution {
    public void insertionSort() {
        if (this.length < 2) return;

        Node sortedListHead = this.head;
        Node unsortedListHead = this.head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.value < sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next != null && searchPointer.next.value < current.value) {
                    searchPointer = searchPointer.next;
                }

                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        tail = temp;
    }
}