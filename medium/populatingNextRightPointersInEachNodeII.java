/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        int cur = 0;
        int pre = 1;
        while (!q.isEmpty()) {
            TreeLinkNode node = q.poll();
            pre--;
            if (node.left != null) {
                q.add(node.left);
                cur++;
            }
            if (node.right != null) {
                q.add(node.right);
                cur++;
            }
            if (pre == 0) {
                pre = cur;
                cur = 0;
                node.next = null;
            }
            else {
                node.next = q.peek();
            }
        }
    }
}