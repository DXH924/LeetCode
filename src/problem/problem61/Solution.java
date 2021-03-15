package problem.problem61;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 * @date 2021-03-15 14:40
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        int move = k % length;
        if (move == 0) {
            return head;
        }
        int left = length - move;
        ListNode newEnd = null, newHead = null, end = null;
        current = head;
        for (int i = 0; i < length; i++) {
            if (i == left - 1) {
                newEnd = current;
                if (newEnd.next != null) {
                    newHead = newEnd.next;
                }
            }
            if (i == length - 1) {
                end = current;
            }
            current = current.next;
        }
        end.next = head;
        newEnd.next = null;
        return newHead;
    }



}

class Test {
    public static void main(String[] args) {
        ListNode list = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode newList = new Solution().rotateRight(list, 4);
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
