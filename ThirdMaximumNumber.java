/*
Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return
the maximum number.
 */
import java.util.*;
public class ThirdMaximumNumber {
    public static int thirdMax(int[] a) {

        Set <Integer> maxElements = new HashSet <>();

        for(int element : a)
        {
            //Adding the elements to the set
            maxElements.add(element);

            //Removing the minimum element if the size of the set is more than 3
            if(maxElements.size() > 3)
                maxElements.remove(Collections.min(maxElements));
        }

        //Returning the 3rd largest element
        if(maxElements.size() == 3)
            return Collections.min(maxElements);

        //Else return the largest element
        return Collections.max(maxElements);

    }

    public static void main(String[] args) {

        int arr [] = {1,4,6,2,8,1,4,3};

        System.out.println(thirdMax(arr));
    }
}
