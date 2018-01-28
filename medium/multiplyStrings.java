class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int [] temp = new int[num1.length() + num2.length()];
        for (int i=0; i<num1.length(); i++) {
            for (int j=0; j<num2.length(); j++) {
                temp[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i=0; i<temp.length; i++) {
            int carry = temp[i] / 10;
            int mod = temp[i] % 10;
            if (i < temp.length - 1) temp[i+1] += carry;
            res.insert(0, mod);
        }
        while (res.charAt(0) == '0' && res.length() > 1) res.deleteCharAt(0);
        return res.toString();
    }
}