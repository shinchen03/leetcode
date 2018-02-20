/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static ListNode p;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode h = head;
        p = head;
        int len = 0;
        while (h.next != null) {
            len++;
            h = h.next;
        }
        return helper(0, len);
    }
    
    public TreeNode helper(int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = helper(start, mid-1);
        TreeNode node = new TreeNode(p.val);
        p = p.next;
        TreeNode right = helper (mid+1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}