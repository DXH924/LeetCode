package problem.problem83;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/309:22
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newList = head == null ? null : new ListNode(head.val);
        ListNode current = head, result = newList;
        while (current != null) {
           if (current.val != result.val) {
               ListNode newNode = new ListNode(current.val, null);
               result.next = newNode;
               result = result.next;
           }
           current = current.next;
        }
        return newList;
    }
}
