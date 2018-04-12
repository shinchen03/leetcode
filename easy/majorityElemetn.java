class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                double m = map.get(num);
                double v = nums.length / 2.0;
                if (m+1 > v) return num;
                map.put(num, (int)m + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        return nums[0];
        
    }
                // fastest solution:
    public int majorityElement(int[] nums) {
        int major = nums[0]; int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            }
            else if (major == nums[i]) {
                count++;
            }
            else count--;
        }
        return major;
    }
}