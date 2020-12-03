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
    ListNode head, node;
    int prevIndex, size;
    Random random;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;

        this.node = head;
        this.prevIndex = 0;
        this.size = -1;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int index = random.nextInt(Integer.MAX_VALUE);
        if (size > 0) {
            index %= size;
        }
        if (index < prevIndex) {
            prevIndex = 0;
            node = head;
        }
        int i = prevIndex;
        while (i < index) {
            node = node.next;
            if (node == null) {
                size = i + 1;
                index %= size;
                i = 0;
                node = head;
            } else {
                i ++;
            }
        }
        prevIndex = i;
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
