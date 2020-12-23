package csNote.Sort;

// 自顶向下归并排序
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public T[] sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }
}
