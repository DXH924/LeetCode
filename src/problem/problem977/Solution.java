package problem.problem977;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-04 11:44
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        while (i <= j) {
            int a = nums[i] * nums[i], b = nums[j] * nums[j];
            result[k] = Math.max(a, b);
            if (a > b) {
                i++;
            } else {
                j--;
            }
            k--;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int nums[] = new int[] {-4, -1, 0, 3, 10};
        int nums1[] = new int[] {-7, -3, 2, 3, 11};
        int nums2[] = new int[] {9};
        int nums3[] = new int[] {-1};
        int nums4[] = new int[] {-5, -3, -2, -1};
        new Solution().sortedSquares(nums3);
    }
}