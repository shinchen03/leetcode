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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 0;
        int pre = 1;
        int cur = 0;
        while (!q.isEmpty()) {
            if (pre == 0) {
                i++;
                pre = cur;
                cur = 0;
            }
            TreeNode node = q.poll();
            pre--;
            if (node.left != null) {
                q.add(node.left);
                cur++;
            }
            if (node.right != null) {
                q.add(node.right);
                cur++;
            }
            if (node.right == null && node.left == null) return ++i;
        }
        return i;
    }
}