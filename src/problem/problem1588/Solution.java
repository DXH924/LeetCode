package problem.problem1588;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-04 14:50
 */
public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, arrLen = arr.length;
        for (int i = 1; i <= arrLen; i += 2) { // i为子数组长度
            // 子数组个数
            int subArrNum = arrLen - i + 1;
            for (int j = 0; j < subArrNum; j++) {
                for (int k = j; k < i + j; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

}

class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 5, 3};
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{10, 11, 12};
        int[] arr3 = new int[]{1};
        new Solution().sumOddLengthSubarrays(arr);
        new Solution().sumOddLengthSubarrays(arr1);
        new Solution().sumOddLengthSubarrays(arr2);
        new Solution().sumOddLengthSubarrays(arr3);
    }
}