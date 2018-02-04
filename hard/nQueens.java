class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] array = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                array[i][j] = 0;
            }
        }
        queens(array, res, 0, 0);
        return res;
    }
    
    public boolean queens(int[][] array, List<List<String>> res, int m, int n) {
        if (m >= array.length) return false;
        for (int j=n; j<array.length; j++) {
            array[m][j] = 1;
            if (!check(array, res, m, j)) {
                array[m][j] = 0;
                continue;
            }
            else queens(array, res, m+1, 0);
            array[m][j] = 0;
        }
        return true;
    }
    
    public boolean check(int[][] array, List<List<String>> res, int m, int n) {
        //printArray(array);
        for (int i=0; i<array.length; i++) {
            if (i != m && array[i][n] == 1) return false;
        }
        for (int i=0; i<array.length; i++) {
            if (i != n && array[m][i] == 1) return false;
        }
        int i=1;
        int j=-1;
        while (i + m < array.length && j + n >= 0) {
            if (array[i+m][j+n] == 1) return false;
            i++;
            j--;
        }
        i=-1;
        j=1;
        while (i + m >= 0 && j + n < array.length) {
            if (array[i+m][j+n] == 1) return false;
            i--;
            j++;
        }
        i = -1;
        j = -1;
        while (i + m >= 0 && j + n >= 0) {
            if (array[i+m][j+n] == 1) return false;
            i--;
            j--;
        }
        if (m == array.length - 1) {
            List<String> temp = new ArrayList<>();
            for (i=0; i<array.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (j=0; j<array.length; j++) {
                    if (array[i][j] == 0) sb.insert(j, ".");
                    else sb.insert(j, "Q");
                }
                temp.add(sb.toString());
            }
            res.add(temp);
        }
        return true;
    }
    
    public void printArray(int[][] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
            System.out.println("");        
    }
}