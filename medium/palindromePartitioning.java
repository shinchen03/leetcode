class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(res, temp, s, 0);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> temp, String s, int num) {
        if (num == s.length()) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int i=num+1; i<=s.length(); i++) {
            String str = s.substring(num, i);
            if (isPa(str)) {
                temp.add(str);
                dfs(res, temp, s, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPa(String str) {
        int left = 0;
        int right = str.length()-1;
        while( left < right ) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}