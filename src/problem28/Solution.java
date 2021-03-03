package problem28;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2311:35
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (null == needle || haystack.equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int result = i;
            boolean flag = true;
            for (int j = 0, k = i; j < needle.length() && k < haystack.length(); j++, k++) {
                char h = haystack.charAt(k), n = needle.charAt(j);
                if (h != n) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return result;
            }
        }
        return -1;
    }
}
