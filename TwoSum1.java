//If we need to return the indices of the elements
import java.util.HashMap;
class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[] { map.get(temp), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int [] nums= {3,2,4};
        int target = 10;
        int result [] = twoSum(nums, target);
        System.out.println(result[0]+ " " + result[1]);
    }
}