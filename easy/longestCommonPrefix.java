class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int minIndex = 10000;
        int minLen = 10000;
        String minSub = "";
        if( len == 1) {
            return strs[0];
        }
        if (len == 0) {
            return "";
        }
        for(int i=0; i<len; i++) {
            int temp = strs[i].length();
            if (minLen > temp) {
                minLen = temp;
                minIndex = i;
            }
        }
        for(int i=minLen; i>=0; i--) {
            minSub = strs[minIndex].substring(0,i);
            int j = 0;
            for(; j<len; j++){
                String temp = strs[j].substring(0,i);

                if(!minSub.equals(temp)) {
                    break;
                }
            }
            System.out.println(j);
            if(j == len) {
                return minSub;
            }
        }
        return minSub;
    }
}