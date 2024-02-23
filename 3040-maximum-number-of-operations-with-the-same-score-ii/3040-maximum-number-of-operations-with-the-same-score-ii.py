class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        cache = {}
        
        def dfs(arr, prev):
            
            if (arr, prev) in cache:
                return cache[(arr, prev)]
            #valid basecase-1
            if len(arr) == 2 and sum(arr) == prev:
                return 1
            #valid basecase-2
            if len(arr) < 2:
                return 0
            
            ans1, ans2, ans3 = 0,0,0
            if (prev==0 or (prev == arr[0]+arr[1])):
                #delete first and second element
                ans1 = 1 + dfs(arr[2:], arr[0] + arr[1]) 
            if (prev==0 or (prev == arr[-1] + arr[-2])):
                #delete last and second last element
                ans2 = 1 + dfs(arr[:-2], arr[-2] + arr[-1]) 
            if (prev==0 or (prev == arr[0] + arr[-1])):
                #delete first and last element
                ans3 = 1 + dfs(arr[1:-1], arr[0] + arr[-1]) 
            
            cache[tuple([arr, prev])] = max(ans1, ans2, ans3)
            return max(ans1, ans2, ans3)
        
        return dfs(tuple(nums), 0)