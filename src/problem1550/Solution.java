package problem1550;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-04 15:40
 */
public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while (i + 2 <= arr.length - 1) {
            if (arr[i] % 2 == 1) {
                if (arr[i + 1] % 2 == 1) {
                    if (arr[i + 2] % 2 == 1) {
                        return true;
                    } else {
                        i += 3;
                        continue;
                    }
                } else {
                    i += 2;
                    continue;
                }
            }
            i++;
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 6, 4, 1};
        int arr1[] = new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12};
        int arr2[] = new int[]{1, 1, 1};
        System.out.println(new Solution().threeConsecutiveOdds(arr2));
    }
}