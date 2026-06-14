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

// 0 -> 1 -> 2 -> 3
// 3 -> 2 -> 1 -> 0

// 1 -> 0    2 -> 3
// 2 -> 1 -> 0    3
// 3 -> 2 -> 1 -> 0

// 0 -> 1 -> 2 -> 3
// prev = 0, cur = 0, next = 1, skip = 2
// 1 -> 0 -> 2 -> 3
// prev = 1, cur = 0, next = 2, skip = 3
// 2 -> 1 -> 0 -> 3
// prev = 2, cur = 0, next = 3, skip = null
// 3 -> 2 -> 1 -> 0


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode prev = cur;
        while (cur.next != null) {
            ListNode next = cur.next;
            ListNode skip = cur.next.next;

            next.next = prev;
            cur.next = skip;
            prev = next;
        }

        return prev;
    }

    private void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
