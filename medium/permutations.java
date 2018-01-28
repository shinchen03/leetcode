class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, res);
        return res;
    }
    
    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, list, res);
                if (list.size() > 0) list.remove(list.size() - 1);
        }}
    }
}