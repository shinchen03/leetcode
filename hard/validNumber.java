class Solution {
    public boolean isNumber(String s) {
        if (s.length() < 1) return false;
        char chars[] = s.toCharArray();
        int i=0;
        int eflag = 0;
        boolean num1 = false;
        boolean num2 = false;
        boolean en = false;
        while (i<s.length() && chars[i] == ' ') i++;
        if (i<chars.length && (chars[i] == '+' || chars[i] == '-')) {
            i++;
        }
        while (i<s.length() && chars[i] <= '9' && chars[i] >= '0') {
            i++;
            if(!en && i<s.length() && chars[i] == 'e') {
                i++;
                eflag = 1;
                en = true;
                if (i<s.length() && (chars[i] == '+' || chars[i] == '-')) i++;
                continue;
            }
            eflag = 0;
            num1 = true;
        }
        if (!en && i<s.length() && chars[i] == '.') {
            i++;
            if (i<s.length() && chars[i] == 'e') {
                        i++;
                        eflag = 1;
                        if (i<s.length() && (chars[i] == '+' || chars[i] == '-')) i++;
                        if(num1 == false) return false;
                    }
                while(i<chars.length && chars[i] <= '9' && chars[i] >= '0') {
                    i++;
                    if (!en && i<s.length() && chars[i] == 'e') {
                        i++;
                        en = true;
                        eflag = 1;
                        if (i<s.length() && (chars[i] == '+' || chars[i] == '-')) i++;
                        continue;
                    }
                    num2 = true;
                    eflag = 0;
                }
        }
        while (i<chars.length && chars[i] == ' ') i++;
        if (num1 == false && num2 == false) return false;
        if (eflag == 1) return false;
        return i == chars.length;
    }
}