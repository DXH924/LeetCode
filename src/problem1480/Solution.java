package problem1480;

import java.util.Arrays;

public class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}


class Test {
    public static void main(String[] args) {
        int[] nums = new int[] {1};
        System.out.println(Arrays.toString(new Solution().runningSum(nums)));
    }
}