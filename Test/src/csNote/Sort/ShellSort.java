package csNote.Sort;

//希尔排序：对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。

public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        int n = nums.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
        return nums;
    }
}
