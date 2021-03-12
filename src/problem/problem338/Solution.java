package problem.problem338;

import java.util.Arrays;

public class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        int p = 2, i;
        while (true) {
            int p2 = p * 2;
            for (i = p; i < p2 && i < num + 1; i++) {
                result[i] = result[i - p] + 1;
            }
            if (i > num) {
                break;
            }
            p *= 2;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(2)));
    }
}