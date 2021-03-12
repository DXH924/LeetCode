package problem.problem8;
/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2319:26
 */
public class Solution {
    public int myAtoi(String s) {
        if (null == s || isBlank(s)) {
            return 0;
        }
        // 判断第一个非空字符
        int len = s.length();
        boolean isPositive = true;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '-') { // 如果第一个字符为负号
                isPositive = false;
                return atoi(s, i + 1, len, isPositive);
            } else if (c == '+') {
                return atoi(s, i + 1, len, isPositive);
            } else if (c >= '0' && c <= '9'){ // 如果第一个非空字符为数字
                return atoi(s, i, len, isPositive);
            } else if (c == ' ') { // 空格则跳过
                continue;
            } else {
                break;
            }
        }
        return 0;
    }

    // 判断s是否只包含空格
    public boolean isBlank(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    // 获取结果
    public int atoi(String s, int i, int len, boolean isPositive) {
        String num = "";
        if (isPositive) {
            num += '+';
        } else {
            num += '-';
        }
        for (int j = i; j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9'; j++) {
            num += s.charAt(j);
        }
        try {
            if (num.length() == 1) {
                return 0;
            }
            return Integer.parseInt(num);
        } catch (Exception e) {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
