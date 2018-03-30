public class Solution {
    public String reverseWords(String s) {
        //if (s.equals(" ")) return "";
        if (s.length()  == 0) return s;
        String[] strs = s.split(" ");
        if (strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        String last = "123";
        for (String str:strs) {
            if (str.equals("")) continue;
            res.insert(0, str);
            res.insert(0, " ");
            last = str;
        }
        while (res.length() > 0 && res.charAt(0) == ' ') res.deleteCharAt(0);
        while (res.length() > 0 && res.charAt(res.length()-1) == ' ') res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}