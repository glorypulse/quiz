/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Map;
import java.util.HashMap;
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sumMap = new HashMap<Integer, ListNode>();
        int sum = 0, tmp_sum = 0;
        ListNode node = head, ret = head, tmp, tmp_head;
        sumMap.put(0, null);
        while (node != null) {
            sum += node.val;
            if (sumMap.containsKey(sum)) {
                tmp_head = sumMap.get(sum);
                if (tmp_head == null) { // headが変わる時
                    tmp = ret;
                } else {
                    tmp = tmp_head.next;
                }
                tmp_sum = sum;
                while (tmp != node) {
                    tmp_sum += tmp.val;
                    sumMap.remove(tmp_sum);
                    tmp = tmp.next;
                }
                if (tmp_head == null) {
                    ret = node.next;
                } else {
                    tmp_head.next = node.next;
                }
            } else {
                sumMap.put(sum, node);
            }
            node = node.next;
        }
        return ret;
    }
}
