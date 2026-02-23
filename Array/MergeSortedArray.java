/*
    We are given two sorted arrays. Our goal is to merge them into the first array so it stays sorted.

    My approach to the solution is provided below:
        I use 3 pointers:
            i - keeps index of the largest number in the first array
            j - keeps index of the largest number in the second array
            k - keeps index of the next insertion position
        We are looping until we reach the beginning of the second array, because at that point
        all elements from the second array would be inserted to the first array and the left part
        of the first array is already sorted.

    Example:
           i        k          j
    [1, 2, 3, 0, 0, 0]  [2, 5, 6]

    First iteration:
           i     k          j
    [1, 2, 3, 0, 0, 6]  [2, 5, 6]

    Second iteration:
           i  k          j
    [1, 2, 3, 0, 5, 6]  [2, 5, 6]

    Fourth iteration:
        i  k             j
    [1, 2, 3, 3, 5, 6]  [2, 5, 6]

    Fifth iteration:
        k
        i               j
    [1, 2, 2, 3, 5, 6]  [2, 5, 6]

    Time Complexity: O(n)
    Space Complexity: O(1)
 */

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}