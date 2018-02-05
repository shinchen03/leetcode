class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if (len == 0) return false;
        int lon = matrix[0].length;
        if (lon == 0) return false;
        int i=0;
        int j=0;
        if (matrix[i][j] > target) return false;
        while (i<len && matrix[i][j] < target) i++;
        if (i >= len || matrix[i][j] > target) i--;
        while (j<lon && matrix[i][j] < target) j++;
        if (j < lon && matrix[i][j] == target) return true;
        return false;
    }
}