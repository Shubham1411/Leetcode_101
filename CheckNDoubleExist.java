import java.util.HashSet;
import java.util.Set;

/*
Given an array arr of integers, check if there exists two integers N and M such that N is the double
of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 */
public class CheckNDoubleExist {
    public static boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            //Check if double or half of arr[i] exist in the set
            if(set.contains(arr[i] * 2) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2))){
                return true;
            }
            //add new element to set
            set.add(arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int arr[] = {10,2,6,6};

        System.out.println("Double Exist : "+checkIfExist(arr));
    }
}
