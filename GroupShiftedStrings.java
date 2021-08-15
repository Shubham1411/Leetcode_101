import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep
"shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting
sequence.
 */

//Approach: Using HashMap to store the hashed value and words with same hash as List. Using difference between
//Consecutive character of each word and '#' as a separator between them to calculate the hash.
//Time: O(n) 80 percentile
public class GroupShiftedStrings {

    //Method to calculate the hash of each words
    public static String getHash(String s) {
        char prev = s.charAt(0);
        String hash = "#";

        for (int i = 1; i < s.length(); i++) {
            int temp = s.charAt(i) - prev;
            if (temp < 0)
                temp = temp + 26;
            hash = hash + temp + "#";
        }
        return hash;
    }

    public static List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {

            String hash = getHash(strings[i]);

            if (map.containsKey(hash)) {
                map.get(hash).add(strings[i]);
            } else {
                List<String> words = new ArrayList<>();
                words.add(strings[i]);
                map.put(hash, words);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String str[] = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "aaa", "bbb", "pqr", "prtu"};
        System.out.println("Group Shifted Strings are : " + groupStrings(str));
    }
}
