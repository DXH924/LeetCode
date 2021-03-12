package problem.problem227;

import java.util.Stack;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-11 09:50
 */
public class Solution {
    public int calculate(String s) {
        int len = s.length(), i = 0;
        Stack<Character> op = new Stack<Character>();
        Stack<Integer> num = new Stack<Integer>();
        while (i < len) {
            char c = s.charAt(i);
            // 如果遇见空格，跳过
            if (c == ' ') {
                i++;
            }
            else if (isDigit(c)) { // 如果是数字，压数字栈
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                i++;
                while (i < len && isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                num.push(Integer.parseInt(sb.toString()));
                if (!op.isEmpty()) {
                    // 如果当前符号栈栈顶为乘除法，做乘除运算
                    if (op.peek() == '*') {
                        int num2 = num.pop(), num1 = num.pop();
                        num.push(num1 * num2);
                        op.pop();
                    } else if (op.peek() == '/') {
                        int num2 = num.pop(), num1 = num.pop();
                        num.push(num1 / num2);
                        op.pop();
                    }
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') { // 如果是运算符,压符号栈
                // 当前符号为加减法时，判断符号栈栈顶是否为加减号
                if ((c == '+' || c == '-') && !op.isEmpty()) { // 若此前为加减运算，则更新数字栈
                    if (op.peek() == '+') {
                        int num2 = num.pop(), num1 = num.pop();
                        num.push(num1 + num2);
                        op.pop();
                    } else if (op.peek() == '-') {
                        int num2 = num.pop(), num1 = num.pop();
                        num.push(num1 - num2);
                        op.pop();
                    }
                }
                op.push(c);
                i++;
            }
        }
        if (!op.isEmpty()) {
            int num2 = num.pop(), num1 = num.pop();
            if (op.peek() == '+') {
                return num1 + num2;
            } else if (op.peek() == '-') {
                return num1 - num2;
            } else if (op.peek() == '*') {
                return num1 * num2;
            } else {
                return num1 / num2;
            }
        } else {
            return num.pop();
        }
    }

    boolean isDigit(char c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
}


class Test {
    public static void main(String[] args) {
        String s = "13 + 24";
        System.out.println(new Solution().calculate(s));
    }
}