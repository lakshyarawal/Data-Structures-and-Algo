class Solution:
    def maxOperations(self, nums):
        n = len(nums)

        @lru_cache(None)
        def dfs(l,r,score):
            if l >= n or r <= 0 or l >= r:
                return 0 

            max_count = 0

            if nums[l] + nums[r] == score:
                max_count = max(max_count,1+dfs(l+1,r-1,score))
            if l+1 <= r and nums[l] + nums[l+1] == score:
                max_count = max(max_count,1+dfs(l+2,r,score))
            if r-1 >= l and nums[r] + nums[r-1] == score:
                max_count = max(max_count,1+dfs(l,r-2,score))

            return max_count

        return 1 + max(dfs(2,n-1,nums[0]+nums[1]),dfs(1,n-2,nums[0]+nums[-1]),dfs(0,n-3,nums[-1]+nums[-2]))