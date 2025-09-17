/*
    Bubble Sort for a singly linked list:

    Here is the explanatin of the logic:
    - If the list has fewer than 2 elements, it is already sorted.
    - I use a pointer 'sortedUntil' to mark the boundary of the sorted portion of the list (starting from the end).
    - I repeat passes over the unsorted portion of the list until fully sorted:
        - Start from the head of the list.
        - Compare each node with its next node.
        - Swap values if the current node is greater than the next node.
    - After each pass, I update 'sortedUntil' to the last node visited to shrink the unsorted portion.

    This sorts the linked list in-place without creating a new list.
 */

class Solution {
    public void bubbleSort() {
        if (this.length < 2) return;

        // A pointer to the last sorted element.
        Node sortedUntil = null;

        while(sortedUntil != this.head.next) {
            Node temp = this.head;
            while (temp.next != sortedUntil) {
                if (temp.value > temp.next.value) {
                    int tempValue = temp.value;
                    temp.value = temp.next.value;
                    temp.next.value = tempValue;
                }
                temp = temp.next;
            }
            sortedUntil = temp;
        }
    }
}