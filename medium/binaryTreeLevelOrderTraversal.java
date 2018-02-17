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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        res.add(new ArrayList());
        inOrder(root, res, 0);
        return res;
    }
    
    public void inOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size()-1 < level) {
            res.add(new ArrayList());
        }
        res.get(level).add(root.val);
        inOrder(root.left, res, level+1);
        inOrder(root.right, res, level+1);
    }
}