/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you
have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also
jewels.
Letters are case-sensitive, so "a" is considered a different type of stone from "A".

Constraints:
1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 */

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    //Using set to store the unique jewels. Then iterate stones to count the number of jewels
    //Time: O(n) space: O(n)
    public static int numJewelsInStones1(String jewels, String stones) {

        int count = 0;

        Set<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i)))
                count++;
        }
        return count;
    }

    //Iterating stones and jewels and check for each stone in jewel. Brute force
    //Time: O(n*m) Space:O(1)
    public static int numJewelsInStones2(String jewels, String stones) {
        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String jewels = "aA", stones = "aAAbbbb";
        System.out.println("Stones those are jewels : " + numJewelsInStones2(jewels, stones));

    }
}
