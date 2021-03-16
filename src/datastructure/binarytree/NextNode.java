package datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
 * @date 2021-03-14 21:11
 */
public class NextNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            // 读取当前层队列的元素个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 将当前节点的子节点加入队列
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i < size - 1) {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Test {
        public static void main(String[] args) {
            Node tree = new Node(1, new Node(2, new Node(4, null, null, null),
                    new Node(5, null, null, null), null),
                    new Node(3, new Node(6, null, null, null),
                            new Node(7, null, null, null), null), null);
            Node result = new NextNode().connect(tree);
            System.out.println();
        }
    }
}
