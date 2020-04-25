package sort;

public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    //合并2个数组，left-mid，mid+1-right
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;//第一个数组left
        int j = mid + 1;//第二个数组left
        int k = 0;//temp的index
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
    // private int num = 0; // 全局变量或者成员变量

    // public int count(int[] a, int n) {
    //     num = 0;
    //     mergeSortCounting(a, 0, n - 1);
    //     return num;
    // }

    // private void mergeSortCounting(int[] a, int p, int r) {
    //     if (p >= r)
    //         return;
    //     int q = (p + r) / 2;
    //     mergeSortCounting(a, p, q);
    //     // mergeSortCounting(a, q + 1, r);
    //     merge(a, p, q, r);
    // }

    // private void merge(int[] a, int p, int q, int r) {
    //     System.out.println("p:" + p + ",q:" + q + ",r:" + r);
    //     int left = p, end = q + 1, tempIndex = 0;
    //     int[] tmp = new int[r - p + 1];
    //     while (left <= q && end <= r) {
    //         if (a[left] <= a[end]) {
    //             tmp[tempIndex++] = a[left++];
    //         } else {
    //             num += (q - left + 1); // 统计p-q之间，比a[j]大的元素个数
    //             tmp[tempIndex++] = a[end++];
    //         }
    //     }
    //     while (left <= q) { // 处理剩下的
    //         tmp[tempIndex++] = a[left++];
    //     }
    //     while (end <= r) { // 处理剩下的
    //         tmp[tempIndex++] = a[end++];
    //     }
    //     for (int i = 0; i <= r - p; ++i) { // 从tmp拷贝回a
    //         a[p + i] = tmp[left];
    //     }
    // }

    // public int numDecodings(String s) {
    //     if (s.length() == 0 || s.charAt(0) == '0')
    //         return 0;

    //     if (s.length() == 1)
    //         return 1;

    //     int dp1 = 1;
    //     int dp2 = 1;
    //     int result = 0;
    //     for (int i = 1; i < s.length(); i++) {
    //         int i1 = (s.charAt(i - 1) - 48) * 10 + (s.charAt(i) - 48);

    //         if (i1 == 0)
    //             return 0;

    //         if (i1 >= 10 && i1 <= 26) {
    //             result = dp1;
    //         }
    //         if (s.charAt(i) != '0') {
    //             result += dp2;
    //         }
    //         dp1 = dp2;
    //         dp2 = result;
    //         result = 0;
    //     }
    //     return dp2;

    // }
}