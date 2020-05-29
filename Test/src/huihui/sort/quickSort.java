package huihui.sort;

//快速排序
public class quickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        int pirotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pirotIndex - 1);
        quickSort(arr, pirotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && arr[right] > pivot)
                right--;
            while (left < right && arr[left] < pivot)
                left++;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}