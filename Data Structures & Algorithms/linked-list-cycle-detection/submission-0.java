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
    public boolean hasCycle(ListNode head) {
        if (head.next == null || head.next.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null) {
            if (fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) return true;
        }

        return false;
    }
}
