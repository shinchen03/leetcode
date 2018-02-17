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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        }
        else {
            res.get(level).add(0, root.val);            
        }
        inOrder(root.left, res, level+1);
        inOrder(root.right, res, level+1);
    }
}