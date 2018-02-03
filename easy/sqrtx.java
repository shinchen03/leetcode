class Solution {
    public int mySqrt(int x) {
        long right = x/2 + 1;
        long left = 0;
        long temp = 0;
        while (left <= right) {
            temp = (right + left) / 2;
            if (temp * temp == x) return (int)temp;
            if (temp * temp > x) right = temp - 1;
            if (temp * temp < x) left = temp + 1;
        }
        return (int)right;
    }
}