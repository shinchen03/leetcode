class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();  
            temp.add(-100);
            temp.add(-100);
            temp.add(-100);
        for (int i=0; i<len; i++) {
            if(nums[i] > 0) break;
            int left = i+1;
            int right = len - 1;
            while (left < right) {
                int res = nums[left] + nums [right] + nums[i];
                if (res < 0) left++;
                if (res > 0) right--;
                if (res > 0 && nums[right] == nums[right+1]) right--;
                if (res < 0 && nums[left] == nums[left-1]) left++;
                if (res == 0) {
                    List<Integer> ans = new ArrayList<Integer>();  
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    // System.out.println(temp.get(0));
                    if (temp.get(0) != ans.get(0) || temp.get(1) != ans.get(1)) temp = ans;
                    else {
                        left++;
                        right--;
                        continue;
                    }
                    // result.add([nums[i], nums[left], nums[right]]);
                    result.add(ans);
                    left++;
                    right--;
                    while (right<len-2 && right>0 && nums[right] == nums[right+1]) right--;
                    while (left > 0 && left < len && nums[left] == nums[left-1]) left++;
                }
            }
            while (i < len-1 && nums[i] == nums[i+1]) i++;
        }
        return result;
    }
}