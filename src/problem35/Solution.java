package problem35;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2311:58
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if (target > nums[i]) {
                return i + 1;
            } else if (target == nums[i]) {
                return i;
            }
        }
        return 0;
    }
}
