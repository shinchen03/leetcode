class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i=0; i<candidates.length; i++) {
            temp.add(candidates[i]);
            combSum(candidates, target-candidates[i], i+1, temp, res);
            temp.clear();
            while (i<=candidates.length-2 && candidates[i] == candidates[i+1]) i++;
        }
        return res;
    }
    
    public boolean combSum(int[] candidates, int left, int i, List<Integer> temp, List<List<Integer>> res) {            
        if (left == 0) {
            res.add(new ArrayList(temp));
            return false;
        }
        if (left < 0) return false;
        for (;i<candidates.length; i++) {
            if (left - candidates[i] < 0) {
                // if (temp.size() <2) return false;
                //temp.remove(temp.size() - 1);
                return true;
            }
            temp.add(candidates[i]);
            boolean f = combSum(candidates, left-candidates[i], i+1, temp, res);
            temp.remove(temp.size()-1);
            while (i <= candidates.length-2 && candidates[i] == candidates[i+1]) i++;
            if (!f) break;
        }
        return true;
    }
}