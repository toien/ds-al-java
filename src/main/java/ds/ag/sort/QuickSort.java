package ds.ag.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 快速排序法，又称分区交换排序 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为较小和较大的2个子序列，
 * 然后递归地排序两个子序列。
 * 
 * 平均时间复杂度: O(nlogn)
 * 
 */
public class QuickSort extends Base {

    static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, storeIndex); // 保证 storeIndex 左侧没有比 pivotValue 大的元素
                storeIndex++;               // 如果有 n 个元素比 pivotValue 小，storeIndex 则为 n
            }
        }

        swap(array, right, storeIndex);

        // storeIndex 是 pivot 元素应该待的索引
        return storeIndex;
    }

    /**
     * 原地 in-place
     * 
     * 平均空间复杂度: O(logn)
     */
    static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = (left + right) / 2;
        int pivotNewIndex = partition(array, left, right, pivotIndex);

        sort(array, left, pivotNewIndex - 1);
        sort(array, pivotNewIndex + 1, right);
    }

    /**
     * 3-way partition
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    static int[] partition_v2(int[] array, int left, int right) {
        int pivotIndex = (left + right) / 2;
        int pivotValue = array[pivotIndex];

        int lessIndex = left, equalIndex = left, greaterIndex = right;

        while (equalIndex != greaterIndex) {
            if (array[equalIndex] < pivotValue) {
                swap(array, equalIndex, lessIndex);
                equalIndex++;
                lessIndex++;
            } else if (array[equalIndex] > pivotIndex) {
                swap(array, equalIndex, greaterIndex);
                greaterIndex--;
            } else {
                equalIndex++;
            }
        }

        return new int[] { lessIndex, greaterIndex };
    }

    static void sort_v2(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] indices = partition_v2(array, left, right);

        sort(array, left, indices[0] - 1);
        sort(array, indices[1] + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = IntStream.generate(() -> new Random().nextInt(100)).limit(10).toArray();
        System.out.println("before: " + Arrays.toString(arr)); 

        sort(arr, 0, arr.length - 1);

        System.out.println("after: " + Arrays.toString(arr));        
    }

}
