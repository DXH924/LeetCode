package problem.problem58;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2920:23
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length(), count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                for (int j = i; j >= 0; j--) {
                    if (s.charAt(j) != ' ') {
                        count++;
                    } else {
                        return count;
                    }
                }
                return count;
            }
        }
        return 0;
    }
}
