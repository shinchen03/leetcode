class Solution {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=0; i<len; i++) {
            int numa = 0;
            int numb = 0;
            if (a.length() <= i) numa = 0;
            else numa = a.charAt(a.length() - i - 1) - '0';
            if (b.length() <= i) numb = 0;
            else numb = b.charAt(b.length() - i - 1) - '0';
            int temp = numa + numb + carry;
            if (temp > 1) {
                carry = 1;
                temp %= 2;
            }
            else carry = 0;
            sb.insert(0, temp);
        }
        if (carry == 1) sb.insert(0, 1);
        return sb.toString();
    }
}