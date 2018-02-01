/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals,new Comparator<Interval>() {  
            @Override  
            public int compare(Interval o1, Interval o2) {  
                return o1.start - o2.start;  
            }  
         });  
        
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) return res;
        int preEnd = 0;
        int preSta = 0;
        for (int i=0; i<intervals.size(); i++) {
            Interval temp = intervals.get(i);
            int start = temp.start;
            int end = temp.end;
            if (preEnd >= start && preSta <= end || preSta >= start && preEnd >= end && preSta <= end) {
                if (preEnd >= start && preEnd < end) preEnd = end;
                if (preSta > start) preSta = start;
            }
            else  {
                temp.start = preSta;
                temp.end = preEnd;
                if (i != 0) res.add(temp);
                preEnd = end;
                preSta = start;
            }
        }
        Interval temp = new Interval();
        temp.start = preSta;
        temp.end = preEnd;
        res.add(temp);
        return res;
    }
}