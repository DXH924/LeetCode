package problem.problem1183;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-08 17:25
 */
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int left = Math.min(start, destination);
        int right = Math.max(start, destination);
        int d1 = 0, d2 = 0;
        for (int i = 0; i <left; i++) {
            d1 += distance[i];
        }
        for (int i = left; i < right; i++) {
            d2 += distance[i];
        }
        for (int i = right; i < n; i++) {
            d1 += distance[i];
        }
        return Math.min(d1, d2);
    }
}

class Test {
    public static void main(String[] args) {
        int[] distance = new int[] {
                1, 2, 3, 4
        };
        System.out.println(new Solution().distanceBetweenBusStops(distance, 0, 3));
    }
}