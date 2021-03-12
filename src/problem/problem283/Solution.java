package problem.problem283;

public class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new Solution().moveZeroes(nums);
    }
}