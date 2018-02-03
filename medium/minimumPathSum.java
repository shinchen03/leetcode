
class Solution {
    public int minPathSum(int[][] grid) {
        int len = grid.length;
        int lon = grid[0].length;
        int[][] array = new int[len][lon];
        array[0][0] = grid[0][0];
        for (int i=1; i<len; i++) {
            for (int j=1; j<lon; j++) {
                array[i][j] = 0;
            }
        }
        for (int i=1; i<len; i++) {
            array[i][0] += array[i-1][0] + grid[i][0];
        }
        for (int i=1; i<lon; i++) {
            array[0][i] += array[0][i-1] + grid[0][i];
        }
        for (int i=1; i<len; i++) {
            for (int j=1; j<lon; j++) {
                array[i][j] = grid[i][j] + Math.min(array[i][j-1], array[i-1][j]);
            }
        }
        return array[len-1][lon-1];
    }
}