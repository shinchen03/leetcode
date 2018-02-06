class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(nums, temp, res, 0);
        return res;
    }
    
    public void backtracking(int[] nums, List<Integer> temp, List<List<Integer>> res, int n) {
        res.add(new ArrayList(temp));
        for (int i=n; i<nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, temp, res, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}