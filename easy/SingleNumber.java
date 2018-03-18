class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                res -= nums[i];
            }
            else {
                res += nums[i];
                set.add(nums[i]);
            }
        }
        return res;
    }
}