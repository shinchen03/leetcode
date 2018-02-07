class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] map = new int[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                map[i][j] = 0;
            }
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    map[i][j] = 1;
                    if (check(board, i, j, word, 1, map)) return true;
                    map[i][j] = 0;
                }
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, int m, int n, String word, int index, int[][] map) {
        if (index == word.length()) return true;
        //System.out.println(index);
        if (m+1 < board.length && map[m+1][n] != 1 && board[m+1][n] == word.charAt(index)) {
            map[m+1][n] = 1;
            if (check(board, m+1, n, word, index+1, map)) return true;
            map[m+1][n] = 0;
        }
        if (n+1 < board[0].length && map[m][n+1] != 1 && board[m][n+1] == word.charAt(index)) {
            map[m][n+1] = 1;
            if (check(board, m, n+1, word, index+1, map)) return true;
            map[m][n+1] = 0;
        }
        if (m>0 && map[m-1][n] != 1 && board[m-1][n] == word.charAt(index)) {
            map[m-1][n] = 1;
            if (check(board, m-1, n, word, index+1, map)) return true;
            map[m-1][n] = 0;
        }
        if (n>0 && map[m][n-1] != 1 && board[m][n-1] == word.charAt(index)) {
            map[m][n-1] = 1;
            if (check(board, m, n-1, word, index+1, map)) return true;
            map[m][n-1] = 0;
        }
        return false;
    }
}