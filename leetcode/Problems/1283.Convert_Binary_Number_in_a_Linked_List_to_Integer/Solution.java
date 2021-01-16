/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode current = head;
        while (current != null) {
            ans *= 2;
            ans += current.val;
            current = current.next;
        }
        return ans;
    }
}
