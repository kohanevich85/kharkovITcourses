
public class Merger {

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex + bIndex != result.length) {

            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, aIndex + bIndex, result.length - bIndex - aIndex);
                return result;

            } else if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, aIndex + bIndex, result.length - bIndex - aIndex);
                return result;

            } else if (a[aIndex] < b[bIndex]) {
                result[aIndex + bIndex] = a[aIndex++];

            } else {
                result[aIndex + bIndex] = b[bIndex++];
            }
        }
        return result;
    }
}