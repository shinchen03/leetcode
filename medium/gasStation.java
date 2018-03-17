class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int start = 0;
        int total = 0;
        for(int i=0; i<gas.length; i++) {
            //System.out.println(gas[i]);
            int re = gas[i] - cost[i];
            if (gasSum > 0) {
                gasSum += re;    
            }
            else {
                start = i;
                gasSum = re;
            }
            total += re;
        }
        return total >= 0 ? start : -1;
     }
}