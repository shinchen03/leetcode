class Solution {
    public int jump2(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i=0; i<dp.length; i++ ) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=1; j<=nums[i]; j++) {
                if (j+i < nums.length && dp[i+j] > dp[i] + 1) {
                    dp[i+j] = 1 + dp[i];
                    if (dp[i+j] >= nums.length-1) return dp[i+j];
                }
            }
        }
        return dp[nums.length-1];
    }
    
    public int jump(int[] nums) {
        int level = 0, m=0, i=0;
        while (i < nums.length - 1) {
            level++;
            int next = 0;
            for (; i<=m; i++) {
                next = Math.max(next, nums[i]+i);
                if (next >= nums.length - 1) return level;
            }
            m = next;
        }
        return level;
    }
}