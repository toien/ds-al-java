package ds.ag.sort;

import java.util.Arrays;

/**
 * 冒泡排序法
 */
public class BubbleSort extends Base {

    static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[i] < array[k]) {
                    swap(array, i, k);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 14, 5, 100, 2, 3 };

        sort(array);

        System.out.println(Arrays.toString(array));
    }
}
