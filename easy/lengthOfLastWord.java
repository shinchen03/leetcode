class Solution {
    public int lengthOfLastWord(String s) {
        String[] sub = s.split(" ");
        if( sub.length == 0 ) {
            return 0;
        }
        else {
            return sub[sub.length-1].length();
        }
    }
}