class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int res = 1000000;
        Arrays.sort(nums);
        for (int i=0; i<len; i++) {
            int right = len-1;
            int left = i+1;
            while (left < right) {
                if (Math.abs(nums[i] + nums[left] + nums[right] - target) < Math.abs(res - target)) {
                    res = nums[i] + nums[left] + nums[right];
                }
                if (nums[i] + nums[left] + nums[right] - target < 0) left++;
                else if (nums[i] + nums[left] + nums[right] - target > 0) right--;
                else return res;
            }
        }
        return res;
    }
}