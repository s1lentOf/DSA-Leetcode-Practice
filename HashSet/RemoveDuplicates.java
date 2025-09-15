/*
    Here is the solution to the problem of removing duplicates from a List of numbers.

    Approach:
    - A HashSet is used because it automatically eliminates duplicate values.
    - When the input List is passed into a HashSet, any repeated numbers are removed.
    - Since the method must return a List, we convert the HashSet back into an ArrayList.
*/

class Solution {
    public static List<Integer> removeDuplicates(List<Integer> myList) {
        HashSet<Integer> numbers = new HashSet<>(myList);
        return new ArrayList<Integer>(numbers);
    }
}