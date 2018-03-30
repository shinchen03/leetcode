class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for (String token : tokens) {
            if (isNum(token)) {
                s.push(Integer.parseInt(token));
            }
            else {
                int x = s.pop();
                int y = s.pop();
                res = cal(x, y, token);
                s.push(res);
            }
        }
        return res;
    }
                       
                       
    public boolean isNum(String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
                       
    public int cal(int y, int x, String op) {
        if (op.equals("+")) return x+y;
        if (op.equals("-")) return x-y;
        if (op.equals("*")) return x*y;
        else return x/y;
    }
}