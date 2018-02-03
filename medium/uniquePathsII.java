class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len =obstacleGrid.length;
        int lon = obstacleGrid[0].length;
        if (len == 1 && lon == 1 && obstacleGrid[0][0] == 0) return 1;
        if (len == 1 && lon == 1 && obstacleGrid[0][0] == 1) return 0;
        if (obstacleGrid[len-1][lon-1] == 1) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        if (len == 1 || lon == 1) {
            for (int i=0; i<len; i++) {
                for (int j=0; j<lon; j++) {
                    if (obstacleGrid[i][j] == 1) return 0;
                }
            }
            return 1; 
        }
        for (int i=0; i<len; i++) {
            for (int j=0; j<lon; j++) {
                if (obstacleGrid[i][j] == 0) obstacleGrid[i][j] = 1;
                else obstacleGrid[i][j] = 0;
            }
        }
        //obstacleGrid[len-1][lon-1] = 0; 
        for (int i=0; i<len; i++) {
            for (int j=0; j<lon; j++) {
                if (i == 0 && j==0) {
                    obstacleGrid[i][j] = 1;
                    continue;
                }
                if (j == 0 && i > 0) {
                    if (obstacleGrid[i][j] != 0) obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    continue;
                }
                if (i == 0 && j > 0) {
                    if (obstacleGrid[i][j] != 0) obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    continue;
                }
                if (obstacleGrid[i][j] != 0)
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[len-1][lon-1];
    }
}