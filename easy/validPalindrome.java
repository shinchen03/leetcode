class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            if (!((s.charAt(left) >= '0' && s.charAt(left) <= '9') || (s.charAt(left) >= 'A' && s.charAt(left) <= 'Z') || (s.charAt(left) <= 'z' && s.charAt(left) >= 'a'))) {
                left++;
                continue;
            }
            if (!((s.charAt(right) >= '0' && s.charAt(right) <= '9') || (s.charAt(right) >= 'A' && s.charAt(right) <= 'Z') || (s.charAt(right) <= 'z' && s.charAt(right) >= 'a'))) {
                right--;
                continue;
            }
            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) return false;
            right--;
            left++;
        }
        return true;
    }
}