package problem.problem2;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/229:44
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        ListNode last, temp = null;
        int carry = 0;
        while (null != l1 && null != l2) {
            int sum = l1.val + l2.val + carry;
            carry = sum >= 10 ? 1 : 0;
            ListNode newNode = new ListNode(sum % 10, null);
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
            temp = current;
        }
        last = null == l1 ? l2 : l1;
        if (last == null) {
            temp.next = carry == 1 ? new ListNode(1, null) : null;
            return result.next;
        }
        current = last;
        while (last != null) {
            int sum = last.val + carry;
            carry = sum >= 10 ? 1 : 0;
            last.val = sum % 10;
            if (last.next == null) {
                last.next = carry == 1 ? new ListNode(1, null) : null;
                break;
            }
            last = last.next;
        }
        temp.next = current;
        return result.next;
    }
}
