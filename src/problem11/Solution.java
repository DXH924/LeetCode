package problem11;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 12/22/20209:36 PM
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        while (left <= right) {
            area = Math.max(Math.min(height[left], height[right]) * (right - left), area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(height));
    }
}
