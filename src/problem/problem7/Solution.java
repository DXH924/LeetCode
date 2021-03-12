package problem.problem7;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2211:48
 */
public class Solution {
    public int reverse(int x) {
        boolean positive = x >= 0;
        if (!positive) {
            x = Math.abs(x);
        }
        String source = String.valueOf(x);
        String target = new StringBuffer(source).reverse().toString();
        int result = 0;
        boolean flag = true;
        try {
            result = Integer.parseInt(target);
            if (!positive) {
                result = 0 - result;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag ? result : 0;
    }
}
