class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (paths.length == 0) return res;
        Map<String, Set<String>> map = new HashMap<>();
        for (String path: paths) {
            String[] file = path.split("\\s+");
            for(int i=1; i<file.length; i++) {
                int index = file[i].indexOf("(");
                String content = file[i].substring(index);
                String name = file[0] + "/" + file[i].substring(0, index);
                Set<String> set = map.getOrDefault(content, new HashSet<String>());
                set.add(name);
                map.put(content, set);
            }
        }
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1) res.add(new ArrayList<String>(map.get(key)));
        }
        return res;
    }
}