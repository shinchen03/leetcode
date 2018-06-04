class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (stack.isEmpty() && s.charAt(i) != ')') {
                stack.push(i);
            }
            else if (stack.isEmpty() && s.charAt(i) == ')') {
                res = Math.max(res, i-start);
                start = i+1;
                stack.clear();
            }
            else if (s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
            }
            else if (s.charAt(i) == '(') {
                stack.push(i);
            }
        }
        int over = s.length();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            res = Math.max(res, over - temp - 1);
            over = temp;
        }
        res = Math.max(res, over - start);
        return res;
    }
}