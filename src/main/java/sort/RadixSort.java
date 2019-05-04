package sort;

import static java.lang.System.arraycopy;
import static java.util.Arrays.stream;

public class RadixSort {

    private static final int RADIX = 10;

    public void sort(int[] array) {
        if (array.length == 0) {
            return;
        }

        int max = stream(array)
                .max()
                .getAsInt();

        // Perform counting sort on each exponent/digit, starting at the least significant digit
        int exponent = 1;
        while (max / exponent >= 1) {
            countingSort(array, exponent);
            exponent *= RADIX;
        }
    }

    private void countingSort(int[] array, int exponent) {
        int[] buckets = new int[RADIX];
        int[] temp = new int[array.length];

        // Count frequencies
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = ((array[i]) / exponent) % RADIX;
            buckets[bucketIndex]++;
        }

        // Cumulate
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }

        // Move records
        for (int i = array.length - 1; i >= 0; i--) {
            int bucketIndex = (((array[i]) / exponent) % RADIX);
            temp[--buckets[bucketIndex]] = array[i];
        }

        arraycopy(temp, 0, array, 0, array.length);
    }

}
