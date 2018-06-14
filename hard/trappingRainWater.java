class Solution {
    public int trap(int[] height) {
        int res = 0;
        int rightmax = 0;
        int leftmax = 0;
        int l = 0, r = height.length-1; 
        while (l <= r) {
            rightmax = Math.max(rightmax, height[r]);
            leftmax = Math.max(leftmax, height[l]);
            if (leftmax < rightmax) {
                res += leftmax - height[l]; 
                l++;
            } else {
                res += rightmax - height[r];
                r--;
            }
        }
        return res;
    }
}