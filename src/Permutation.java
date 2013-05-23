import java.util.Arrays;


public class Permutation {

    private static void permutation(int[] arr, int size) {
        if (size < 2) {
            System.out.println(Arrays.toString(arr));

        } else {
            for (int k = 0; k < size; k++) {
                permutation(arr, size - 1);
                if (k == size - 1) {
                    swap(arr, k, k - 1);
                } else {
                    swap(arr, k, size - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int index0, int index1) {
        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }
}
