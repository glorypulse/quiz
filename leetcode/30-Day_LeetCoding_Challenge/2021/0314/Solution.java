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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        int check = k - 1;
        Queue<ListNode> queue = new LinkedList<>();
        head = dummy;
        ListNode fromNode = dummy;
        while (head != null) {
            if (check == 0) {
                fromNode = head;
            }

            queue.offer(head);
            if (queue.size() > k + 1) {
                queue.poll();
            }

            head = head.next;
            check --;
        }

        ListNode toNode = queue.poll();
        swapNext(fromNode, toNode);
        swapNext(fromNode.next, toNode.next);

        return dummy.next;
    }


    void swapNext(ListNode fromNode, ListNode toNode) {
        ListNode tmp = fromNode.next;
        fromNode.next = toNode.next;
        toNode.next = tmp;
    }
}
