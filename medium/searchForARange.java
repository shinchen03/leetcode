class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                int j = i+1;
                while ( j<nums.length && nums[j] == target ) j++;
                res[0] = i;
                res[1] = j-1;
                return res;
            }
        }
        return res;
    }
}