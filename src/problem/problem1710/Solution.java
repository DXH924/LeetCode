package problem.problem1710;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-03 18:59
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length, half = length / 2;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (count.get(nums[i]) == null) {
                count.put(nums[i], 1);
            } else {
                int freq = count.get(nums[i]) + 1;
                if (freq > half) {
                    return nums[i];
                }
                count.put(nums[i], freq);
            }
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        int a[] = new int[] {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(a));
    }
}