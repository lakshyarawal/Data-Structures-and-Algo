class Solution:
    def maxOperations(self, nums):
        if len(nums) == 2:
            return 1
        n = len(nums)
        ans = self.solve(nums, n, nums[0] + nums[1])
        ans = max(ans, self.solve(nums, n, nums[0] + nums[n - 1]))
        ans = max(ans, self.solve(nums, n, nums[n - 1] + nums[n - 2]))
        return ans
    
    def solve(self, nums, n, target):
        dp = [[-1] * n for _ in range(n)]
        ans = self.helper(nums, 0, n - 1, target, dp)
        return ans
    
    def helper(self, nums, l, r, target, dp):
        if l >= r:
            return 0
        if dp[l][r] != -1:
            return dp[l][r]
        ans = 0
        if nums[l] + nums[r] == target:
            ans = max(ans, 1 + self.helper(nums, l + 1, r - 1, target, dp))
        if l + 1 <= r and nums[l] + nums[l + 1] == target:
            ans = max(ans, 1 + self.helper(nums, l + 2, r, target, dp))
        if l <= r - 1 and nums[r] + nums[r - 1] == target:
            ans = max(ans, 1 + self.helper(nums, l, r - 2, target, dp))
        dp[l][r] = ans
        return ans
