/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
the number of elements in nums1 and nums2 respectively.
 */
public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int len = m + n;
        int nums3[] = new int[len];
        int i = 0, j = 0, k = 0;

        //Comparing and merging the 2 arrays
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        //If elements are remaining in nums1 copy all of them
        while (i < m) {
            nums3[k++] = nums1[i++];
        }

        //If elements are remaining in nums2 copy all of them
        while (j < n) {
            nums3[k++] = nums2[j++];
        }

        for (k = 0; k < m + n; k++) {
            nums1[k] = nums3[k];
        }
    }

    public static void main(String[] args) {

        int nums1[] = {1, 2, 3, 0, 0, 0}, m = 3, nums2[] = {2, 5, 6}, n = 3;

        merge(nums1, m, nums2, n);
    }
}
