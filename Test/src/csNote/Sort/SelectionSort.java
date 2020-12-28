package csNote.Sort;

//选择排序：从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(nums[j], nums[min]))
                    min = j;
            }
            swap(nums, i, min);
        }
        return nums;
    }
}
