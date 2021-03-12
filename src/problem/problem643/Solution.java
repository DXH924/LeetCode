package problem.problem643;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-08 09:22
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int subSum = 0;
        for (int i = 0; i < k; i++) {
            subSum += nums[i];
        }
        int maxSum = subSum;
        for (int i = k; i < len; i++) {
            subSum = subSum - nums[i - k] + nums[i];
            maxSum = Math.max(subSum, maxSum);
        }
        return maxSum * 1.0 / k;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = new int[] {
                0 , 3, 32, 4, 5

        };
        System.out.println(new Solution().findMaxAverage(nums, 1));
    }
}