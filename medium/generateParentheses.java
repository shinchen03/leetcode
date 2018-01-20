class Solution {
    public List<String> generateParenthesis(int n) {
        String p = "";
        List<String> result = new ArrayList<String>();
        genP(n, 0, 0, p, result);
        return result;
    }
    public void genP(int n, int left, int right, String p, List<String> result) {
        // if (right>left) return;
        if (right>left || left>n || right>n) return;
        if (left == n && right == n) {
            result.add(p);
            return;
        }
		// comment out part is wrong solution 
		
        // if(left<n) {
        //     p += "(";
        //     genP(n, ++left, right, p, result);
        // }
        // if(right<left) {
        //     p += ")";
        //     genP(n, left, ++right, p, result);
        // }
		
		
        genP(n, left+1, right, p+"(", result);
        genP(n, left, right+1, p+")", result);
    }
}