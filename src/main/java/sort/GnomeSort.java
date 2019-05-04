package sort;

public class GnomeSort {

    public int[] sort(int[] arrayToSort) {

        int temp;
        int index = 0;

        while (index < arrayToSort.length) {
            if (index == 0) {
                index++;
            } else if (arrayToSort[index] < arrayToSort[index - 1]) {
                temp = arrayToSort[index];
                arrayToSort[index] = arrayToSort[index - 1];
                arrayToSort[index - 1] = temp;
                index--;
            } else {
                index++;
            }
        }
        return arrayToSort;
    }
}
