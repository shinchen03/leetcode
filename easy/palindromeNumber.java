class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int l = 0;
        int f = 0;
        int temp = x;
        int len = 1;
        while (temp >= 10){
            temp /= 10;
            len *= 10;
        }
        while (x > 0){
            f = x / len;
            l = x % 10;
            if(f != l){
                return false;
            }
            x = x % len / 10;
            len = len / 100;
        }
        return true;
    }
}