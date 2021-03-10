package problem304;

public class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int i = matrix.length;
        if (i > 0) {
            int j = matrix[0].length;
            sumMatrix = new int[i][j + 1];
            for (int row = 0; row < i; row++) {
                for (int col = 0; col < j; col++) {
                    sumMatrix[row][col + 1] = sumMatrix[row][col] + matrix[row][col];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sumMatrix[i][col2 + 1] - sumMatrix[i][col1];
        }
        return sum;
    }

}
class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{

        };
        new NumMatrix(matrix);
    }
}