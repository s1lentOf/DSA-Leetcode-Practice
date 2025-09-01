/*
    We start with answer = 0. For each node:
      1. Multiply answer by 2 (shifts digits left in binary).
      2. Add the node’s value (0 or 1).
    
    Continue until we reach the end of the list.

 Example:
    Linked list: 1 -> 0 -> 1
    Steps: 0*2+1 = 1
           1*2+0 = 2
           2*2+1 = 5
    Result: 5
*/

class Solution {
    public int binaryToDecimal(Node head) {
        if (length == 0) return 0;

        int answer = 0;
        Node temp = head;
        while (temp != null) {
            answer = answer * 2 + temp.value;
            temp = temp.next;
        }
        return answer;
    }
}