package problem.problem219;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        boolean flag = false;
        while (i <= j) {
            if (nums[i] != nums[j]) {
                i++;
                j--;
            } else {
               if ((j - i) <= k) {
                   return true;
               } else {
                   if (nums[i + 1] ==nums[i]) {
                       i++;
                   }
                   if (nums[j - 1] == nums[j]) {
                       j--;
                   }
               }
            }
        }
        return false;
    }
}
//         i         j
// nums = [1,2,3,1,2,3], k = 2

class Test {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 1, 2, 3};
        int nums1[] = new int[]{1, 2, 3, 1};
        int nums2[] = new int[]{1, 0, 1, 1};
        new Solution().containsNearbyDuplicate(nums, 2);
    }
}
