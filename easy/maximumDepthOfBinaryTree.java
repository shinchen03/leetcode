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
    public int maxDepth(TreeNode root) {
        int level = 1;
        if (root == null) return 0;
        return helper(root, level, 0);
    }
    
    public int helper(TreeNode node, int level, int max) {
        max = max > level ? max : level;
        if (node.left != null && node.right != null) {
            return Math.max(helper(node.left, level+1, max), helper(node.right, level+1, max));
        }
        else if (node.left != null) {
            return Math.max(helper(node.left, level+1, max), max);
        }
        else if (node.right != null) {
            return Math.max(helper(node.right, level+1, max), max);
        }
        return max;
    }
}