package problem21;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/2916:28
 */
public class Test {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l1 = null;
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(new Solution().mergeTwoLists(l1, l2));
    }
}
