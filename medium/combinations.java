class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || k == 0 || n == 0) return res;
        List<Integer> temp = new ArrayList<>();
        backtracking(temp, n, k, 1, res);
        return res;
    }
    
    public void backtracking(List<Integer> temp, int n, int k, int start, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList(temp));
            //System.out.println("123");
            return;
        }
        for (int i=start; i<n+1; i++) {
            if (temp.size() != 0 && temp.get(temp.size() - 1) > i) continue;
            if (temp.size() != 0 && temp.get(temp.size() - 1) == i) continue;
            temp.add(i);
            backtracking(temp, n, k, start+1, res);
            temp.remove(temp.size() - 1);
        }
    }
}