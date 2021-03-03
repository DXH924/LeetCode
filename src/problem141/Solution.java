package problem141;

import java.util.HashMap;

/**
 * @author dxh924
 * @Title:
 * @Package
 * @Description:
 * @date 2020/10/3011:39
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashMap<Integer, ListNode> listMap = new HashMap<>();
        int pos = 0;
        while (head.next != null) {
            if (!listMap.containsValue(head)) {
                listMap.put(pos++, head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}
