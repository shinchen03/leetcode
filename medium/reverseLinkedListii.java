class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        int i=1;
        while(cur != null && i < m) {
            cur = cur.next;
            pre = pre.next;
            i++;
        }
        cur = cur.next;
        ListNode temp = pre.next;
        while(cur != null && i < n) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            temp.next = next;
            cur = next;
            i++;
        }
        return h.next;
    }
}