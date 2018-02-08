class Solution {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        int j=1;
        if (nums.length < 2) return res;
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
                if (count > 2) {
                    res--;
                    continue;
                }
            }
            else count = 1;
            nums[j++] = nums[i];
        }
        return res;
    }
}