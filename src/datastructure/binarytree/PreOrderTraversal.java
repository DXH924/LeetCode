package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 二叉树前序遍历
 * @date 2021-03-12 10:41
 */
public class PreOrderTraversal {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // preOrder(root);
        preOrderByStack(root);
        return result;
    }

    // 二叉树递归前序遍历
    public void preOrder(TreeNode t) {
        if (t != null) {
            result.add(t.val);
            preOrder(t.left);
            preOrder(t.right);
        }
        return;
    }

    // 二叉树栈前序遍历
    public void preOrderByStack(TreeNode t) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (t != null || !stack.isEmpty()) {
            // 遇到新节点，压栈，并将节点值存入list
            while (t != null) {
                stack.push(t);
                result.add(t.val);
                t = t.left;
            }
            t = stack.pop().right;
        }
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = null;
        t.right = new TreeNode(2, new TreeNode(3, null, null), null);
        new PreOrderTraversal().preorderTraversal(t);
    }
}