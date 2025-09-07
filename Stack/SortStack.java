/*
    To solve this problem, and sort stack with integers efficiently,
    we have to use additional temp variable and secondStack. We try to keep
    the lowest numbers at the bottom of the secondStack

    Here is the schema:
    1. Pop a number from the main stack and assign it to temp;
    2. If it is bigger or equal the current top number in the secondStack (we use peek() method to get it),
    we just add it to the secondStack;
    3. Otherwise, we pop a number and add it to the main stack until the current peek number is lower than temp;
    4. In the end, just pop each value from the secondStack and push it to the main stack
 */

class Solution {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.size() <= 1) return;


        Stack<Integer> secondStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!secondStack.isEmpty() && temp < secondStack.peek()) {
                stack.push(secondStack.pop());
            }

            secondStack.push(temp);
        }

        while (!secondStack.isEmpty()) {
            stack.push(secondStack.pop());
        }
    }
}