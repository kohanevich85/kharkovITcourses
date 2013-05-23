
public class BubbleSort {

    static void bubbleSortDrown(int[] arr) {

        for (int barrier = 0; barrier < arr.length; barrier++) {
            for (int index = arr.length - 1; index > barrier; index--) {
                if (arr[index] < arr[index - 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = tmp;
                }
            }
        }
    }
}
