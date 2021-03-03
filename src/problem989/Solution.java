package problem989;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2521:37
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int[] k = new int[5];
        int klen = 0, alen = A.length, kk = K;
        Stack<Integer> stack = new Stack<>();
        while (K > 0) {
            k[klen++] = K % 10;
            K /= 10;
        }

        if (alen == 0) {
            for (int i = 0; i < klen; i++) {
                stack.push(k[i]);
            }
            return stack2list(stack);
        }

        if (klen <= alen) {
            int carry = 0, i, j;
            for (i = alen - 1, j = 0; j < klen; j++, i--) {
                int sum = k[j] + A[i] + carry;
                stack.push(sum % 10);
                carry = sum >= 10 ? 1 : 0;
            }
            while (i >= 0) {
                int sum = A[i--] + carry;
                stack.push(sum % 10);
                carry = sum >= 10 ? 1 : 0;
            }
            if (carry == 1) {
                stack.push(1);
            }
            return stack2list(stack);
        } else {
            int result = 0, weight = 1;
            for (int i = alen - 1; i >= 0; i--) {
                result += (A[i] * weight);
                weight *= 10;
            }
            result += kk;
            while (result > 0) {
                stack.push(result % 10);
                result /= 10;
            }
            return stack2list(stack);
        }
    }

    public List<Integer> stack2list(Stack<Integer> stack) {
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
