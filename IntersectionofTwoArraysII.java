/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear
as many times as it shows in both arrays, and you may return the result in any order.
 */

import java.util.*;

public class IntersectionofTwoArraysII {

    //Approach 1: Using Hashmap to store the frequency of numbers in nums1 and then iterating the nums2 and add to a
    // result list if count is more than 0 and then make count--
    //Time: O(n) space: O(n)
    public static int[] intersect1(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (int num : nums1)
            map1.put(num, map1.getOrDefault(num, 0) + 1);

        for (int num : nums2) {
            if (map1.get(num) != null && map1.get(num) > 0) {
                result.add(num);
                map1.put(num, map1.get(num) - 1);
            }
        }

        int res[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;

    }

    //Approach 2: Sort the arrays and then use 2 pointers to check the intersecting elements.
    ////Time: O(n) , space:O(1)
    public static int[] intersect2(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;
        List<Integer> intersection = new ArrayList<Integer>();

        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[intersection.size()];
        j = 0;
        for (int c : intersection) {
            res[j++] = c;
        }

        return res;
    }

    //Approach 3: Create a int array of size 1000 and using it to store frequency of numbers in nums1 and then
    // iterating the nums2 and add to a result list if count is more than 0 and then make count--
    //Time: O(n), 100 percentile space: O(n)
    public static int[] intersect3(int[] nums1, int[] nums2) {

        int[] count = new int[1001];

        for (int num : nums1)
            count[num]++;

        List<Integer> intersection = new ArrayList<Integer>();

        for (int num : nums2) {
            if (count[num] > 0) {
                intersection.add(num);
                count[num]--;
            }
        }

        int[] res = new int[intersection.size()];
        int j = 0;
        for (int c : intersection) {
            res[j++] = c;
        }

        return res;
    }

    public static void main(String[] args) {

        int nums1[] = {4, 9, 5}, nums2[] = {9, 4, 9, 8, 4};

        int result[] = intersect3(nums1, nums2);
        System.out.println("Intersection Array : ");
        for (int res : result)
            System.out.print(res + " ");
    }
}
