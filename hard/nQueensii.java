class Solution {
    public static int res;
    public int totalNQueens(int n) {
        res = 0;
        int[] used = new int[n];
        queens(used, 0);
        return res;
    }
    
    public void queens(int[] used, int row) {
        int n = used.length;
        if (n == row) {
            res++;
            return;
        }
        for (int i=0; i<n; i++) {
            if (check(used, row, i)) {
                used[row] = i;
                queens(used, row+1);
            }
        }
    }
    
    public boolean check(int[] used, int row, int col) {
        for (int i=0; i<row; i++) {
            if (used[i] == col) return false;
            if ((row - i) == Math.abs(col - used[i])) return false; 
        }
        return true;
    }
}