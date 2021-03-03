package problem88;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/3010:19
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int[] result = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < m) {
            result[k++] = nums1[i++];
        }
        while (j < n) {
            result[k++] = nums2[j++];
        }
        for (i = 0; i < len; i++) {
            nums1[i] = result[i];
        }
    }
}
