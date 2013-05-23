/**
 * Created with IntelliJ IDEA.
 * User: eugene
 * Date: 5/23/13
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Invert {

    static void invert(int[] arr) {

        for (int k = (arr.length - 2) / 2; k >= 0; k--) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
    }
}
