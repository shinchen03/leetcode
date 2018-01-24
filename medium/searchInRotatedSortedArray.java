class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int first = nums[0];
        int sec = nums[nums.length - 1];
        if (Math.abs(first-target) < Math.abs(sec - target)) {
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == target) return i;
            }
        }
        else {
            for(int i=nums.length-1; i>=0; i--) {
                if (nums[i] == target) return i;
            }
        }
        return -1;
    }
}