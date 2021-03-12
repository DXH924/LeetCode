package problem.problem2;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/229:50
 */
public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5, null);
        ListNode l2 = new ListNode(5, null);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}
