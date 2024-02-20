class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        s = sum(nums)
        l = len(nums)
        res = (l * (l + 1))/2
        return int(res - s)