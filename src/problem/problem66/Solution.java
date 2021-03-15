package problem.problem66;

import java.util.Arrays;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-15 21:12
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n + 1];
        // 无需进位
        if (digits[n - 1] < 9) {
            digits[n - 1]++;
            return digits;
        }
        digits[n - 1]++;
        for (int i = n - 1; i >= 1; i--) {
            if (digits[i] == 10) {
                // 需要进位
                digits[i] = 0;
                digits[i - 1]++;
            }
        }
        if (digits[0] == 10) {
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
class Test {
    public static void main(String[] args) {
        int[] digits = new int[]{1, 9, 9};
        System.out.println(Arrays.toString(new Solution().plusOne(digits)));
    }
}