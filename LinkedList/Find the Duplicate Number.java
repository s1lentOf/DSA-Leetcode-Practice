/*
    My approach is to use Floyd's cycle detection algorithm so we satisfy the main constraint, which is the constant space, because
    the given array can be also represented by a LinkedList, where nums[i] points to the nums[nums[i]]. The logic of this algorithm 
    is to use fast and slow pointers as the cycle in the LinkedList is guaranteed. 

    1. Find the point where the slow and fast pointers meet;
    2. Reset one of the pointers to start from the beginning and move each pointer one step ata a time. They will meet 
    at the beginning of the cycle.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}