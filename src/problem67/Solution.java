package problem67;

import java.util.Stack;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/248:35
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) {
            return "0";
        } else if (a.equals("0") && !b.equals("0")) {
            return b;
        } else if (!a.equals("0") && b.equals("0")) {
            return a;
        }
        int alen = a.length(), blen = b.length();
        boolean carry = false;
        String low = "";
        char digit = '0';
        for (int i = alen - 1, j = blen - 1 ; i >= 0 && j >= 0; i--, j--) {
            char aa = a.charAt(i), bb = b.charAt(j);
            if (aa == '0' && bb == '0') {
                // 两数均为0，肯定不进位
                digit = carry ? '1' : '0';
                carry = false;
            } else if (aa == '1' && bb == '1') {
                // 两数均为1，肯定有进位
                digit = carry ? '1' : '0';
                carry = true;
            } else {
                // 两数相异，进位视情况而定
                digit = carry ? '0' : '1';
                carry = digit == '0' ? true : false;
            }
            low = digit + low;
        }
        // 高位数据处理
        String high = "";
        if (alen > blen) {
            high = a.substring(0, alen - blen);
        } else {
            high = b.substring(0, blen - alen);
        }
        high = carry ? plusOne(high) : high;
        return high + low;
    }

    public String plusOne(String str) {
        String result = "";
        int len = str.length(), i;
        for (i = len - 1; i >= 0; i--) {
            // 遇到第一个0时停止反转
            if (str.charAt(i) == '1') {
                result = "0" + result;
            } else {
                result = "1" + result;
                break;
            }
        }
        if (result == "" || result.charAt(0) == '0') {
            return "1" + result;
        }
        result = str.substring(0, i) + result;
        return result;
    }
}
