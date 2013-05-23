
public class SelectionSort {

    public static void sort(int[] arr) {

        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int min = arr[barrier];
            for (int index = barrier + 1; index < arr.length; index++) {
                if (min > arr[index]) {
                    int tmp = min;
                    min = arr[index];
                    arr[index] = tmp;
                }
            }
            if (min < arr[barrier]) {
                arr[barrier] = min;
            }
        }
    }
}
