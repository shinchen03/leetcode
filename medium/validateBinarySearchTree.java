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
    public boolean isValidBST(TreeNode root) {
        // if (root == null) return true;
        // // System.out.println(root.right);
        // Stack<TreeNode> st = new Stack<>();
        // st.push(root);
        // int min = Integer.MIN_VALUE;
        // while (!st.isEmpty()) {
        //     TreeNode node = st.pop();
        //     if (node.left == null && node.right == null) continue;
        //     if (node.val < min) min = node.val;
        //     if (node.left != null && node.left.val >= node.val) return false;
        //     if (node.right != null && node.right.val <= node.val) return false;
        //     if (node.left != null && node.left.val < min) return false;
        //     if (node.left != null) st.push(node.left);
        //     if (node.right != null) st.push(node.right);
        // }
        // return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, Math.min(max, root.val)) && helper(root.right, Math.max(root.val, min), max);
    }
}