/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k<2) return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode t = h;
        ListNode p = h;
        int count;
        while (true) {
            count = k;
            while (t != null && count > 0) {
                t = t.next;
                count--;
            }
            if (t == null) break;
            head = p.next;
            while (p.next != t) {
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next=t.next;
                t.next=temp;
            }
            p = head;
            t = head;
        }
        
        return h.next;
    }
}