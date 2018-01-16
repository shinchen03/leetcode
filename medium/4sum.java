class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len<4) return result;
        for (int i=0; i<len; i++) {
            // if (nums[i] > 0) break;
            for (int j=i+1; j<len; j++) {
                // if (nums[j] > 0) break;
                    int left = j+1;
                    int right = len-1;
                while (left < right) {
                    int res = nums[i] + nums[j] + nums[left]+ nums[right];
                    if (res == target) {
                        List<Integer> ans = new ArrayList<Integer>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        result.add(ans);
                        while (i+1<len && nums[i] == nums[i+1]) i++;
                        while (j+1<len && nums[j] == nums[j+1]) j++;
                        while (left+1<len && nums[left] == nums[left+1]) left++;
                        while (right-1>0 && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    if (res - target < 0) left++;
                    if (res - target > 0) right--;
                }
            }
        }
        return result;
    }
}