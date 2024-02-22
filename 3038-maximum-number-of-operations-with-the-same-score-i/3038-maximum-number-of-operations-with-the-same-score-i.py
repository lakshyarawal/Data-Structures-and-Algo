class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        
        res = 1
        total = nums[0] + nums[1]
        
        for i in range(2, len(nums)-1, 2):
            if nums[i] + nums[i+1] == total:
                res += 1
            else:
                return res
    
        return res