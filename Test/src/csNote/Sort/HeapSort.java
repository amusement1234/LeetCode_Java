package csNote.Sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    private T[] heap;
    private int n = 0;

    public HeapSort(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    // 上浮
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    // 下沉
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }

    public void insert(Comparable v) {
        heap[++n] = (T) v;
        swim(n);
    }

    public T delMax() {
        T max = heap[1];
        swap(1, n--);
        sink(1);
        return max;
    }

    /**
    * 数组第 0 个位置不能有元素
    */
    @Override
    public T[] sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--)
            sink(nums, k, N);

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
        return nums;
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1))
                j++;
            if (!less(nums, k, j))
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
}
