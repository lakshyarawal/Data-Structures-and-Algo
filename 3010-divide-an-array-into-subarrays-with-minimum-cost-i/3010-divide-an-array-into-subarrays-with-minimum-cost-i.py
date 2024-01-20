class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        secondSmallest = 10000000
        thirdSmallest = 10000000
        for i in range(1, len(nums)):
            if nums[i] < secondSmallest:
                thirdSmallest = secondSmallest
                secondSmallest = nums[i]
            elif nums[i] < thirdSmallest:
                thirdSmallest = nums[i]
        return nums[0] + secondSmallest + thirdSmallest
                