class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num: nums) {
            count[num]++;
        }
        int avoid = 0;
        int using = 0;
        int prev = -1;
        
        for (int k=1; k<=10000; k++) {
            if (count[k] > 0) {
                int m = Math.max(avoid, using);
                if (k-1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                }
                else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        }
        return Math.max(avoid, using);
    }
}