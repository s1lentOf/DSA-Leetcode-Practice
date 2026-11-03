/*
    The following code implements the Selection sorting algorithm for the Linked List.

    Basically, the idea is to find the smallest number in the LinkedList and put it to the front.

    Here is the code structure:
    - iterate over the LinkedList
    - find the smallest number in the LinkedList starting from the current position
    - swap this number with the value of the current position
 */

class Solution {
    public void selectionSort() {
        if (this.length < 2) return;

        Node current = this.head;

        while(current.next != null) {
            Node min = current;
            Node innerCurrent = current.next;

            while (innerCurrent != null) {
                if (innerCurrent.value < min.value) {
                    min = innerCurrent;
                }

                innerCurrent = innerCurrent.next;
            }

            if (min != current) {
                int temp = min.value;
                min.value = current.value;
                current.value = temp;
            }

            current = current.next;
        }

    }
}