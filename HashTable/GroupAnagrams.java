/*
     This solution groups anagrams from a list of strings.

     The idea to the solution:
         - Anagrams have the same characters in different orders, so sorting their letters
           gives the same "signature" string.
         - We use a HashMap where:
             - Key = the sorted version of the word (the signature).
             - Value = a list of words (anagrams) that match this signature.
         - For each input word, we sort its characters using insertion sort (implemented in sortWord),
           then add it to the correct group in the HashMap.
         - Finally, we return all the grouped anagrams as a list of lists.

     Time Complexity:
        - Sorting each word takes O(L²) with insertion sort (L = word length).
        - Overall complexity is about O(N * L²), where N = number of words.
*/

class Solution {
    public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, ArrayList<String>> dataMap = new HashMap<>();

        for (String word : strings) {
            String sortedWord = sortWord(word.toCharArray());
            if (dataMap.containsKey(sortedWord)) {
                dataMap.get(sortedWord).add(word);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                dataMap.put(sortedWord, list);
            }
        }

        return new ArrayList<>(dataMap.values());
    }

    public static String sortWord(char[] letters) {
        for (int i = 1; i < letters.length; i++) {
            int key = letters[i];

            int j = i - 1;
            while(j >= 0 && key < letters[j]) {
                letters[j + 1] = letters[j];
                j--;
            }

            letters[j] = (char)key;
        }

        return new String(letters);
    }
}