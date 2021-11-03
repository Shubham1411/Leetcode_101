public class QuickSort {

    public static void sortArray(int[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int begin, int end) {

        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 2, 8, 7, 6, 1};

        sortArray(arr);

        System.out.println("The Sorted array is : ");
        for (int num : arr)
            System.out.print(num + " ");
    }
}
