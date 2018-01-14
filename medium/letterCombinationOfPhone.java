class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int num = 0;
        combinations(digits, "", num, table, res);
        return res;
    }
    
    public void combinations(String digits, String curr, int num, String[] table, List res) {
        if (num == digits.length()) {
            if (curr.length() != 0) res.add(curr);
            return;
        }
        String temp = table[digits.charAt(num) - '0'];
        for(int i=0;i<temp.length();i++) {
           String next = curr + temp.charAt(i);
           combinations(digits, next, num+1, table, res);
        }
    }
}