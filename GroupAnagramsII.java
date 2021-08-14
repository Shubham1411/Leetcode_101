/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
original letters exactly once.
 */

import java.util.*;

public class GroupAnagramsII {

    //Approach : Using HashSet. For each word, sort the characters and make them key. Next if an anagrams is encountered
    //store it in the key with the sorted word
    //Time: O(n), 99 percentile, Space:O(n)
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        // loop over all words
        for (int i = 0; i < strs.length; i++) {

            // convert to char array, sort and
            // then re-convert to string
            String word = strs[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

    }

}
