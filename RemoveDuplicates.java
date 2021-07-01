//Program to delete duplicate elements from a sorted array
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int i=0,j=1;

        while(j<nums.length){
            if(nums[j] != nums[j-1])
                nums[++i] = nums[j];

            j++;
        }

        System.out.println("Array after removing duplicate elements");
        for(j=0; j<=i; j++)
            System.out.print(nums[j] + " ");

        System.out.println();

        return ++i;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,5,6,6};

        System.out.println(removeDuplicates(arr));
    }

}
