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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum, 0);
    }
    
    public boolean helper(TreeNode node, int sum, int cur) {
        if (node == null) return false;
        cur += node.val;
        if (cur == sum && node.right == null && node.left == null) return true;
        //if (cur > sum) return false;
        return (helper (node.left, sum, cur) || helper (node.right, sum, cur));
        
    }
}