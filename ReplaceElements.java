//Program to Replace Elements with Greatest Element on Right Side of each element in the array and replace last element with -1
public class ReplaceElements {

    public static int[] replaceElements(int[] arr) {

        int max = arr[arr.length-1], temp;

        arr[arr.length-1] = -1;

        for(int i=arr.length-2; i>=0; i--){
            temp = arr[i];
            arr[i] = max;

            if(temp > max)
                max = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {400};

        int res [] = replaceElements(arr);

        System.out.println("Array after Modification");
        for(int i=0; i<res.length; i++)
            System.out.print(res[i] + " ");
    }
}
