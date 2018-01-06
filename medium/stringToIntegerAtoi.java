class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        int sign = 0;
        int result = 0;
        for(int i = 0; i<len; i++) {
            if ( str.charAt(i) >= '0' && str.charAt(i) <= '9' ) {
                if (sign != -1) {
                    if (result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7) {
                        System.out.println(result);
                        result = Integer.MAX_VALUE;
                        break;
                    }
                }
                else {
                    if (result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 8) {
                        System.out.println(result);
                        result = -Integer.MIN_VALUE;
                        break;
                    }
                }
            }
            if (str.charAt(i) == '+' && sign != 0) return 0;
            if (str.charAt(i) == '-' && sign != 0) return 0;
            if (str.charAt(i) == '+') sign = 1;
            else if (str.charAt(i) == '-') sign = -1;
            else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result = result*10 + (int)str.charAt(i)-'0';
            }
            else if (result != 0 || sign != 0 || str.charAt(i) != ' ') {
                break;
            }
        }
        if (sign == 0) sign = 1;
        return result*sign;
    }
}