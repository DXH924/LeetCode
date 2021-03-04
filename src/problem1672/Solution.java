package problem1672;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-04 15:53
 */
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0 ; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0 ; j <accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}

class Test {
    public static void main(String[] args) {
        int accounts[][] = new int[][] {
                {1, 2, 3},
                {3, 2, 1}
        };
        System.out.println(new Solution().maximumWealth(accounts));
    }
}