import java.util.Arrays;

public class InsertionSort {

    public static int[] sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int prevElement = arr[k - 1];
            int location = k - 1;
            if (newElement < prevElement) {
                int pos = Arrays.binarySearch(arr, 0, location, newElement);
                if (pos < 0) {

                    pos = pos * (-1) - 1;
                }
                System.arraycopy(arr, pos, arr, pos + 1, k - pos);
                arr[pos] = newElement;
            }
        }
        return arr;
    }
}
