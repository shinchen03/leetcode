class Solution {
    public int numDecodings(String s) {
        int res = 0;
        if (s.length() == 0) return res;
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length+1];
        nums[0] = 1;
        for (int i=1; i<=chars.length; i++) {
            if (chars[i-1] != '0') nums[i] += nums[i-1];
            if (i>1 && chars[i-2] == '1') nums[i] += nums[i-2];
            if (i>1 && chars[i-2] == '2' && chars[i-1] >= '0' && chars[i-1] <= '6') nums[i] += nums[i-2];
        }
        return nums[chars.length];
    }
}