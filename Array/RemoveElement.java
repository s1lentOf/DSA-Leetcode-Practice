/*
    The problem is to remove all occurences of val in nums array in-place. My approach to the solution consists of the following:

    i - pointer, that moves from the beginning to the end
    j - pointer, that moves from the end of the array to the left.

    if currentElement == val, we move j until we find the first non val element and swap elements.
    The loop stops when the i pointer meet j pointer, meaning we have moved oll occurences of val to the right.

    Example:
         i                    j
        [0, 1, 2, 2, 3, 0, 4, 2]

            i                 j
        [0, 1, 2, 2, 3, 0, 4, 2]

               i           j
        [0, 1, 4, 2, 3, 0, 2, 2] - iterate from right to left until we find the value that != val and swap

                  i     j
        [0, 1, 4, 0, 3, 2, 2, 2] - iterate from right to left until we find the value that != val and swap

                        ij
        [0, 1, 4, 0, 3, 2, 2, 2]
 */

class Solution {
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        int j = nums.length - 1;
        int i = 0;

        while (i <= j) {
            if (nums[i] == val) {
                while (nums[j] == val) {
                    // If at any point, when we are trying an element on the right to swap with, the pointers i and j meet
                    // each other, we return k straight away, as all items that equal val are already to the right.
                    if (j <= i) return k;
                    j--;
                }

                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }

            k++;
            i++;
        }

        return k;
    }
}