class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double y = x;
        int sign = 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n%2 == 0) return 1;
            else return -1;
        }
        if (n<0) {
            if ( n == Double.MIN_VALUE ) {
                x = x*x;
                n++;
            }
            sign = 0;
            n = -n;
        }        
        for (int i=0; i<n-1; i++) {
            x *= y;
            if (x > Double.MAX_VALUE) {
                if (sign == 1)
                    return Double.MAX_VALUE;
                else return 0;
            }
            if (x == 0) return 0;
         }
        if (sign == 0) x = 1/x;
        return x;
    }
}