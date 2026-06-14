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

 // 2 -> 4 -> 6 -> 8
 // 2 -> 4 -> 8 -> 6
 // start = 2, middle = 8, next = 6
 /*
 next = middle.next
 start.next = middle
 start = start.next
 start = start.next.next
 start.next = next
 */
 // 2 -> 8 -> 4 -> 6


// // 1 -> 2 -> 3 -> 4 -> 8 -> 7 -> 6 -> 5
// head = 1, cur = 1, prev = 4
// middle = prev.next
// head = 1, cur = 1, prev = 4, middle = 8
// // temp = 8 -> 7 -> 6 -> 5
// temp = middle
// // prev = 4 -> 7 -> 6 -> 5
// prev.next = middle.next
// // temp = 8 -> 2 -> 3 -> 4 -> 7 -> 6 -> 5
// temp.next = cur.next
// // cur = 1 -> 8 -> 2 -> 3 -> 4 -> 7 -> 6 -> 5
// cur.next = temp
// cur = cur.next.next
// // head = 1 -> 8 -> 2 -> 3 -> 4 -> 7 -> 6 -> 5
// // cur = 2 -> 3 -> 4 -> 7 -> 6 -> 5


// head = 1, cur = 2, prev = 4
// middle = prev.next
// head = 1, cur = 2, prev = 4, middle = 7
// // temp = 7 -> 6 -> 5
// temp = middle
// // prev = 4 -> 6 -> 5
// prev.next = middle.next
// // temp = 7 -> 3 -> 4 -> 6 -> 5
// temp.next = cur.next
// // cur = 2 -> 7 -> 3 -> 4 -> 6 -> 5
// cur.next = temp
// cur = cur.next.next


// desired: 1 -> 8 -> 2 -> 7 -> 3 -> 6 -> 4 -> 5

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
