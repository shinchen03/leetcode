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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        res.add(root.val);
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            helper(res, root.left);
            res.add(root.left.val);
        }
        if (root.right != null) {
            helper(res, root.right);
            res.add(root.right.val);
        }
    }
}