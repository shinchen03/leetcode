class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (comp(beginWord, endWord) == 1) return 2;
        int res = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        HashSet<String> visited = new HashSet<>();        
        visited.add(beginWord);
        while (!q.isEmpty()) {
            for (int j=q.size(); j>0; j--) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int i=0; i<wordList.size(); i++) {
                    String temp = wordList.get(i);
                    if (!visited.contains(temp) && comp(word, temp) == 1) {
                        q.add(temp);
                        visited.add(temp);
                        continue;
                    }
                }
            }
            res++;
        }
        return 0;
    }
    
    public int comp(String w1, String w2) {
        int res = 0;
        for (int i=0; i<w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                res++;
                if (res > 1) return res;
            }
        }
        return res;
    }
}