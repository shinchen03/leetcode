class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] table = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        if (triangle.size() == 1) return triangle.get(0).get(0);
        table[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int i=1; i<triangle.size(); i++) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                if (j == 0) {
                    table[i][j] += table[i-1][j] + triangle.get(i).get(j);
                }
                if (j == triangle.get(i).size() - 1) {
                    table[i][j] += table[i-1][j-1] + triangle.get(i).get(j);
                }
                if (j != 0 && j != triangle.get(i).size() - 1) {
                    table[i][j] += Math.min(table[i-1][j-1], table[i-1][j]) + triangle.get(i).get(j);
                }
                if (i == triangle.size() - 1) {
                   System.out.println(table[i][j]);
                    res = Math.min(table[i][j], res);
                }
            }
        }
        return res;
    }
}