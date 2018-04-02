class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        return helper(nums, 0, nums.length-1);
    }
    
    public int helper (int[] nums, int left, int right) {
        if (left == right) return nums[left];
        if (nums[left] < nums[right]) return nums[left];
        int ave = (left + right) / 2;
        return Math.min(helper(nums, left, ave), helper(nums, ave + 1, right));
    }
}