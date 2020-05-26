package ds.ag.sort;

import java.util.Arrays;

/**
 * 插入排序法
 */
public class InsertionSort extends Base {

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {

            // 类似冒泡排序，依次比较 i 左侧的元素
            for (int j = 0; j < i; j++) {
                // 如果比 i 小，则交换两者
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void sort_v2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;

            // 依次比较 i 左侧元素顺序是否正确
            while ((j >= 0) && (array[j] < array[j + 1])) {
                swap(array, j, j + 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 9, 19, 2, 4 };

        sort_v2(array);

        System.out.println(Arrays.toString(array));
    }
}
