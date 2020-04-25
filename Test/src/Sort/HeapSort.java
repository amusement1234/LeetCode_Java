package sort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr.length == 0)
            return;
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            change(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && arr[left] > arr[largest])
            largest = left;
        if (left < length && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            change(arr, i, largest);
            heapify(arr, length, largest);
        }
    }

    private static void change(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}