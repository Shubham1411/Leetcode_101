/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
import java.util.*;
public class GroupAnagrams {
        private static void printAnagrams(String arr[])
        {
            HashMap<String, List<String> > map = new HashMap<>();

            // loop over all words
            for (int i = 0; i < arr.length; i++) {

                // convert to char array, sort and
                // then re-convert to string
                String word = arr[i];
                char[] letters = word.toCharArray();
                Arrays.sort(letters);
                String newWord = new String(letters);

                if (map.containsKey(newWord)) {
                    map.get(newWord).add(word);
                }else {
                    List<String> words = new ArrayList<>();
                    words.add(word);
                    map.put(newWord, words);
                }
            }

            // print all the values where size is > 1
            // If you want to print non-anagrams,
            // just print the values having size = 1
            for (String s : map.keySet()) {
                List<String> values = map.get(s);
                if (values.size() > 1) {
                    System.out.print(values);
                }
            }
        }

        public static void main(String[] args)
        {

            // Driver program
            String arr[] = { "cat", "dog", "tac", "god", "act" };
            printAnagrams(arr);
        }
}
