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
    public void flatten(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode h = root;
        while (h != null || !s.isEmpty()) {
            if (h.right != null) {
                s.push(h.right);
            }
            if (h.left != null) {
                h.right = h.left;
                h.left = null;
            }
            else if (!s.isEmpty()) {
                TreeNode node = s.pop();
                h.right = node;
            }
            h = h.right;
        }
    }
}