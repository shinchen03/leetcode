class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int right = 0;
        int left = 0;
        int maxlen = 0;
        if (len<2) return s;
        String result = s.substring(0,1);
        for (int i = 1; i<len; i++) {
            left = 1;
            right = 1;
            while (i-left >=0 && i+right < len && s.charAt(i-left) == s.charAt(i+right)) {
                if (maxlen < right+left+1) {
                        result = s.substring(i-left, i+right+1);
                        maxlen = right+left+1;
                }
                right++;
                left++;
            }
            left = 1;
            right = 0;
            while (i-left >=0 && i+right < len && s.charAt(i-left) == s.charAt(i+right)) {
                if (maxlen < right+left+1) {
                       // System.out.println(right);
                        result = s.substring(i-left, i+right+1);
                        maxlen = right+left;
                }
                right++;
                left++;
            }
        }
        return result;
    }
}