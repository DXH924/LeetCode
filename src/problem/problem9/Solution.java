package problem.problem9;

import java.util.Stack;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2220:58
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int s = x, rev = 0, pow = 1;
        Stack<Integer> stack = new Stack<>();
        while (x > 0) {
            stack.push(x % 10);
            x /= 10;
        }
        while (!stack.isEmpty()) {
            rev = rev + stack.pop() * pow;
            pow *= 10;
        }
        return s == rev;
    }
}
