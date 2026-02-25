/*
    The problem is to remove all duplicate in-place calculate the number of unique numbers.

    My approach to solving this problem is the following:

        We have two pointers:
            i - to track last element on the correct index.
            j - to find the next unique element.
        We iterate over the given array and when the number at index i does not equal the number at index j,
        we increment the i pointer and assign it to be number at index j.

    Example:
     i  j
    [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]

     i     j
    [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] - here we increment i and change its value to be the new one we found.

        i           j
    [0, 1, 1, 1, 1, 2, 2, 3, 3, 4] - we continue until the j pointer reaches the end of the array.

    Time Complexity: O(n)
    Space Complexity: O(1)
 */

class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        int k = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                k++;
            }
        }

        return k;
    }
}