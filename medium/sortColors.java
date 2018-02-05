class Solution {
    // bubble sort 3ms
    // public void sortColors(int[] nums) {
    //     if (nums.length < 2) return;
    //     for (int j=0; j<nums.length; j++) {
    //         for (int i=1; i<nums.length-j; i++) {
    //             if (nums[i] < nums[i-1]) {
    //                 int temp = nums[i];
    //                 nums[i] = nums[i-1];
    //                 nums[i-1] = temp;
    //             }
    //         }
    //     }
    // }
    //quick sort 0ms
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        quickSort(nums, left, right);
    }
    
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int mid = nums[(l+r)/2];
        while (l <= r) {
            while (nums[l] < mid) l++;
            while (nums[r] > mid) r--;
            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
                l++;
            }
        }
        quickSort(nums, left, r);
        quickSort(nums, l, right);
    }
}