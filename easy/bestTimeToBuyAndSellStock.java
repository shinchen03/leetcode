class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int mini = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < mini) {
                mini = prices[i];
                continue;
            }
            int temp = prices[i] - mini;
            if (temp > res) {
                res = temp;
            }
        }
        return res;
    }
}