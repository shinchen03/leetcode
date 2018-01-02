class Solution {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int needlelen = needle.length();
        if (needlelen == 0) {
            return 0;
        }
        if (len == 0 || needlelen > len) {
            return -1;
        }
        for (int i=0; i< len; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                for (; j< needlelen; j++) {
                    if (i+j > len-1) {
                        break;
                    }
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needlelen) {
                    return i;
                }
            }
        }
        return -1;
    }
}