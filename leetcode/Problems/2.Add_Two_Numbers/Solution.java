/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode ans = cur;
        int pre = 0;
        while (l1 != null || l2 != null) {
            int val = pre;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (val > 9) {
                pre = 1;
                val -= 10;
            } else {
                pre = 0;
            }

            cur.next = new ListNode(val);
            cur = cur.next;
        }
        if (pre > 0) {
            cur.next = new ListNode(pre);
        }
        ans = ans.next;
        return ans;
    }
}
