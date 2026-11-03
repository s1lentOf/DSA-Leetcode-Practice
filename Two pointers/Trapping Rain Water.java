/*
    My approach is to use two pointers: one - starting from the beginning, another - from the end, and to
    move the smaller border to the higher border.

    Additionally, we have to track the left an right heighest "border" to calculate the amount of the water
    that can be trapped on this index. 
    
    At each index we: 
        1. update the max value for both "trackers". 
        2. if right border is smaller: 
            a) fix the left border;
            b) calculate the amount of water for this index by subtracting the current height from the max seen on the right side;
            c) move right pointer;
        3. else: 
            a) fix the right border;
            b) calculate the amount of water for this index by subtracting the current height from the max seen on the left side;
            c) move left pointer;
    Iterate until two pointers meet.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax > rightMax) {
                water += rightMax - height[right];
                right--;
            } else {
                water += leftMax - height[left];
                left++;
            }
        }

        return water;
    }
}