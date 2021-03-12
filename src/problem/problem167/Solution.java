package problem.problem167;

// numbers = [2,7,11,15], target = 9
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] numbers = new int[] {2, 7, 11, 15};
    }
}