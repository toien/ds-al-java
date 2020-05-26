package ds.ag.sort;

import java.util.Arrays;

public class MergeSort {

    static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex + rightIndex < merged.length) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] > right[rightIndex]) {
                    merged[leftIndex + rightIndex] = right[rightIndex];
                    rightIndex += 1;
                } else {
                    merged[leftIndex + rightIndex] = left[leftIndex];
                    leftIndex += 1;
                }
            } else if (leftIndex < left.length) {
                merged[leftIndex + rightIndex] = left[leftIndex];
                leftIndex += 1;
            } else if (rightIndex < right.length) {
                merged[leftIndex + rightIndex] = right[rightIndex];
                rightIndex += 1;
            }
        }

        return merged;
    }

    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        int[] sortedLeft = sort(left);
        int[] sortedRight = sort(right);

        return merge(sortedLeft, sortedRight);
    }
}
