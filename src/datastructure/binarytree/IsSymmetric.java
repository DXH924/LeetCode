package datastructure.binarytree;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(right.left, left.right);
    }
}
