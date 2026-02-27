/*
    The problem is to find the element in the given array that appears more than n/2 times.

    This solution is based on the Boyer–Moore Voting Algorithm.

    Every time we encounter an element that is different from the current candidate, we decrement the count.
    This represents canceling out one occurrence of the candidate with one occurrence of a different element.

    Since the majority element appears more than n/2 times, it cannot be completely canceled out by the other elements.
    Therefore, it will remain as the final candidate.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[0]) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }
}