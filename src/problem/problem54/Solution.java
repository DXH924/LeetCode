package problem.problem54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 * @date 2021-03-15 10:01
 */
public class Solution {
    private static String UP = "up";
    private static String DOWN = "down";
    private static String RIGHT = "right";
    private static String LEFT = "left";

    private String direction = RIGHT;
    // 遍历顺序：右-下-左-上-----右-----
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        // 当前最左行，最右行，最上行，最下行
        int leftLimit = 0;
        int rightLimit = col - 1;
        int upLimit = 0;
        int downLimit = row - 1;
        // 当前坐标
        int x = 0;
        int y = 0;
        while (leftLimit <= rightLimit && upLimit <= downLimit) {
            if (direction.equals(RIGHT)) {
                if (y <= rightLimit) {
                    result.add(matrix[x][y]);
                    // System.out.print(matrix[x][y] + " ");
                    y++;
                } else {
                    y--;
                    x++;
                    direction = DOWN;
                    upLimit++;
                }
            } else if (direction.equals(DOWN)) {
                if (x <= downLimit) {
                    result.add(matrix[x][y]);
                    // System.out.print(matrix[x][y] + " ");
                    x++;
                } else {
                    x--;
                    y--;
                    direction = LEFT;
                    rightLimit--;
                }
            } else if (direction.equals(LEFT)) {
                if (y >= leftLimit) {
                    result.add(matrix[x][y]);
                    // System.out.print(matrix[x][y] + " ");
                    y--;
                } else {
                    y++;
                    x--;
                    direction = UP;
                    downLimit--;
                }
            } else if (direction.equals(UP)) {
                if (x >= upLimit) {
                    result.add(matrix[x][y]);
                    // System.out.print(matrix[x][y] + " ");
                    x--;
                } else {
                    x++;
                    y++;
                    direction = RIGHT;
                    leftLimit++;
                }
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println(new Solution().spiralOrder(matrix));
    }
}