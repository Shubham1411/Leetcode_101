//Program to check if the given integer Array is a valid Mountain Array
public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr) {
        int i = 0, len = arr.length;

        if (len < 3)
            return false;

        while (i < len - 1 && arr[i + 1] > arr[i])
            i++;

        if (i + 1 == len || i == 0)
            return false;

        while (i < len - 1 && arr[i] > arr[i + 1])
            i++;

        return i + 1 == len;
    }

    public static void main(String[] args) {
        int arr [] = {0,3,2,1,1};

        System.out.println(validMountainArray(arr));
    }
}
