/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
represented by strings.
You need to help them find out their common interest with the least list index sum. If there is a choice tie between
answers, output all of them with no order requirement. You could assume there always exists an answer.
 */

import java.util.*;

public class MinimumIndexSumOfTwoLists {

    //Approach: Using HashMap. Store the index of the 1st list and then iterate the 2nd list if it contains the elements
    //If true add there indices and compare for the minimum one.
    //Time: O(n) 99 percentile
    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map1 = new HashMap<>();
        List<String> result = new ArrayList<>();

        int i, minIndex = Integer.MAX_VALUE, min = 0;

        for (i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (i = 0; i < list2.length && i <= minIndex; i++) {
            if (map1.containsKey(list2[i])) {
                min = i + map1.get(list2[i]);
                if (min < minIndex) {
                    result.clear();
                    result.add(list2[i]);
                    minIndex = min;
                } else if (min == minIndex)
                    result.add(list2[i]);
            }
        }
        return result.toArray(new String[result.size()]);
        
    }

    public static void main(String[] args) {

        String list1[] = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String list2[] = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String result[] = findRestaurant(list1, list2);

        System.out.println("Common Restaurants :");
        for (String s : result)
            System.out.print(s + " ");
    }
}
