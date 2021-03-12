package datastructure.binarytree;

import java.util.*;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 二叉树层序遍历
 * @date 2021-03-12 11:34
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode t = root;
        queue.add(t);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                t = queue.remove();
                layer.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            result.add(layer);
        }
        return result;
    }
}

class Test4 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3, new TreeNode(9, new TreeNode(5, null, null), null),
                new TreeNode(20, new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        new LevelOrderTraversal().levelOrder(null);
    }
}