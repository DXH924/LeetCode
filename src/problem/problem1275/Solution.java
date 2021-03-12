package problem.problem1275;

public class Solution {
    public String tictactoe(int[][] moves) {
        int turn = 0; // 0-A走，X // 1-B走，O
        char A = 'X', B = 'O';
        char[][] map = new char[][] {
            {'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}
        };
        for (int i = 0; i < moves.length; i++) {
            if (turn == 0) { // A走
                map[moves[i][0]][moves[i][1]] = A;
                turn = 1;
            } else { // B走
                map[moves[i][0]][moves[i][1]] = B;
                turn = 0;
            }
        }
        // 判断行
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == map[i][1] && map[i][0] == map[i][2] && map[i][1] == map[i][2]) {
                if (map[i][0] == A) {
                    return "A";
                } else if (map[i][0] == B){
                    return "B";
                }
            }
        }
        // 判断列
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == map[1][i] && map[0][i] == map[2][i] && map[1][i] == map[2][i]) {
                if (map[0][i] == A) {
                    return "A";
                } else if (map[0][i] == B){
                    return "B";
                }
            }
        }
        // 判断主对角线
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] == map[2][2]) {
            if (map[0][0] == A) {
                return "A";
            } else if (map[0][0] == B){
                return "B";
            }
        }
        // 判断次对角线
        if (map[0][2] == map[1][1] && map[0][2] == map[2][0] && map[1][1] == map[2][0]) {
            if (map[0][2] == A) {
                return "A";
            } else if (map[0][2] == B) {
                return "B";
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == '-')
                    return "Pending";
            }
        }
        return "Draw";
    }
}

class Test {
    public static void main(String[] args) {
        int[][] moves = new int[][] {
                {0, 0},
                {2, 0},
                {1, 1},
                {2, 1},
                {2, 2}
        };
        System.out.println(new Solution().tictactoe(moves));
    }
}