package problem.problem832;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-04 15:15
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length, col = image[0].length;
        for (int i = 0; i < row; i++) {
            // 水平翻转
            for (int j = 0; j < col / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][col - j - 1];
                image[i][col - j - 1] = temp;
            }
            // 反转图片
            for (int j = 0; j < col; j++) {
                image[i][j] = image[i][j] == 1 ? 0 : 1;
            }
        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(image[i][j] + " ");
//            }
//            System.out.println();
//        }
        return image;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] image = new int[][] {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        new Solution().flipAndInvertImage(image);
    }
}