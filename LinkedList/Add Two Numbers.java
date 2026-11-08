/*
    My approach is to create a dummy ListNode that would point at the beginning of the LinkedList. Add two corresponding ListNode values
    plus the overflow from previous operations and update overflow. Create a new ListNode with this value and move the pointer to the 
    newly created ListNode. By using this approach of firstly creating a ListNode and then move to it, we can easily create the 
    additional ListNode if there is remaining overflow.

    Time Complexity: O(max(l1, l2))
    Space Complexity: O(max(l1, l2))
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;

        int overflow = 0;

        while (l1 != null || l2 != null || overflow > 0) {
            int sum = overflow;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            overflow = sum >= 10 ? 1 : 0;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        return head.next;
    }
}