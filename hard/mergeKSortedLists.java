class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length-1);
    }
    
    public ListNode helper(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left < right) {
            int mid = (left + right)/2;
            ListNode l1 = helper(lists, left, mid);
            ListNode l2 = helper(lists, mid+1, right);
            return merge(l1, l2);
        }
        else return null;
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}