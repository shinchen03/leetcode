class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String tempStr = new String(ch);
            if (map.containsKey(tempStr)) {
                map.get(tempStr).add(strs[i]);
            }
            else {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(tempStr, tempList);
            }
        }
        for (String s: map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
}