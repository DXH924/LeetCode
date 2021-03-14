package datastructure.binarytree;

public class HasPathSum {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        preOrder(root, 0, targetSum);
        return flag;
    }

    // 二叉树递归前序遍历，
    public void preOrder(TreeNode t, int currentSum, int targetSum) {
        if (t != null) {
            currentSum += t.val;
            if (currentSum == targetSum && t.left == null && t.right == null) {
                flag = true;
                return;
            }
            preOrder(t.left, currentSum, targetSum);
            preOrder(t.right, currentSum, targetSum);
        }
    }

    static class Test {
        public static void main(String[] args) {
            TreeNode tree = new TreeNode(3, new TreeNode(9, null, null),
                    new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
            System.out.println(new HasPathSum().hasPathSum(tree, 12));
        }
    }
}
