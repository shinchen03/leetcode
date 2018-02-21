class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int min = 0;
        int a = 0;
        int b = 0;
        for (int i=2; i<cost.length+1; i++) {
            min = Math.min(a+cost[i-2], b+cost[i-1]);
            a = b;
            b = min;
        }
        return min;
    }
}