package problem.problem331;

import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] tree = preorder.split(",");
        int len = tree.length, i = 0;
        Stack<String> stack = new Stack<String>();
        while (i < len) {
            // 检测栈顶是否有两个连续的#
            mergeNode(stack);
            String node = tree[i];
            stack.push(node);
            i++;
        }
        mergeNode(stack);
        if (stack.size() == 1 && stack.pop().equals("#")) {
            return true;
        }
        return false;
    }

    void mergeNode(Stack<String> stack) {
        // 检测栈顶是否有两个连续的#
        while (stack.size() >= 3) {
            String node2 = stack.pop();
            String node1 = stack.pop();
            if (node1.equals("#") && node2.equals("#")&&!stack.peek().equals("#")) {
                stack.pop();
                stack.push("#");
            } else {
                stack.push(node1);
                stack.push(node2);
                break;
            }
        }
    }

}

class Test {
    public static void main(String[] args) {
        boolean result = new Solution().isValidSerialization("1,#,#,#,#");
        System.out.println(result);
    }
}
