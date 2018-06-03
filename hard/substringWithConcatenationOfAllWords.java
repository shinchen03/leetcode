class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return res;
        int wordlen = words[0].length();
        ArrayList<String> allWords = new ArrayList<>();
        for (String word: words) {
            allWords.add(word);
        }
        for (int i=0; i<s.length(); i++) {
            ArrayList<String> curWords = new ArrayList<>(allWords);
            if (s.length() - i < wordlen * words.length) break;
            int j = i;
            while (true) {
                String newword = s.substring(j, j+wordlen);
                if (curWords.contains(newword)) {
                    curWords.remove(newword);
                    j += wordlen;
                } 
                else {
                    break;
                }
                if (curWords.size() == 0) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}