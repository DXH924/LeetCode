package interview0106;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2410:53
 */
public class Solution {
    public String compressString(String S) {
        if (null == S || S.length() == 0) {
            return S;
        }
        StringBuffer result = new StringBuffer();
        int len = S.length(), count = 1;
        char pre = S.charAt(0);
        for (int i = 0; i < len - 1; i++) {
            char current = S.charAt(i + 1);
            if (current != pre) {
                result.append(pre);
                result.append(count);
                count = 0;
                pre = current;
            }
            count++;
        }
        result.append(pre);
        result.append(count);
        return result.length() > S.length() ? S : result.toString();
    }
}
