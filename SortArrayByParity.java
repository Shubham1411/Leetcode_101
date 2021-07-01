public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {

        /*int even=0,odd=nums.length-1,j=0;
        int res [] = new int[nums.length];

        while(even <= odd){
           if(nums[j] % 2 == 0)
               res[even++] = nums[j];

           else
               res[odd--] = nums[j];

           j++;
        }
       return res;*/

        //More optimized technique using 2-Pointers

        int i=0,j= nums.length-1;
        while(i<j) {
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            if (nums[i] % 2 == 0) i++;
            if (nums[j] % 2 == 1) j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int arr [] = {3,1,2,4};

        int res [] = sortArrayByParity(arr);

        System.out.println("Array after Modification");
        for(int i=0; i< res.length; i++)
            System.out.print(res[i] + " ");
    }
}
