package problem303;

import java.util.HashMap;
import java.util.Map;

public class NumArray {

    private int[] nums;
    private int[] sums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        this.sums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
