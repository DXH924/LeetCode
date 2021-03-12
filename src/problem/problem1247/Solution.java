package problem.problem1247;

import java.util.Stack;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-09 16:57
 */
public class Solution {
    public String removeDuplicates(String S) {
        int len = S.length();
        if (len == 1) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        stack.push(S.charAt(len - 1));
        boolean isSkipped = false;
        // 记录栈顶元素
        char temp = stack.peek();
        for (int i = len - 2; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != temp) {
                if (isSkipped) {
                    stack.pop();
                    isSkipped = false;
                }
                stack.push(c);
                temp = c;
            } else {
                isSkipped = true;
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        new Solution().removeDuplicates("xaabbaca");
    }
}