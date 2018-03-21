class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i=0; i<s.length(); i++) {
            if (!res[i]) continue;
            for (String word : wordDict) {
                if (i + word.length() > s.length()) continue;
                if (res[i+word.length()]) continue;
                if (s.substring(i, i+word.length()).equals(word)) {
                    res[i+word.length()] = true;
                }
            }
        }
        return res[s.length()];
    }
}