class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        result = []
        for i in range(len(nums)):
            # if nums[i] <= target:
                num2 = target - nums[i]
                index = [x for x in range(len(nums)) if nums[x] == num2]
                if len(index) == 1 and index[0] != i:
                    result = [i, index[0]]
                    return result
                if len(index) == 2:
                    result = [i, index[1]]
                    return result
        return None
                    
        