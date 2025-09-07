/*
    The problem is to check if each openeing parenthese has its closing pair.

    To solve this problem, we use the LIFO method of Stack.

    1. Push each '(' to the Stack
    2. Pop each ')' from the Stack.
    3. If, at some point, when we want to pop from the Stack and it is already empty, we return false,
    because it means that the pair is not completed.
    4. Otherwise, we return stack.isEmpty()
 */

class Solution {
    public static boolean isBalancedParentheses(String stc) {
        Stack<Character> stack = new Stack<>();

        char[] parentheses = stc.toCharArray();

        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '(') {
                stack.push('(');
            } else if (parentheses[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}