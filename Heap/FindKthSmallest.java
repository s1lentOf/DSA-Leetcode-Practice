/*
    To solve the problem of finding the k-th smallest number, I use a max-heap.

    As the maxHeap keeps the biggest number always on top, I remove it everytime the size of the array is bigger than k.
    Additionally, as I keep the array the correct size (the kth size), just return the top element of the Heap,
    because it is gonna be kth smallest.

    Here is the solution pattern:

    - While iterating through the array, I insert each number into the heap.
    - At the end, the root of the max-heap represents the k-th smallest element,
      because the heap has exactly k elements, and the largest of them is the answer.
 */

class Solution {
    public int findKthSmallest(int[] nums, int k) {
        Heap heap = new Heap();
        int answer = 0;

        for (int num : nums) {
            heap.insert(num);
            if (heap.getHeap().size() > k) {
                heap.remove();
            }
        }

        return heap.remove();
    }
}