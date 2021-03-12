package problem.problem1535;

public class Solution {
    public int getWinner(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE, maxTemp = Integer.MIN_VALUE, maxIndex = 0;
        int winTimes = 0;
        int begin = 0, next = 1, end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        if (k >= maxIndex) {
            return maxValue;
        }
        while (next <= end) {
            if (arr[begin] > arr[next]) {
                if (arr[begin] > maxTemp) {
                    maxTemp = arr[begin];
                    winTimes = 1;
                } else if (arr[begin] == maxTemp){
                    winTimes++;
                }
            } else {
                if (arr[next] > maxTemp) {
                    maxTemp = arr[next];
                    begin = next;
                    winTimes = 1;
                } else if (arr[next] == maxTemp) {
                    winTimes++;
                }
            }
            next++;
            if (winTimes >= k) {
                return maxTemp;
            }
        }
        return maxValue;
    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {1,11,22,33,44,55,66,77,88,99};
        System.out.println(new Solution().getWinner(arr, 1000000000));
    }
}
