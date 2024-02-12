class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        start, end, res = 0, 0, 0
        while end < len(nums):
            if nums[end] == 1:
                end += 1
                res = max(end - start, res)
            elif k > 0:
                k -= 1
                end += 1
                res = max(end-start, res)
            else:
                if nums[start] == 0:
                    k += 1
                start += 1
        return res