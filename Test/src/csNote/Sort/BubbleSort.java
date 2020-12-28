package csNote.Sort;

//冒泡排序：从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public T[] sort(T[] nums) {
        int n = nums.length;
        boolean isSorted = false;
        for (int i = n - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j + 1, j);
                }
            }
        }
        return nums;
    }
}