/*
Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a
particular value.
Implement the TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it
returns false.

Example 1:
Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false

Constraints:
-105 <= number <= 105
-231 <= value <= 231 - 1
At most 104 calls will be made to add and find.
 */

import java.util.Map;
import java.util.HashMap;

//Approach : Using HashMap to store the values.
//Time: 1418 ms, 97 percentile
public class TwoSum3 {

    Map<Integer, Integer> numbers;

    //Initialize your data structure here
    public TwoSum3() {
        numbers = new HashMap<>();
    }

    //Add the number to an internal data structure
    public void add(int number) {
        numbers.put(number, numbers.getOrDefault(number, 0) + 1);
    }

    //Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        int diff;
        for (int num : numbers.keySet()) {
            diff = value - num;
            if (numbers.containsKey(diff)) {
                if (diff != num || numbers.get(diff) > 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        TwoSum3 obj = new TwoSum3();
        obj.add(1);
        obj.add(3);
        obj.add(5);
        System.out.println(obj.find(4));
        System.out.println(obj.find(7));
    }

}
