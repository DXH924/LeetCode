package problem92;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description:
 * @date 2021-03-08 10:03
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置空的头节点listHead
        ListNode listHead = new ListNode();
        listHead.next = head;
        // 设置当前指针p
        ListNode p = listHead;
        // 先找start的前驱节点
        ListNode startPre;
        for (int i = 1; i < left; i++) {
            p = p.next;
        }
        startPre = p;
        p = p.next;
        // 对从startPre的next开始经过right - left + 1个节点逆置
        ListNode reverseList = new ListNode(p.val);
        // 标记reverseList的尾节点
        ListNode end = reverseList;
        for (int i = 0; i < right - left; i++) {
            p = p.next;
            ListNode newNode = new ListNode(p.val);
            newNode.next = reverseList;
            reverseList = newNode;
        }
        // 将reverseList并入原链表
        startPre.next = reverseList;
        // 找到end的后继节点
        end.next = p.next;
        return listHead.next;
    }
}

class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(new Solution().reverseBetween(head, 1, 6));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}