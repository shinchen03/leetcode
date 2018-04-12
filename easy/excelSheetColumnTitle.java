class Solution {
    public String convertToTitle(int n) {
        String[] table = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String res = "";
        int d = n - 1;
        while (d >= 0) {
            res = table[d % 26] + res;
            d = d / 26 ;
            if (d == 0) break;
            d -= 1;
        }
        return res;
    }
}