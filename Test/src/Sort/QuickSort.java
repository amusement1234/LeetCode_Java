package sort;

public class QuickSort {

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                change(arr, counter, i);
                counter++;
            }
        }

        change(arr, pivot, counter);
        return counter;
    }

    private static void change(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}