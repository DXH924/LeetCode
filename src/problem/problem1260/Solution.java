package problem.problem1260;

import java.util.*;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        int length = row * col;
        int move = k % length;
        int[] temp = new int[length];
        int[] exchange = new int[move];
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[count++] = grid[i][j];
            }
        }
        for (int i = 0; i < move; i++) {
            exchange[i] = temp[length - move + i];
        }

        for (int i = length - 1; i >= move; i--) {
            // temp[8] = temp[5]
            temp[i] = temp[i - move];
        }
        for (int i = 0; i < move; i++) {
            temp[i] = exchange[i];
        }
        count = 0;
        for (int i = 0; i < row; i++) {
            List<Integer> subGrid = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                subGrid.add(temp[count++]);
            }
            result.add(subGrid);
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution().shiftGrid(grid, 3);
    }
}