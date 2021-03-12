package problem.problem922;

import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int ou = 0, ji = 1;
        for (int i = 0; i < nums.length; i++) {
            // 若是偶数
            if (nums[i] % 2 == 0) {
                result[ou] = nums[i];
                ou += 2;
            }  else {
                result[ji] = nums[i];
                ji += 2;
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 4};
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(nums)));
    }
}