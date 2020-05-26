package ds.ag.sort;

public class SelectionSort extends Base {
    public static void sort(int[] array) {
        int i, j;
        int minIndex;

        for (i = 0; i < array.length - 1; i++) {
            minIndex = i;

            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);
        }
    }
}
