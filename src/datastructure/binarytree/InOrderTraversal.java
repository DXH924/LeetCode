package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 二叉树中序遍历
 * @date 2021-03-12 11:17
 */
public class InOrderTraversal {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrderByStack(root);
        return result;
    }

    // 二叉树递归中序遍历
    public void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            result.add(t.val);
            inOrder(t.right);
        }
        return;
    }

    public void inOrderByStack(TreeNode t) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            result.add(stack.peek().val);
            t = stack.pop().right;
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = null;
        t.right = new TreeNode(2, new TreeNode(3, null, null), null);
        new InOrderTraversal().inorderTraversal(t);
    }
}