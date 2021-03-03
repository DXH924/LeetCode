package problem83;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/309:22
 */
public class Test {
    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode l1 = null;
        System.out.println(new Solution().deleteDuplicates(l));
    }
}
