/*
    In this problem we use a Stack, implemented using an ArrayList, to reverse a string.
    The solution to this problem is basically to use the LIFO method.

    1. Push each character from the string to the stack
    2. Pop (retrieve) each character from the stack
 */

public static String reverseString(String word) {
    Stack<Character> stack = new Stack<>();
    char[] letters = word.toCharArray();

    StringBuilder reversed = new StringBuilder(word.length());

    for (int i = 0; i < word.length(); i++) {
        stack.push(letters[i]);
    }

    while(!stack.isEmpty()) {
        reversed.append(stack.pop());
    }

    return reversed.toString();
}