class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        start = 0
        res = 0
        
        for end in range(len(nums)):
            if nums[end] == 0:
                k -= 1
            
            while k < 0:
                if nums[start] == 0:
                    k += 1
                start += 1
            
            res = max(res, end - start + 1)
        
        return res