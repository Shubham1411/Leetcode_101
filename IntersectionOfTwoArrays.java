/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
unique and you may return the result in any order.
 */

import java.util.*;

public class IntersectionOfTwoArrays {

    //Approach 1: Using HashSet to store the unique elements of the nums1 and nums2. If overlaps then store in result
    //Time: O(n) 95 percentile, space:O(n+m)
    public static int[] intersection1(int[] nums1, int[] nums2) {

        //Store the unique elements of nums1 in HashSet S1
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }

        Set<Integer> s2 = new HashSet<>();
        for (int c : nums2) {
            if (s1.contains(c))
                //if overlaps, add to s2 set
                s2.add(c);
        }

        int[] res = new int[s2.size()];
        int j = 0;
        for (int c : s2) {
            res[j++] = c;
        }

        return res;
    }

    //Approach 2: Sort the arrays and then use 2 pointers to check the intersecting elements.
    ////Time: O(n) 95 percentile, space:O(1)
    public static int[] intersection2(int[] nums1, int[] nums2) {

        //Sort the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;
        List<Integer> intersection = new ArrayList<Integer>();

        int i = 0, j = 0, flag = -1;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {

                if (nums1[i] != flag) {
                    flag = nums1[i];
                    intersection.add(nums1[i]);
                }

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

    //Approach 3: Create a boolean array of size 1000 and using it to store the occurrence of the key
    ////Time: O(n) 100 percentile
    public static int[] intersection3(int[] nums1, int[] nums2) {

        boolean hashset[] = new boolean[1001];
        List<Integer> intersection = new ArrayList<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            hashset[nums1[i]] = true;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hashset[nums2[i]] == true) {
                intersection.add(nums2[i]);
                hashset[nums2[i]] = false;
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

        int nums1[] = {1, 2, 2, 1}, nums2[] = {2, 2};

        int result[] = intersection3(nums1, nums2);
        System.out.println("Intersection Array : ");
        for (int res : result)
            System.out.print(res + " ");
    }
}

