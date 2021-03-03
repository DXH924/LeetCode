package problem70;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2921:47
 */
public class Solution {
    public int climbStairs(int n) {
        int[] result = new int[10000];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < 9998; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
