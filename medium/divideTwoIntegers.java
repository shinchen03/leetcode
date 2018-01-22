class Solution {
    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        long res = 0;
        int sign = 0;
        if (a<0 && b>0) sign = 1;
        if (a>0 && b<0) sign = 1;
        b = Math.abs(b);
        a = Math.abs(a);
        long c = b;
        long i = 1;
        while (b<a-b) {
            b += b;
            i += i;
        }
        while (a>=c) {
            if (a >= b) {
                a -= b;
                res += i;
            }
            else {
                b -= c;
                i--;
            }
        }
        res = sign == 0 ? res:-res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        else return (int)res;
    }
}