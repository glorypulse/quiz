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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddRoot = head;
        if (oddRoot == null) return null;
        ListNode evenRoot = null;
        if (head.next != null) {
            evenRoot = head.next;
        } else {
            return head;
        }

        ListNode odd = oddRoot, even = evenRoot;
        ListNode node = evenRoot.next;

        boolean isOdd = true;
        while (node != null) {
            if (isOdd) {
                odd.next = node;
                odd = odd.next;
            } else {
                even.next = node;
                even = even.next;
            }
            isOdd = !isOdd;
            node = node.next;
        }

        odd.next = evenRoot;
        if (even != null) {
            even.next = null;
        }

        return oddRoot;
    }
}
