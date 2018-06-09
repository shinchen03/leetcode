class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
    
    public boolean backtracking(char[][] board) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') {
                    for (char c='1'; c<='9'; c++) {
                        if (check(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtracking(board)) { 
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean check(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c) return false;
            if (board[i][k] == c) return false;
            int m = 3 * (i / 3) + k / 3;
            int n = k % 3 + 3 * (j / 3);
            if (board[m][n] == c) return false;
        }
        return true;
    }
}