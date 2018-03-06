class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int right = map.containsKey(nums[i]+1) ? map.get(nums[i]+1) : 0;
                int left = map.containsKey(nums[i]-1) ? map.get(nums[i]-1) : 0;
                map.put(nums[i], right+left+1);
                map.put(nums[i]+right, right+left+1);
                map.put(nums[i]-left, right+left+1);
                res = res > right+left+1 ? res : right+left+1;
            }
        }
        return res;
    }
}