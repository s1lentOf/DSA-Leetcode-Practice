/*
    The solution to the problem of processing a stream of integers and returning the maximum number encountered
    so far for each input number.

    The solution works as follows:
    For each number in the input array:
          - The number is inserted into the heap.
          - The current maximum value in the heap (always stored at index 0) is retrieved.
          - This maximum value is added to the result list.

    In short, this function tracks the maximum element seen so far in a stream of numbers,
    updating the maximum efficiently using a heap data structure.
 */

class Solution {
    public static List<Integer> streamMax(int[] nums) {
        Heap heap = new Heap();
        ArrayList<Integer> answers = new ArrayList<>();

        for (int num : nums) {
            heap.insert(num);
            answers.add(heap.getHeap().get(0));
        }

        return answers;
    }
}