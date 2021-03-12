package problem.problem17;

import java.util.*;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-03 15:49
 */
public class Solution {
    public List<String> result = new ArrayList<>();
    int index[][] = {
        {3}, {3}, {3}, {3}, {3}, {4}, {3}, {4}
    };

    public List<String> letterCombinations(String digits) {
        return null;
    }

    static String digitMap[][] = new String[][]{
            {"a", "b", "c"}, // 2
            {"d", "e", "f"}, // 3
            {"g", "h", "i"}, // 4
            {"j", "k", "l"}, // 5
            {"m", "n", "o"}, // 6
            {"p", "q", "r", "s"}, // 7
            {"t", "u", "v"}, // 8
            {"w", "x", "y", "z"} // 9
    };

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(digitMap[i]));
        }
    }


}