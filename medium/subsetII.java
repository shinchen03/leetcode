class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(nums, res, temp, 0);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int n) {
        res.add(new ArrayList(temp));
        for (int i=n; i<nums.length; i++) {
            if (i>n && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            helper(nums, res, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}