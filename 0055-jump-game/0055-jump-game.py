class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxjump = 0
        for i in range(len(nums)):
            if(i > maxjump):
                return False
            maxjump = max(maxjump, i + nums[i])
            if(maxjump >= len(nums)-1):
                return True
        
        return False