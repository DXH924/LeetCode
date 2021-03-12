package problem.problem1552;

import java.util.Arrays;

/*
    n == position.length
    2 <= n <= 10^5
    1 <= position[i] <= 10^9
    所有 position 中的整数 互不相同 。
    2 <= m <= position.length

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/magnetic-force-between-two-balls
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private int remainBasket;
    private int distance;
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        this.remainBasket = m;
        this.distance = Integer.MAX_VALUE;
        setBall(0, position.length - 1, position);
        return distance;
    }

    /**
     * 放球
     * @param left position下标
     * @param right position下标
     * @param position
     */
    public void setBall(int left, int right, int[] position) {
        if (remainBasket == 0) {
            return;
        }
        int midValue = (position[left] + position[right]) / 2;
        int midIndex = (left + right) / 2;
        if (arrayContains(position, midValue)) { // 如果当前中点有篮子，放入磁力球并更新距离
            remainBasket--;
            // distance = Math.min(distance, Math.max())
        } else { // 如果当前中点没有篮子，寻找更长子区间的中点
            if (midValue - position[left] > position[right] - midValue) {
                setBall(left + 1, midIndex, position);
            } else {
                setBall(midIndex, right - 1, position);
            }
        }
        setBall(left, midIndex - 1, position);
        setBall(midIndex + 1, right, position);
    }

    public static boolean arrayContains(int[] positon, int target) {
        int a =  Arrays.binarySearch(positon, target);
        if(a > 0) {
            return true;
        }else {
            return false;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int position[] = new int[] {1,2,3,4,7};
        int m = 3;
        System.out.println(new Solution().maxDistance(position, m));
    }
}