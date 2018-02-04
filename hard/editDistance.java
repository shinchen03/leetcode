class Solution {
    public int minDistance(String word1, String word2) {
        int[][] mat = new int[word1.length() + 1][word2.length() + 1];
        for (int i=0; i<mat.length; i++) {
            mat[i][0] = i;
        }
        for (int i=0; i<mat[0].length; i++) {
            mat[0][i] = i;
        }
        for (int i=1; i<mat.length; i++) {
            for (int j=1; j<mat[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) mat[i][j] = mat[i-1][j-1];
                else mat[i][j] = Math.min(Math.min(mat[i-1][j-1], mat[i-1][j]), mat[i][j-1])+1;
            }
        }
        return mat[word1.length()][word2.length()];
    }
}