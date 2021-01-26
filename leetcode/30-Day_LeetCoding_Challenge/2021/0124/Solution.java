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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list: lists) {
            if (list == null) continue;
            pq.offer(list);
        }
        ListNode dummy = new ListNode(0, null);
        ListNode node = dummy;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            node.next = top;
            if (top.next != null) {
                pq.offer(top.next);
            }
            node = node.next;
        }
        return dummy.next;
    }
}
