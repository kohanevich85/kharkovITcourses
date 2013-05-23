
public class FibonacciTreeUtils {

    static int count = 1;

    static TreeNode generateArg(int k) {

        if (k < 2) {
            return new TreeNode(k, null, null);
        } else {
            return new TreeNode(k, generateArg(k - 2), generateArg(k - 1));
        }
    }

    static TreeNode generateNum(int k) {

        if (k < 2) {
            return new TreeNode(count++, null, null);
        } else {
            return new TreeNode(count++, generateNum(k - 2), generateNum(k - 1));
        }
    }

    static TreeNode generateRes(int k) {

        if (k < 2) {
            return new TreeNode(k, null, null);
        } else {
            return new TreeNode(generateRes(k - 2).value + generateRes(k - 1).value, generateRes(k - 2), generateRes(k - 1));
        }
    }
}
