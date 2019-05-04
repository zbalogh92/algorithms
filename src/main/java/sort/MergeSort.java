package sort;

import static java.lang.System.arraycopy;

public class MergeSort {

    public int[] sort(int[] input) {
        int[] temp = new int[input.length];
        return sort(input, temp, 0, input.length - 1);
    }

    private int[] sort(int[] input, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return input;
        }

        int middlePoint = (leftStart + rightEnd) / 2;

        sort(input, temp, leftStart, middlePoint);
        sort(input, temp, middlePoint + 1, rightEnd);
        return merge(input, temp, leftStart, rightEnd);
    }

    private int[] merge(int[] input, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int leftPointer = leftStart;
        int rightPointer = rightStart;
        int index = leftStart;

        while (leftPointer <= leftEnd && rightPointer <= rightEnd) {

            if (input[leftPointer] <= input[rightPointer]) {
                temp[index] = input[leftPointer];
                leftPointer++;
            } else {
                temp[index] = input[rightPointer];
                rightPointer++;
            }
            index++;
        }

        arraycopy(input, leftPointer, temp, index, leftEnd - leftPointer + 1);
        arraycopy(input, rightPointer, temp, index, rightEnd - rightPointer + 1);
        arraycopy(temp, leftStart, input, leftStart, size);

        return input;
    }

}
