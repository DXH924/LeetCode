package datastructure.binarytree;

public class MaxDepth {
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        findDepth(root, maxDepth);
        return maxDepth;
    }

    public void findDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, depth + 1);
        findDepth(node.left, depth + 1);
        findDepth(node.right, depth + 1);
    }

    static class Test {
        public static void main(String[] args) {
            TreeNode tree = new TreeNode(3, new TreeNode(9, null, null),
                    new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
            System.out.println(new MaxDepth().maxDepth(tree));
        }
    }
}