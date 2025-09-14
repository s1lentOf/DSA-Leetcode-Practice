/*
    There are many approaches to solving the two sum problem, where you have to find
    two numbers from the given array, the sum of which eqals the provided 'target' number.

    In this solution I used HashMap to keep track of the numbers that have already been 'processed'.

    The structure of the HashMap:
    {
        number: index
    }

    The logic is the following:
    1. Iterate over each number in the given array
    2. Find the difference between the target and the current number, remainder, in other words.
    3. If the HashMap already has the number that equals the remainder, I return the index of the current number
    and the value of the remainder in the HashMap
    4. Otherwise, we just add this number to the HashMap.
 */

class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> dataMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int remainder = target - numbers[i];

            if (dataMap.containsKey(remainder)) {
                return new int[]{dataMap.get(remainder), i};
            }

            dataMap.put(numbers[i], i);
        }

        return new int[]{};
    }
}