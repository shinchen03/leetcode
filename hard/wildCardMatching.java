class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        if(p.length() == 1 && p.charAt(0) == '*') return true;
        for (int i=1; i<p.length()+1; i++) {
            if (p.charAt(i-1) != '*') break;
            else dp[0][i] = true;
        }
        for (int i=1; i<s.length()+1; i++) {
            for (int j=1; j<p.length()+1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}




