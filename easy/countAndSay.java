class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i=0; i<n-1; i++) {
            String temp = "";
            for (int m=0; m<result.length(); m++) {
                int num=(int)result.charAt(m)-48;
                int j = 1;
                while (j+m<result.length() && result.charAt(m+j) == result.charAt(m)) {
                    j++;
                }
                m += j-1;
                temp += Integer.toString(j);
                temp += Integer.toString(num);
            }
            result = temp;
            System.out.println(result);
        }
        return result;
    }
}