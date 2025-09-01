class Solution {
    // Brute-Force Solution
    //
    // To solve this problem and remove duplicates from the Linked List, we can use nested loops.
    // The outer loop (with `slow`) picks one element at a time.
    // The inner loop (with `fast`) then checks all subsequent nodes
    // to see if any node has the same value as the `slow` node. If a duplicate is found,
    // we skip it by changing the `next` pointer of `fast` to remove that node from the list,
    // and reduce the length. Otherwise, we just move `fast` ahead.
    public void removeDuplicates() {
        if (length <= 1) return;

        Node slow = head;
        Node fast = head;

        while (slow != null) {
            while (fast.next != null) {
                if (fast.next.value == slow.value) {
                    fast.next = fast.next.next;
                    length--;
                } else {
                    fast = fast.next;
                }
            }

            slow = slow.next;
            fast = slow;
        }
    }

    // Optimal Solution using Set
    //
    // More optimal solution for this problem would be by using set. That way, we are iterating over the LL,
    // and if the value of the current node is in the set, we remove this node. Otherwise, we just add this
    // value to the set
    public void removeDuplicates() {
        if (length <= 1) return;

        Set<Integer> values = new HashSet<>();

        Node current = head;
        Node previous = null;

        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length--;
            } else {
                values.add(current.value);
                previous = current;
            }

            current = current.next;
        }
    }
}