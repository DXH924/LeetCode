package problem867;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-03 18:29
 */
public class Test {
    public static void main(String[] args) {
        int matrix[][] = new int[][] {
                {2, 4, -1},
                {-10, 5, 11},
        };
        int result[][] = new Solution().transpose(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}