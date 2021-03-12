package problem.problem83;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/309:23
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
