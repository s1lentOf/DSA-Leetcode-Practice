/*
    To solve this problem, we have to create two temporary nodes:
    1. One, which will start from the beginning (head) and will be moving forward,
    2. Another one, which will start from the end (tail) and will be moving backward,

    On each step we have to check their values to be equal, because if they are not,
    it means that the 'word' is not palindrome.

    Move 'forward' Node to the next Node and 'backward' Node to the perevious Node
 */

class Solution {
    public boolean isPalindrome() {
        if(length <= 1) return true;

        Node forward = head;
        Node backward = tail;

        while (forward != backward && forward.next != backward.next) {
            if (forward.value != backward.value) return false;

            forward = forward.next;
            backward = backward.prev;
        }

        return true;
    }
}