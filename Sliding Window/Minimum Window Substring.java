/*
    My approach is to use dynamic sliding window to track the current window that contains all chars from t. The logic is to initially build
    a Map of letters and their quantities in t. Then, add elements from the right to the window and decrement the quantity. 
    Additionally, I use 'missing' tracker to easily identify if the current window has all the required elements. When 'missing' is 0,
    record this window and remove the elements from the left.

    Time Complexity: O(m + n)
    Space Complexity: O(k), where k - number of distinct chars is t
*/

class Solution {
    public static String minWindow(String s, String t) {
        int missing = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char curr : t.toCharArray()) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;
        
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                if (map.get(s.charAt(j)) > 0) {
                    missing--;
                }

                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            }

            while (missing == 0) {
                if (j - i + 1 < bestLen) {
                    bestLen = j - i + 1;
                    bestStart = i;
                }

                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) > 0) {
                        missing++;
                    }
                }
                
                i++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}