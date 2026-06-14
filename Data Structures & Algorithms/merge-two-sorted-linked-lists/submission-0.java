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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list1 == null && list2 != null) return list2;

        ListNode min;
        if (list1.val <= list2.val) {
            min = list1;
            list1 = list1.next;
        } else {
            min = list2;
            list2 = list2.next;
        }
        min.next = null;
        ListNode l3 = min;
        
        while (list1 != null || list2 != null) {
            if (list1 != null && (list2 == null || list1.val < list2.val)) {
                ListNode next = list1.next;
                l3.next = list1;
                l3 = l3.next;
                l3.next = null;
                list1 = next;
            } else {
                ListNode next = list2.next;
                l3.next = list2;
                l3 = l3.next;
                l3.next = null;
                list2 = next;
            }
        }


        return min;
    }
}