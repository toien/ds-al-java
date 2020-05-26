package ds.ag.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort extends Base {

    static void siftDown(int[] array, int startIndex, int endIndex) {
        int rootIndex = startIndex;

        while (true) {
            int childIndex = rootIndex * 2 + 1;
            if (childIndex > endIndex) {
                break;
            }

            int rightChildIndex = childIndex + 1;
            if (rightChildIndex <= endIndex && array[childIndex] < array[rightChildIndex]) {
                childIndex++;
            }

            if (array[rootIndex] < array[childIndex]) {
                swap(array, rootIndex, childIndex);
                rootIndex = childIndex;
            } else {
                break;
            }
        }
    }

    public static void sort(int[] array) {
        // heapify
        for (int i = (array.length - 1 ) / 2; i > 0 ; i--) {
            siftDown(array, i, array.length - 1);
        }

        System.out.println(Arrays.toString(array));

        // sort
        for (int j = array.length - 1; j > 0; j--) {
            swap(array, 0, j);
            siftDown(array, 0, j - 1);
        }
    }
}
