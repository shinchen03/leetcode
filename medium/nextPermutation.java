class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i=nums.length - 2;
        for (; i>= 0; i--) {
            if (nums[i] < nums[i+1]) break;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (j>0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);   
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }
    
}