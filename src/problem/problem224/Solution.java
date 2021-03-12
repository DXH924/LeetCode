package problem.problem224;

import java.util.Stack;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 尝试用递归来做
 * @date 2021-03-10 09:36
 */
public class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> ops = new Stack<Integer>();
        ops.push(1);
        int result = 0;
        int sign = 1;
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }

}

class Test {
    public static void main(String[] args) {
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        String s4 = "2147483647";
        String s5 = "((1+2)-(3-4))";
        String s6 = "((1+2)-4+6)";
        System.out.println(new Solution().calculate(s4));
    }
}