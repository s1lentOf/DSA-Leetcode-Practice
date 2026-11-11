/*
    My approach is to use minHeap to get instant access to the ListNode with the smallest value. I initially add all nodes 
    from all lists to the minHeap. Then, I create a new LinkedList by gradually polling the nodes from the minHeap until it is empty.

    Time Complexity: O(NlogN)
    Space Complexity: O(N)

    where N - total number of ListNodes
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                minHeap.add(head);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
        }
        
        tail.next = null;
        return dummy.next;
    }
}