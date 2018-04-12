/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        int lenA = helper(headA);
        int lenB = helper(headB);
        while (lenA > lenB) {
            pa = pa.next;
            lenA--;
        }
        while (lenB > lenA) {
            pb = pb.next;
            lenB--;
        }
        while (pa != pb) {
            if (pa.next == null || pb.next == null) return null;
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
    
    public int helper(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}