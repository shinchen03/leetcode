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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) return res;
        helper(root, sum, 0, res, temp);
        return res;
    }
    
    public boolean helper(TreeNode node, int sum, int cur, List<List<Integer>> res, List<Integer> temp) {
        if(node == null) {
            //temp.remove(temp.size() - 1);
            return false;
        }
        temp.add(node.val);
        if(cur + node.val == sum && node.left == null && node.right == null) {
            res.add(new ArrayList(temp));
            return true;
        }
        if (helper(node.left, sum, cur + node.val, res, temp)) {
            temp.remove(temp.size() - 1);
        }
        if (helper(node.right, sum, cur + node.val, res, temp)) {
            temp.remove(temp.size() - 1);
        }
        return true;
    }
}