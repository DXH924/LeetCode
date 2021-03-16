package problem.problem59;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 * @date 2021-03-15 21:01
 */
public class Solution {
    private static String UP = "up";
    private static String DOWN = "down";
    private static String RIGHT = "right";
    private static String LEFT = "left";

    private String direction = RIGHT;
    // 遍历顺序：右-下-左-上-----右-----
    public int[][] generateMatrix(int n) {
        int num = n * n;
        int row = n;
        int col = n;
        int[][] matrix = new int[row][col];
        // 当前最左行，最右行，最上行，最下行
        int leftLimit = 0;
        int rightLimit = col - 1;
        int upLimit = 0;
        int downLimit = row - 1;
        // 当前坐标
        int x = 0;
        int y = 0;
        int i = 1;
        while (i <= num) {
            if (direction.equals(RIGHT)) {
                if (y <= rightLimit) {
                    matrix[x][y] = i;
                    // System.out.print(matrix[x][y] + " ");
                    y++;
                    i++;
                } else {
                    y--;
                    x++;
                    direction = DOWN;
                    upLimit++;
                }
            } else if (direction.equals(DOWN)) {
                if (x <= downLimit) {
                    matrix[x][y] = i;
                    // System.out.print(matrix[x][y] + " ");
                    x++;
                    i++;
                } else {
                    x--;
                    y--;
                    direction = LEFT;
                    rightLimit--;
                }
            } else if (direction.equals(LEFT)) {
                if (y >= leftLimit) {
                    matrix[x][y] = i;
                    // System.out.print(matrix[x][y] + " ");
                    y--;
                    i++;
                } else {
                    y++;
                    x--;
                    direction = UP;
                    downLimit--;
                }
            } else if (direction.equals(UP)) {
                if (x >= upLimit) {
                    matrix[x][y] = i;
                    // System.out.print(matrix[x][y] + " ");
                    x--;
                    i++;
                } else {
                    x++;
                    y++;
                    direction = RIGHT;
                    leftLimit++;
                }
            }
        }
        return matrix;
    }
}

class Test {
    public static void main(String[] args) {
        new Solution().generateMatrix(3);
    }
}