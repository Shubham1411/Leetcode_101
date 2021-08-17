import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

/*
PROBLEM: Unique Word Abbreviation
The abbreviation of a word is a concatenation of its first letter, the number of characters between the first
and last letter, and its last letter. If a word has only two characters, then it is an abbreviation of itself.
For example:
dog --> d1g because there is one letter between the first letter 'd' and the last letter 'g'.
internationalization --> i18n because there are 18 letters between the first letter 'i' and the last letter 'n'.
it --> it because any word with only two characters is an abbreviation of itself.
Implement the ValidWordAbbr class:
ValidWordAbbr(String[] dictionary) Initializes the object with a dictionary of words.
boolean isUnique(string word) Returns true if either of the following conditions are met (otherwise returns false):
There is no word in dictionary whose abbreviation is equal to word's abbreviation.
For any word in dictionary whose abbreviation is equal to word's abbreviation, that word and word are the same.
 */

//Approach: Using HashMap and HashSet to maintain the key and the set of words
//Time: 1901 ms, 99 percentile
public class UniqueWordAbbreviation {

    Map<String, Set<String>> dict;

    public UniqueWordAbbreviation(String[] dictionary) {

        dict = new HashMap<>();

        for (String str : dictionary) {

            String key = getHash(str);
            if (dict.containsKey(key)) {
                dict.get(key).add(str);
            } else {
                Set<String> t = new HashSet<>();
                t.add(str);
                dict.put(key, t);
            }

        }
    }

    //Method to get hashed key for the word
    public String getHash(String str) {
        int len = str.length();
        if (len <= 2) {
            return str;
        } else {
            String hash = str.charAt(0) + Integer.toString(len - 2) + str.charAt(len - 1);
            return hash;
        }
    }

    public boolean isUnique(String word) {

        String key = getHash(word);
        //If word is not in dict return false, if its present check the size of the set
        if (!dict.containsKey(key))
            return true;
        else
            return dict.get(key).contains(word) && dict.get(key).size() <= 1;
    }

    public static void main(String[] args) {

        String dictionary[] = {"deer", "door", "cake", "card"};
        UniqueWordAbbreviation obj = new UniqueWordAbbreviation(dictionary);
        System.out.println("Is Unique : " + obj.isUnique("cane"));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */