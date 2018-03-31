class Solution {
    public int maxProduct(int[] nums) {
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        neg[0] = nums[0];
        pos[0] = nums[0];
        int res = pos[0];
        for (int i=1; i<nums.length; i++) {
            pos[i] = nums[i];
            neg[i] = nums[i];
            if (nums[i] > 0) {
                pos[i] = Math.max(pos[i], nums[i] * pos[i-1]);
                neg[i] = Math.min(neg[i], nums[i] * neg[i-1]);
            }
            else {
                pos[i] = Math.max(pos[i], nums[i] * neg[i-1]);
                neg[i] = Math.min(neg[i], nums[i] * pos[i-1]);
            }
            res = Math.max(pos[i], res);
        }
        return res;
    }
}