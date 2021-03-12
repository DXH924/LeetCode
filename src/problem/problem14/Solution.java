package problem.problem14;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2621:56
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int len = strs.length, shortest = Integer.MAX_VALUE, index = -1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (strs[i].length() < shortest) {
                shortest = strs[i].length();
                index = i;
            }
        }
        for (int j = 0; j < shortest; j++) {
            char c = ' ';
            for (int i = 0; i < len; i++) {
                c = strs[index].charAt(j);
                if (strs[i].charAt(j) != c) {
                    return stringBuffer.length() == 0 ? "" : stringBuffer.toString();
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.length() == 0 ? "" : stringBuffer.toString();
    }
}
