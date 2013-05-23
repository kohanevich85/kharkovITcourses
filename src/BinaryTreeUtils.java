
public class BinaryTreeUtils {

    static int sum(TreeNode root) {
        if (root != null) {
            int sum = root.value;
            if (root.left != null) {
                sum += sum(root.left);
            }
            if (root.right != null) {
                sum += sum(root.right);
            }
            return sum;
        } else {
            throw new NullPointerException();
        }
    }

    static int size(TreeNode root) {

        return root == null ? 0 : 1 + size(root.left) + size(root.right);

    }

    static int max(TreeNode root) {

        if (root != null) {
            int max = root.value;
            if (root.left != null) {
                int leftValue = max(root.left);
                if (max < leftValue) {
                    max = leftValue;
                }
            }
            if (root.right != null) {
                int rightValue = max(root.right);
                if (max < rightValue) {
                    max = rightValue;
                }
            }
            return max;
        } else {
            throw new NullPointerException();
        }
    }

    static int height(TreeNode root) {

        return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}