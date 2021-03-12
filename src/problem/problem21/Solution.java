package problem.problem21;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2221:28
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }
        ListNode  current =  l1.val <= l2.val ? l1 : l2, result = current;
        while (null != l1 && null != l2) {
            if (current == l1) {
                l1 = l1.next;
            } else if (current == l2) {
                l2 = l2.next;
            }
            if (null != l1 && null !=l2) {
                current.next = l1.val <= l2.val ? l1 : l2;
                current = current.next;
            }
        }
        current.next = null == l1 ? l2 : l1;
        return result;
    }
}
