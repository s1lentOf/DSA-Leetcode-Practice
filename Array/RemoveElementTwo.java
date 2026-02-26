/*
    The goal is to remove duplicates in-place so that each unique element appears at most twice, while preserving the original relative order.

    My approach is to iterate through the array and write each element to its correct position as long as its occurrence
    count is less than or equal to 2. Once the count exceeds 2, I skip writing that element until a new value appears.

    Example:
     i
       j
    [0,0,1,1,1,1,2,3,3] - at this position we rewrite the value at index 1 and increment the counter, so it becomes 2.

           i
             j
    [0,0,1,1,1,1,2,3,3] - we keep looping until the counter is greater than 2. The i pointer just waits until j pointer finds a new value.

           i
                 j
    [0,0,1,1,1,1,2,3,3] - at this position we resume writing a new value.


    Time complexity: O(n)
    Space complexity: O(1)
*/

class Solution {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int k = 1;
        int count = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j-1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                i++;
                nums[i] = nums[j];
                k++;
            }
        }

        return k;
    }
}