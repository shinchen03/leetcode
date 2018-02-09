class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int right = len-1;
        int left = 0;
        while (left <= right) {
            if (nums[left] > target && nums[right] < target) return false;
            if (nums[left] == target || nums[right] == target) return true;
            if (nums[left] < target) left++;
            if (nums[right] > target) right--;
        }
        return false;
    }
}