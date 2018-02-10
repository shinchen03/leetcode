class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            else {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;   
            }
        }
        return h.next;
    }
}