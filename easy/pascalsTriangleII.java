class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        return helper(rowIndex, 0, pre);
    }
    
    public List<Integer> helper(int row, int cur, List<Integer> pre) {
        if (cur == row+1) {
            return pre;
        }
        int count = 0;
        List<Integer> temp = new ArrayList<>();  
        while (count <= cur) {
            if (count == 0 || count == cur) {
                temp.add(1);
            }
            else {
                temp.add(pre.get(count-1) + pre.get(count));
            }
            count++;
        }
        return helper(row, cur+1, temp);
    }
}