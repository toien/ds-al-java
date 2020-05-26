package ds.ag.sort;

/**
 * 排序算法的工具函数
 */
public class Base {

    /**
     * 交换 int 数组中索引为 i 和 j 两个元素
     */
    static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
