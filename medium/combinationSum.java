class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<Integer>();
        for (int i=0; i<candidates.length; i++) {
            if (candidates[i] > target) break;
            // l.add(candidates[i]);
            combSum(candidates, target, i, l, res);
            l.clear();
            }
        return res;
    }
    
    public boolean combSum(int[] candidates, int target, int i, List<Integer> l, List<List<Integer>> res) {
        int s = 0;
        for (int j=0; j<l.size(); j++) {
            s += l.get(j);
        }
        if (s == target) {
            res.add(new ArrayList<>(l));
            // l.remove(l.size() - 1);
            return false;
        }
        if (s > target) return false;
        for (; i<candidates.length; i++) {
            if (candidates[i] > target) return false;
            // if (s + candidates[i] > target) {
            //     l.remove(l.size() - 1);
            //     if (l.size() == 0) return false;
            //     return true;
            // }
            l.add(candidates[i]);
            boolean flag = combSum(candidates, target, i, l, res);
            l.remove(l.size() - 1);
            if (l.size() == 0) return false;
            if (!flag) return true;
        }
        return true;
    }
}