/*
    The solution to the problem of rotating an array by k times.

    Approach:
        - Compute effective rotations (k % n)
        - Reverse the entire array
        - Reverse the first k elements
        - Reverse the remaining elements
 */

class Solution {
    public static void rotate(int[] nums, int k) {
        int rotations = k % nums.length;

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, rotations - 1);

        reverse(nums, rotations, nums.length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}