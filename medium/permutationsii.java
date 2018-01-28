class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, res, list, visited);
        return res;
    }
    
    public void backtracking(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1] && visited[i-1]) continue;
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums, res, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}