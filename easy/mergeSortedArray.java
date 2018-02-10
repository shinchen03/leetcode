class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int s = m+n-1;
        while (s >= 0) {
            if (i < 0 && j >= 0) {
                while (j >= 0) {
                    nums1[s] = nums2[j];
                    s--;
                    j--;
                }
                break;
            }
            else if (j < 0 && i >= 0) {
                while (i >= 0) {
                    nums1[s] = nums1[i];
                    s--;
                    i--;
                }
                break;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[s] = nums1[i];
                i--;
            }
            else {
                nums1[s] = nums2[j];
                j--;
            }
            s--;
        }
    }
}