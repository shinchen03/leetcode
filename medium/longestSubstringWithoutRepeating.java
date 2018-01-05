class Solution {
    public int lengthOfLongestSubstring(String s) {
		// reject in last testcase -> Time Limit Exceeded
        int len = s.length();
        HashMap map = new HashMap();
        int i = 0;
        for(; i<len; i++) {
            char c = s.charAt(i);
            // System.out.println(c);
            if (map.containsKey(c)) {
                return Math.max(i, lengthOfLongestSubstring(s.substring((int)map.get(c)+1, len)));
            }
            else {
                map.put(c, i);
            }
        }
        return i;
    }
}

class Solution {
	// accepeted
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        HashSet set = new HashSet();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < len) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                result = Math.max(result, set.size());
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }
}