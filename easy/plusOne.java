class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 1;
        int temp = 0;
        for (int i=digits.length - 1; i>=0; i--) {
            temp = digits[i] + carry;
            carry = temp / 10;
            temp %= 10;
            digits[i] = temp;
        }
        if (carry == 0) return digits;
        else {
            for (int i=0; i<digits.length + 1; i++) {
                if (i == 0) res[i] = 1;
                else res[i] = digits[i-1];
            }
        }
        return res;
    }
}