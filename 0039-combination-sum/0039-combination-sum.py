class Solution:
    def combinationSum(self, nums, target):
        result = []
        nums.sort()
        self.backtrack(result, [], nums, target, 0)
        return result

    def backtrack(self, result, tempList, nums, remain, start):
        if remain < 0:
            return
        elif remain == 0:
            result.append(list(tempList))
        else:
            for i in range(start, len(nums)):
                tempList.append(nums[i])
                self.backtrack(result, tempList, nums, remain - nums[i], i)
                tempList.pop()


