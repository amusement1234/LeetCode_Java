package csNote.Sort;

//插入排序：每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--)
                swap(nums, j, j - 1);
        }
        return nums;
    }
}
