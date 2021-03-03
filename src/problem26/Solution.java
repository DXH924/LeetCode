package problem26;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2920:08
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        for (int i = 1, x = nums[i - 1]; i < nums.length; i++) {
            if (x != nums[i]) {
                nums[len++] = nums[i];
                x = nums[i];
            }
        }
        return len;
    }
}
