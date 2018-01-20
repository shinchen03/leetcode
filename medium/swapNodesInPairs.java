/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        while (p.next != null && p.next.next != null) {
            ListNode temp = p;
            p = p.next;
            temp.next = p.next;
            
            ListNode temp2 = p.next.next;
            p.next.next = p;
            p.next = temp2;
        }
        return h.next;
    }
}