class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        if (numRows == 0) return res;
        int i = 0;
        int count = 0;
        while (i<numRows) {
            if (count == 0 || count == i) {
                row.add(1);
            }
            else {
                row.add(res.get(i-1).get(count-1) + res.get(i-1).get(count));
            }
            if (count == i) {
                res.add(new ArrayList(row));
                row.clear();
                i++;
                count = 0;
                continue;
            }
            count++;
        }
        return res;
    }
}