class Solution {
    public int climbStairs(int n) {
        int res = 0;
        int[] array = new int[n];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        array[1] = 2;
        array[0] = 1;
        for (int i=2; i<n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        res = array[n-1];
        return res;
    }
}