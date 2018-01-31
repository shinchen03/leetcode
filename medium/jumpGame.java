class Solution {
    // method 1: Time Limit Exceeded T.T
    
//     public boolean canJump(int[] nums) {
//         if (nums.length < 2) return true; 
//         int jump = nums[0];
//         int n = 0;
//         return jumpArray(nums, n, jump);
//     }
    
//     public boolean jumpArray(int[] nums, int n, int jump) {
//         if (n >= nums.length - 1) return true;
//         if (jump == 0) return false;
//         for (int i=1; i<jump+1; i++) {
//             boolean f = jumpArray(nums, n+i, nums[n+i]);
//             if (f == true) return true;
//         }
//         return false;
//     }
    
        public boolean canJump(int[] nums) {
            int jump = 0;
            for (int i=0; i<nums.length && i<=jump; i++) {
                jump = Math.max(jump, i+nums[i]);
            }
            return jump >= nums.length - 1;
        }
}