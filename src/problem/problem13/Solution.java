package problem.problem13;

import java.util.HashMap;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2916:13
 */
public class Solution {
    public static HashMap<Character, Integer> roman = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);

        }
    };
    public int romanToInt(String s) {
        int result = 0, len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            result += roman.get(c);
        }
        return result;
    }
}
