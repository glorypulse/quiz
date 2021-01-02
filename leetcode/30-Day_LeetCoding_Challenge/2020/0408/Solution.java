/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size ++;
            node = node.next;
        }

        node = head;
        for (int i = 0; i < size / 2; i ++) {
            node = node.next;
        }

        return node;
    }
}
