package problem.problem268;

import java.util.Arrays;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-04 16:00
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        // 最大乘积-3个正数，2个负数1个整数，3个负数
        // 如果最大值非正或最小值非负
        if (nums[j] <= 0 || nums[i] >= 0) {
            return nums[j] * nums[j - 1] * nums[j - 2];
        }
        // 有正有负
        int a = nums[i] * nums[i + 1], b = nums[j - 1] * nums[j];
        return Math.max(a * nums[j], b *nums[j - 2]);
    }
}

class Test {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3};
        int nums1[] = new int[]{1, 2, 3, 4};
        int nums2[] = new int[]{-1, -2, -3};
        int nums3[] = new int[]{-8, -7, -2, 10, 20};
        System.out.println(new Solution().maximumProduct(nums));
        System.out.println(new Solution().maximumProduct(nums1));
        System.out.println(new Solution().maximumProduct(nums2));
        System.out.println(new Solution().maximumProduct(nums3));
    }
}