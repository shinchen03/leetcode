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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper2(res, root, 1);
        return res;
    }
    
    // recursive
    public void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level > res.size()) {
            res.add(0, new ArrayList<Integer>());
        }
        res.get(res.size()-level).add(root.val);
        helper(res, root.left, level+1);
        helper(res, root.right, level+1);
    }
    // with out recursive
    
    public void helper2(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i=1;
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (i == 0) {
                res.add(0, temp);
                i = queue.size();
                temp = new ArrayList<Integer>();
            }
            i--;
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        res.add(0,temp);
    }
}