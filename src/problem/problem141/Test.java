package problem.problem141;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/3011:39
 */
public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        //l4.next = l2;
        new Solution().hasCycle(l1);
    }
}
