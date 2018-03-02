class Solution {
    public int maxProfit(int[] prices) {
        int[] local = new int[3];
        int[] global = new int[3];
        for (int i=1; i<prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j=2; j>0; j--) {
                local[j] = Math.max(global[j-1] + diff, local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
}