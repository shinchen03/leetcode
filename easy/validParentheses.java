class Solution {
	// solution 1: recursive, but stackoverflow in leetcode
    public boolean isValid(String s) {
            int len = s.length();
            if(len < 2) {
                return false;
            }
            return paran(s, 0, 1, 0);
        }
    public boolean paran(String s, int i, int j, int f) {
            switch(s.charAt(i)){
                case '(':
                    if (s.charAt(j) == ')') {
                        if(j+1 == s.length()) {
                            return true;
                        }
                        else if( i != f ){
                            paran(s, i-1, j+1, f);
                        }
                        else if( i == f ){
                            return isValid( s.substring(j+1, s.length()) );
                        }
                    }
                    else if(j+1 == s.length()) {
                        System.out.println("here");
                        return false;
                    }
                    else if(s.charAt(j) != '}' && s.charAt(j) != ']')
                        paran(s, j, j+1, f);
                    else {
                                                System.out.println("here");
                        return false;
                    }
                case '[':
                   if (s.charAt(j) == ']') {
                        if(j+1 == s.length()) {
                            return true;
                        }
                        else if( i != f ){
                            paran(s, i-1, j+1, f);
                        }
                        else if( i == f ){
                            return isValid( s.substring(j+1, s.length()) );
                        }
                    }
                    else if(j+1 == s.length()) {
                        return false;
                    }
                    else if(s.charAt(j) != '}' && s.charAt(j) != ')')
                        paran(s, j, j+1, f);
                    else {
                        return false;
                    }
                case '{':
                    if (s.charAt(j) == '}') {
                        if(j+1 == s.length()) {
                            return true;
                        }
                        else if( i != f ){
                            paran(s, i-1, j+1, f);
                        }
                        else if( i == f ){
                            return isValid( s.substring(j+1, s.length()) );
                        }
                    }
                    else if(j+1 == s.length()) {
                        return false;
                    }
                    else if(s.charAt(j) != ')' && s.charAt(j) != ']')
                        paran(s, j, j+1, f);
                    else {
                        return false;
                    }
            }
        return false;
        }
}


class Solution2 {
	// solution2, using stack
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int len = s.length();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i=0; i<len; i++) {
            Character n = s.charAt(i);
            switch(n) {
                case '{': case '(': case '[':
                    st.push(n);
                    break;
                case ')': case ']': case '}':
                    if(st.isEmpty() || n != map.get(st.pop())) {
                        return false;
                    }
            }
        }
        return st.isEmpty();
    }
}