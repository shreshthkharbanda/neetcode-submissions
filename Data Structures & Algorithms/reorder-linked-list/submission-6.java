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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode cur = head;
        int length = 1;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }

        cur = head;
        ListNode middle = cur;
        for (int i = 0; i < length/2; i++) {
            middle = middle.next;
            if (i >= 1) cur = cur.next;
        }

        ListNode start = middle;
        ListNode cur2 = start;
        ListNode prev = start;
        while (cur2.next != null) {
            ListNode next = cur2.next;
            ListNode skip = next.next;
            cur2.next = skip;
            next.next = prev;
            prev = next;
        }
        cur.next = prev;

        prev = cur;
        cur = head;

        while (cur != null && cur.next != null) {
            middle = prev.next;
            ListNode temp = middle;
            prev.next = middle.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
    }
}
