package problem.problem1047;

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
        char[] s = S.toCharArray();
        int len = s.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || s[i] != stack.peek()) {
                stack.push(s[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        for (Character c : stack) {
            str.append(c);
        }
        return str.toString();
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));

    }
}

