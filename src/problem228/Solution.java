package problem228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int p = 0;
        while (p < nums.length) {
            int start = p, end = start;
            while (end + 1 < nums.length && nums[end] + 1 == nums[end + 1]) {
                end++;
            }
            String range;
            if (end == start) {
                range = nums[start] + "";
            } else {
                range = nums[start] + "->" + nums[end];
            }
            result.add(range);
            p = end + 1;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int nums[] = new int[]{0};
        List<String> result = new Solution().summaryRanges(nums);
        for (String s : result) {
            System.out.println(s);
        }
    }
}