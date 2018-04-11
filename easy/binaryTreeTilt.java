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
    int res = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        helper2(root);
        return res;
    }
    // my solution
    public int helper(TreeNode node, int res) {
        if (node == null) return res;
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = node.left.val;
        }
        if (node.right != null) {
            right = node.right.val;
        }
        res += Math.abs(right - left);
        res = helper(node.left, res);
        res = helper(node.right, res);
        return res;
    }
    // accepted solution
    public int helper2(TreeNode node) {
        if (node == null) return 0;
        int left = helper2(node.left);
        int right = helper2(node.right);
        res += Math.abs(left - right);
        return left + right + node.val;
    }
}