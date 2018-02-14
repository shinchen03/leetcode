class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s2.length() + s1.length() != s3.length()) {
            return false;
        }
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
        res[0][0] = true;
        for (int i=0; i<=s1.length(); i++) {
            for (int j=0; j<=s2.length(); j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = true;
                }
                else if (i == 0) {
                    res[i][j] = res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
                else if (j == 0) {
                    res[i][j] = res[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }
                else {
                    res[i][j] = (res[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }
            return res[s1.length()][s2.length()];         
    }
}