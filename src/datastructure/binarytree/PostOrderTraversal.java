package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 二叉树后序遍历
 * @date 2021-03-12 11:34
 */
public class PostOrderTraversal {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return result;
    }

    // 二叉树递归后序遍历
    public void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            result.add(t.val);
        }
        return;
    }
}

class Test3 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = null;
        t.right = new TreeNode(2, new TreeNode(3, null, null), null);
        new PostOrderTraversal().postorderTraversal(t);
    }
}