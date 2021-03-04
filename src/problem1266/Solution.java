package problem1266;

// [[1,1],[3,4],[-1,0]]
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int second = 0;
        for (int i = 0; i <points.length - 1; i++) {
            int step1 = Math.abs(points[i][0] - points[i + 1][0]);
            int step2 = Math.abs(points[i][1] - points[i + 1][1]);
            if (step1 < step2) {
                second += step2;
            } else {
                second += step1;
            }
        }
        return second;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] points = new int[][] {
                {1, 1}, {3, 4}, {-1, 0}
        };
        int[][] points1 = new int[][] {
                {3, 2}, {-2, 2}
        };
        System.out.println(new Solution().minTimeToVisitAllPoints(points1));
    }
}
